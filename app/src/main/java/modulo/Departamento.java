package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Departamento {

    private int id;
    private int pais_id;
    private String nombre;

    public Departamento(int id, int pais_id, String nombre) {
        this.id = id;
        this.pais_id = pais_id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
