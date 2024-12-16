package com.bookstay.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel extends Lodging{
    private List<Room> rooms;

    public Hotel(String name, String city, double rating, String description) {
        super(name, city, "Hotel", rating, description);
        this.rooms = new ArrayList<>();
    }

    @Override
    public double calculatePrice(int adults, int children, int days) {
        return 0;
    }

    /*@Override
    public boolean isAvailable(String startDate, String endDate, int guests) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        for (Room room : rooms) {
            if (room.getCapacity() >= guests && room.isAvailable(startDate, endDate)) {
                return true;
            }
        }
        return false;
    }*/

    // Getters
    public List<Room> getRooms() {
        return rooms;
    }
}

class Room {
    private String type;
    private String description;
    private double pricePerNight;
    private int capacity;

    public Room(String type, String description, double pricePerNight, int capacity) {
        this.type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
    }

    /*public boolean isAvailable(List<Reservation> reservations, String startDate, String endDate) {
        // Lógica de disponibilidad (simplificada)
        return true;
    }*/

    // Getters
    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public int getCapacity() {
        return capacity;
    }
}
