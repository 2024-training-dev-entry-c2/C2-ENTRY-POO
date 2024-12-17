package com.bookstay;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class DayResort extends Lodging {
    private List<String> activities;
    private List<String> meals;
    private double pricePerPerson;

    public DayResort(String name, String city, double rating, String description, double price) {
        super(name, city, "Día de sol", rating, description);
        this.activities = new ArrayList<>();
        this.meals = new ArrayList<>();
        this.pricePerPerson = price;
    }

    public void addActivity(String activity){
        activities.add(activity);
    }

    public void addMeal(String meal){
        meals.add(meal);
    }

    @Override
    public double calculatePrice(int adults, int children, int days) {
        if (days != 1) {
            throw new IllegalArgumentException("Un 'Día de Sol' solo puede ser reservado por 1 día.");
        }

        int totalGuests = adults + children;
        return totalGuests * pricePerPerson;
    }


    public boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests) {
        if (!startDate.isEqual(endDate)) {
            return false;
        }

        for (Reservation reservation : getReservations()) {
            if (datesOverlap(reservation.getStartDate(), reservation.getEndDate(), startDate, startDate)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<String> confirmAvailability(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        System.out.println("Descripción: " + description);
        System.out.println("Actividades: " + activities);
        System.out.println("Comidas: " + meals);
        return new ArrayList<>();
    }




    @Override
    public void printDetails(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        double pricePerNight = calculatePrice(adults, children, 1);
        long days = ChronoUnit.DAYS.between(startDate, endDate);
        double baseTotalPrice = calculatePrice(adults, children, (int) days);
        double adjustment = calculateDiscountOrIncrement(startDate, endDate);
        double totalAdjusted;
        System.out.println(this.toString());
        System.out.println("Precio por persona: $" + pricePerNight);
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
                "Descripción: " + description + '\n' +
                "Actividades: " + activities.toString() + '\n' +
                "Meriendas Incluidas: " + meals.toString()
                ;
    }

    // Getters
    public List<String> getActivities() {
        return activities;
    }

    public List<String> getMealsIncluded() {
        return meals;
    }

    public double getPricePerPerson() {
        return pricePerPerson;
    }
}
