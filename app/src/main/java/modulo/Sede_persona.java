package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Sede_persona {

    private int sede_id;
    private int persona_id;

    public Sede_persona(int sede_id, int persona_id) {
        this.sede_id = sede_id;
        this.persona_id = persona_id;
    }

    public int getSede_id() {
        return sede_id;
    }

    public void setSede_id(int sede_id) {
        this.sede_id = sede_id;
    }

    public int getPersona_id() {
        return persona_id;
    }

    public void setPersona_id(int persona_id) {
        this.persona_id = persona_id;
    }
}
