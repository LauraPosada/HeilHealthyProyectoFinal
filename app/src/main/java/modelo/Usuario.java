package modelo;

import modelo.Persona;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Usuario{

    private String nombreUsuario;
    private String contrasena;
    private String idCedula;

    public Usuario(String nombreUsuario, String contrasena, String idCedula) {
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

    public String getIdCedula() {
        return idCedula;
    }

    public void setIdCedula(String idCedula) {
        this.idCedula = idCedula;
    }
}
