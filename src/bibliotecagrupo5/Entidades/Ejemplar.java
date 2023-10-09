
package bibliotecagrupo5.Entidades;

/**
 *
 * @author Leandro
 */
public class Ejemplar implements Comparable<Ejemplar>{
    private int codigo;
    private Libro Libro;
    private int cantidad;
    private boolean estado;
    private Condicion condicion;

    public Ejemplar() {
    }

    public Ejemplar(Libro Libro, int cantidad, boolean estado, Condicion condicion) {
        this.Libro = Libro;
        this.cantidad = cantidad;
        this.estado = estado;
        this.condicion = condicion;
    }

    public Ejemplar(int codigo, Libro Libro, int cantidad, boolean estado, Condicion condicion) {
        this.codigo = codigo;
        this.Libro = Libro;
        this.cantidad = cantidad;
        this.estado = estado;
        this.condicion = condicion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Libro getLibro() {
        return Libro;
    }

    public void setLibro(Libro Libro) {
        this.Libro = Libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    @Override
    public String toString() {
        return "Ejemplar{" + "codigo=" + codigo + ", Libro=" + Libro + ", cantidad=" + cantidad + ", estado=" + estado + ", condicion=" + condicion + '}';
    }

    @Override
    public int compareTo(Ejemplar e) {
        String condicion1=this.condicion.toString();
        String condicion2=e.condicion.toString();
        
        return condicion1.compareTo(condicion2);
    }
    
    

  
    
}
