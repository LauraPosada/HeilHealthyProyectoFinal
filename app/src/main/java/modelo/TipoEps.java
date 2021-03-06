package modelo;

import java.io.Serializable;

/**
 * Created by oscar on 20/04/17.
 */

public class TipoEps implements Serializable{

    private int id;
    private String nombre;

    public TipoEps(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoEps() {
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
        return nombre;
    }
}
