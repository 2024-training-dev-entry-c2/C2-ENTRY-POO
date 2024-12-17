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
  String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + city + "\n";
    result += "Tipo de alojamiento: " + typeOfHousing + "\n";
    result += "Nombre: " + name + "\n";
    result += "Calificación: " + rating + "\n";
    result += "Precio por noche: " + pricePerNight + "\n";

    result += "\n********** HABITACIONES **********\n";
    int index = 1;
    for (Room room : rooms) {
      result += "Habitación " + index + ":\n";
      result += room.printStay();
      result += "----\n";
      index++;
    }

    return result;
  }
}
