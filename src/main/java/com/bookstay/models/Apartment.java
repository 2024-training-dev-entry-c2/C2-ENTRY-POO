package com.bookstay.models;

import java.time.LocalDate;

public class Apartment extends Lodging{
    private int maxCapacity;
    private double pricePerNight;

    public Apartment(String name, String city, double rating, String description, int maxCapacity, double pricePerNight) {
        super(name, city, "Apartamento", rating, description);
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public double calculatePrice(int adults, int children, int days, Object... params) {
        int totalPeople = adults + children;

        if (totalPeople > maxCapacity) {
            throw new IllegalArgumentException("La capacidad máxima del apartamento es de " + maxCapacity + " personas.");
        }

        return pricePerNight * days;
    }

    @Override
    public boolean isAvailable(String startDate, String endDate, int guests) {
        if (guests > maxCapacity) {
            return false;
        }

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        for (Reservation reservation : getReservations()) {
            if (datesOverlap(reservation.getStartDate(), reservation.getEndDate(), start, end)) {
                return false;
            }
        }
        return true;
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

    // Getters y setters
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
