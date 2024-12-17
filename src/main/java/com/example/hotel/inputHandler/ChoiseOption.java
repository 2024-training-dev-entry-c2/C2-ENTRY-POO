package com.example.hotel.inputHandler;

import com.example.hotel.data.BookingData;
import com.example.hotel.models.Hosting;
import com.example.hotel.models.HostingWithActivity;
import com.example.hotel.models.HostingWithRoom;

import java.util.List;
import java.util.Scanner;

public class ChoiseOption {
  private static BookingData bookingData = new BookingData();

  public static String getCity() {
    List<String> cities = bookingData.createCities();

    System.out.println("Ciudades disponibles:");
    for (int i = 0; i < cities.size(); i++) {
      System.out.println((i + 1) + ". " + cities.get(i));
    }

    Scanner sc = new Scanner(System.in);
    int ciudad;

    while (true) {
      try {
        ciudad = InputValidator.readInt("Escribe el número de la ciudad que deseas seleccionar (1-" + cities.size() + "): ");

        if (ciudad > 0 && ciudad <= cities.size()) {
          return cities.get(ciudad - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        sc.next();
      }
    }
  }

  public static String getHosting() {
    List<String> types = bookingData.createHostingTypes();

    System.out.println("Tipos de alojamiento:");
    for (int i = 0; i < types.size(); i++) {
      System.out.println((i + 1) + ". " + types.get(i));
    }

    Scanner sc = new Scanner(System.in);
    int type = -1;

    while (true) {
      try {
        type = InputValidator.readInt("Escribe el número del alojamiento que deseas seleccionar (1-" + types.size() + "): ");

        if (type > 0 && type <= types.size()) {
          return types.get(type - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        sc.next();
      }

    }
  }

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