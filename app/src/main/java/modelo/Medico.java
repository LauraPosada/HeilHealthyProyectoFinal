package modelo;

import java.util.Date;

/**
 * Created by oscar on 20/04/17.
 */

public class Medico extends Persona{

    private Especializacion especializacion;
    private TipoMedico tipo_medico;

    public Medico(int cedula, String nombre, String apellido, String emaill, Date fechaNacimiento, Ciudad ciudad, String genero, double igresos, Especializacion especializacion, TipoMedico tipo_medico) {
        super(cedula, nombre, apellido, emaill, fechaNacimiento, ciudad, genero, igresos);
        this.especializacion = especializacion;
        this.tipo_medico = tipo_medico;
    }

    public Especializacion getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(Especializacion especializacion) {
        this.especializacion = especializacion;
    }

    public TipoMedico getTipo_medico() {
        return tipo_medico;
    }

    public void setTipo_medico(TipoMedico tipo_medico) {
        this.tipo_medico = tipo_medico;
    }
}
