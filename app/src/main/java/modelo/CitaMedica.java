package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by oscar on 20/04/17.
 */

public class CitaMedica implements Serializable {

    private int id;
    private String motivo_descripcion;
    private double valor_consulta;
    private String disponibilidad;
    private EstadoCita estado_cita;
    private TipoCita tipo_cita;
    private Medico medico;
    private Paciente paciente;
    private Agenda agenda;

    public CitaMedica() {

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

    public double getValor_consulta() {
        return valor_consulta;
    }

    public void setValor_consulta(double valor_consulta) {
        this.valor_consulta = valor_consulta;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public EstadoCita getEstado_cita() {
        return estado_cita;
    }

    public void setEstado_cita(EstadoCita estado_cita) {
        this.estado_cita = estado_cita;
    }

    public TipoCita getTipo_cita() {
        return tipo_cita;
    }

    public void setTipo_cita(TipoCita tipo_cita) {
        this.tipo_cita = tipo_cita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }


    @Override
    public String toString() {
        return  paciente.getNombre() +" " +paciente.getApellido();

    }
}