package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Paciente {

    private int id_persona;
    private int persona_cedula;
    private int tipo_eps_id;
    private int nivel_ingreso_id;

    public Paciente(int id_persona, int persona_cedula, int tipo_eps_id, int nivel_ingreso_id) {
        this.id_persona = id_persona;
        this.persona_cedula = persona_cedula;
        this.tipo_eps_id = tipo_eps_id;
        this.nivel_ingreso_id = nivel_ingreso_id;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getPersona_cedula() {
        return persona_cedula;
    }

    public void setPersona_cedula(int persona_cedula) {
        this.persona_cedula = persona_cedula;
    }

    public int getTipo_eps_id() {
        return tipo_eps_id;
    }

    public void setTipo_eps_id(int tipo_eps_id) {
        this.tipo_eps_id = tipo_eps_id;
    }

    public int getNivel_ingreso_id() {
        return nivel_ingreso_id;
    }

    public void setNivel_ingreso_id(int nivel_ingreso_id) {
        this.nivel_ingreso_id = nivel_ingreso_id;
    }
}
