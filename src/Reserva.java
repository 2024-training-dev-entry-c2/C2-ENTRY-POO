import java.time.LocalDate;

public class Reserva {

    // Atributos privados
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private int cantidadAdultos;
    private int cantidadNinos;
    private Cliente cliente;
    private Alojamiento alojamiento;
    private Habitacion habitacion;
    private String tipo;

    // Constructor para reserva normal
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

    // Constructor para reserva de Día de Sol
    public Reserva(LocalDate fechaInicio, int cantidadAdultos, int cantidadNinos, Cliente cliente, Alojamiento alojamiento) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaInicio;
        this.cantidadAdultos = cantidadAdultos;
        this.cantidadNinos = cantidadNinos;
        this.cliente = cliente;
        this.alojamiento = alojamiento;
        this.habitacion = new Habitacion("Sin habitación", "Habitación por defecto", 0, alojamiento.precioDiaSol);
        this.tipo = "Día de sol";
    }

    // Método para mostrar detalles de la reserva
    public String mostrarDetalles() {
        return ("Reserva de tipo " + tipo + " : " + "Fecha de inicio: " + fechaInicio + ", Fecha de fin: " + fechaFin +
                ", Cantidad de adultos: " + cantidadAdultos + ", Cantidad de niños: " + cantidadNinos + ", Cliente: " +
                cliente.nombre + " " + cliente.apellido + ", Alojamiento: " + alojamiento.nombre + " en " +
                alojamiento.ciudad + ", Habitación: " + habitacion.nombre + "Con un costo de: " +
                calcularCostoReserva(fechaInicio, fechaFin, habitacion.precioNoche) +
                " pesos" + "(Ajuste por temporada: " + calcularAjuste(fechaInicio, fechaFin) + " pesos)"
        );
    }

    // Método para calcular el costo de la reserva
    public float calcularCostoReserva(LocalDate fechaInicio, LocalDate fechaFin, float precioNoche) {
        float costoReserva = habitacion.precioNoche * fechaInicio.until(fechaFin).getDays();
        float ajusteTemporada = calcularAjuste(fechaInicio, fechaFin);
        costoReserva += ajusteTemporada;
        return costoReserva;
    }

    // Método para calcular ajuste por temporada
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

    // Getters y Setters
    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidadAdultos() {
        return cantidadAdultos;
    }

    public void setCantidadAdultos(int cantidadAdultos) {
        this.cantidadAdultos = cantidadAdultos;
    }

    public int getCantidadNinos() {
        return cantidadNinos;
    }

    public void setCantidadNinos(int cantidadNinos) {
        this.cantidadNinos = cantidadNinos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
