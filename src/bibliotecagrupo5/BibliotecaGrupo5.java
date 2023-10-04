package bibliotecagrupo5;

import bibliotecagrupo5.AccesoADatos.LibroData;
import bibliotecagrupo5.Entidades.Libro;
import bibliotecagrupo5.Entidades.Tipo;

/**
 *
 * @author BETO
 */
public class BibliotecaGrupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        LibroData librodata=new LibroData();
//        Libro libro= new Libro(422, "Santa Evita", "Tomas Eloy Martines", 1975, Tipo.LITERATURA, "Sudamericana", true);
//        librodata.guardarLibro(libro);

        LibroData librodata=new LibroData();
        Libro libro= new Libro(1,422, "Santa Evita 2", "Tomas Eloy Martines", 1975, Tipo.LITERATURA, "Sudamericana", true);
        librodata.modificarLibro(libro);
        
    }
   
}
