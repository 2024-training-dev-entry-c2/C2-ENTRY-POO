package com.example.hotel.models;

import java.util.List;

public abstract class Hosting {
  protected String city;
  protected String typeOfHousing;
  protected String name;
  protected double rating;
  protected double pricePerNight;
  protected double pricePerStay;
  protected List<Stay> stays;

  public Hosting(String city, String typeOfHousing, String name, double rating, double pricePerNight, double pricePerStay, List<Stay> stays) {
    this.city = city;
    this.typeOfHousing = typeOfHousing;
    this.name = name;
    this.rating = rating;
    this.pricePerNight = pricePerNight;
    this.pricePerStay = pricePerStay;
    this.stays = stays;
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

  public List<Stay> getStays() {
    return stays;
  }

  public void setStays(List<Stay> stays) {
    this.stays = stays;
  }

  public abstract String printHosting();
  public abstract String printHostingWithStay();
}
