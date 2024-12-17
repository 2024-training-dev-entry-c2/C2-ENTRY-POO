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

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getTypeOfHousing() {
    return typeOfHousing;
  }

  public void setTypeOfHousing(String typeOfHousing) {
    this.typeOfHousing = typeOfHousing;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public double getPricePerStay() {
    return pricePerStay;
  }

  public void setPricePerStay(double pricePerStay) {
    this.pricePerStay = pricePerStay;
  }

  public abstract String printHosting();
  public abstract String printHostingWithStay();
}
