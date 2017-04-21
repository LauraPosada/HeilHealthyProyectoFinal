package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Estado_cita {

    private int id;
    private String estado;

    public Estado_cita(int id, String estado) {
        this.id = id;
        this.estado = estado;
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
}
