import java.util.ArrayList;
import java.util.List;

public class Alojamiento implements IReservas {
    private String nombre;
    private String ciudad;
    private String tipo;
    private int calificacion;
    private int precioPorNoche;
    private List<Habitacion> habitaciones;
    private List<String> reservas;

    public Alojamiento(String nombre, String ciudad, String tipo, int calificacion, int precioPorNoche, List<Habitacion> habitaciones) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.precioPorNoche = precioPorNoche;
        this.habitaciones = habitaciones;
        this.reservas = new ArrayList<>();

    }

    public void mostrarHabitaciones() {
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarDetalles();
        }
    }

    public void hacerReserva(Cliente cliente, String tipoHabitacion) {
        reservas.add("Cliente: " + cliente.getNombreCompleto() + ", Habitación: " + tipoHabitacion);
        System.out.println("Reserva realizada con éxito.");
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecioPorNoche() {
        return precioPorNoche;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void hacerReserva(Cliente cliente) {
        reservas.add("Cliente: " + cliente.getNombreCompleto() + ", Habitación: Estándar");
        System.out.println("Reserva realizada con éxito en habitación estándar.");
    }


    public void mostrarReservas() {
        System.out.println(" Reservas en " + nombre + " ");
        for (String reserva : reservas) {
            System.out.println(reserva);
        }
    }
}
