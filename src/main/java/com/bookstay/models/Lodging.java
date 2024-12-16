package com.bookstay.models;

public abstract class Lodging {
    private String name;
    private String city;
    private String category;
    private double rating;
    private String description;
    //private List<Reservation> reservations;

    //Constructor
    public Lodging(String name, String city, String category, double rating, String description) {
        this.name = name;
        this.city = city;
        this.category = category;
        this.rating = rating;
        this.description = description;
        //this.reservations = new ArrayList<>();
    }

    public abstract double calculatePrice(int adults, int children, int days);

    public abstract boolean isAvailable(String startDate, String endDate, int guests);

    /*
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
    */

    // Getters y setters
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
