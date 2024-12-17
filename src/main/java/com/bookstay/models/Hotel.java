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

    public void addRoom(String type, String description, double pricePerNight, int capacity, int totalRooms){
        Room room = new Room(type,description,pricePerNight,capacity,totalRooms);
        rooms.add(room);
    }

    @Override
    public double calculatePrice(int adults, int children, int days, Object... params) {
        if (params.length == 1 && params[0] instanceof Integer) {
            int requiredRooms = (int) params[0];
            double lowestPrice = Double.MAX_VALUE;
            for (Room room : rooms) {
                if (room.getPricePerNight() < lowestPrice) {
                    lowestPrice = room.getPricePerNight();
                }
            }
            return lowestPrice * days * requiredRooms;
        } else if (params.length == 1 && params[0] instanceof List) {
            List<Room> selectedRooms = (List<Room>) params[0];
            double totalPrice = 0;
            for (Room room : selectedRooms) {
                totalPrice += room.getPricePerNight() * days;
            }
            return totalPrice;
        }
        throw new IllegalArgumentException("Invalid parameters for calculatePrice");
    }

    @Override
    public boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests, int requiredRooms) {
        int roomsNeeded = requiredRooms > 0 ? requiredRooms : (int) Math.ceil((double) guests / rooms.get(0).getCapacity());
        int roomsAvailable = 0;

        for (Room room : rooms) {
            if (room.isAvailable(getReservations(), startDate, endDate)) {
                roomsAvailable++;
            }

            // Verificar si ya hay suficientes habitaciones disponibles
            if (roomsAvailable >= roomsNeeded) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "+------------------------------------+" +
                "       " + name + '\n' +
                "Calificación: " + rating +'\n' +
                "Descripción: " + description + '\n' +
                "+------------------------------------+"
                ;
    }

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
    private int totalRooms;

    public Room(String type, String description, double pricePerNight, int capacity, int totalRooms) {
        this.type = type;
        this.description = description;
        this.pricePerNight = pricePerNight;
        this.capacity = capacity;
        this.totalRooms = totalRooms;
    }

    public boolean isAvailable(List<Reservation> reservations, LocalDate startDate, LocalDate endDate) {
        int reservedCount = 0;
        for (Reservation reservation : reservations) {
            for (Room room : reservation.getRooms()) {
                if (room.getType().equals(this.type) && datesOverlap(reservation.getStartDate(), reservation.getEndDate(), startDate, endDate)) {
                    reservedCount++;
                }
            }
        }
        return reservedCount < totalRooms;
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

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
