package com.example.hotel.models;

import java.util.List;

public class Room extends Stay {
  private double pricePerNight;
  private String hostingName;

  public Room(String hostingName, String typeOfRoom, String description, double pricePerNight, int capacityAvailability, int quantity) {
    super(typeOfRoom, description, capacityAvailability, quantity);
    this.pricePerNight = pricePerNight;
    this.hostingName = hostingName;
  }

  public Room(String hostingName, String typeOfRoom, String description, double pricePerNight, int capacityAvailability) {
    super(typeOfRoom, description, capacityAvailability);
    this.pricePerNight = pricePerNight;
    this.hostingName = hostingName;
  }

  public Room(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public Room() {
  }

  public double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public String getHostingName() {
    return hostingName;
  }

  public void setHostingName(String hostingName) {
    this.hostingName = hostingName;
  }

  @Override
  public String printStay() {
    return "  Hotel: " + hostingName + "\n" +
      "  Tipo de habitación: " + typeOfRoom + "\n" +
      "  Descripción: " + description + "\n" +
      "  Precio por noche: $" + pricePerNight + "\n" +
      "  Disponibilidad: " + capacityAvailability + "\n" +
      "  Cantidad: " + quantity + "\n";
  }
}
