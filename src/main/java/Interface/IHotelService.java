package Interface;

import Models.Type;
import Models.Hotel;

import java.time.LocalDate;
import java.util.List;

public interface IHotelService {
    List<Hotel> getHotels();
    List<String> searchHotels(String city, Type type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms);
    List<String> searchRooms(String hotelName, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms);
    String reserve(String firstName, String lastName, String email,LocalDate dateBirth , String nationality, String phone, String arrivalTime, LocalDate startDate, LocalDate endDate, int adults, int children);
    String changeReservation(String email, LocalDate dateOfBirth, int option, int roomOption, int newRoomOption);
}