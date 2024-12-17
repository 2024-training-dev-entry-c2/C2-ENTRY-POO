package com.example.hotel.services;

import com.example.hotel.inputHandler.InputValidator;
import com.example.hotel.models.Client;
import com.example.hotel.models.Hosting;
import com.example.hotel.models.Reserve;
import com.example.hotel.models.Room;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ReserveService {
  private static List<Reserve> reservations = new ArrayList<>();

  public Reserve createReservation(Hosting hosting, List<Room> rooms, int numberOfRooms, int numberOfAdults, int numberOfChildren, String name, String lastName, String email, String nationality, String phone, LocalTime arrivalTime, LocalDate startDate, LocalDate endDate) {
    Client client = new Client(name, lastName, email, nationality, phone);

    Reserve reservation = new Reserve(client, hosting,  numberOfRooms, numberOfAdults, numberOfChildren, startDate, endDate, arrivalTime, rooms);

    System.out.println("\n============================================================");
    System.out.println("          ¡RESERVA REALIZADA CON ÉXITO!");
    System.out.println("============================================================");


    return reservation;
  }

  public void getReservation(Reserve reservation) {
    System.out.println("\n============================================================");
    System.out.println("                INFORMACIÓN DEL CLIENTE                    ");
    System.out.println("============================================================");
    System.out.println("Nombre: " +reservation.getClient().getName() + " " + reservation.getClient().getLastName());
    System.out.println("Email: " + reservation.getClient().getEmail());
    System.out.println("Nacionalidad: " + reservation.getClient().getNationality());
    System.out.println("Teléfono: " + reservation.getClient().getPhone());
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                    INFORMACIÓN DEL HOTEL                  ");
    System.out.println("============================================================");
    System.out.println("Ciudad: " + reservation.getHosting().getCity());
    System.out.println("Tipo de alojamiento: " + reservation.getHosting().getTypeOfHousing());
    System.out.println("Nombre: " + reservation.getHosting().getName());
    System.out.println("Calificación: " + reservation.getHosting().getRating());
    System.out.println("Precio por noche: " + reservation.getHosting().getPricePerNight());
    System.out.println("Precio por estadía: " + reservation.getHosting().getPricePerStay());
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                    DETALLES DE LA RESERVA                 ");
    System.out.println("============================================================");
    System.out.println("Numero de habitaciones: " + reservation.getNumberOfRooms());
    System.out.println("Numero de adultos: " + reservation.getNumberOfAdults());
    System.out.println("Numero de niños: " + reservation.getNumberOfChildren());
    System.out.println("Hora de llegada: " + reservation.getArrivalTime().toString());
    System.out.println("Fecha de inicio: " + reservation.getStartDate().toString());
    System.out.println("Fecha de fin: " + reservation.getEndDate().toString());
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                  HABITACIONES RESERVADAS                   ");
    System.out.println("============================================================");

    for (Room room : reservation.getSelectedRooms()) {
      System.out.println("Tipo de habitación: " + room.getTypeOfRoom());
      System.out.println("Descripción: " + room.getDescription());
      System.out.println("Precio por noche: $" + room.getPricePerNight());
      System.out.println("Cantidad: " + room.getQuantity());
      System.out.println("----------------------------");
    }
  }

  public void addReservations(List<Reserve> reservations, Reserve reservation) {
    reservations.add(reservation);
  }

  public Reserve selectedReservation(List<Reserve> reservations, String email) {
    System.out.println("\n============================================================");
    System.out.println("      FILTRANDO RESERVAS POR EMAIL: " + email);
    System.out.println("============================================================");

    List<Reserve> filteredReservations = new ArrayList<>();
    int count = 1;

    for (Reserve reservation : reservations) {
      if (reservation.getClient().getEmail().equals(email)) {
        filteredReservations.add(reservation);
      }
    }

    if (filteredReservations.isEmpty()) {
      System.out.println("\n  >> No se encontraron reservas para el email: " + email);
      System.out.println("============================================================");
    } else {
      System.out.println("\n============================================================");
      System.out.println("                  RESERVAS ENCONTRADAS                       ");
      System.out.println("============================================================");
      for (Reserve reservation : filteredReservations) {
        System.out.println("\n============================================================");
        System.out.println("                     RESERVA #" + count + "                      ");
        System.out.println("============================================================");
        getReservation(reservation);
        count++;
      }
    }
    int selectedReservation;
    while (true) {
      try {
        selectedReservation = InputValidator.readInt("Escribe el número de la reserva que deseas seleccionar (1-\" + filteredReservations.size() + \"): ");

        if (selectedReservation > 0 && selectedReservation <= filteredReservations.size()) {
          return filteredReservations.get(selectedReservation - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        InputValidator.clearBuffer();
      }
    }
  }

  public void printReservations(List<Reserve> reservations, String email) {
    System.out.println("\n============================================================");
    System.out.println("      FILTRANDO RESERVAS POR EMAIL: " + email);
    System.out.println("============================================================");

    boolean found = false;
    int count = 1;
    for (Reserve reservation : reservations) {
      if (reservation.getClient().getEmail().equals(email)) {
        if (!found) {
          System.out.println("\n============================================================");
          System.out.println("                    RESERVAS ENCONTRADAS                     ");
          System.out.println("============================================================");
        }
        found = true;
        System.out.println("\n============================================================");
        System.out.println("                   RESERVA #" + count + "                    ");
        System.out.println("============================================================");
        getReservation(reservation);
        count++;
      }
    }
    if (!found) {
      System.out.println("\n  >> No se encontraron reservas para el email: " + email);
      System.out.println("============================================================");
    }

    System.out.println("\n============================================================");
    System.out.println("                    FIN DE LA BÚSQUEDA                      ");
    System.out.println("============================================================");
  }

  public void removeReservation(List<Reserve> reservations, Reserve reservationToRemove) {
    System.out.println("\n============================================================");
    System.out.println("               ¡ELIMINANDO RESERVA!");
    System.out.println("============================================================");

    boolean found = false;

    for (int i = reservations.size() - 1; i >= 0; i--) {
      Reserve reservation = reservations.get(i);
      if (reservation.equals(reservationToRemove)) {
        reservations.remove(i);
        found = true;
      }
    }

    if (found) {
      System.out.println("Se ha eliminado la reserva correctamente.");
    } else {
      System.out.println("No se encontró la reserva.");
    }
  }

  public Room selectedRoom(Reserve reservation) {
    System.out.println("\n============================================================");
    System.out.println("                Información del hotel:");
    System.out.println("============================================================");
    System.out.println("Ciudad: " + reservation.getHosting().getCity());
    System.out.println("Tipo de alojamiento: " + reservation.getHosting().getTypeOfHousing());
    System.out.println("Nombre: " + reservation.getHosting().getName());
    System.out.println("Calificación: " + reservation.getHosting().getRating());
    System.out.println("Precio por noche: " + reservation.getHosting().getPricePerNight());
    System.out.println("Precio por estadía: " + reservation.getHosting().getPricePerStay());

    System.out.println("\n============================================================");
    System.out.println("               Habitaciones reservadas:");
    System.out.println("============================================================");

    List<Room> rooms = new ArrayList<>();

    for (Room room : reservation.getSelectedRooms()) {
      rooms.add(room);

      System.out.println("Tipo de habitación: " + room.getTypeOfRoom());
      System.out.println("Descripción: " + room.getDescription());
      System.out.println("Precio por noche: $" + room.getPricePerNight());
      System.out.println("Cantidad: " + room.getQuantity());
      System.out.println("----------------------------");
    }

    int selectedRoom;

    while (true) {
      try {
        selectedRoom = InputValidator.readInt("Escribe el número de la habitación que deseas seleccionar (1-\" + rooms.size() + \"): ");

        if (selectedRoom > 0 && selectedRoom <= rooms.size()) {
          return rooms.get(selectedRoom - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        InputValidator.clearBuffer();
      }
    }
  }

  public Reserve updateRoomInReservation(Reserve reservation, Room oldRoom, Room newRoom) {
    for (Room room : reservation.getSelectedRooms()) {
      if (room.getTypeOfRoom().equals(oldRoom.getTypeOfRoom())) {
        room.setTypeOfRoom(newRoom.getTypeOfRoom());
        room.setDescription(newRoom.getDescription());
        room.setPricePerNight(newRoom.getPricePerNight());
        room.setQuantity(newRoom.getQuantity());
        break;
      }
    }

    return reservation;
  }
}