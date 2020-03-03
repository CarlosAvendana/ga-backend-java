/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gaBackend.modelo;

/**
 *
 * @author carlos
 */
public class Usuario {

    private int cedula;
    private String contrasena;
    private String nombre;

    public Usuario() {
        this.cedula = 0;
        this.contrasena = new String();
        this.nombre = new String();

    }

    public Usuario(int cedula, String contrasena, String nombre) {
        this.cedula = cedula;
        this.contrasena = contrasena;
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", contrasena=" + contrasena + ", nombre=" + nombre + '}';
    }

}
