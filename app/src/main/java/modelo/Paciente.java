package modelo;

import java.util.Date;

/**
 * Created by oscar on 20/04/17.
 */

public class Paciente extends Persona{

    private TipoEps tipo_eps;
    private NivelIngreso nivel_ingreso;

    public Paciente() {
    }

    public Paciente(int cedula, String nombre, String apellido, String emaill, Date fechaNacimiento, Ciudad ciudad, String genero, double igresos, TipoEps tipo_eps, NivelIngreso nivel_ingreso) {
        super();
        this.tipo_eps = tipo_eps;
        this.nivel_ingreso = nivel_ingreso;
    }

    public TipoEps getTipo_eps() {
        return tipo_eps;
    }

    public void setTipo_eps(TipoEps tipo_eps) {
        this.tipo_eps = tipo_eps;
    }

    public NivelIngreso getNivel_ingreso() {
        return nivel_ingreso;
    }

    public void setNivel_ingreso(NivelIngreso nivel_ingreso) {
        this.nivel_ingreso = nivel_ingreso;
    }
}
