package com.example.hotel.models;

public class Stay {
  private String hostingName;
  private String typeOfRoom;
  private String description;
  private double pricePerNight;
  private int capacityAvailability;
  private int quantity;

  public Stay(String hostingName, String typeOfRoom, String description, double pricePerNight, int capacityAvailability, int quantity) {
    this.hostingName = hostingName;
    this.typeOfRoom = typeOfRoom;
    this.description = description;
    this.pricePerNight = pricePerNight;
    this.capacityAvailability = capacityAvailability;
    this.quantity = quantity;
  }

  public Stay(String hostingName, String typeOfRoom, String description, double pricePerNight, int capacityAvailability) {
    this.hostingName = hostingName;
    this.typeOfRoom = typeOfRoom;
    this.description = description;
    this.pricePerNight = pricePerNight;
    this.capacityAvailability = capacityAvailability;
  }

  public Stay() {
  }

  public String getHostingName() {
    return hostingName;
  }

  public void setHostingName(String hostingName) {
    this.hostingName = hostingName;
  }

  public String getTypeOfRoom() {
    return typeOfRoom;
  }

  public void setTypeOfRoom(String typeOfRoom) {
    this.typeOfRoom = typeOfRoom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(double pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public int getCapacityAvailability() {
    return capacityAvailability;
  }

  public void setCapacityAvailability(int capacityAvailability) {
    this.capacityAvailability = capacityAvailability;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String printStay() {
    return "  Tipo de habitación o actividad: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Precio por noche: $" + pricePerNight  + "\n" +
           "  Disponibilidad: " + capacityAvailability + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
