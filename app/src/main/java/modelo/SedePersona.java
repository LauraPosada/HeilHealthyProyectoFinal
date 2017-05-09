package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class SedePersona {

    private Sede sede;
    private Persona persona;

    public SedePersona(Sede sede, Persona persona) {
        this.sede = sede;
        this.persona = persona;
    }

    public Sede getSede() {
        return sede;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
