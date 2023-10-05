package bibliotecagrupo5.AccesoADatos;

import biblioteca.Comparadores.ComparacionesLibros;
import bibliotecagrupo5.Entidades.Libro;
import bibliotecagrupo5.Entidades.Tipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.TreeSet;
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

    public void guardarLibro(Libro libro) {
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
            JOptionPane.showMessageDialog(null, "ERROR LD1 - Error al acceder a la tabla Libro: " + ex.getMessage());

        }
    }

    public void modificarLibro(Libro libro) {
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
            JOptionPane.showMessageDialog(null, "ERROR LD2 - Error al acceder a la tabla Libro: " + ex.getMessage());
        }
    }

    public void eliminarLibro(int id) {
        String sql = "UPDATE libro SET estado = 0 WHERE idLibro = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Libro eliminado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD3 - Error al acceder a la tabla Libro: " + ex.getMessage());
        }
    }

    public TreeSet<Libro> listarLibros() {
        String sql = "SELECT * FROM libro WHERE estado = 1";

        TreeSet<Libro> libros = new TreeSet<>(ComparacionesLibros.ordenadosPorTituloAZ);
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));

                libros.add(libro);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD4 - Error al acceder a la tabla Libro: " + ex.getMessage());
        }
        return libros;
    }

    public Libro buscarLibro(int id) {
        Libro libro = null;
        String sql = "SELECT isbn, titulo, autor, anio, tipo, editorial FROM libro WHERE idLibro=? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libro = new Libro();
                libro.setIdLibro(id);
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el Libro");

                ps.close();
            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "ERROR LD5 - Error al acceder a la tabla Libro: " + ex.getMessage());

        }
        return libro;
    }

    public Libro buscarLibroPorTitulo(String tituloBuscado) {
        Libro libro = null;

        String sql = "SELECT idLibro,isbn,titulo,autor,anio,tipo,editorial FROM libro WHERE UPPER(titulo)=UPPER(?) AND estado=1";
        try {
            PreparedStatement Ps = con.prepareStatement(sql);
            Ps.setString(1, tituloBuscado);

            ResultSet rs = Ps.executeQuery();
            if (rs.next()) {
                libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(true);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el Libro");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD6 - Error al acceder a la tabla Libro " + ex.getMessage());
        }
        return libro;
    }

    public Libro buscarLibroPorIsbn(int isbn) {
        String sql = "SELECT idLibro, isbn, titulo, autor, anio, tipo, editorial FROM libro WHERE isbn = ? AND estado = 1 ";
        Libro libro = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, isbn);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el libro");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error LD7 - Error al acceder a la tabla Libro: "+ex.getMessage());
        }
        return libro;
    }
    
    public TreeSet<Libro> listarLibrosPorAutor(String autorABuscar){
        String sql = "SELECT * FROM libro WHERE UPPER(autor)= UPPER (?) AND estado = 1";

        TreeSet<Libro> libros = new TreeSet<>(ComparacionesLibros.ordenadosPorTituloAZ);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, autorABuscar);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));

                libros.add(libro);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD8 - Error al acceder a la tabla Libro: " + ex.getMessage());
        }
        return libros;
    
    }
    
     public TreeSet<Libro> listarLibrosPorTipo(String categoria){
        String sql = "SELECT * FROM libro WHERE tipo=? AND estado = 1";

        TreeSet<Libro> libros = new TreeSet<>(ComparacionesLibros.ordenadosPorTituloAZ);
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, categoria);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Libro libro = new Libro();
                libro.setIdLibro(rs.getInt("idLibro"));
                libro.setIsbn(rs.getInt("isbn"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setAnio(rs.getInt("anio"));
                libro.setTipo(Tipo.valueOf(rs.getString("tipo")));
                libro.setEditorial(rs.getString("editorial"));
                libro.setEstado(rs.getBoolean("estado"));

                libros.add(libro);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR LD9 - Error al acceder a la tabla Libro: " + ex.getMessage());
        }
        return libros;
     }
}
