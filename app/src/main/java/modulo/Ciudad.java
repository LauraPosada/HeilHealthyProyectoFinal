package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Ciudad {

    private int id;
    private int departamento_id;
    private String nombre;

    public Ciudad(int id, int departamento_id, String nombre) {
        this.id = id;
        this.departamento_id = departamento_id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(int departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
