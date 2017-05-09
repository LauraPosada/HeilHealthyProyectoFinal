package modulo;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Usuario   {

    private String nombreUsuario;
    private String contrasena;
    private Persona persona;


    public Usuario(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Usuario(String nombreUsuario, String contrasena, Persona persona) {

        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.persona = persona;
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

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
