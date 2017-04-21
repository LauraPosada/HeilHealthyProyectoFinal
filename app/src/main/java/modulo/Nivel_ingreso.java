package modulo;

/**
 * Created by oscar on 20/04/17.
 */

public class Nivel_ingreso {

    private int id;
    private String tipo;
    private double cuota_moderadora;

    public Nivel_ingreso(int id, String tipo, double cuota_moderadora) {
        this.id = id;
        this.tipo = tipo;
        this.cuota_moderadora = cuota_moderadora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCuota_moderadora() {
        return cuota_moderadora;
    }

    public void setCuota_moderadora(double cuota_moderadora) {
        this.cuota_moderadora = cuota_moderadora;
    }
}
