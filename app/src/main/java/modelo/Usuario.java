package modelo;

import modelo.Persona;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Usuario{

    private String nombreUsuario;
    private String contrasena;
    private Persona idCedula;

    public Usuario(String nombreUsuario, String contrasena, Persona idCedula) {
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
