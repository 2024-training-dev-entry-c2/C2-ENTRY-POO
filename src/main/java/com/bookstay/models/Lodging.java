package com.bookstay.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public abstract class Lodging {
    protected String name;
    protected String city;
    protected String category;
    protected double rating;
    protected String description;
    protected List<Reservation> reservations;

    //Constructor
    public Lodging(String name, String city, String category, double rating, String description) {
        this.name = name;
        this.city = city;
        this.category = category;
        this.rating = rating;
        this.description = description;
        this.reservations = new ArrayList<>();
    }


    public abstract double calculatePrice(int adults, int children, int days);

    public abstract boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests);

    public abstract List<String> confirmAvailability(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded);

    public abstract void printDetails(LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded);


    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public static double calculateDiscountOrIncrement(LocalDate startDate, LocalDate endDate){
        LocalDate range1Start = LocalDate.of(startDate.getYear(), startDate.getMonth(), 5);
        LocalDate range1End = LocalDate.of(startDate.getYear(), startDate.getMonth(), 10);
        LocalDate range2Start = LocalDate.of(startDate.getYear(), startDate.getMonth(), 10);
        LocalDate range2End = LocalDate.of(startDate.getYear(), startDate.getMonth(), 15);
        LocalDate range3Start = LocalDate.of(startDate.getYear(), startDate.getMonth(), 26);
        LocalDate range3End = LocalDate.of(startDate.getYear(), startDate.getMonth(), 31);

        // Calculate intersection days for each range
        long daysInRange1 = calculateIntersectionDays(startDate, endDate, range1Start, range1End);
        long daysInRange2 = calculateIntersectionDays(startDate, endDate, range2Start, range2End);
        long daysInRange3 = calculateIntersectionDays(startDate, endDate, range3Start, range3End);

        // Determine the range with the largest intersection
        if (daysInRange1 >= daysInRange2 && daysInRange1 >= daysInRange3) {
            return -0.08f;
        } else if (daysInRange2 >= daysInRange1 && daysInRange2 >= daysInRange3) {
            return 0.10f;
        } else if (daysInRange3 > 0) {
            return 0.15f;
        }
        return 0;
    }

    public static long calculateIntersectionDays(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        LocalDate maxStart = start1.isAfter(start2) ? start1 : start2;
        LocalDate minEnd = end1.isBefore(end2) ? end1 : end2;

        if (maxStart.isBefore(minEnd) || maxStart.equals(minEnd)) {
            return ChronoUnit.DAYS.between(maxStart, minEnd) + 1;
        }
        return 0;
    }

    public boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !start1.isAfter(end2) && !end1.isBefore(start2);
    }

    // Getters y setters

    public List<Reservation> getReservations() {
        return reservations;
    }
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }
}
