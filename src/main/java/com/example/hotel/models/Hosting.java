package com.example.hotel.models;

public abstract class Hosting {
  protected String city;
  protected String typeOfHousing;
  protected String name;
  protected double rating;
  protected double pricePerNight;
  protected double pricePerStay;

  public Hosting(String city, String typeOfHousing, String name, double rating, double pricePerNight) {
    this.city = city;
    this.typeOfHousing = typeOfHousing;
    this.name = name;
    this.rating = rating;
    this.pricePerNight = pricePerNight;
  }

  public Hosting() {
  }

  public abstract String printHosting();
}
