package src.habitaciones;

public class Habitacion implements IHabitacion{

    private String nombre;
    private String descripcion;
    private String extras;
    private double precio;

    public Habitacion(String nombre, String descripcion, String extras, double precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.extras = extras;
        this.precio = precio;
    }

    @Override
    public void mostrarInfoHbatiacion() {
        System.out.println("=== Habitación " + this.nombre + " ===");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
