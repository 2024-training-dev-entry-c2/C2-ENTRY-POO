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
    return "  Nombre: " + name + "\n" +
      "  Calificación: " + rating + "\n" +
      "  Precio por noche: $" + pricePerNight + "\n" +
      "  Precio por estadía: $" + pricePerStay + "\n" +
      "  Actividades: " + activities.size() + "\n" +
      "-----------------------------------\n" +
      activities.toString();
  }
}
