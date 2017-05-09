package modelo;

/**
 * Created by oscar on 20/04/17.
 */

public class Sede {

    private int id;
    private String nombre;
    private Ciudad ciudad;
    private String longitud;
    private String latitud;

    public Sede(int id, String nombre, Ciudad ciudad_id, String longitud, String latitud) {
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
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

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
