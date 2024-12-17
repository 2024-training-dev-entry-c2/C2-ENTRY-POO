package com.example.hotel.models;

import java.util.List;

public class HostingWithRoom extends Hosting {
  public HostingWithRoom(String city, String typeOfHousing, String name, double rating, double pricePerNight, double pricePerStay, List<Stay> stays) {
    super(city, typeOfHousing, name, rating, pricePerNight, pricePerStay, stays);
  }

  public HostingWithRoom() {
  }

  @Override
  public String printHosting() {
    String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + city + "\n";
    result += "Tipo de alojamiento: " + typeOfHousing + "\n";
    result += "Nombre: " + name + "\n";
    result += "Calificación: " + rating + "\n";
    result += "Precio por noche: " + pricePerNight + "\n";
    result += "Precio por estadía: " + pricePerStay + "\n";

    return result;
  }

  @Override
  public String printHostingWithStay() {
  String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + city + "\n";
    result += "Tipo de alojamiento: " + typeOfHousing + "\n";
    result += "Nombre: " + name + "\n";
    result += "Calificación: " + rating + "\n";
    result += "Precio por noche: " + pricePerNight + "\n";

    result += "\n********** HABITACIONES **********\n";
    int index = 1;
    for (Stay room : stays) {
      result += "Habitación " + index + ":\n";
      result += room.printStay();
      result += "----\n";
      index++;
    }

    return result;
  }
}
