package com.example.hotel.models;

import java.util.List;

public class Activity extends Stay {
  private double pricePerDay;
  private String hostingName;

  public Activity(String hostingName, String typeOfRoom, String description, double pricePerDay,int capacityAvailability, int quantity) {
    super(typeOfRoom, description, capacityAvailability, quantity);
    this.pricePerDay = pricePerDay;
    this.hostingName = hostingName;
  }

  public Activity(String hostingName, String typeOfRoom, String description, double pricePerDay, int capacityAvailability) {
    super(typeOfRoom, description, capacityAvailability);
    this.pricePerDay = pricePerDay;
    this.hostingName = hostingName;
  }

  public Activity() {
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

  public String getHostingName() {
    return hostingName;
  }

  public void setHostingName(String hostingName) {
    this.hostingName = hostingName;
  }

  @Override
  public String printStay() {
    return "  Hotel: " + hostingName + "\n" +
           "  Tipo de actividad: " + typeOfRoom + "\n" +
           "  Descripción: " + description + "\n" +
           "  Precio por noche: $" + pricePerDay + "\n" +
           "  Disponibilidad: " + capacityAvailability + "\n" +
           "  Cantidad: " + quantity + "\n";
  }
}
