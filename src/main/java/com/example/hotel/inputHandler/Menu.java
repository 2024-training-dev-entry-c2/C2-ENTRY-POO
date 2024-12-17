package com.example.hotel.inputHandler;

import com.example.hotel.data.BookingData;
import com.example.hotel.models.*;
import com.example.hotel.services.ActivityService;
import com.example.hotel.services.HostingService;
import com.example.hotel.services.ReserveService;
import com.example.hotel.services.RoomService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Menu {
  private static BookingData bookingData = new BookingData();
  private static List<Room> rooms = null;
  private static List<Activity> activities = null;
  private static List<Hosting> hostings = null;
  private static List<Reserve> reservations = new ArrayList<>();
  private static HostingService hostingService = new HostingService();
  private static RoomService roomService = new RoomService();
  private static ReserveService reserveService = new ReserveService();
  private static ActivityService activityService = new ActivityService();

  public int showOptions() {
    System.out.println("\n============================================================");
    System.out.println("                BIENVENIDO A LA APLICACIÓN                 ");
    System.out.println("                DE RESERVA DE ALOJAMIENTOS                 ");
    System.out.println("============================================================");
    System.out.println("                    ¿QUÉ DESEAS HACER?                     ");
    System.out.println("------------------------------------------------------------");
    System.out.println("                  (1) Hacer una reserva                    ");
    System.out.println("                  (2) Modificar una reserva                ");
    System.out.println("                  (3) Cancelar una reserva                 ");
    System.out.println("------------------------------------------------------------");

    return InputValidator.readInt("Selecciona una opción (1-3): ");
  }

  public void menu() {
    int option = showOptions();

    switch (option) {
      case 1:
        makeReservation();
        menu();
        break;
      case 2:
        modifyReservation();
        menu();
        break;
      case 3:
        System.out.println("\n============================================================");
        System.out.println("                     SESIÓN CERRADA                        ");
        System.out.println("============================================================");

        break;
      default:
        System.out.println("Opción no válida. Intenta nuevamente.");
        menu();
        break;
    }
  }

  public void makeReservation() {
    System.out.println("\n============================================================");
    System.out.println("                  RESERVA DE ALOJAMIENTO                    ");
    System.out.println("============================================================");

    String city = ChoiseOption.getCity();
    String housing = ChoiseOption.getHosting();

    LocalDate startDate = InputValidator.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");

    while (startDate.isBefore(LocalDate.now())) {
      System.out.println("La fecha de inicio no puede ser anterior a la fecha actual. Inténtelo nuevamente.");
      startDate = InputValidator.readLocalDate("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    }

    LocalDate endDate = InputValidator.readLocalDate("Ingrese la fecha de fin de la reserva (yyyy-MM-dd): ");

    while (endDate.isBefore(startDate)) {
      System.out.println("La fecha de fin no puede ser anterior a la de inicio. Inténtelo nuevamente.");
      endDate = InputValidator.readLocalDate("Ingrese la fecha de fin de la reserva (yyyy-MM-dd): ");
    }

    int numberOfAdults = InputValidator.readInt("Ingrese el número de adultos: ");
    int numberOfChildren = InputValidator.readInt("Ingrese el número de niños: ");
    int numberOfRooms = InputValidator.readInt("Ingrese el número de habitaciones: ");


    List<Room> rooms = bookingData.createRooms();
    List<Activity> activities = bookingData.createActivities()
      ;
    List<Hosting> hostingWithRooms = bookingData.createHostingWithRoomOrActivity(housing);

    Hosting hosting = hostingService.createDesiredAccommodation(rooms, hostingWithRooms, city, housing, startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);
    List<Room> selectedRooms = roomService.confirmRooms(rooms, hosting.getName(), startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);

    hostingService.calculatePriceWithRooms(hosting, selectedRooms, startDate, endDate, numberOfRooms);

    if (housing.equals("Dia de Sol")) {
      List<Activity> selectedActivities = activityService.confirmActivities(activities, hosting.getName(), startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);
      hostingService.calculatePriceWithActivities(hosting, selectedActivities, startDate, endDate, numberOfRooms);
    }


    System.out.println("\n============================================================");
    System.out.println("                DATOS DE LA PERSONA TITULAR                 ");
    System.out.println("============================================================");

    String name = InputValidator.readString("Ingrese el nombre: ");
    String lastName = InputValidator.readString("Ingrese el apellido: ");
    String email = InputValidator.readString("Ingrese el email: ");
    String nationality = InputValidator.readString("Ingrese la nacionalidad: ");
    String phone = InputValidator.readString("Ingrese el número de teléfono: ");
    LocalTime arrivalTime = InputValidator.readLocalTime("Ingrese la hora de llegada (HH:mm): ");

    Reserve reservation = reserveService.createReservation(hosting, selectedRooms, numberOfRooms, numberOfAdults, numberOfChildren, name, lastName, email, nationality, phone, arrivalTime, startDate, endDate);

    reserveService.getReservation(reservation);
    reserveService.addReservations(reservations, reservation);

    System.out.println("\n============================================================");
    System.out.println("                ¡GRACIAS POR ELEGIRNOS!                     ");
    System.out.println("============================================================");

  }

  public void modifyReservation() {
    System.out.println("\n============================================================");
    System.out.println("                     MODIFICAR RESERVA                      ");
    System.out.println("============================================================");

    String email = InputValidator.readString("\nIngrese el email para buscar la reserva: ");

    Reserve reservation = reserveService.selectedReservation(reservations, email);

    System.out.println("\n------------------------------------------------------------");
    System.out.println("                     ¿QUÉ DESEAS HACER?                     ");
    System.out.println("------------------------------------------------------------");
    System.out.println("                  (1) Cambiar habitación(es)                ");
    System.out.println("                  (2) Cambiar alojamiento                   ");
    System.out.println("                  (3) Cancelar                              ");
    System.out.println("------------------------------------------------------------");
    System.out.print("         Selecciona una opción (1-3): ");

    int response = InputValidator.readInt("");

    switch (response) {
      case 1:
        System.out.println("\n============================================================");
        System.out.println("                   MODIFICAR HABITACIÓN(ES)                 ");
        System.out.println("============================================================");

        Room selectedRoom = reserveService.selectedRoom(reservation);
        String hotelName = reservation.getHosting().getName();

        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
          String roomHotelName = room.getHostingName();
          if (hotelName.equals(roomHotelName)) {
            availableRooms.add(room);
          }
        }

        Room newRoom = roomService.getRoomsForHousing(availableRooms, hotelName);

        int newQuantity = InputValidator.readInt("Ingresa la nueva cantidad de habitaciones para esta reserva: " );

        newRoom.setQuantity(newQuantity);

        Reserve updatedReservation = reserveService.updateRoomInReservation(reservation, selectedRoom, newRoom);

        reserveService.getReservation(updatedReservation);

        break;
      case 2:
        System.out.println("\n============================================================");
        System.out.println("                   MODIFICAR ALOJAMIENTO                   ");
        System.out.println("============================================================");

        reserveService.removeReservation(reservations, reservation);
        reserveService.printReservations(reservations, email);

        makeReservation();
        break;
      case 3:
        System.out.println("\n============================================================");
        System.out.println("                     SESIÓN CERRADA                        ");
        System.out.println("============================================================");

        break;
      default:
        System.out.println("Opción no válida. Intenta nuevamente.");
        modifyReservation();
        break;
    }
  }

}
