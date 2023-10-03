package bibliotecagrupo5.Entidades;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Leandro
 */
public class Libro {
    private int isbn;
    private String nombre;
    private String editorial;
    private Tipo tipo;
    private String autor;
    private boolean estado;

    public Libro() {
    }

    public Libro(String nombre, String editorial, Tipo tipo, String autor, boolean estado) {
        this.nombre = nombre;
        this.editorial = editorial;
        this.tipo = tipo;
        this.autor = autor;
        this.estado = estado;
    }

    public Libro(int isbn, String nombre, String editorial, Tipo tipo, String autor, boolean estado) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.editorial = editorial;
        this.tipo = tipo;
        this.autor = autor;
        this.estado = estado;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
