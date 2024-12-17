package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoomService {
  public Room getRoomsForHousing(List<Room> rooms, String hostingName) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n***************************************");
    System.out.println("    >> Listado de Habitaciones <<      ");
    System.out.println("***************************************");

    int index = 1;

    System.out.println("Nombre del alojamiento: " + hostingName);

    for (Room room : rooms) {
      String roomHotelName = room.getHostingName();

      if (hostingName.equals(roomHotelName)) {
        System.out.println(index + ":");
        System.out.println(room.printStay());
        System.out.println("-----------------------------------");
        index++;
      }
    }
    if (index == 1) {
      System.out.println("No se encontraron habitaciones que coincidan con los criterios.");
    }

    int selection;
    while (true) {
      try {
        selection = InputValidator.readInt("Escribe el número de la habitación que deseas seleccionar (1-" + (index - 1) + "): ");

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (Room room : rooms) {
            String roomHotelName = room.getHostingName();

            if (hostingName.equals(roomHotelName)) {
              if (currentIndex == selection) {
                return room;
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

  public List<Room> confirmRooms(List<Room> rooms, String hostingName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("       *** Confirmación de Habitaciones para el alojamiento: " + hostingName + " ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    List<Room> selectedRooms = new ArrayList<>();
    List<Room> summary = new ArrayList<>();
    int remainingRooms = numberOfRooms;

    while (remainingRooms > 0) {
      System.out.println("\nHabitaciones restantes por seleccionar: " + remainingRooms);

      Room selectedRoom = getRoomsForHousing(rooms, hostingName);

      int quantity;
      int availableRooms;

      while (true) {
        try {
          quantity = InputValidator.readInt("¿Cuántas habitaciones de este tipo deseas? ");
          availableRooms = selectedRoom.getCapacityAvailability();

          if (quantity > remainingRooms) {
            System.out.println("La cantidad ingresada supera el número de habitaciones restantes (" + remainingRooms + "). Por favor, ingresa una cantidad válida.");
          } else if (quantity > availableRooms) {
            System.out.println("La cantidad ingresada supera la disponibilidad de este tipo de habitación (" + availableRooms + ").");
          } else if (quantity <= 0) {
            System.out.println("Por favor, ingresa un número mayor a 0.");
          } else {
            selectedRoom.setCapacityAvailability(availableRooms - quantity);
            selectedRoom.setQuantity(quantity);

            boolean foundInSummary = false;
            for (Room summaryRoom : summary) {
              if (summaryRoom.getTypeOfRoom().equals(selectedRoom.getTypeOfRoom())) {
                summaryRoom.setQuantity(summaryRoom.getQuantity() + quantity);
                foundInSummary = true;
                break;
              }
            }
            if (!foundInSummary) {
              Room summaryRoom = new Room();
              summaryRoom.setTypeOfRoom(selectedRoom.getTypeOfRoom());
              summaryRoom.setDescription(selectedRoom.getDescription());
              summaryRoom.setPricePerNight(selectedRoom.getPricePerNight());
              summaryRoom.setQuantity(quantity);
              summary.add(summaryRoom);
            }
            break;
          }
        } catch (Exception e) {
          System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
          InputValidator.clearBuffer();
        }
      }

      for (int i = 0; i < quantity; i++) {
        selectedRooms.add(selectedRoom);
      }

      remainingRooms -= quantity;
      System.out.println("\nHas seleccionado " + quantity + " habitación(es) correctamente.");

      if (remainingRooms > 0) {
        String response = InputValidator.readString("¿Deseas seleccionar más habitaciones? (S/N): ");
        if (!response.equalsIgnoreCase("S")) {
          break;
        }
      }
    }

    System.out.println("\n*** Resumen de habitaciones seleccionadas ***\n");

    for (Room room : summary) {
      System.out.println("Tipo de habitación: " + room.getTypeOfRoom());
      System.out.println("Descripción: " + room.getDescription());
      System.out.println("Precio por noche: $" + room.getPricePerNight());
      System.out.println("Cantidad seleccionada: " + room.getQuantity());
      System.out.println("-----------------------------------");
    }

    if (remainingRooms > 0) {
      System.out.println("\nNo seleccionaste todas las habitaciones disponibles. ¡Asegúrate de confirmar tus opciones!");
    }

    System.out.println("\nGracias por confirmar tus habitaciones. ¡Que tengas una estancia agradable!");

    return summary;
  }
}
