import java.time.LocalDate;

public class Finca extends Alojamiento{
    public Finca(String nombreAlojamiento, String ciudadDestino, int maxAdultos, int maxNinos, boolean ofreceDiaDeSol, double calificacion, String actividades, boolean incluyeAlmuerzo, boolean incluyeRefrigerio, Habitacion[] habitaciones) {
        super(nombreAlojamiento, ciudadDestino, maxAdultos, maxNinos, ofreceDiaDeSol, calificacion, actividades, incluyeAlmuerzo, incluyeRefrigerio, habitaciones);
    }

    @Override
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos, boolean incluyeAlmuerzo, boolean incluyeRefrigerio) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion()
        );
        double precioTotal = calcularPrecioTotal(inicioEstadia, finEstadia, habitacionesSolicitadas);
        System.out.println("El precio base total de la estadía es: $" + precioTotal);
        mostrarInfoActividadesYAdicionales(adultos, ninos, incluyeAlmuerzo, incluyeRefrigerio);
//        mostrarHabitacionesDisponibles();
    }

    @Override
    public void mostrarHabitacionesDisponibles() {
        super.mostrarHabitacionesDisponibles();
    }
}
