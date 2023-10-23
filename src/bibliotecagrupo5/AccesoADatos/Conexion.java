package bibliotecagrupo5.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost:3306/";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String DRIVER = "org.mariadb.jdbc.Driver";

    public static Connection getConexion(String BD) {
        Connection connection = null;

        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL + BD, USUARIO, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos " + BD);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos: " + ex.getMessage());
        }

        return connection;
    }

    public static void desconectar(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Desconexión exitosa");
            } catch (SQLException ex) {
                System.out.println("No se pudo desconectar de la base de datos: " + ex.getMessage());
            }
        }
    }
}
