package com.example.hotel.models;

public class Room extends Stay {
  private double pricePerNight;

  public Room(String typeOfRoom, String description, int disponingCapacity, int quantity, double pricePerNight) {
    super(typeOfRoom, description, disponingCapacity, quantity);
    this.pricePerNight = pricePerNight;
  }

  public Room(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  @Override
  public String printStay() {
    return "  Tipo de habitación: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Precio por noche: $" + pricePerNight + "\n" +
           "  Disponibilidad: " + disponingCapacity + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
