package models;

/**
 *
 * @author Carlos y Felipe
 */
public class Curso {

    private String codigo;
    private String carrera_codigo;
    private String anio;
    private String ciclo;
    private int nombre;
    private int creditos;
    private int horas_semanales;

    public Curso() {
        codigo = new String();
        carrera_codigo = new String();
        anio = new String();
        ciclo = new String();
        nombre = 0;
        creditos = 0;
        horas_semanales = 0;
    }

    public Curso(String codigo, String carrera_codigo, String anio, String ciclo, int nombre, int creditos, int horas_semanales) {
        this.codigo = codigo;
        this.carrera_codigo = carrera_codigo;
        this.anio = anio;
        this.ciclo = ciclo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.horas_semanales = horas_semanales;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCarrera_codigo() {
        return carrera_codigo;
    }

    public void setCarrera_codigo(String carrera_codigo) {
        this.carrera_codigo = carrera_codigo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras_semanales() {
        return horas_semanales;
    }

    public void setHoras_semanales(int horas_semanales) {
        this.horas_semanales = horas_semanales;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigo=" + codigo + ", carrera_codigo=" + carrera_codigo + ", anio=" + anio + ", ciclo=" + ciclo + ", nombre=" + nombre + ", creditos=" + creditos + ", horas_semanales=" + horas_semanales + '}';
    }

}
