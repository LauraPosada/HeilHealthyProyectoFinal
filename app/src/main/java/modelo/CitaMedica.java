package modelo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by oscar on 20/04/17.
 */

public class CitaMedica implements Serializable{

    private int id;
    private String motivo_descripcion;
    private double valor_consulta;
    private boolean disponibilidad;
    private EstadoCita estado_cita;
    private TipoCita tipo_cita;
    private Medico medico;
    private Paciente paciente;
    private String fecha_cita;

    public CitaMedica() {

    }

    public CitaMedica(int id, String motivo_descripcion, double valor_consulta,
                      boolean disponibilidad, EstadoCita estado_cita, TipoCita tipo_cita,
                      Medico medico, Paciente paciente, String fecha_cita) {
        this.id = id;
        this.motivo_descripcion = motivo_descripcion;
        this.valor_consulta = valor_consulta;
        this.disponibilidad = disponibilidad;
        this.estado_cita = estado_cita;
        this.tipo_cita = tipo_cita;
        this.medico = medico;
        this.paciente = paciente;
        this.fecha_cita = fecha_cita;
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

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
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

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    @Override
    public String toString() {
        return  fecha_cita;
    }
}
