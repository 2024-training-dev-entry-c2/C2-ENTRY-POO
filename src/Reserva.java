import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {

    public LocalDate fechaInicio;
    public LocalDate fechaFin;
    public int cantidadAdultos;
    public int cantidadNinos;
    public Cliente cliente;
    public Alojamiento alojamiento;
    public Habitacion habitacion;
    public String tipo;

    public Reserva(LocalDate fechaInicio, LocalDate fechaFin, int cantidadAdultos, int cantidadNinos, Cliente cliente, Alojamiento alojamiento, Habitacion habitacion) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
        this.tipo = "Normal";
    }

    public Reserva  (LocalDate fechaInicio, int cantidadAdultos, int cantidadNinos, Cliente cliente, Alojamiento alojamiento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaInicio;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = new Habitacion("Sin habitación", "Habitación por defecto", 0, alojamiento.precioDiaSol);
        this.tipo = "Día de sol";
    }

    public String mostrarDetalles() {
        return ("Reserva de tipo " + tipo + " : " + "Fecha de inicio: " + fechaInicio + ", Fecha de fin: " + fechaFin +
                ", Cantidad de adultos: " + cantidadAdultos + ", Cantidad de niños: " + cantidadNinos + ", Cliente: " +
                cliente.nombre + " " + cliente.apellido + ", Alojamiento: " + alojamiento.nombre + ", Habitación: " +
                habitacion.nombre + "Con un costo de: " + calcularCostoReserva(fechaInicio, fechaFin, habitacion.precioNoche) +
                " pesos" + "(Ajuste por temporada: " + calcularAjuste(fechaInicio, fechaFin) + " pesos)"
        );
    }

    public float calcularCostoReserva(LocalDate fechaInicio, LocalDate fechaFin, float precioNoche) {
        float costoReserva = 0;
        float ajusteTemporada = calcularAjuste(fechaInicio, fechaFin);
        costoReserva += ajusteTemporada;
        return costoReserva;
    }

    public float calcularAjuste(LocalDate fechaInicio, LocalDate fechaFin) {
        float ajuste = 0;
        float precioParcial = habitacion.precioNoche * fechaInicio.until(fechaFin).getDays();
        if (fechaFin.getDayOfMonth() >= 25) {
            ajuste = precioParcial * 0.15f;
        } else if (fechaInicio.getDayOfMonth() >= 10 && fechaInicio.getDayOfMonth() <= 15) {
            ajuste = precioParcial * 0.10f;
        } else if (fechaInicio.getDayOfMonth() >= 5 && fechaInicio.getDayOfMonth() <= 10) {
            ajuste = -precioParcial * 0.08f;
        }
        return ajuste;
    }

}
