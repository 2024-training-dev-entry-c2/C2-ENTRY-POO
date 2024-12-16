package com.bookstay.models;

import java.time.LocalDate;
import java.util.List;

public class DayResort extends Lodging{
    private List<String> activities;
    private List<String> meals;
    private double pricePerPerson;

    public DayResort(String name, String city, String category, double rating, String description, List<String> activities, List<String> meals, double price) {
        super(name, city, category, rating, description);
        this.activities = activities;
        this.meals = meals;
        this.pricePerPerson = price;
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
    public boolean isAvailable(String startDate, String endDate, int guests) {
        if (!startDate.equals(endDate)) {
            return false;
        }

        LocalDate date = LocalDate.parse(startDate);

        for (Reservation reservation : getReservations()) {
            if (datesOverlap(reservation.getStartDate(), reservation.getEndDate(), date, date)) {
                return false;
            }
        }
        return true;
    }

    private boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
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
