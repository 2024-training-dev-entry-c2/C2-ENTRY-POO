package example.hotel;

public interface Reservable {
    void reservar(String fechaInicio, String fechaFin, int cantidadHabitaciones);
    void cancelarReserva();
    void actualizarReserva(String fechaInicio, String fechaFin, int cantidadHabitaciones);
}
