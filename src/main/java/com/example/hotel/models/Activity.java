package com.example.hotel.models;

public class Activity extends Stay {
  private double pricePerDay;

  public Activity(String typeOfRoom, String description, int disponingCapacity, int quantity, double pricePerDay) {
    super(typeOfRoom, description, disponingCapacity, quantity);
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
    return "  Tipo de habitación: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Precio por noche: $" + pricePerDay + "\n" +
           "  Disponibilidad: " + disponingCapacity + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
