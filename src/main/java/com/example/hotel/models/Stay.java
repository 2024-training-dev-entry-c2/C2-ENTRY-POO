package com.example.hotel.models;

public class Stay {
  protected String typeOfRoom;
  protected String description;
  protected int capacityAvailability;
  protected int quantity;

  public Stay(String typeOfRoom, String description, int capacityAvailability, int quantity) {
    this.typeOfRoom = typeOfRoom;
    this.description = description;
    this.capacityAvailability = capacityAvailability;
    this.quantity = quantity;
  }

  public Stay(String typeOfRoom, String description, int capacityAvailability) {
    this.typeOfRoom = typeOfRoom;
    this.description = description;
    this.capacityAvailability = capacityAvailability;
  }

  public Stay() {
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
    return "  Tipo de habitación: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Disponibilidad: " + capacityAvailability + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
