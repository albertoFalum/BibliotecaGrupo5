package bibliotecagrupo5.AccesoADatos;

import java.sql.Connection;

/**
 *
 * @author BETO
 */
public class LibroData {
    private Connection con = null;

    public LibroData() {

        con = Conexion.getConexion();

    }
}
