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
    public boolean isAvailable(String startDate, String endDate, int guests) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        int requiredRooms = (int) Math.ceil((double) guests / rooms.get(0).getCapacity());

        for (Room room : rooms) {
            if (room.getCapacity() >= guests / requiredRooms && room.isAvailable(getReservations(), startDate, endDate)) {
                return true;
            }
        }
        return false;
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

    public boolean isAvailable(List<Reservation> reservations, String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        int reservedCount = 0;
        for (Reservation reservation : reservations) {
            for (Room room : reservation.getRooms()) {
                if (room.getType().equals(this.type) && datesOverlap(reservation.getStartDate(), reservation.getEndDate(), start, end)) {
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
