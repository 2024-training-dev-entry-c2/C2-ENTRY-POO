package com.example.hotel.models;

public class Stay {
  protected String typeOfRoom;
  protected String description;
  protected int disponingCapacity;
  protected int quantity;

  public Stay(String typeOfRoom, String description, int disponingCapacity, int quantity) {
    this.typeOfRoom = typeOfRoom;
    this.description = description;
    this.disponingCapacity = disponingCapacity;
    this.quantity = quantity;
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

  public int getDisponingCapacity() {
    return disponingCapacity;
  }

  public void setDisponingCapacity(int disponingCapacity) {
    this.disponingCapacity = disponingCapacity;
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
           "  Disponibilidad: " + disponingCapacity + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
