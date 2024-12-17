// Abstraccion para obtener de la interfaz la gestion de reservas
public abstract class Lodging implements IReservationService {
    private String name;
    private String location;
    private String type;
    private double rating;
    private int price;
    private int availableRooms;
    private String[] roomDescriptions;

    public Lodging(String name, String location, String type,
                   double rating, int price, int availableRooms,
                   String[] roomDescriptions) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.rating = rating;
        this.price = price;
        this.availableRooms = availableRooms;
        this.roomDescriptions = roomDescriptions;
    }

    @Override
    public boolean checkAvailability(int requiredRooms) {
        return availableRooms >= requiredRooms;
    }

    @Override
    public void reduceAvailableRooms(int rooms) {
        if (rooms <= availableRooms) {
            availableRooms -= rooms;
        }
    }

    @Override
    public void increaseAvailableRooms(int rooms) {
        availableRooms += rooms;
    }

    @Override
    public abstract double calculateFinalPrice(int days);

// Marca la habitacion como ocupada para que no aparezca
    public boolean markRoomAsOccupied(String selectedRoom) {
        for (int i = 0; i < roomDescriptions.length; i++) {
            if (roomDescriptions[i].equals(selectedRoom)) {
                roomDescriptions[i] = "Ocupada";
                return true;
            }
        }
        return false;
    }
// Quita la marcacion de ocupada para que se muestre como disponible
    public boolean unmarkRoom(String occupiedRoom) {
        for (int i = 0; i < roomDescriptions.length; i++) {
            if (roomDescriptions[i].equals("Ocupada")) {
                roomDescriptions[i] = occupiedRoom; // Restaurar descripción original
                return true;
            }
        }
        return false;
    }


    // Getters y Setters del Alojamiento
    public String getName() {return name;}
    public void setName(String name) { this.name = name; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getAvailableRooms() { return availableRooms; }
    public void setAvailableRooms(int availableRooms) { this.availableRooms = availableRooms; }
    public String[] getRoomDescriptions() { return roomDescriptions; }
    public void setRoomDescriptions(String[] roomDescriptions) { this.roomDescriptions = roomDescriptions; }

    public String getDetails() { return name; }
    public String getDetails(boolean includeLocation) {
        return includeLocation ? name + " - " + location : name;
    }
}