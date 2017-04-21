package modulo;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by oscar on 20/04/17.
 */

public class Agenda {

    private int id;
    private int medico_id;
    private Calendar fecha;
    private Calendar hora_inicio;
    private Calendar hora_final;

    public Agenda(int id, int medico_id, Calendar fecha, Calendar hora_inicio, Calendar hora_final) {
        this.id = id;
        this.medico_id = medico_id;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_final = hora_final;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(int medico_id) {
        this.medico_id = medico_id;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Calendar getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Calendar hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Calendar getHora_final() {
        return hora_final;
    }

    public void setHora_final(Calendar hora_final) {
        this.hora_final = hora_final;
    }
}
