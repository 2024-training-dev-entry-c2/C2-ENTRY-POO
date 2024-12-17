package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.Activity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActivityService {
  public Activity getActivityForHousing(List<Activity> activities, String hostingName) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n***************************************");
    System.out.println("    >> Listado de Actividades <<      ");
    System.out.println("***************************************");

    int index = 1;

    System.out.println("Nombre del alojamiento: " + hostingName);

    for (Activity activity : activities) {
      String activityHostingName = activity.getHostingName();

      if (hostingName.equals(activityHostingName)) {
        System.out.println(index + ":");
        System.out.println(activity.printStay());
        System.out.println("-----------------------------------");
        index++;
      }
    }
    if (index == 1) {
      System.out.println("No se encontraron actividades que coincidan con los criterios.");
    }

    int selection;
    while (true) {
      try {
        selection = InputValidator.readInt("Escribe el número de la actividad que deseas seleccionar (1-" + (index - 1) + "): ");

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (Activity activity : activities) {
            String activityHostingName = activity.getHostingName();

            if (hostingName.equals(activityHostingName)) {
              if (currentIndex == selection) {
                return activity;
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

  public List<Activity> confirmActivities(List<Activity> activities, String hostingName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("       *** Confirmación de actividades para el alojamiento: " + hostingName + " ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    List<Activity> selectedActivities = new ArrayList<>();
    List<Activity> summary = new ArrayList<>();
    int remainingActivities = numberOfRooms;

    while (remainingActivities > 0) {
      System.out.println("\nActividades restantes por seleccionar: " + remainingActivities);

      Activity selectedActivity = getActivityForHousing(activities, hostingName);

      int quantity;
      int availableActivities;

      while (true) {
        try {
          quantity = InputValidator.readInt("¿Cuántas actividades de este tipo deseas? ");
          availableActivities = selectedActivity.getCapacityAvailability();

          if (quantity > remainingActivities) {
            System.out.println("La cantidad ingresada supera el número de actividades restantes (" + remainingActivities + "). Por favor, ingresa una cantidad válida.");
          } else if (quantity > remainingActivities) {
            System.out.println("La cantidad ingresada supera la disponibilidad de este tipo de actividad (" + availableActivities + ").");
          } else if (quantity <= 0) {
            System.out.println("Por favor, ingresa un número mayor a 0.");
          } else {
            selectedActivity.setCapacityAvailability(availableActivities - quantity);
            selectedActivity.setQuantity(quantity);

            boolean foundInSummary = false;
            for (Activity summaryActivity : summary) {
              if (summaryActivity.getTypeOfRoom().equals(summaryActivity.getTypeOfRoom())) {
                summaryActivity.setQuantity(summaryActivity.getQuantity() + quantity);
                foundInSummary = true;
                break;
              }
            }
            if (!foundInSummary) {
              Activity summaryActivity = new Activity();
              summaryActivity.setTypeOfRoom(selectedActivity.getTypeOfRoom());
              summaryActivity.setDescription(selectedActivity.getDescription());
              summaryActivity.setPricePerDay(selectedActivity.getPricePerDay());
              summaryActivity.setQuantity(quantity);
              summary.add(summaryActivity);
            }
            break;
          }
        } catch (Exception e) {
          System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
          InputValidator.clearBuffer();
        }
      }

      for (int i = 0; i < quantity; i++) {
        selectedActivities.add(selectedActivity);
      }

      remainingActivities -= quantity;
      System.out.println("\nHas seleccionado " + quantity + " actividad(es) correctamente.");

      if (remainingActivities > 0) {
        String response = InputValidator.readString("¿Deseas seleccionar más actividades? (S/N): ");
        if (!response.equalsIgnoreCase("S")) {
          break;
        }
      }
    }

    System.out.println("\n*** Resumen de actividades seleccionadas ***\n");

    for (Activity activity : summary) {
      System.out.println("Tipo de actividad: " + activity.getTypeOfRoom());
      System.out.println("Descripción: " + activity.getDescription());
      System.out.println("Precio por noche: $" + activity.getPricePerDay());
      System.out.println("Cantidad seleccionada: " + activity.getQuantity());
      System.out.println("-----------------------------------");
    }

    if (remainingActivities > 0) {
      System.out.println("\nNo seleccionaste todas las actividades disponibles. ¡Asegúrate de confirmar tus opciones!");
    }

    System.out.println("\nGracias por confirmar tus actividades. ¡Que tengas una estancia agradable!");

    return summary;
  }

}
