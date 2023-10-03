/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecagrupo5.Entidades;

/**
 *
 * @author Leandro
 */
public class Ejemplar {
    private int codigo;
    private Libro Libro;
    private int cantidad;
    private Condicion condicion;

    public Ejemplar() {
    }

    public Ejemplar(Libro Libro, int cantidad, Condicion condicion) {
        this.Libro = Libro;
        this.cantidad = cantidad;
        this.condicion = condicion;
    }

    public Ejemplar(int codigo, Libro Libro, int cantidad, Condicion condicion) {
        this.codigo = codigo;
        this.Libro = Libro;
        this.cantidad = cantidad;
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

    public Condicion getCondicion() {
        return condicion;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    
}
