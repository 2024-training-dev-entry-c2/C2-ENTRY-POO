package com.bookstay.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayResort extends Lodging{
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
    public double calculatePrice(int adults, int children, int days, Object... params) {
        if (days != 1) {
            throw new IllegalArgumentException("Un 'Día de Sol' solo puede ser reservado por 1 día.");
        }

        int totalGuests = adults + children;
        return totalGuests * pricePerPerson;
    }

    @Override
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

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

    @Override
    public String toString() {
        return "+------------------------------------+" +
                "       " + name + '\n' +
                "Calificación: " + rating +'\n' +
                "Descripción: " + description + '\n' +
                "Actividades: " + activities.toString() + '\n' +
                "Meriendas Incluidas: " + meals.toString() +
                "+------------------------------------+"
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
