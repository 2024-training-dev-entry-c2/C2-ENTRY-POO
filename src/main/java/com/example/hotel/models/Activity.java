package com.example.hotel.models;

import java.util.List;

public class Activity extends Stay {
  private double pricePerDay;

  public Activity(String typeOfRoom, String description, double pricePerDay,int capacityAvailability, int quantity) {
    super(typeOfRoom, description, capacityAvailability, quantity);
    this.pricePerDay = pricePerDay;
  }

  public Activity(String typeOfRoom, String description, double pricePerDay, int capacityAvailability) {
    super(typeOfRoom, description, capacityAvailability);
    this.pricePerDay = pricePerDay;
  }

  public Activity(double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  public double getPricePerDay() {
    return pricePerDay;
  }

  public void setPricePerDay(double pricePerDay) {
    this.pricePerDay = pricePerDay;
  }

  @Override
  public String printStay() {
    return "  Tipo de actividad: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Precio por noche: $" + pricePerDay + "\n" +
           "  Disponibilidad: " + capacityAvailability + "\n" +
           "  Cantidad: " + quantity + "\n";
  }

  public static double getMinPrice(List<Activity> activities) {
    double minPrice = Double.MAX_VALUE;

    for (Activity activity : activities) {
      if (activity.getPricePerDay() < minPrice) {
        minPrice = activity.getPricePerDay();
      }
    }

    return minPrice == Double.MAX_VALUE ? 0.0 : minPrice;
  }
}
