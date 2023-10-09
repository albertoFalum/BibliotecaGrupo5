package bibliotecagrupo5;

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
<<<<<<< Updated upstream
=======
        
       LibroData librodata=new LibroData();
//        Libro libro= new Libro(422, "Santa Evita", "Tomas Eloy Martines", 1975, Tipo.LITERATURA, "Sudamericana", true);
//        librodata.guardarLibro(libro);


        Libro libro= new Libro(1,422, "Santa Evita", "Tomas Eloy Martinez", 1975, Tipo.LITERATURA, "Sudamericana", true);
//        librodata.modificarLibro(libro);
        Libro libro2=librodata.buscarLibro(1);
        System.out.println(libro2);
        
//        Libro libro3=librodata.buscarLibroPorTitulo("santa evita");
//        System.out.println(libro3);
//            EjemplarData ejemplardata=new EjemplarData();
//            Ejemplar ejemplar=new Ejemplar(1,libro, 2, true, Condicion.DISPONIBLE);
//            ejemplardata.guardarEjemplar(ejemplar);
            
//        librodata.eliminarLibro(1);
        
//       Libro libro4= librodata.buscarLibroPorIsbn(422);
//        System.out.println(libro4);

//        
//        librodata.eliminarLibro(1);
//        LectorData lectordata=new LectorData();
//       Lector lector=new Lector(1, "lucas", "cuello", "sudamerica1238", "leandro@gmail.com", true);
//        lectordata.modificarLector(lector);
//          lectordata.eliminarLector(1);
        
//        TreeSet<Libro> listaPorTipo=librodata.listarLibrosPorAutor("Gabriel Garcia Marquez");
//        
//        for(Libro aux:listaPorTipo){
//            System.out.println(aux);

        
//        }
          PrestamoData prestamodata=new PrestamoData();
//          Prestamo prestamo=new Prestamo(3,LocalDate.of(1998, Month.MARCH, 24), LocalDate.of(1999, Month.MAY, 14), ejemplar, lector, true);
//          prestamodata.guardarPrestamo(prestamo);
//           prestamo.setFechaFin(LocalDate.of(1998, Month.MARCH, 5));
//          prestamodata.modificarEjemplar(prestamo);
//            prestamodata.eliminarPrestamo(4);
            TreeSet<Prestamo> listarPrestamos=prestamodata.listarPrestamos();
            for(Prestamo aux:listarPrestamos){
                System.out.println(aux);
            }
//        
//        }

>>>>>>> Stashed changes
    }
    
}
