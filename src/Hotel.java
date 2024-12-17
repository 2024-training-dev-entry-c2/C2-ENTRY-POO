import java.time.LocalDate;

public class Hotel extends Alojamiento {
    public Hotel(String nombreAlojamiento, String ciudadDestino, int maxAdultos, int maxNinos, boolean ofreceDiaDeSol, double calificacion, String actividades, boolean incluyeAlmuerzo, boolean incluyeRefrigerio, Habitacion[] habitaciones) {
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
    }

    //sobrecarga
    public void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia) {
        System.out.println("Nombre: " + getNombreAlojamiento() +
                "\nciudad: " + getCiudadDestino() +
                "\nCalificación: " + getCalificacion()
        );
        System.out.println("Fecha de inicio de estadia: " + inicioEstadia);
        System.out.println("Fecha de fin de estadia: " + finEstadia);
    }

    @Override
    public void mostrarHabitacionesDisponibles() {
        super.mostrarHabitacionesDisponibles();
    }
}

