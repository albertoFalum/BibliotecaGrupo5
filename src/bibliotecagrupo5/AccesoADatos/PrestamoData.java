
package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Prestamo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class PrestamoData {
    private Connection con=null;
    private EjemplarData ejemplardata;
    private LectorData lectorData;
 
    public PrestamoData() {
       con=Conexion.getConexion();
       ejemplardata=new EjemplarData();
       lectorData=new LectorData();
    }
     public void guardarPrestamo(Prestamo  prestamo) {
        String sql = "INSERT INTO prestamo(fechaInicio, fechaFin, codigo, nroSocio, estado)"
                + "VALUES( ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2,Date.valueOf(prestamo.getFechaFin()) );
            ps.setInt(3, prestamo.getEjemplar().getCodigo());
            ps.setInt(4, prestamo.getLector().getNroSocio());
            ps.setBoolean(5, prestamo.isEstado());
           
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {

                prestamo.setIdPrestamo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Prestamo Guardado");

            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR P1 - Error al acceder a la tabla Libro: " + ex.getMessage());

        }
        
    }
      public void modificarEjemplar(Prestamo prestamo) {
        String sql = "UPDATE prestamo SET fechaInicio = ?, fechaFin = ?, codigo = ?, nroSocio = ? WHERE idPrestamo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, Date.valueOf(prestamo.getFechaInicio()));
            ps.setDate(2, Date.valueOf(prestamo.getFechaFin()));
            ps.setInt(3, prestamo.getEjemplar().getCodigo());
            ps.setInt(4, prestamo.getLector().getNroSocio());
            ps.setInt(5, prestamo.getIdPrestamo());
            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "El Prestamo no existe");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR P2 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
    }
     public void eliminarPrestamo(int idPresta) {
        String sql = "UPDATE prestamo SET estado = 0 WHERE idPrestamo = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPresta);
           
            int exito = ps.executeUpdate();
            if (exito == 1) {

                JOptionPane.showMessageDialog(null, "Prestamo eliminado");

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR P3 - Error al acceder a la tabla Prestamo: " + ex.getMessage());
        }
    }
}
