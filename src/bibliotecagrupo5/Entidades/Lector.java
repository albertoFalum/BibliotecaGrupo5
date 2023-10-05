/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bibliotecagrupo5.Entidades;

/**
 *
 * @author manue
 */
public class Lector implements Comparable<Lector>{
    private int nroSocio;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String mail;
    private boolean estado;

    public Lector() {
    }

    public Lector(String nombre, String apellido, String domicilio, String mail, boolean estado) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }

    public Lector(int nroSocio, String nombre, String apellido, String domicilio, String mail, boolean estado) {
        this.nroSocio = nroSocio;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.mail = mail;
        this.estado = estado;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

   
    @Override
    public String toString() {
        return "Lector{" + "nroSocio=" + nroSocio + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", mail=" + mail + ", estado=" + estado + '}';
    }   

    @Override
    public int compareTo(Lector l) {
       int resultado= this.apellido.compareToIgnoreCase(l.getApellido());
       
       if(resultado==0){
           resultado= this.nombre.compareToIgnoreCase(l.getNombre());
       }
       
       return resultado;
    }
}