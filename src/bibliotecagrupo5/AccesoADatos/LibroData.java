package bibliotecagrupo5.AccesoADatos;

import bibliotecagrupo5.Entidades.Libro;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author BETO
 */
public class LibroData {
    private Connection con = null;

    public LibroData() {

        con = Conexion.getConexion();

    }
    
    public void guardarLibro(Libro libro){
        
    }
    
    public void modificarLibro (Libro libro){
    
    }
    
    public void eliminarLibro (Libro libro){
    
    }
    
    public List <Libro> listarLibros(){
    
    }
    
    public Libro buscarLibro(int isbn){
    
    }
    
    public List<Libro> buscarLibrosPorAutor(String autor){
    
    }
    
    public Libro buscarLibroPorTitulo(String titulo){
    
    }
    

    
    
}
