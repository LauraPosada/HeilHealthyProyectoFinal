package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class Departamento {

    private int id;
    private Pais pais;
    private String nombre;

    public Departamento(int id, Pais pais, String nombre) {
        this.id = id;
        this.pais = pais;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
