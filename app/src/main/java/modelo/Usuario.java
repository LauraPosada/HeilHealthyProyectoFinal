package modelo;

import modelo.Persona;

/**
 * Created by TecnoSystem on 20/04/2017.
 */

public class Usuario{

    private String nombreUsuario;
    private String contrasena;
    private Persona idCedula;
    private String tipoPersona;

    public Usuario(String nombreUsuario, String contrasena, Persona idCedula, String tipoPersona) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.idCedula = idCedula;
        this.tipoPersona = tipoPersona;
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

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
}
