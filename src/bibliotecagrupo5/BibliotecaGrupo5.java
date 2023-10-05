package bibliotecagrupo5;

import bibliotecagrupo5.AccesoADatos.LectorData;
import bibliotecagrupo5.AccesoADatos.LibroData;
import bibliotecagrupo5.Entidades.Lector;
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
        
       LibroData librodata=new LibroData();
//        Libro libro= new Libro(422, "Santa Evita", "Tomas Eloy Martines", 1975, Tipo.LITERATURA, "Sudamericana", true);
//        librodata.guardarLibro(libro);


//        Libro libro= new Libro(1,422, "Santa Evita", "Tomas Eloy Martinez", 1975, Tipo.LITERATURA, "Sudamericana", true);
//        librodata.modificarLibro(libro);
//        Libro libro2=librodata.buscarLibro(1);
//        System.out.println(libro2);
        
//        Libro libro3=librodata.buscarLibroPorTitulo("santa evita");
//        System.out.println(libro3);

        
//        librodata.eliminarLibro(1);
        
//       Libro libro4= librodata.buscarLibroPorIsbn(422);
//        System.out.println(libro4);

//        
//        librodata.eliminarLibro(1);
        LectorData lectordata=new LectorData();
//        Lector lector=new Lector(1, "lucas", "cuello", "sudamerica1238", "leandro@gmail.com", true);
//        lectordata.modificarLector(lector);
           lectordata.eliminarLector(1);
    }
   
}
