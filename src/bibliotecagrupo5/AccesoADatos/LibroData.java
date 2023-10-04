package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Libro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class LibroData {
    private Connection con = null;

    public LibroData() {

        con = Conexion.getConexion();

    }
    
    public void guardarLibro(Libro libro){
        String sql = "INSERT INTO libro(isbn, titulo, autor, anio, tipo, editorial, estado)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getTipo().toString());
            ps.setString(6, libro.getEditorial());
            ps.setBoolean(7, libro.isEstado());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                libro.setIdLibro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Libro Guardado");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro: "+ex.getMessage());

        }
    }
    
    public void modificarLibro (Libro libro){
        String sql = "UPDATE libro SET isbn = ?, titulo = ?, autor = ?, anio = ?, tipo = ?, editorial = ? WHERE idLibro = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getIsbn());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setInt(4, libro.getAnio());
            ps.setString(5, libro.getTipo().toString());
            ps.setString(6, libro.getEditorial());
            ps.setInt(7, libro.getIdLibro());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El libro no existe");
            }

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Libro: "+ex.getMessage());
        }
    }
    
    public void eliminarLibro (Libro libro){
    
    }
    
//    public List <Libro> listarLibros(){
//    
//    }
//    
//    public Libro buscarLibro(int isbn){
//    
//    }
//    
//    public List<Libro> buscarLibrosPorAutor(String autor){
//    
//    }
//    
//    public Libro buscarLibroPorTitulo(String titulo){
//    
//    }
    

    
    
}
