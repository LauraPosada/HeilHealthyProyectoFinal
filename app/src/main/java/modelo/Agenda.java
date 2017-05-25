package modelo;

/**
 * Created by CAMILO on 17/05/2017.
 */

public class Agenda {

    private int id;

    private String fecha_cita;

    private Hora hora;

    private Medico medico;

    public Agenda() {
    }

    public Agenda(int id, String fecha_cita, Hora hora, Medico medico) {
        this.id = id;
        this.fecha_cita = fecha_cita;
        this.hora = hora;
        this.medico = medico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_cita() {
        return fecha_cita;
    }

    public void setFecha_cita(String fecha_cita) {
        this.fecha_cita = fecha_cita;
    }

    public Hora getHora() {
        return hora;
    }

    public void setHora(Hora hora) {
        this.hora = hora;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @Override
    public String toString() {
        return fecha_cita;
    }
}