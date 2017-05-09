package modulo;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Persona {

    private int cedula;
    private String nombre;
    private String apellido;
    private String emaill;
    private String fechaNacimiento;
    private String genero;
    private double igresos;

    public Persona(int cedula, String nombre, String apellido, String emaill, String fechaNacimiento, String genero, double igresos) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.emaill = emaill;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.igresos = igresos;
    }

    public Persona() {
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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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
