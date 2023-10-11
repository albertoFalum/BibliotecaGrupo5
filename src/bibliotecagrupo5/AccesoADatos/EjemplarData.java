
package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Condicion;
import bibliotecagrupo5.Entidades.Ejemplar;
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
public class EjemplarData {
     private Connection con = null;
     private LibroData librodata;

    public EjemplarData() {
        con = Conexion.getConexion();
        librodata = new LibroData();
    }
    
    public void guardarEjemplar(Ejemplar ejemplar){
        String sql = "INSERT INTO ejemplar(idLibro, cantidad, estado, condicion)"
                + "VALUES(?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ejemplar.getLibro().getIdLibro());
            ps.setInt(2, ejemplar.getCantidad());
            ps.setBoolean(3, ejemplar.isEstado());
            ps.setString(4, ejemplar.getCondicion().toString());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                ejemplar.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ejemplares Guardados");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED1 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());

        }
    }
    
    public void modificarEjemplar(Ejemplar ejemplar) {
        String sql = "UPDATE ejemplar SET cantidad = ?, condición = ? WHERE codigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ejemplar.getCantidad());
            ps.setString(2, ejemplar.getCondicion().toString());
            ps.setInt(3, ejemplar.getCodigo());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Ejemplar no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED2 - Error al acceder a la tabla Ejemplar: " + ex.getMessage());
        }
    }

    public void eliminarEjemplar(int codigoAEliminar) {
        String sql = "UPDATE ejemplar SET estado = 0 WHERE codigo = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigoAEliminar);
           
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Ejemplar eliminado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED3 - Error al acceder a la tabla Ejemplar: " + ex.getMessage());
        }
    }

    public TreeSet <Ejemplar> listarEjemplares(){
        String sql = "SELECT * FROM ejemplar WHERE estado = 1";
        
        TreeSet<Ejemplar> ejemplares = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setEstado(rs.getBoolean("estado"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));                
                

                ejemplares.add(ejemplar);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED4 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplares;
    }
    
    public Ejemplar buscarEjemplar(int codigoABuscar){
        Ejemplar ejemplar = null;
        String sql = "SELECT idLibro, condicion FROM ejemplar WHERE codigo=? AND estado = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, codigoABuscar);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                ejemplar = new Ejemplar();
                ejemplar.setCodigo(codigoABuscar);
                ejemplar.setLibro(librodata.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                ejemplar.setEstado(true);

            } else {
                JOptionPane.showMessageDialog(null, "No existe el Ejemplar");

                ps.close();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED5 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());

        }
        return ejemplar;
    }
     
    public TreeSet <Ejemplar> listarEjemplaresPorLibro(int idL){
        String sql = "SELECT * FROM ejemplar WHERE idLibro = ? AND estado = 1";
        
        TreeSet<Ejemplar> ejemplares = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idL);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(idL));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                ejemplar.setEstado(rs.getBoolean("estado"));

                ejemplares.add(ejemplar);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED6 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplares;
    }
    
    public TreeSet <Ejemplar> listarEjemplaresPorCondicion(String condicionABuscar){
        String sql = "SELECT * FROM ejemplar WHERE condicion=? AND estado = 1";
        
        TreeSet<Ejemplar> ejemplares = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, condicionABuscar);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                ejemplar.setEstado(rs.getBoolean("estado"));

                ejemplares.add(ejemplar);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED7 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplares;
    }
    
    public Ejemplar BuscarEjemplarPorLibroYCondicion(int idL, String condicionABuscar){
           String sql = "SELECT * FROM ejemplar WHERE idLibro = ? AND condicion=? AND estado = 1";
           Ejemplar ejemplar = null;
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idL);
            ps.setString(2, condicionABuscar);
            
            ResultSet rs = ps.executeQuery();
            
            
            if (rs.next()) {
                ejemplar=new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(idL));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                ejemplar.setEstado(rs.getBoolean("estado"));
                
            }
            ps.close();
            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED8 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplar;
    }
     public Ejemplar buscarEjemplarIdLibroYCondicion(int idLibro,Condicion condicionABuscar){
         Ejemplar ejemplar = null;
         String sql = "SELECT * FROM ejemplar WHERE  idLibro=? AND condicion=? AND estado = 1";
        
       
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idLibro);
            String condi=condicionABuscar.toString();
            ps.setString(2, condi);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(idLibro));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setCondicion(condicionABuscar);
                ejemplar.setEstado(rs.getBoolean("estado"));
 
            }else{
                JOptionPane.showMessageDialog(null, "Ejemplar encontrado");
                ps.close();
            }
               
                
           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED9 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplar;
    }
     public TreeSet <Ejemplar> listarEjemplaresNoDisponibles(int idLibro, String condicionABuscar){
        String sql = "SELECT * FROM ejemplar WHERE NOT condicion=? AND cantidad>0 AND estado = 1";
        
        TreeSet<Ejemplar> ejemplares = new TreeSet<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, condicionABuscar);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setCodigo(rs.getInt("codigo"));
                ejemplar.setLibro(librodata.buscarLibro(rs.getInt("idLibro")));
                ejemplar.setCantidad(rs.getInt("cantidad"));
                ejemplar.setCondicion(Condicion.valueOf(rs.getString("condicion")));
                ejemplar.setEstado(rs.getBoolean("estado"));

                ejemplares.add(ejemplar);

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR ED9 - Error al acceder a la tabla Ejemplar: "+ex.getMessage());
        }
        return ejemplares;
    }
}


