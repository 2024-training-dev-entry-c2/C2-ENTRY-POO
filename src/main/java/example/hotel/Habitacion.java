package example.hotel;

public class Habitacion {
    private String tipo;
    private String caracteristicas;
    private double precio;

    public Habitacion(String tipo, String caracteristicas, double precio) {
        this.tipo = tipo;
        this.caracteristicas = caracteristicas;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public double getPrecio() {
        return precio;
    }

    public void mostrarDetalles() {
        System.out.println(tipo + ": " + caracteristicas + " - " + precio + " USD");
    }
}
