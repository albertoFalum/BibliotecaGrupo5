
package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Ejemplar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class EjemplarData {
     private Connection con = null;

    public EjemplarData() {
        con = Conexion.getConexion();
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ejemplar: "+ex.getMessage());

        }
    }
     
     
}
