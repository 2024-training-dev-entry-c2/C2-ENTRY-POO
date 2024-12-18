package Models;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    private final String name;
    private final String city;
    private final Type type;
    private final double rating;
    private final boolean lunch;
    private final List<Room> rooms;
    private final List<Clients> clients;

    public Hotel(String name, String city, Type type, double rating, boolean lunch) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.rating = rating;
        this.lunch = lunch;
        this.rooms = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Type getType() {
        return type;
    }

    public double getRating() {
        return rating;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public boolean isLunch () {return lunch;}

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addReservation(Clients client) {
        this.clients.add(client);
    }
}