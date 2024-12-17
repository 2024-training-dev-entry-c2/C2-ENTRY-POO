package example.hotel;

public interface IReservable {
    void reservar(String fechaInicio, String fechaFin, int cantidadHabitaciones);
    void cancelarReserva();
    void actualizarReserva(String fechaInicio, String fechaFin, int cantidadHabitaciones);
}
