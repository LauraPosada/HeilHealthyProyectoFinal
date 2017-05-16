package modelo;

import java.io.Serializable;

/**
 * Created by oscar on 20/04/17.
 */

public class Ciudad implements Serializable{

    private int id;
    private Departamento departamento;
    private String nombre;

    public Ciudad(int id, Departamento departamento, String nombre) {
        this.id = id;
        this.departamento = departamento;
        this.nombre = nombre;
    }

    public Ciudad() {
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

    @Override
    public String toString() {
        return nombre;
    }
}
