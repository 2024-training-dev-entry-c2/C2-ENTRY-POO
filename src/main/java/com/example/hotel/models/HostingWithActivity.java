package com.example.hotel.models;

import java.util.List;

public class HostingWithActivity extends Hosting {
  List<Activity> activities;

  public HostingWithActivity(String city, String typeOfHousing, String name, double rating, double pricePerNight, List<Activity> activities) {
    super(city, typeOfHousing, name, rating, pricePerNight);
    this.activities = activities;
  }

  public HostingWithActivity(List<Activity> activities) {
    this.activities = activities;
  }

  public HostingWithActivity() {
  }

  public List<Activity> getActivities() {
    return activities;
  }

  public void setActivities(List<Activity> activities) {
    this.activities = activities;
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
    for (Activity activity : activities) {
      result += activity.printStay();
      result += "----\n";
      index++;
    }

    return result;
  }
}
