package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class EstadoCita {

    private int id;
    private String estado;

    public EstadoCita(int id, String estado) {
        this.id = id;
        this.estado = estado;
    }

    public EstadoCita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return  estado;
    }
}
