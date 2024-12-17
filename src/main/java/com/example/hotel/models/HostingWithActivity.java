package com.example.hotel.models;

import java.util.List;

public class HostingWithActivity extends Hosting {
  public HostingWithActivity(String city, String typeOfHousing, String name, double rating, double pricePerNight, double pricePerStay, List<Stay> stays) {
    super(city, typeOfHousing, name, rating, pricePerNight, pricePerStay, stays);
  }

  public HostingWithActivity() {
  }

  @Override
  public String printHosting() {
    String result = "\n********** ALOJAMIENTO **********\n";

    result += "Ciudad: " + city + "\n";
    result += "Tipo de alojamiento: " + typeOfHousing + "\n";
    result += "Nombre: " + name + "\n";
    result += "Calificación: " + rating + "\n";
    result += "Precio por día: " + pricePerNight + "\n";
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
    result += "Precio por día: " + pricePerNight + "\n";

    result += "\n********** ACTIVIDADES **********\n";
    int index = 1;
    for (Stay activity : stays) {
      result += activity.printStay();
      result += "----\n";
      index++;
    }

    return result;
  }
}
