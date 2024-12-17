public class Habitacion {
    private String tipo;
    private double precio;
    private String descripcion;

    public Habitacion(String tipo, double precio, String descripcion) {
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void mostrarDetalles() {
        System.out.println("Tipo: " + tipo + ", Precio: $" + precio + ", Descripción: " + descripcion);
    }
}
