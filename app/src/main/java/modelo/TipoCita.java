package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class TipoCita {

    private int id;
    private String nombre;

    public TipoCita(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoCita() {
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

    @Override
    public String toString() {
        return  nombre ;
    }
}
