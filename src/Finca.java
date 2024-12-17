import java.time.LocalDate;

public class Finca extends Alojamiento{
    public Finca(String nombreAlojamiento, String ciudadDestino, int maxAdultos, int maxNinos, boolean ofreceDiaDeSol, double calificacion, String actividades, Habitacion[] habitaciones) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, maxNinos, ofreceDiaDeSol, calificacion, actividades, habitaciones);
    }

    @Override
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion()
        );
        double precioTotal = calcularPrecioTotal(inicioEstadia, finEstadia, habitacionesSolicitadas);
        System.out.println("El precio total de la estadía es: $" + precioTotal);
//        mostrarHabitacionesDisponibles();
    }
}
