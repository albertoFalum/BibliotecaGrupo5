
package bibliotecagrupo5.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author BETO
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:3306/";
    private static final String BD="bibliotecagrupo5";
    private static final String USUARIO="root";
    private static final String PASSWORD="";
    private static final String DRIVER="org.mariadb.jdbc.Driver";
    
    private static Connection connection;

    public Conexion() {
    }
    
    public static Connection getConexion(){
        if(connection==null){
        
            try {
                Class.forName(DRIVER);
                
                connection=DriverManager.getConnection(URL+BD, USUARIO, PASSWORD);
                
                //JOptionPane.showMessageDialog(null, "Conexion exitosa a la base de datos "+BD);
                System.out.println("Conexion exitosa a la base de datos");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el driver: "+ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: "+ex.getMessage());
            }
        }
        return connection;
    }
    
    public static void desconectar(){
        try {
            connection.close();
            JOptionPane.showMessageDialog(null, "Desconexion exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo desconectar de la base de datos: "+ex.getMessage());
        }
    }
}
