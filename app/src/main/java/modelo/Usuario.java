package modulo;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Usuario extends Persona {

    private String nombreUsuario;
    private String contrasena;
    private Persona idCedula;

    public Usuario(int cedula, String nombre, String apellido, String emaill, String fechaNacimiento, String genero, double igresos, String nombreUsuario, String contrasena) {
        super(cedula, nombre, apellido, emaill, fechaNacimiento, genero, igresos);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(int cedula, String nombre, String apellido, String emaill, String fechaNacimiento, String genero, double igresos, String nombreUsuario, String contrasena, Persona idCedula) {
        super(cedula, nombre, apellido, emaill, fechaNacimiento, genero, igresos);
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.idCedula = idCedula;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Persona getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(Persona idCedula) {
        this.idCedula = idCedula;
    }
}
