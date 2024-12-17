package com.example.hotel;

import com.example.hotel.inputHandler.Menu;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
  private static List<List<String>> rooms = null;
  private static List<List<String>> hotels = null;
  private static List<List<String>> reservations = new ArrayList<>();

  public static void main(String[] args) {
    Menu menu = new Menu();
    menu.menu();
  }

  // region city
  public static List<String> createCities() {
    List<String> cities = new ArrayList<>();
    cities.add("Cartagena");
    cities.add("Medellín");
    cities.add("Bogotá");
    cities.add("Santa Marta");
    cities.add("San Andrés");
    cities.add("Barichara");
    cities.add("Guatapé");
    cities.add("Cali");

    return cities;
  }

  public static String getCity() {
    List<String> cities = createCities();

    System.out.println("Ciudades disponibles:");
    for (int i = 0; i < cities.size(); i++) {
      System.out.println((i + 1) + ". " + cities.get(i));
    }

    Scanner sc = new Scanner(System.in);
    int ciudad = -1;

    while (true) {
      try {
        System.out.print("\nEscribe el número de la ciudad que deseas seleccionar (1-" + cities.size() + "): ");
        ciudad = sc.nextInt();

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
  // endregion

  // region type of housing
  public static List<String> createHousing() {
    List<String> types = new ArrayList<>();
    types.add("Hotel");
    types.add("Apartamento");
    types.add("Finca");
    types.add("Dia de Sol");

    return types;
  }

  public static String getHousing() {
    List<String> types = createHousing();

    System.out.println("Tipos de alojamiento:");
    for (int i = 0; i < types.size(); i++) {
      System.out.println((i + 1) + ". " + types.get(i));
    }

    Scanner sc = new Scanner(System.in);
    int type = -1;

    while (true) {
      try {
        System.out.print("\nEscribe el número del alojamiento que deseas seleccionar (1-" + types.size() + "): ");
        type = sc.nextInt();

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
  // endregion

  // region hotel
  public static List<List<String>> createHotelsValues(int price, int days) {
    List<String> cities = createCities();
    List<String> typeOfHousing = createHousing();
    List<List<String>> allHotels = new ArrayList<>();

    // Hoteles
    allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(0), "Marriott Hotel", "4.5", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Hilton Garden Inn", "4.4", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(0), "Ritz-Carlton", "5.0", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(0), "Holiday Inn", "4.2", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(0), "Sheraton", "4.3", String.valueOf(price), String.valueOf(days * price)));

    // Apartamentos
    allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(1), "Apartamento Luxury", "4.7", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(1), "Apartamento Vista Mar", "4.6", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(1), "Apartamento Moderno", "4.5", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(5), typeOfHousing.get(1), "Apartamento Familiar", "4.8", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(7), typeOfHousing.get(1), "Apartamento en el Centro", "4.4", String.valueOf(price), String.valueOf(days * price)));

    // Fincas
    allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(2), "Finca El Paraíso", "4.9", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(1), typeOfHousing.get(2), "Finca La Esperanza", "4.6", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(2), "Finca El Refugio", "4.8", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(2), "Finca Santa Isabel", "4.7", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(6), typeOfHousing.get(2), "Finca Las Palmas", "4.5", String.valueOf(price), String.valueOf(days * price)));

    // Día de Sol
    allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Aventura", "4.5", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(0), typeOfHousing.get(3), "Día de Sol Relax", "4.7", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(2), typeOfHousing.get(3), "Día de Sol Familiar", "4.6", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(3), typeOfHousing.get(3), "Día de Sol Deportivo", "4.8", String.valueOf(price), String.valueOf(days * price)));
    allHotels.add(Arrays.asList(cities.get(4), typeOfHousing.get(3), "Día de Sol con Spa", "4.9", String.valueOf(price), String.valueOf(days * price)));

    return allHotels;
  }

  public static void getHotel(List<String> hotel) {
    System.out.println("  Nombre: " + hotel.get(2));
    System.out.println("  Calificación: " + hotel.get(3));
    System.out.println("  Precio por noche: $" + hotel.get(4));
    System.out.println("  Precio calculado por días: $" + hotel.get(5));
  }

  public static List<String> getHotelByCityAndHousing(List<List<String>> hotels, String city, String housing) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Listado de hoteles:");
    int index = 1;
    for (List<String> hotel : hotels) {
      if (hotel.get(0).equals(city) && hotel.get(1).equals(housing)) {
        System.out.println(index + ":");
        getHotel(hotel);
        System.out.println("-----------------------------------");
        index++;
      }
    }
    if (index == 1) {
      System.out.println("No se encontraron hoteles que coincidan con los criterios.");
    }

    int selection = -1;
    while (true) {
      try {
        System.out.print("\nEscribe el número del hotel que deseas seleccionar (1-" + (index - 1) + "): ");
        selection = sc.nextInt();

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (List<String> hotel : hotels) {
            if (hotel.get(0).equals(city) && hotel.get(1).equals(housing)) {
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
        sc.next();
      }
    }
  }

  // endregion

  // region type of room
  public static List<String> createTypesOfRoom() {
    List<String> types = new ArrayList<>();
    types.add("Habitacion Sencilla");
    types.add("Habitacion Doble");
    types.add("Habitacion Triple");
    types.add("Habitacion Suite");
    types.add("Habitacion Suite Deluxe");
    types.add("Actividades de dia de sol");

    return types;
  }

  public static List<List<String>> createRooms(int days) {
    List<List<String>> hotels = createHotelsValues(100, days);
    List<String> roomTypes = createTypesOfRoom();
    List<List<String>> rooms = new ArrayList<>();

    // Hotel rooms
    rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", "100", "10"));
    rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado y desayuno incluido.", "150", "7"));
    rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(2), "Habitacion triple con 3 camas dobles, minibar, vista al mar, aire acondicionado y servicio a la habitación 24/7.", "250", "20"));
    rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica y servicio a la habitación 24/7.", "300", "10"));
    rooms.add(Arrays.asList(hotels.get(0).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada y acceso exclusivo al spa.", "500", "10"));

    rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y escritorio de trabajo.", "110", "15"));
    rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y acceso a gimnasio.", "170", "6"));
    rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a actividades recreativas.", "270", "18"));
    rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo a la piscina privada.", "350", "12"));
    rooms.add(Arrays.asList(hotels.get(1).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio personalizado de conserjería.", "600", "8"));

    rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y vista a la ciudad.", "110", "12"));
    rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y balcón privado.", "160", "8"));
    rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a la piscina exterior.", "270", "15"));
    rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso al spa.", "350", "9"));
    rooms.add(Arrays.asList(hotels.get(2).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio de mayordomo.", "600", "6"));

    rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y vistas al jardín.", "120", "12"));
    rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y balcón privado.", "170", "6"));
    rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso al gimnasio.", "270", "18"));
    rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo al lounge ejecutivo.", "350", "8"));
    rooms.add(Arrays.asList(hotels.get(3).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y servicio de mayordomo las 24 horas.", "550", "5"));

    rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado, Wi-Fi gratuito y una vista al jardín.", "110", "15"));
    rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado, desayuno incluido y terraza privada.", "170", "8"));
    rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(2), "Habitación triple con 3 camas dobles, minibar, vista al mar, aire acondicionado, servicio a la habitación 24/7 y acceso a la piscina.", "270", "18"));
    rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica, servicio a la habitación 24/7 y acceso exclusivo al gimnasio.", "350", "12"));
    rooms.add(Arrays.asList(hotels.get(4).get(2), roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada, acceso exclusivo al spa y una zona de trabajo privada.", "550", "6"));

    // Apartment rooms
    rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(0), "Estudio moderno con cocina completamente equipada, cama individual, baño privado, balcón con vistas al jardín y Wi-Fi gratuito.", "170", "12"));
    rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completamente equipada, sala de estar espaciosa, terraza con vista panorámica a la ciudad y acceso a la piscina.", "350", "6"));
    rooms.add(Arrays.asList(hotels.get(5).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, sala de cine, terraza privada con barbacoa, ascensor exclusivo y servicio de mayordomo.", "750", "3"));

    rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(0), "Estudio moderno con cocina equipada, cama individual, baño privado, balcón con vistas al jardín y acceso a gimnasio.", "160", "15"));
    rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completa, sala de estar amplia, terraza con vista a la ciudad y zona de juegos para niños.", "320", "9"));
    rooms.add(Arrays.asList(hotels.get(6).get(2), roomTypes.get(3), "Penthouse con 3 dormitorios, jacuzzi, sala de cine, terraza privada, ascensor exclusivo, acceso a spa y servicio 24/7.", "700", "4"));

    rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(0), "Estudio con cocina moderna, cama individual, baño privado, balcón con vistas al jardín, TV inteligente y Wi-Fi.", "180", "14"));
    rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones con cocina completa, sala de estar, terraza con vista a la ciudad y acceso al club privado de residentes.", "330", "7"));
    rooms.add(Arrays.asList(hotels.get(7).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, cine en casa, terraza privada con vista al mar, ascensor privado y chef personal.", "800", "2"));

    rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(0), "Estudio de diseño moderno con cocina equipada, cama individual, baño privado, balcón, aire acondicionado y acceso a la piscina exterior.", "160", "10"));
    rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completamente equipada, sala de estar, terraza con vista panorámica y acceso al gimnasio.", "340", "8"));
    rooms.add(Arrays.asList(hotels.get(8).get(2), roomTypes.get(3), "Penthouse con 3 dormitorios, jacuzzi, cine privado, terraza exclusiva, ascensor privado, y acceso a la zona VIP del hotel.", "720", "5"));

    rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(0), "Estudio moderno con cocina equipada, cama individual, baño privado, balcón y servicio de limpieza diario.", "165", "13"));
    rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(2), "Apartamento de 2 habitaciones con cocina completa, sala de estar, terraza con vista a la ciudad, y servicio de desayuno incluido.", "325", "6"));
    rooms.add(Arrays.asList(hotels.get(9).get(2), roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, cine en casa, terraza privada, ascensor exclusivo, y acceso al spa y gimnasio.", "750", "4"));

    // Country house (Finca) rooms
    rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con hamacas y vista panorámica a las montañas.", "140", "30"));
    rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos locales, acceso a una piscina natural y actividades al aire libre como senderismo.", "270", "6"));
    rooms.add(Arrays.asList(hotels.get(10).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi al aire libre, terraza con hamacas, vista al valle y acceso exclusivo a un mirador privado.", "500", "35"));

    rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con vistas a la naturaleza y acceso a senderos ecológicos.", "130", "28"));
    rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno casero con productos locales, acceso a una piscina natural y actividades como pesca y paseos a caballo.", "260", "5"));
    rooms.add(Arrays.asList(hotels.get(11).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi privado, terraza con hamacas, vistas al valle y acceso a una zona de bienestar con spa y sauna.", "480", "33"));

    rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, balcón con vista a las montañas y acceso a una zona de picnic al aire libre.", "135", "27"));
    rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno orgánico con productos locales y acceso a una piscina natural rodeada de naturaleza.", "280", "7"));
    rooms.add(Arrays.asList(hotels.get(12).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi exterior, terraza con hamacas, vistas al valle y acceso a una zona privada para hacer fogatas.", "490", "32"));

    rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, vista a las montañas y acceso a una zona de observación de aves.", "125", "29"));
    rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno típico con productos orgánicos y acceso a piscina natural, ideal para relajarse.", "275", "6"));
    rooms.add(Arrays.asList(hotels.get(13).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi privado al aire libre, terraza con hamacas, vistas panorámicas al valle y acceso a una sala de yoga y meditación.", "470", "31"));

    rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, balcón y acceso a rutas de senderismo en el bosque.", "125", "25"));
    rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos orgánicos y acceso a una piscina natural rodeada de jardines y fauna local.", "265", "5"));
    rooms.add(Arrays.asList(hotels.get(14).get(2), roomTypes.get(4), "Suite Deluxe en finca con jacuzzi al aire libre, terraza con hamacas, vistas al valle y acceso a una zona privada con fogatas para las noches estrelladas.", "460", "34"));

    // Day-use (Día de Sol) rooms
    rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de yoga al aire libre.", "90", "7"));
    rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de un taller de cocina local.", "130", "18"));
    rooms.add(Arrays.asList(hotels.get(15).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y acceso a un tour privado de la ciudad.", "320", "10"));

    rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y actividad de arte al aire libre.", "90", "7"));
    rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, con un taller de danza local incluido.", "130", "18"));
    rooms.add(Arrays.asList(hotels.get(16).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y un paseo en bote por el río.", "320", "10"));

    rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de meditación al atardecer.", "90", "7"));
    rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de una clase de fotografía en la naturaleza.", "130", "18"));
    rooms.add(Arrays.asList(hotels.get(17).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y acceso a un recorrido privado por una reserva natural.", "320", "10"));

    rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y clase de pilates en el jardín.", "90", "7"));
    rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, además de una clase de cocina tradicional.", "130", "18"));
    rooms.add(Arrays.asList(hotels.get(18).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y una experiencia de cata de vinos.", "320", "10"));

    rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol con acceso a piscina, zonas recreativas, almuerzo buffet y sesión de tai chi al aire libre.", "90", "7"));
    rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol con actividades deportivas, acceso a spa, transporte y refrigerio, y un taller de arte para niños.", "130", "18"));
    rooms.add(Arrays.asList(hotels.get(19).get(2), roomTypes.get(5), "Día de sol premium con piscina privada, actividades exclusivas, almuerzo gourmet, masajes y una noche de música en vivo.", "320", "10"));

    return rooms;
  }
  // endregion

  // region rooms available
  public static List<List<String>> updatePriceHotel(List<List<String>> rooms, List<List<String>> hotels, int daysBetween) {
    for (List<String> hotel : hotels) {
      String hotelName = hotel.get(2);
      double minPrice = Double.MAX_VALUE;

      for (List<String> room : rooms) {
        String roomHotelName = room.get(0);
        if (roomHotelName.equals(hotelName)) {
          double roomPrice = Double.parseDouble(room.get(3));
          minPrice = Math.min(minPrice, roomPrice);
        }
      }

      hotel.set(4, String.valueOf(minPrice));
      hotel.set(5, String.valueOf(minPrice * daysBetween));
    }

    return hotels;
  }

  public static void getRoom(List<String> room) {
    System.out.println("Tipo de habitación: " + room.get(1));
    System.out.println("Descripción de la habitación: " + room.get(2));
    System.out.println("Precio de la habitación: $" + room.get(3));
    System.out.println("Habitaciones disponibles: " + room.get(4));
  }

  public static List<String> getRoomsForHousing(List<List<String>> rooms, String hotelName) {
    Scanner sc = new Scanner(System.in);

    System.out.println("\n***************************************");
    System.out.println("    >> Listado de Habitaciones <<      ");
    System.out.println("***************************************");

    int index = 1;

    System.out.println("Nombre del hotel: " + hotelName);

    for (List<String> room : rooms) {
      String roomHotelName = room.get(0);

      if (hotelName.equals(roomHotelName)) {
        System.out.println(index + ":");
        getRoom(room);
        System.out.println("-----------------------------------");
        index++;
      }
    }
    if (index == 1) {
      System.out.println("No se encontraron habitaciones que coincidan con los criterios.");
    }

    int selection = -1;
    while (true) {
      try {
        System.out.print("\nEscribe el número de la habitación que deseas seleccionar (1-" + (index - 1) + "): ");
        selection = sc.nextInt();

        if (selection > 0 && selection < index) {
          int currentIndex = 1;
          for (List<String> room : rooms) {
            String roomHotelName = room.get(0);

            if (hotelName.equals(roomHotelName)) {
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
  // endregion

  // region desired accommodation
  public static List<String> createDesiredAccommodation(List<List<String>> rooms, List<List<String>> hotels, String city, String housingType, LocalDate startDate, LocalDate endDate,
                                                        int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());

    List<List<String>> hotelsNow = updatePriceHotel(rooms, hotels, (int) daysBetween);

    List<String> hotel = getHotelByCityAndHousing(hotelsNow, city, housingType);
    System.out.println("\nHotel seleccionado: ");
    getHotel(hotel);

    hotel.set(5, String.valueOf((double) numberOfRooms * Double.parseDouble(hotel.get(4))));
    calculatePrice(hotel, startDate, endDate, numberOfRooms);

    return hotel;
  }

  public static void calculatePrice(List<String> hotel, LocalDate startDate, LocalDate endDate, int numberOfRooms) {
    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());
    double totalPrice = Double.parseDouble(hotel.get(5)) * daysBetween;

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
    hotel.set(5, String.valueOf(totalPrice));
  }

  public static void calculatePriceWithRooms(List<String> hotel, List<List<String>> rooms, LocalDate startDate, LocalDate endDate, int numberOfRooms) {
    double price = 0;

    for (List<String> room : rooms) {
      price += Double.parseDouble(room.get(2)) * Integer.parseInt(room.get(4));
    }
    hotel.set(4, String.valueOf(price));
    hotel.set(5, String.valueOf(price));

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("        *** Precio total con precio de habitaciones ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    calculatePrice(hotel, startDate, endDate, numberOfRooms);
  }

  // endregion

  // region confirm rooms
  public static List<List<String>> confirmRooms(List<List<String>> rooms, String hotelName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms) {
    Scanner sc = new Scanner(System.in);

    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());

    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("       *** Confirmación de Habitaciones para el Hotel: " + hotelName + " ***");
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    List<List<String>> selectedRooms = new ArrayList<>();
    List<List<String>> summary = new ArrayList<>();
    int remainingRooms = numberOfRooms;

    while (remainingRooms > 0) {
      System.out.println("\nHabitaciones restantes por seleccionar: " + remainingRooms);

      List<String> selectedRoom = getRoomsForHousing(rooms, hotelName);

      int quantity;
      int availableRooms;
      while (true) {
        System.out.print("\n¿Cuántas habitaciones de este tipo deseas? ");
        try {
          quantity = sc.nextInt();
          availableRooms = Integer.parseInt(selectedRoom.get(4));

          if (quantity > remainingRooms) {
            System.out.println("La cantidad ingresada supera el número de habitaciones restantes (" + remainingRooms + "). Por favor, ingresa una cantidad válida.");
          } else if (quantity > availableRooms) {
            System.out.println("La cantidad ingresada supera la disponibilidad de este tipo de habitación (" + availableRooms + ").");
          } else if (quantity <= 0) {
            System.out.println("Por favor, ingresa un número mayor a 0.");
          } else {
            availableRooms -= quantity;
            selectedRoom.set(4, String.valueOf(availableRooms));

            boolean foundInSummary = false;
            for (List<String> summaryRoom : summary) {
              if (summaryRoom.get(0).equals(selectedRoom.get(0))) {
                int currentQuantity = Integer.parseInt(summaryRoom.get(4));
                summaryRoom.set(4, String.valueOf(currentQuantity + quantity));
                foundInSummary = true;
                break;
              }
            }
            if (!foundInSummary) {
              List<String> summaryRoom = new ArrayList<>();
              summaryRoom.add(selectedRoom.get(1));
              summaryRoom.add(selectedRoom.get(2));
              summaryRoom.add(selectedRoom.get(3));
              summaryRoom.add(selectedRoom.get(4));
              summaryRoom.add(String.valueOf(quantity));
              summary.add(summaryRoom);
            }
            break;
          }
        } catch (Exception e) {
          System.out.println("Entrada no válida. Por favor, ingresa un número entero.");
          sc.next();
        }
      }

      for (int i = 0; i < quantity; i++) {
        selectedRooms.add(new ArrayList<>(selectedRoom));
      }

      remainingRooms -= quantity;
      System.out.println("\nHas seleccionado " + quantity + " habitación(es) correctamente.");

      if (remainingRooms > 0) {
        System.out.print("¿Deseas seleccionar más habitaciones? (S/N): ");
        String response = sc.next();
        if (!response.equalsIgnoreCase("S")) {
          break;
        }
      }
    }

    System.out.println("\n*** Resumen de habitaciones seleccionadas ***\n");

    for (List<String> room : summary) {
      System.out.println("Tipo de habitación: " + room.get(0));
      System.out.println("Descripción: " + room.get(1));
      System.out.println("Precio por noche: $" + room.get(2));
      System.out.println("Disponibilidad restante: " + room.get(3));
      System.out.println("Cantidad seleccionada: " + room.get(4));
      System.out.println("-----------------------------------");
    }

    if (remainingRooms > 0) {
      System.out.println("\nNo seleccionaste todas las habitaciones disponibles. ¡Asegúrate de confirmar tus opciones!");
    }

    System.out.println("\nGracias por confirmar tus habitaciones. ¡Que tengas una estancia agradable!");

    return summary;
  }

  // endregion

  // region revervation
  public static List<String> createReservation(List<String> hotel, List<List<String>> rooms, int numberOfRooms, int numberOfAdults, int numberOfChildren, String nombre, String lastName, String email, String nationality, String phone, LocalTime arrivalTime, LocalDate startDate, LocalDate endDate) {
    List<String> reservation = new ArrayList<>();

    reservation.add("Nombre: " + nombre + " " + lastName);
    reservation.add("Email: " + email);
    reservation.add("Nacionalidad: " + nationality);
    reservation.add("Teléfono: " + phone);

    reservation.add("Ciudad: " + hotel.get(0));
    reservation.add("Tipo de alojamiento: " + hotel.get(1));
    reservation.add("Nombre: " + hotel.get(2));
    reservation.add("Calificación: " + hotel.get(3));
    reservation.add("Precio por noche: " + hotel.get(4));
    reservation.add("Precio por estadía: " + hotel.get(5));

    reservation.add("Número de habitaciones: " + numberOfRooms);
    reservation.add("Número de adultos: " + numberOfAdults);
    reservation.add("Número de niños: " + numberOfChildren);

    reservation.add("Hora de llegada: " + arrivalTime.toString());
    reservation.add("Fecha de inicio: " + startDate.toString());
    reservation.add("Fecha de fin: " + endDate.toString());

    for (List<String> room : rooms) {
      reservation.add("Tipo de habitación: " + room.get(0));
      reservation.add("Descripción: " + room.get(1));
      reservation.add("Precio por noche: " + room.get(2));
      reservation.add("Cantidad: " + room.get(4));
    }
    System.out.println("\n============================================================");
    System.out.println("          ¡RESERVA REALIZADA CON ÉXITO!");
    System.out.println("============================================================");


    return reservation;
  }

  public static void getReservation(List<String> reservation) {
    System.out.println("\n============================================================");
    System.out.println("                INFORMACIÓN DEL CLIENTE                    ");
    System.out.println("============================================================");
    System.out.println(reservation.get(0));
    System.out.println(reservation.get(1));
    System.out.println(reservation.get(2));
    System.out.println(reservation.get(3));
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                    INFORMACIÓN DEL HOTEL                  ");
    System.out.println("============================================================");
    System.out.println(reservation.get(4));
    System.out.println(reservation.get(5));
    System.out.println(reservation.get(6));
    System.out.println(reservation.get(7));
    System.out.println(reservation.get(8));
    System.out.println(reservation.get(9));
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                    DETALLES DE LA RESERVA                 ");
    System.out.println("============================================================");
    System.out.println(reservation.get(10));
    System.out.println(reservation.get(11));
    System.out.println(reservation.get(12));
    System.out.println(reservation.get(13));
    System.out.println(reservation.get(14));
    System.out.println(reservation.get(15));
    System.out.println("============================================================");

    System.out.println("\n============================================================");
    System.out.println("                  HABITACIONES RESERVADAS                   ");
    System.out.println("============================================================");

    int roomStartIndex = 16;
    for (int i = roomStartIndex; i < reservation.size(); i += 4) {
      System.out.println(reservation.get(i));
      System.out.println(reservation.get(i + 1));
      System.out.println(reservation.get(i + 2));
      System.out.println(reservation.get(i + 3));
      System.out.println("----------------------------");
    }
  }

  public static void addReservations(List<List<String>> reservations, List<String> reservation) {
    reservations.add(reservation);
  }

  public static List<String> selectedReservation(List<List<String>> reservations, String email) {
    System.out.println("\n============================================================");
    System.out.println("      FILTRANDO RESERVAS POR EMAIL: " + email);
    System.out.println("============================================================");

    List<List<String>> filteredReservations = new ArrayList<>();
    int count = 1;

    for (List<String> reservation : reservations) {
      if (reservation.get(1).equals("Email: " + email)) {
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
      for (List<String> reservation : filteredReservations) {
        System.out.println("\n============================================================");
        System.out.println("                     RESERVA #" + count + "                      ");
        System.out.println("============================================================");
        getReservation(reservation);
        count++;
      }
    }
    Scanner sc = new Scanner(System.in);
    int selectedReservation = -1;
    while (true) {
      try {
        System.out.print("\nEscribe el número de la reserva que deseas seleccionar (1-" + filteredReservations.size() + "): ");
        selectedReservation = sc.nextInt();

        if (selectedReservation > 0 && selectedReservation <= filteredReservations.size()) {
          return filteredReservations.get(selectedReservation - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        sc.next();
      }
    }
  }

  public static void printReservations(List<List<String>> reservations, String email) {
    System.out.println("\n============================================================");
    System.out.println("      FILTRANDO RESERVAS POR EMAIL: " + email);
    System.out.println("============================================================");

    boolean found = false;
    int count = 1;
    for (List<String> reservation : reservations) {
      if (reservation.get(1).equals("Email: " + email)) {
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

  public static void removeReservation(List<List<String>> reservations, List<String> reservationToRemove) {
    System.out.println("\n============================================================");
    System.out.println("               ¡ELIMINANDO RESERVA!");
    System.out.println("============================================================");

    boolean found = false;

    for (int i = reservations.size() - 1; i >= 0; i--) {
      List<String> reservation = reservations.get(i);
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

  public static List<String> selectedRoom(List<String> reservation) {
    System.out.println("\n============================================================");
    System.out.println("                Información del hotel:");
    System.out.println("============================================================");
    System.out.println(reservation.get(4));
    System.out.println(reservation.get(5));
    System.out.println(reservation.get(6));
    System.out.println(reservation.get(7));
    System.out.println(reservation.get(8));
    System.out.println(reservation.get(9));

    System.out.println("\n============================================================");
    System.out.println("               Habitaciones reservadas:");
    System.out.println("============================================================");

    List<List<String>> rooms = new ArrayList<>();

    int roomStartIndex = 16;
    for (int i = roomStartIndex; i < reservation.size(); i += 4) {
      List<String> room = new ArrayList<>();
      room.add(reservation.get(i));
      room.add(reservation.get(i + 1));
      room.add(reservation.get(i + 2));
      room.add(reservation.get(i + 3));
      rooms.add(room);

      System.out.println("\n------------------------------------------------------------");
      System.out.println(reservation.get(i));
      System.out.println(reservation.get(i + 1));
      System.out.println(reservation.get(i + 2));
      System.out.println(reservation.get(i + 3));
      System.out.println("------------------------------------------------------------");
    }

    Scanner sc = new Scanner(System.in);
    int selectedRoom;

    while (true) {
      try {
        System.out.print("\nEscribe el número de la habitación que deseas seleccionar (1-" + rooms.size() + "): ");
        selectedRoom = sc.nextInt();

        if (selectedRoom > 0 && selectedRoom <= rooms.size()) {
          return rooms.get(selectedRoom - 1);
        } else {
          System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Inténtalo de nuevo.");
        sc.next();
      }
    }
  }

  public static List<String> updateRoomInReservation(List<String> reservation, List<String> oldRoom, List<String> newRoom) {
    int roomStartIndex = 16;

    for (int i = roomStartIndex; i < reservation.size(); i += 4) {
      if (reservation.get(i).trim().equals(oldRoom.get(0).trim())) {
        reservation.set(i, newRoom.get(0));
        reservation.set(i + 1, newRoom.get(1));
        reservation.set(i + 2, newRoom.get(2));
        reservation.set(i + 3, newRoom.get(4));
        break;
      }
    }

    return reservation;
  }
  // endregion

  // region menu
  public static int showOptions() {
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
    System.out.print("Selecciona una opción (1-3): ");


    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  public static void menu() {
    Scanner sc = new Scanner(System.in);
    int option = showOptions();

    switch (option) {
      case 1:
        makeReservation();
        menu();
        break;
      case 2:
        System.out.println("\n============================================================");
        System.out.println("                     MODIFICAR RESERVA                      ");
        System.out.println("============================================================");

        System.out.println("\nIngrese el email para autenticarse en la reserva: ");
        String emailFind = sc.next();

        List<String> reservationSelected = selectedReservation(reservations, emailFind);

        System.out.println("\n------------------------------------------------------------");
        System.out.println("                     ¿QUÉ DESEAS HACER?                    ");
        System.out.println("------------------------------------------------------------");
        System.out.println("                  (1) Cambiar habitación(es)                ");
        System.out.println("                  (2) Cambiar alojamiento                   ");
        System.out.println("                  (3) Cancelar                              ");
        System.out.println("------------------------------------------------------------");
        System.out.print("         Selecciona una opción (1-3): ");

        int response = sc.nextInt();

        switch (response) {
          case 1:
            System.out.println("\n============================================================");
            System.out.println("                   MODIFICAR HABITACIÓN(ES)                 ");
            System.out.println("============================================================");

            List<String> roomSelected = selectedRoom(reservationSelected);
            String hotelName = reservationSelected.get(6);
            hotelName = hotelName.replace("Nombre: ", "").trim();

            List<List<String>> availableRooms = new ArrayList<>();
            for (List<String> room : rooms) {
              String roomHotelName = room.get(0);
              if (hotelName.equals(roomHotelName)) {
                availableRooms.add(room);
              }
            }

            List<String> newRoom = getRoomsForHousing(availableRooms, hotelName);

            System.out.print("Ingresa la nueva cantidad de habitaciones para esta reserva: ");
            int newQuantity = sc.nextInt();

            newRoom.set(4, String.valueOf(newQuantity));

            newRoom.set(0, "Tipo de habitación: " + newRoom.get(1));
            newRoom.set(1, "Descripción: " + newRoom.get(2));
            newRoom.set(2, "Precio por noche: $" + newRoom.get(3));
            newRoom.set(4, "Cantidad: " + newRoom.get(4));

            List<String> updatedReservation = updateRoomInReservation(reservationSelected, roomSelected, newRoom);

            getReservation(updatedReservation);

            break;
          case 2:
            System.out.println("\n============================================================");
            System.out.println("                   MODIFICAR ALOJAMIENTO                   ");
            System.out.println("============================================================");

            removeReservation(reservations, reservationSelected);

            printReservations(reservations, emailFind);

            makeReservation();
            break;
          case 3:
            System.out.println("\n============================================================");
            System.out.println("                     SESIÓN CERRADA                        ");
            System.out.println("============================================================");

            break;
          default:
            System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
            sc.next();
            menu();
        }
        menu();
        break;
      case 3:
        System.out.println("\n============================================================");
        System.out.println("                     SESIÓN CERRADA                        ");
        System.out.println("============================================================");

        break;
      default:
        System.out.println("El número ingresado está fuera del rango. Inténtalo de nuevo.");
        sc.next();
        menu();
    }
  }

  public static void makeReservation() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\n============================================================");
    System.out.println("                  RESERVA DE ALOJAMIENTO                    ");
    System.out.println("============================================================");

    String city = getCity();
    String housing = getHousing();
    System.out.println("\nIngrese la fecha de inicio de la reserva (dd/mm/aaaa): ");
    LocalDate startDate = validateDate();
    System.out.println("\nIngrese la fecha de fin de la reserva (dd/mm/aaaa): ");
    LocalDate endDate = validateDateEnd(startDate);
    System.out.println("\nIngrese el número de adultos: ");
    int numberOfAdults = sc.nextInt();
    System.out.println("\nIngrese el número de niños: ");
    int numberOfChildren = sc.nextInt();
    System.out.println("\nIngrese el número de habitaciones: ");
    int numberOfRooms = sc.nextInt();

    long daysBetween = (endDate.toEpochDay() - startDate.toEpochDay());
    if (rooms == null) {
      rooms = createRooms((int) daysBetween);
    }
    if (hotels == null) {
      hotels = createHotelsValues(100, (int) daysBetween);
    }

    List<String> hotel = createDesiredAccommodation(rooms, hotels, city, housing, startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);
    List<List<String>> selectedRooms = confirmRooms(rooms, hotel.get(2), startDate, endDate, numberOfAdults, numberOfChildren, numberOfRooms);

    calculatePriceWithRooms(hotel, selectedRooms, startDate, endDate, numberOfRooms);

    System.out.println("\n============================================================");
    System.out.println("                DATOS DE LA PERSONA TITULAR                 ");
    System.out.println("============================================================");

    System.out.println("\nIngrese el nombre: ");
    String name = sc.next();
    System.out.println("\nIngrese el apellido: ");
    String lastName = sc.next();
    System.out.println("\nIngrese el email: ");
    String email = sc.next();
    System.out.println("\nIngrese la nacionalidad: ");
    String nationality = sc.next();
    System.out.println("\nIngrese el número de teléfono: ");
    String phone = sc.next();
    System.out.println("\nIngrese la hora de llegada (HH:mm): ");
    LocalTime arrivalDate = validateTime();


    List<String> reservation = createReservation(hotel, selectedRooms, numberOfRooms, numberOfAdults, numberOfChildren, name, lastName, email, nationality, phone, arrivalDate, startDate, endDate);

    getReservation(reservation);

    addReservations(reservations, reservation);

    System.out.println("\n============================================================");
    System.out.println("                ¡GRACIAS POR ELEGIRNOS!                     ");
    System.out.println("============================================================");
  }

// endregion

  // region validation
  public static LocalDate validateDate() {
    LocalDate date = null;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
      String input = sc.next();

      try {
        date = LocalDate.parse(input, formatter);

        if (date.isBefore(LocalDate.now())) {
          System.out.println("La fecha ingresada no es posterior a la fecha actual. Intenta de nuevo.");
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Asegúrate de usar el formato dd/MM/aaaa. Intenta de nuevo.");
      }
    }
    return date;
  }

  public static LocalDate validateDateEnd(LocalDate startDate) {
    LocalDate endDate = null;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
      String input = sc.next();

      try {
        endDate = LocalDate.parse(input, formatter);

        if (endDate.isBefore(startDate)) {
          System.out.println("La fecha de fin no puede ser menor a la fecha de inicio. Intenta de nuevo.");
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Asegúrate de usar el formato dd/MM/aaaa. Intenta de nuevo.");
      }
    }
    return endDate;
  }

  public static LocalTime validateTime() {
    LocalTime time = null;
    Scanner sc = new Scanner(System.in);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

    while (true) {
      String input = sc.next();

      try {
        time = LocalTime.parse(input, formatter);

        if (time.isBefore(LocalTime.MIDNIGHT) || time.isAfter(LocalTime.of(23, 59))) {
          System.out.println("La hora ingresada no es válida. Debe estar en el rango de 00:00 a 23:59. Intenta de nuevo.");
        } else {
          break;
        }
      } catch (Exception e) {
        System.out.println("Entrada no válida. Asegúrate de usar el formato HH:mm. Intenta de nuevo.");
      }
    }
    return time;
  }
// endregion
}
