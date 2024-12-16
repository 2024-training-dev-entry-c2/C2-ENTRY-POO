package com.example.hotel.models;

import java.util.List;

public class HostingWithRoom extends Hosting {
  private List<Room> rooms;

  public HostingWithRoom(String city, String typeOfHousing, String name, double rating, double pricePerNight, List<Room> rooms) {
    super(city, typeOfHousing, name, rating, pricePerNight);
    this.rooms = rooms;
  }

  public HostingWithRoom(List<Room> rooms) {
    this.rooms = rooms;
  }

  public HostingWithRoom(String city, String typeOfHousing, String name, double rating, double pricePerNight) {
    super(city, typeOfHousing, name, rating, pricePerNight);
  }

  public HostingWithRoom() {
  }

  public List<Room> getRooms() {
    return rooms;
  }

  public void setRooms(List<Room> rooms) {
    this.rooms = rooms;
  }

  @Override
  public String printHosting() {
    return "  Nombre: " + name + "\n" +
           "  Calificación: " + rating + "\n" +
           "  Precio por noche: $" + pricePerNight + "\n" +
           "  Precio por estadía: $" + pricePerStay + "\n" +
           "  Habitaciones: " + rooms.size() + "\n" +
           "-----------------------------------\n" +
          rooms.toString();
  }
}
