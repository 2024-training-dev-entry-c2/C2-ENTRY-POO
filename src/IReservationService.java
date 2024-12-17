// Defino los métodos principales para la gestión de reservas usando una interfaz
public interface IReservationService {
    double calculateFinalPrice(int days);
    boolean checkAvailability(int requiredRooms);
    void reduceAvailableRooms(int rooms);
    void increaseAvailableRooms(int rooms);
}