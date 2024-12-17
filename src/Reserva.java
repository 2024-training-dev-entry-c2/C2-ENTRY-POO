import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {

    public LocalDate fechaInicio;
    public LocalDate fechaFin;
    public int cantidadAdultos;
    public int cantidadNinos;
    public Cliente cliente;
    public Alojamiento alojamiento;
    public ArrayList<Habitacion> habitacion;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, int cantidadAdultos, int cantidadNinos, Cliente cliente, Alojamiento alojamiento, ArrayList<Habitacion> habitacion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
    }

    public String mostrarDetalles() {
        String habitaciones;
        if (habitacion.size() > 1) {
            habitaciones = "";
            for (int i = 0; i < habitacion.size(); i++) {
                habitaciones += habitacion.get(i).nombre + ", ";
            }
        } else {
            habitaciones = habitacion.get(0).nombre;
        }
        return "Reserva: " + "Fecha de inicio: " + fechaInicio + ", Fecha de fin: " + fechaFin + ", Cantidad de adultos: " + cantidadAdultos + ", Cantidad de niños: " + cantidadNinos + ", Cliente: " + cliente.nombre + " " + cliente.apellido + ", Alojamiento: " + alojamiento.nombre + ", Habitaciones: " + habitaciones;
    }

}
