
package biblioteca.Comparadores;

import bibliotecagrupo5.Entidades.Libro;
import java.util.Comparator;

/**
 *
 * @author BETO
 */
public class ComparacionesLibros {
 
    public static Comparator<Libro> ordenadosPorTituloAZ = new Comparator<Libro>() {
        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getTitulo().compareToIgnoreCase(l2.getTitulo());
        }
    };

    public static Comparator<Libro> ordenadosPorAutorAZ = new Comparator<Libro>() {
        @Override
        public int compare(Libro l1, Libro l2) {
            return l1.getAutor().compareToIgnoreCase(l2.getAutor());
        }
    };
}
