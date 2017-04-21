package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Sede {

    private int id;
    private String nombre;
    private int ciudad_id;
    private String longitud;
    private String latitud;

    public Sede(int id, String nombre, int ciudad_id, String longitud, String latitud) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad_id = ciudad_id;
        this.longitud = longitud;
        this.latitud = latitud;
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

    public int getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(int ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}
