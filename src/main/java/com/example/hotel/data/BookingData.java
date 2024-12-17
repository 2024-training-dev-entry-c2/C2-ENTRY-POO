package com.example.hotel.data;

import com.example.hotel.models.Activity;
import com.example.hotel.models.HostingWithActivity;
import com.example.hotel.models.HostingWithRoom;
import com.example.hotel.models.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookingData {
  public List<String> createCities() {
    return Arrays.asList("Cartagena", "Medellín", "Bogotá", "Santa Marta", "San Andrés", "Barichara", "Guatapé", "Cali");
  }

  public List<String> createHostingTypes() {
    return  Arrays.asList("Hotel", "Apartamento", "Finca", "Dia de Sol");
  }

  public List<String> createTypesOfRoom() {
    return Arrays.asList("Habitacion Sencilla", "Habitacion Doble", "Habitacion Triple", "Habitacion Suite", "Habitacion Suite Deluxe");
  }

  public List<String> createSunnyDayActivities() {
    return Arrays.asList("Picnic al aire libre", "Cabalgata por el pasto", "Caminata por el campo", "Observación de aves", "Juegos al aire libre");
  }

  public List<Room> createRoomsForHotel() {
    List<String> roomTypes = createTypesOfRoom();
    List<Room> rooms = new ArrayList<>();

    rooms.add(new Room(roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", 100, 10));
    rooms.add(new Room(roomTypes.get(1), "Habitación doble con 2 camas dobles, minibar, vista al mar, aire acondicionado y desayuno incluido.", 150, 7));
    rooms.add(new Room(roomTypes.get(2), "Habitacion triple con 3 camas dobles, minibar, vista al mar, aire acondicionado y servicio a la habitación 24/7.", 250, 20));
    rooms.add(new Room(roomTypes.get(3), "Suite con cama king size, sala de estar, bañera de hidromasaje, vista panorámica y servicio a la habitación 24/7.", 300, 10));
    rooms.add(new Room(roomTypes.get(4), "Suite Deluxe con cama king size, terraza privada, piscina climatizada y acceso exclusivo al spa.", 500, 10));

    return rooms;
  }

  public List<Room> createRoomsForApartment() {
    List<String> roomTypes = createTypesOfRoom();
    List<Room> rooms = new ArrayList<>();

    rooms.add(new Room(roomTypes.get(0), "Estudio moderno con cocina completamente equipada, cama individual, baño privado, balcón con vistas al jardín y Wi-Fi gratuito.", 170, 12));
    rooms.add(new Room(roomTypes.get(2), "Apartamento de 2 habitaciones, cocina completamente equipada, sala de estar espaciosa, terraza con vista panorámica a la ciudad y acceso a la piscina.", 350, 6));
    rooms.add(new Room(roomTypes.get(3), "Penthouse de lujo con 3 dormitorios, jacuzzi privado, sala de cine, terraza privada con barbacoa, ascensor exclusivo y servicio de mayordomo.", 750, 3));

    return rooms;
  }

  public List<Room> createRoomsForFarm() {
    List<String> roomTypes = createTypesOfRoom();
    List<Room> rooms = new ArrayList<>();

    rooms.add(new Room(roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con hamacas y vista panorámica a las montañas.", 140, 30));
    rooms.add(new Room(roomTypes.get(2), "Habitación triple en casa de campo, incluye desayuno con productos locales, acceso a una piscina natural y actividades al aire libre como senderismo.", 270, 6));
    rooms.add(new Room(roomTypes.get(4), "Suite Deluxe en finca con jacuzzi al aire libre, terraza con hamacas, vista al valle y acceso exclusivo a un mirador privado.", 500, 35));

    return rooms;
  }

  public List<Activity> createActivityForSunnyDay() {
    List<String> activityTypes = createSunnyDayActivities();
    List<Activity> activities = new ArrayList<>();

    activities.add(new Activity(activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas", 200, 8));
    activities.add(new Activity(activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad", 250, 5));
    activities.add(new Activity(activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos", 180, 12));
    activities.add(new Activity(activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio", 220, 6));
    activities.add(new Activity(activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas", 120, 15));

    return activities;
  }

  public List<HostingWithRoom> createHostingWithRoom() {
    List<String> cities = createCities();
    List<String> typeOfHosting = createHostingTypes();

    List<HostingWithRoom> hostings = new ArrayList<>();

    List<Room> roomsH = createRoomsForHotel();
    double minPriceH = Room.getMinPrice(roomsH);

    // Hoteles
    hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(0), "Marriott Hotel", getAverageRating(), minPriceH, roomsH));
    hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(0), "Hilton Garden Inn", getAverageRating(), minPriceH, roomsH));
    hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(0), "Ritz-Carlton", getAverageRating(), minPriceH, roomsH));
    hostings.add(new HostingWithRoom(cities.get(3), typeOfHosting.get(0), "Holiday Inn", getAverageRating(), minPriceH, roomsH));
    hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(0), "Sheraton", getAverageRating(), minPriceH, roomsH));

    List<Room> roomsA = createRoomsForApartment();
    double minPriceA = Room.getMinPrice(roomsA);

    // Apartamentos
    hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(1), "Apartamento Luxury", getAverageRating(), minPriceA, roomsA));
    hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(1), "Apartamento Vista Mar", getAverageRating(), minPriceA, roomsA));
    hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(1), "Apartamento Moderno", getAverageRating(), minPriceA, roomsA));
    hostings.add(new HostingWithRoom(cities.get(5), typeOfHosting.get(1), "Apartamento Familiar", getAverageRating(), minPriceA, roomsA));
    hostings.add(new HostingWithRoom(cities.get(7), typeOfHosting.get(1), "Apartamento en el Centro", getAverageRating(), minPriceA, roomsA));

    List<Room> roomsF = createRoomsForFarm();
    double minPriceF = Room.getMinPrice(roomsF);

    // Fincas
    hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(2), "Finca El Paraíso", getAverageRating(), minPriceF, roomsF));
    hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(2), "Finca La Esperanza", getAverageRating(), minPriceF, roomsF));
    hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(2), "Finca El Refugio", getAverageRating(), minPriceF, roomsF));
    hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(2), "Finca Santa Isabel", getAverageRating(), minPriceF, roomsF));
    hostings.add(new HostingWithRoom(cities.get(6), typeOfHosting.get(2), "Finca Las Palmas", getAverageRating(), minPriceF, roomsF));

    return hostings;
  }

  public List<HostingWithActivity> createHostingWithActivity() {
    List<String> cities = createCities();
    List<String> typeOfHosting = createHostingTypes();

    List<HostingWithActivity> hostings = new ArrayList<>();

    List<Activity> activities = createActivityForSunnyDay();
    double minPrice = Activity.getMinPrice(activities);

    hostings.add(new HostingWithActivity(cities.get(0), typeOfHosting.get(3), "Día de Sol Aventura", getAverageRating(), minPrice, activities));
    hostings.add(new HostingWithActivity(cities.get(0), typeOfHosting.get(3), "Día de Sol Relax", getAverageRating(), minPrice, activities));
    hostings.add(new HostingWithActivity(cities.get(2), typeOfHosting.get(3), "Día de Sol Familiar", getAverageRating(), minPrice, activities));
    hostings.add(new HostingWithActivity(cities.get(3), typeOfHosting.get(3), "Día de Sol Deportivo", getAverageRating(), minPrice, activities));
    hostings.add(new HostingWithActivity(cities.get(4), typeOfHosting.get(3), "Día de Sol con Spa", getAverageRating(), minPrice, activities));

    return hostings;
  }
  public void printHostingWithRooms(List<HostingWithRoom> hotels) {
    for (HostingWithRoom hotel : hotels) {
      System.out.println(hotel.printHostingWithStay());
      System.out.println("----");
    }
  }

  public void printHostingWithActivities(List<HostingWithActivity> hotels) {
    for (HostingWithActivity hotel : hotels) {
      System.out.println(hotel.printHostingWithStay());
      System.out.println("----");
    }
  }
  private double getAverageRating() {
    double rating = 1.0 + (Math.random() * 4.0);
    return Math.round(rating * 10.0) / 10.0;
  }
}
