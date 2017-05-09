package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class Ciudad {

    private int id;
    private Departamento departamento;
    private String nombre;

    public Ciudad(int id, Departamento departamento, String nombre) {
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
