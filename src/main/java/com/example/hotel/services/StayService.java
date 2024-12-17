package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.Stay;
import com.example.hotel.services.interfaces.IStayService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StayService implements IStayService {
  public Stay getStaysForHousing(List<Stay> stays, String hostingName) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n***************************************");
    System.out.println("    >> Listado de estadias <<      ");
    System.out.println("***************************************");

    int index = 1;

    System.out.println("Nombre del alojamiento: " + hostingName);

    for (Stay stay : stays) {
      String stayHotelName = stay.getHostingName();

      if (hostingName.equals(stayHotelName)) {
        System.out.println(index + ":");
        System.out.println(stay.printStay());
        System.out.println("-----------------------------------");
        index++;
      }
    }
    if (index == 1) {
      System.out.println("No se encontraron estadias que coincidan con los criterios.");
    }

    int selection;
    while (true) {
      try {
        System.out.print("\nEscribe el número de la estadia que deseas seleccionar (1-" + (index - 1) + "): ");
        selection = InputValidator.readInt("");

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (Stay stay : stays) {
            String stayHotelName = stay.getHostingName();

            if (hostingName.equals(stayHotelName)) {
              if (currentIndex == selection) {
                return stay;
              }
              currentIndex++;
            }
          }
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        sc.next();
      }
    }
  }

  public List<Stay> confirmStays(List<Stay> stays, String hostingName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("       *** Confirmación de estadias para el alojamiento: " + hostingName + " ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    List<Stay> selectedStays = new ArrayList<>();
    List<Stay> summary = new ArrayList<>();
    int remainingStays = numberOfRooms;

    while (remainingStays > 0) {
      System.out.println("\nEstadias restantes por seleccionar: " + remainingStays);

      Stay selectedStay = getStaysForHousing(stays, hostingName);

      int quantity;
      int availableRooms;

      while (true) {
        try {
          quantity = InputValidator.readInt("¿Cuántas estadias de este tipo deseas? ");
          availableRooms = selectedStay.getCapacityAvailability();

          if (quantity > remainingStays) {
            System.out.println("La cantidad ingresada supera el número de estadias restantes (" + remainingStays + "). Por favor, ingresa una cantidad válida.");
          } else if (quantity > availableRooms) {
            System.out.println("La cantidad ingresada supera la disponibilidad de este tipo de estadia (" + availableRooms + ").");
          } else if (quantity <= 0) {
            System.out.println("Por favor, ingresa un número mayor a 0.");
          } else {
            selectedStay.setCapacityAvailability(availableRooms - quantity);
            selectedStay.setQuantity(quantity);

            boolean foundInSummary = false;
            for (Stay summaryStay : summary) {
              if (summaryStay.getTypeOfRoom().equals(selectedStay.getTypeOfRoom())) {
                summaryStay.setQuantity(summaryStay.getQuantity() + quantity);
                foundInSummary = true;
                break;
              }
            }
            if (!foundInSummary) {
              Stay summaryStay = new Stay();
              summaryStay.setTypeOfRoom(selectedStay.getTypeOfRoom());
              summaryStay.setDescription(selectedStay.getDescription());
              summaryStay.setPricePerNight(selectedStay.getPricePerNight());
              summaryStay.setQuantity(quantity);
              summary.add(summaryStay);
            }
            break;
          }
        } catch (Exception e) {
          System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
          InputValidator.clearBuffer();
        }
      }

      for (int i = 0; i < quantity; i++) {
        selectedStays.add(selectedStay);
      }

      remainingStays -= quantity;
      System.out.println("\nHas seleccionado " + quantity + " estadia(s) correctamente.");

      if (remainingStays > 0) {
        String response = InputValidator.readString("¿Deseas seleccionar más estadias? (S/N): ");
        if (!response.equalsIgnoreCase("S")) {
          break;
        }
      }
    }

    System.out.println("\n*** Resumen de estadias seleccionadas ***\n");

    for (Stay stay : summary) {
      System.out.println("Tipo de habitación: " + stay.getTypeOfRoom());
      System.out.println("Descripción: " + stay.getDescription());
      System.out.println("Precio por noche: $" + stay.getPricePerNight());
      System.out.println("Cantidad seleccionada: " + stay.getQuantity());
      System.out.println("-----------------------------------");
    }

    if (remainingStays > 0) {
      System.out.println("\nNo seleccionaste todas las estadias disponibles. ¡Asegúrate de confirmar tus opciones!");
    }

    System.out.println("\nGracias por confirmar tus estadias. ¡Que tengas una estancia agradable!");

    return summary;
  }
}
