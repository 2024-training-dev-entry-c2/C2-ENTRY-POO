package src.habitaciones;

public class Habitacion implements IHabitacion{

    private String nombre;
    private String caracteristicas;
    private String extras;
    private double precio;

    public Habitacion(String nombre, String caracteristicas, String extras, double precio) {
        this.nombre = nombre;
        this.caracteristicas = caracteristicas;
        this.extras = extras;
        this.precio = precio;
    }

    @Override
    public void mostrarInfoHbatiacion() {
        System.out.println("=== Habitación " + this.nombre + " ===");
        System.out.println("Características: " + this.caracteristicas);
        System.out.println("Extras: " + this.extras);
        System.out.println("Precio: $" + this.precio);
        System.out.println("--------------------------------");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }
}
