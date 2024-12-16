package com.example.hotel.models;

public class Room extends Stay {
  private double pricePerNight;

  public Room(String typeOfRoom, String description, double pricePerNight, int capacityAvailability, int quantity) {
    super(typeOfRoom, description, capacityAvailability, quantity);
    this.pricePerNight = pricePerNight;
  }

  public Room(String typeOfRoom, String description, double pricePerNight, int capacityAvailability) {
    super(typeOfRoom, description, capacityAvailability);
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
           "  Disponibilidad: " + capacityAvailability + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
