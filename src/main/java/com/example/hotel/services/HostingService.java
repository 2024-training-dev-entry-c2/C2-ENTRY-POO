package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.HostingWithActivity;
import com.example.hotel.models.HostingWithRoom;

import java.util.List;

public class HostingService {
  public static HostingWithActivity getHotelByCityAndHostingA(List<HostingWithActivity> hotels, String city, String hostingType) {
    System.out.println("Listado de hospedajes:");

    int index = 1;
    for (HostingWithActivity hotel : hotels) {
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
          for (HostingWithActivity hotel : hotels) {
            if (hotel.getCity().equals(city) && hotel.getTypeOfHousing().equals(hostingType)) {
              if (currentIndex == selection) {
                return hotel;
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

  public static HostingWithRoom getHotelByCityAndHostingR(List<HostingWithRoom> hotels, String city, String hostingType) {
    System.out.println("Listado de hospedajes:");

    int index = 1;
    for (HostingWithRoom hotel : hotels) {
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
          for (HostingWithRoom hotel : hotels) {
            if (hotel.getCity().equals(city) && hotel.getTypeOfHousing().equals(hostingType)) {
              if (currentIndex == selection) {
                return hotel;
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


}
