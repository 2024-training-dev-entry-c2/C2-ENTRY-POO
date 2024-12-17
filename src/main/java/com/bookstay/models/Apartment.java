package com.bookstay.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Apartment extends Lodging{
    private int maxCapacity;
    private double pricePerNight;

    public Apartment(String name, String city, double rating, String description, int maxCapacity, double pricePerNight) {
        super(name, city, "Apartamento", rating, description);
        this.maxCapacity = maxCapacity;
        this.pricePerNight = pricePerNight;
    }

    @Override
    public double calculatePrice(int adults, int children, int days) {
        int totalPeople = adults + children;

        if (totalPeople > maxCapacity) {
            throw new IllegalArgumentException("La capacidad máxima del apartamento es de " + maxCapacity + " personas.");
        }
        return pricePerNight * days;
    }

    @Override
    public boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests) {
        if (guests > maxCapacity) {
            return false;
        }

        for (Reservation reservation : getReservations()) {
            if (datesOverlap(reservation.getStartDate(), reservation.getEndDate(), startDate, endDate)) {
                return false;
            }
        }
        return true;
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

    @Override
    public void printDetails(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        double pricePerNight = calculatePrice(adults, children, 1);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double baseTotalPrice = calculatePrice(adults, children, (int) days);
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

    // Getters y setters
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
