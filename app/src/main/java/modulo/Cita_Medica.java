package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Cita_Medica {

    private int id;
    private String motivo_descripcion;
    private int valor_consulta;
    private boolean disponibilidad;
    private int estado_cita_id;
    private int tipo_cita_id;
    private int medico_id;
    private int paciente_id_persona;

    public Cita_Medica(int id, String motivo_descripcion, int valor_consulta, boolean disponibilidad, int estado_cita_id, int tipo_cita_id, int medico_id, int paciente_id_persona) {
        this.id = id;
        this.motivo_descripcion = motivo_descripcion;
        this.valor_consulta = valor_consulta;
        this.disponibilidad = disponibilidad;
        this.estado_cita_id = estado_cita_id;
        this.tipo_cita_id = tipo_cita_id;
        this.medico_id = medico_id;
        this.paciente_id_persona = paciente_id_persona;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMotivo_descripcion() {
        return motivo_descripcion;
    }

    public void setMotivo_descripcion(String motivo_descripcion) {
        this.motivo_descripcion = motivo_descripcion;
    }

    public int getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(int valor_consulta) {
        this.valor_consulta = valor_consulta;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getEstado_cita_id() {
        return estado_cita_id;
    }

    public void setEstado_cita_id(int estado_cita_id) {
        this.estado_cita_id = estado_cita_id;
    }

    public int getTipo_cita_id() {
        return tipo_cita_id;
    }

    public void setTipo_cita_id(int tipo_cita_id) {
        this.tipo_cita_id = tipo_cita_id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public int getPaciente_id_persona() {
        return paciente_id_persona;
    }

    public void setPaciente_id_persona(int paciente_id_persona) {
        this.paciente_id_persona = paciente_id_persona;
    }
}
