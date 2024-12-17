package com.bookstay;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class FarmStay extends Lodging{
    private int maxCapacity;
    private double pricePerNight;

    public FarmStay(String name, String city, double rating, String description, int maxCapacity, double price) {
        super(name, city, "Finca", rating, description);
        this.maxCapacity = maxCapacity;
        this.pricePerNight = price;
    }

    @Override
    public double calculatePrice(int adults, int children, int days) {
        int totalPeople = adults + children;

        if (totalPeople > maxCapacity) {
            throw new IllegalArgumentException("La capacidad máxima de la finca es de " + maxCapacity + " personas.");
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

    @Override
    public List<String> confirmAvailability(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        int totalGuests = adults + children;

        if (!isAvailable(startDate, endDate, totalGuests)) {
            System.out.println("La finca no está disponible para el rango de fechas seleccionado.");
            return new ArrayList<>();
        }

        System.out.println("Descripción: " + getDescription());
        return List.of("Capacidad máxima: " + getMaxCapacity() + " personas.");
    }


    @Override
    public void printDetails(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        double pricePerNight = calculatePrice(adults, children, 1);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double baseTotalPrice = calculatePrice(adults, children, (int) days);
        double adjustment = calculateDiscountOrIncrement(startDate, endDate);
        double totalAdjusted;
        System.out.println(this.toString());
        System.out.println("Precio por noche: $" + String.format("%.2f", pricePerNight) );
        System.out.println("Precio base total: $" + String.format("%.2f", baseTotalPrice));

        if(adjustment < 0){
            System.out.println("Descuento del " + adjustment * 100 + "%");
        }else if(adjustment > 0){
            System.out.println("Incremento del " + adjustment * 100 + "%");
        }
        totalAdjusted = baseTotalPrice + (baseTotalPrice * adjustment);
        System.out.println("Precio final: $" + String.format("%.2f", totalAdjusted));
    }

    @Override
    public String toString() {
        return   name + '\n' +
                "+------------------------------------+" + '\n' +
                "Calificación: " + rating +'\n' +
                "Descripción: " + description + '\n'
                ;
    }

    // Getter
    public int getMaxCapacity() {
        return maxCapacity;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}
