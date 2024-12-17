package com.example.hotel.inputHandler;

import com.example.hotel.data.BookingData;
import com.example.hotel.models.Hosting;
import com.example.hotel.models.HostingWithActivity;
import com.example.hotel.models.HostingWithRoom;
import com.example.hotel.models.Room;
import com.example.hotel.services.HostingService;
import com.example.hotel.services.RoomService;

import java.time.LocalDate;
import java.util.List;

public class Menu {
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
    HostingService hostingService = new HostingService();
  RoomService roomService = new RoomService();

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

    BookingData bookingData = new BookingData();
    List<Room> rooms = bookingData.createRooms();
    List<Hosting> hostingWithRooms = bookingData.createHostingWithRoomOrActivity(housing);

    Hosting hosting = hostingService.createDesiredAccommodation(rooms, hostingWithRooms, city, housing, startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);
    List<Room> selectedRooms = roomService.confirmRooms(rooms, hosting.getName(), startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);

    hostingService.calculatePriceWithRooms(hosting, selectedRooms, startDate, endDate, numberOfRooms);

    System.out.println("\n============================================================");
    System.out.println("                DATOS DE LA PERSONA TITULAR                 ");
    System.out.println("============================================================");

    String name = InputValidator.readString("Ingrese el nombre: ");

    String lastName = InputValidator.readString("Ingrese el apellido: ");

    String email = InputValidator.readString("Ingrese el email: ");

    String nationality = InputValidator.readString("Ingrese la nacionalidad: ");

    String phone = InputValidator.readString("Ingrese el número de teléfono: ");

    // LOGICA

    System.out.println("\n============================================================");
    System.out.println("                ¡GRACIAS POR ELEGIRNOS!                     ");
    System.out.println("============================================================");

  }

  public void modifyReservation() {
    System.out.println("\n============================================================");
    System.out.println("                     MODIFICAR RESERVA                      ");
    System.out.println("============================================================");

    String email = InputValidator.readString("\nIngrese el email para buscar la reserva: ");


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

        break;
      case 2:
        System.out.println("\n============================================================");
        System.out.println("                   MODIFICAR ALOJAMIENTO                   ");
        System.out.println("============================================================");

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
