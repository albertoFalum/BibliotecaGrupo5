
package bibliotecagrupo5.AccesoADatos;

import java.sql.Connection;

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
    
    
}
