package modelo;

/**
 * Created by oscar on 27/04/17.
 */

public class Hora {

    private int id;
    private String hora;

    public Hora(int id, String hora) {
        this.id = id;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
