package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.*;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public class HostingService {
  public Hosting getHotelByCityAndHosting(List<Hosting> hostings, String city, String hostingType) {
    System.out.println("Listado de hospedajes:");

    int index = 1;
    for (Hosting hotel : hostings) {
      if (hotel.getCity().equals(city) && hotel.getTypeOfHousing().equals(hostingType)) {
        System.out.println(index + ":");
        System.out.println(hotel.printHosting());
        System.out.println("-----------------------------------");
        index++;
      }
    }

    if (index == 1) {
      System.out.println("No se encontraron hospedajes que coincidan con los criterios.");
    }

    int selection;
    while (true) {
      try {
        selection = InputValidator.readInt("Escribe el número del hospedaje que deseas seleccionar (1-" + (index - 1) + "): ");

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (Hosting hosting : hostings) {
            if (hosting.getCity().equals(city) && hosting.getTypeOfHousing().equals(hostingType)) {
              if (currentIndex == selection) {
                return hosting;
              }
              currentIndex++;
            }
          }
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        InputValidator.clearBuffer();
      }
    }
  }

  public static List<Hosting> updatePriceHotel(List<Room> rooms, List<Hosting> hostings, int daysBetween) {
    for (Hosting hosting : hostings) {
      String hotelName = hosting.getName();
      double minPrice = Double.MAX_VALUE;

      for (Room room : rooms) {
          double roomPrice = room.getPricePerNight();
          minPrice = Math.min(minPrice, roomPrice);
      }

      hosting.setPricePerNight(minPrice);
      hosting.setPricePerStay(minPrice * daysBetween);
    }

    return hostings;
  }

  public Hosting createDesiredAccommodation(List<Room> rooms, List<Hosting> hostings, String city, String housingType, LocalDate startDate, LocalDate endDate,
                                                        int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());

    List<Hosting> hostingsNow = updatePriceHotel(rooms, hostings, (int) daysBetween);

    Hosting hosting = getHotelByCityAndHosting(hostingsNow, city, housingType);

    System.out.println("\nHotel seleccionado: ");
    hosting.printHosting();
    hosting.setPricePerStay((double) numberOfRooms * hosting.getPricePerNight());
    calculatePrice(hosting, startDate, endDate, numberOfRooms);

    return hosting;
  }


  public void calculatePrice(Hosting hosting, LocalDate startDate, LocalDate endDate, int numberOfRooms) {
    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());
    double totalPrice = hosting.getPricePerNight() * daysBetween;

    System.out.println("\nPrecio base con " + numberOfRooms + " habitaciones: $" + totalPrice);

    int startDay = startDate.getDayOfMonth();
    int endDay = endDate.getDayOfMonth();

    Calendar startCalendar = Calendar.getInstance();
    startCalendar.setTime(java.sql.Date.valueOf(startDate));
    int lastDayOfStartMonth = startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    Calendar endCalendar = Calendar.getInstance();
    endCalendar.setTime(java.sql.Date.valueOf(endDate));
    int lastDayOfEndMonth = endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

    double percentageApplied;
    double adjustmentAmount;

    if ((startDay >= lastDayOfStartMonth - 4) && (endDay >= lastDayOfEndMonth - 4)) {
      percentageApplied = 0.15;
      adjustmentAmount = totalPrice * percentageApplied;
      totalPrice += adjustmentAmount;
      System.out.println("Se aplicó un aumento del 15%: +$" + adjustmentAmount);
    } else if ((startDay >= 10 && startDay <= 15) && (endDay >= 10 && endDay <= 15)) {
      percentageApplied = 0.10;
      adjustmentAmount = totalPrice * percentageApplied;
      totalPrice += adjustmentAmount;
      System.out.println("Se aplicó un aumento del 10%: +$" + adjustmentAmount);
    } else if ((startDay >= 5 && startDay <= 10) && (endDay >= 5 && endDay <= 10)) {
      percentageApplied = -0.08;
      adjustmentAmount = totalPrice * Math.abs(percentageApplied);
      totalPrice -= adjustmentAmount;
      System.out.println("Se aplicó un descuento del 8%: -$" + adjustmentAmount);
    } else {
      System.out.println("No se aplicó descuento ni aumento.");
    }

    System.out.println("Precio total del hotel después de ajustes: $" + totalPrice);
    hosting.setPricePerNight(totalPrice);
  }

  public void calculatePriceWithRooms(Hosting hosting, List<Room> rooms, LocalDate startDate, LocalDate endDate, int numberOfRooms) {
    double price = 0;

    for (Room room : rooms) {
      price += room.getPricePerNight() * room.getQuantity();
    }
    hosting.setPricePerNight(price);

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("        *** Precio total con precio de habitaciones ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    calculatePrice(hosting, startDate, endDate, numberOfRooms);
  }

  public void calculatePriceWithActivities(Hosting hosting, List<Activity> activities, LocalDate startDate, LocalDate endDate, int numberOfRooms) {
    double price = 0;

    for (Activity activity : activities) {
      price += activity.getPricePerDay() * activity.getCapacityAvailability();
    }
    hosting.setPricePerNight(price);

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("        *** Precio total con precio de actividades ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    calculatePrice(hosting, startDate, endDate, numberOfRooms);
  }
}