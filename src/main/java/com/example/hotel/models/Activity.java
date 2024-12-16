package com.example.hotel.models;

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
}
