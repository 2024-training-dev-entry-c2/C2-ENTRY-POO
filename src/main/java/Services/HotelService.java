package Services;

import Interface.IHotelService;
import Models.Type;
import Models.Hotel;
import Models.Clients;
import Models.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelService implements IHotelService {
    private final List<Hotel> hotels;

    public HotelService(List<Hotel> hotels) {
        if (hotels == null || hotels.isEmpty()) {
            throw new IllegalArgumentException("Ingrese un valor válido");
        }
        this.hotels = hotels;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotels;
    }

    @Override
    public List<String> searchHotels(String city, Type type, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {

        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("Ingrese el nombre de la ciudad");
        };

        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        List<String> filteredHotels = new ArrayList<>();

        for (Hotel hotel : hotels) {
            if (!hotel.getCity().equalsIgnoreCase(city)) continue;
            if (type != null && hotel.getType() != type) continue;

            StringBuilder hotelInfo = new StringBuilder();
            boolean hasRooms = false;

            hotelInfo.append("Hotel: ").append(hotel.getName())
                    .append(", Calificación: ").append(hotel.getRating())
                    .append("\nHabitaciones Disponibles: \n");

            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    hasRooms = true;
                    hotelInfo.append(" - ").append(room.getType())
                            .append(", Precio: $").append(room.getPriceNight()).append("\n");
                }
            }
            if (hasRooms) {
                filteredHotels.add(hotelInfo.toString());
            }
        }
        if (filteredHotels.isEmpty()) {
            throw new IllegalStateException("No se encontraron hoteles disponibles para esos parametros.");
        }
        return filteredHotels;
    }

    @Override
    public List<String> searchRooms(String hotelName, LocalDate startDate, LocalDate endDate, int adults, int children, int rooms) {
        if (hotelName == null || hotelName.isBlank()) throw new IllegalArgumentException("Ingrese nombre del hotel.");
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        for (Hotel hotel : hotels) {
            if (!hotel.getName().equalsIgnoreCase(hotelName)) continue;

            List<String> totaleRooms = new ArrayList<>();
            int roomCount = 0;

            for (Room room:hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    totaleRooms.add("Tipo: " + room.getType() + ", Descripción: " + room.getFeatures());
                    roomCount++;
                }
                if (roomCount == rooms){
                    break;
                };
            }

            if (totaleRooms.isEmpty()) {
                throw new IllegalStateException("No hay habitaciones disponibles para ese hotel.");
            }

            return totaleRooms;
        }

        throw new IllegalArgumentException("El hotel no existe.");
    }

    @Override
    public String reserve(String firstName, String lastName, String email, LocalDate dateBirth , String nationality, String phone, String arrivalTime, LocalDate startDate,
                              LocalDate endDate, int adults, int children) {
        if (firstName == null || lastName == null || email == null || phone == null) {
            throw new IllegalArgumentException("Ingrese los datos personales.");
        }
        if (startDate == null || endDate == null || !startDate.isBefore(endDate)) {
            throw new IllegalArgumentException("Las fechas de inicio y fin no son válidas.");
        }

        List<Hotel> totalHotels = new ArrayList<>();
        for (Hotel hotel : hotels) {
            for (Room room : hotel.getRooms()) {
                if (room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)) {
                    totalHotels.add(hotel);
                    break;
                }
            }
        }

        if (totalHotels.isEmpty()) {
            throw new IllegalStateException("No hay habitaciones disponibles.");
        }

        Hotel selectedHotel = totalHotels.get(0);
        Room selectedRoom = selectedHotel.getRooms().stream().filter(room -> room.isAvailable(startDate, endDate) && room.getCapacity() >= (adults + children)).findFirst().orElseThrow(() -> new IllegalStateException("No hay habitaciones disponibles."));

        Clients client = new Clients(firstName, lastName, email, dateBirth , nationality, phone, startDate, endDate, adults, children, 1, selectedRoom.getType(), arrivalTime);

        selectedRoom.setAvailability(false);
        selectedHotel.addReservation(client);

        return "Reserva realizada con éxito en" + selectedHotel.getName() + "!!.";

    }
    @Override
    public String changeReservation(String email, LocalDate dateBirth, int option, int roomOption, int newRoom) {
        for (Hotel hotel : hotels) {
            Optional<Clients> client = hotel.getClients().stream().filter(currentClient -> currentClient.getEmail().equalsIgnoreCase(email) && currentClient.getDateBirth().equals(dateBirth)).findFirst();

            if (client.isPresent()) {
                Clients customer = client.get();

                System.out.println("Información de la reserva: ");
                System.out.println("Instalación: " + hotel.getName());
                System.out.println("Habitación: " + customer.getRoomType());
                System.out.println("Fecha de llegada: " + customer.getStartDate());
                System.out.println("Fecha de salida: " + customer.getEndDate());

                if (option == 1) {
                    Room oldRoom = hotel.getRooms().get(roomOption - 1);
                    List<Room> availableRooms = hotel.getRooms().stream().filter(room -> room.isAvailable(customer.getStartDate(), customer.getEndDate()) && room.getCapacity() >= (customer.getAdultCount() + customer.getChildCount())).toList();

                    Room changedRoom = availableRooms.get(newRoom - 1);
                    oldRoom.setAvailability(true);
                    changedRoom.setAvailability(false);
                    customer.setRoomType(changedRoom.getType());

                    return "Reserva actualizada. Habitación: " + changedRoom.getType();

                } else if (option == 2) {
                    hotel.getClients().remove(client);
                    return "Reserva eliminada. Cree una nueva reserva.";

                } else {
                    return "Error.";
                }
            }
        }
        return "No se encontró la reserva.";
};
}