package modelo;

import java.util.Date;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Persona {

    private int cedula;
    private String nombre;
    private String apellido;
    private String emaill;
    private Date fechaNacimiento;
    private Ciudad ciudad;
    private String genero;
    private double igresos;

    public Persona(int cedula, String nombre, String apellido, String emaill, Date fechaNacimiento, Ciudad ciudad, String genero, double igresos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.emaill = emaill;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.genero = genero;
        this.igresos = igresos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
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

    public String getEmaill() {
        return emaill;
    }

    public void setEmaill(String emaill) {
        this.emaill = emaill;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getIgresos() {
        return igresos;
    }

    public void setIgresos(double igresos) {
        this.igresos = igresos;
    }
}
