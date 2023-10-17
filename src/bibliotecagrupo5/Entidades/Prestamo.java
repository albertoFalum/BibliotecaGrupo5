
package bibliotecagrupo5.Entidades;

import java.time.LocalDate;

/**
 *
 * @author BETO
 */
public class Prestamo implements Comparable<Prestamo> {
    private int idPrestamo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Ejemplar ejemplar;
    private Lector lector;
    private boolean estado;

    public Prestamo() {
    }

    public Prestamo(LocalDate fechaInicio, LocalDate fechaFin, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public Prestamo(int idPrestamo, LocalDate fechaInicio, LocalDate fechaFin, Ejemplar ejemplar, Lector lector, boolean estado) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.ejemplar = ejemplar;
        this.lector = lector;
        this.estado = estado;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "idPrestamo=" + idPrestamo + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", ejemplar=" + ejemplar + ", lector=" + lector + ", estado=" + estado + '}';
    }

    @Override
    public int compareTo(Prestamo o) {
       
       return Integer.compare(this.idPrestamo, o.idPrestamo);
                
        
    }
    
    
}
