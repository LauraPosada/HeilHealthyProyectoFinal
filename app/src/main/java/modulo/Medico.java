package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Medico {

    private int id;
    private int nacionalidad;//Este hay que modificarlo en la base de datos, por el tipo y la relación.
    private int persona_cedula;
    private int especializacion_id;
    private int tipo_medico_id;

    public Medico(int id, int nacionalidad, int persona_cedula, int especializacion_id, int tipo_medico_id) {
        this.id = id;
        this.nacionalidad = nacionalidad;
        this.persona_cedula = persona_cedula;
        this.especializacion_id = especializacion_id;
        this.tipo_medico_id = tipo_medico_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getPersona_cedula() {
        return persona_cedula;
    }

    public void setPersona_cedula(int persona_cedula) {
        this.persona_cedula = persona_cedula;
    }

    public int getEspecializacion_id() {
        return especializacion_id;
    }

    public void setEspecializacion_id(int especializacion_id) {
        this.especializacion_id = especializacion_id;
    }

    public int getTipo_medico_id() {
        return tipo_medico_id;
    }

    public void setTipo_medico_id(int tipo_medico_id) {
        this.tipo_medico_id = tipo_medico_id;
    }
}
