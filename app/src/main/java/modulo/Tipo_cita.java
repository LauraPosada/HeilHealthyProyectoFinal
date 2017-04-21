package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Tipo_cita {

    private int id;
    private String nombre;

    public Tipo_cita(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
