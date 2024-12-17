package com.bookstay.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Hotel extends Lodging implements IRoomReservable{
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
    public double calculatePrice(int adults, int children, int days) {
        System.out.println("No aplica a este alojamiento.");
        return 0;
    }


    public double calculatePrice(int adults, int children, int days, int requiredRooms) {
            double lowestPrice = Double.MAX_VALUE;
            for (Room room : rooms) {
                if (room.getPricePerNight() < lowestPrice) {
                    lowestPrice = room.getPricePerNight();
                }
            }
            return lowestPrice * days * requiredRooms;
    }

    public double calculatePrice(int adults, int children, int days, List<Room> selectedRooms) {
        double totalPrice = 0;
        for (Room room : selectedRooms) {
            totalPrice += room.getPricePerNight() * days;
        }
        return totalPrice;
    }

    public boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests){
        System.out.println("No aplica a este alojamiento.");
        return false;
    }

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
    public List<String> confirmAvailability(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        List<String> availableRooms = new ArrayList<>();

        int totalGuests = adults + children;
        int roomsRequired = roomsNeeded > 0 ? roomsNeeded : (int) Math.ceil((double) totalGuests / rooms.get(0).getCapacity());

        System.out.println("Verificando disponibilidad de habitaciones en el Hotel: " + getName());

        for (Room room : rooms) {
            int reservedRooms = countReservedRooms(room.getType(), startDate, endDate);
            int availableRoomsCount = room.getTotalRooms() - reservedRooms;

            if (availableRoomsCount > 0) {
                System.out.println("- Nombre: " + room.getType());
                System.out.println("  Descripción: " + room.getDescription());
                System.out.println("  Habitaciones disponibles: " + availableRoomsCount);
                availableRooms.add(room.getType());
            }
        }

        if (availableRooms.size() >= roomsRequired) {
            return availableRooms;
        } else {
            System.out.println("No hay suficientes habitaciones disponibles para el rango de fechas seleccionado.");
            return new ArrayList<>();
        }
    }

    private int countReservedRooms(String roomType, LocalDate startDate, LocalDate endDate) {
        int reservedCount = 0;

        for (Reservation reservation : getReservations()) {
            for (Room room : reservation.getRooms()) {
                if (room.getType().equals(roomType) && datesOverlap(reservation.getStartDate(), reservation.getEndDate(), startDate, endDate)) {
                    reservedCount++;
                }
            }
        }
        return reservedCount;
    }




    @Override
    public void printDetails(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        double pricePerNight = calculatePrice(adults, children, 1, roomsNeeded);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double baseTotalPrice = calculatePrice(adults, children, (int) days, roomsNeeded);
        double adjustment = calculateDiscountOrIncrement(startDate, endDate);
        double totalAdjusted;
        System.out.println(this.toString());
        System.out.println("Precio por noche: $" + pricePerNight);
        System.out.println("Precio base total: $" + baseTotalPrice);

        if(adjustment < 0){
            System.out.println("Descuento del " + adjustment * 100 + "%");
        }else if(adjustment > 0){
            System.out.println("Incremento del " + adjustment * 100 + "%");
        }
        totalAdjusted = baseTotalPrice + (baseTotalPrice * adjustment);
        System.out.println("Precio final: $" + totalAdjusted);
    }

    @Override
    public String toString() {
        return  name + '\n' +
                "+------------------------------------+" + '\n' +
                "Calificación: " + rating +'\n' +
                "Descripción: " + description + '\n'
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

    public int getTotalRooms() {
        return totalRooms;
    }

}
