package com.example.hotel.data;

import com.example.hotel.models.*;

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

  public List<Room> createRooms() {
    List<String> roomTypes = createTypesOfRoom();
    List<Room> rooms = new ArrayList<>();

    // Hoteles
    rooms.add(new Room("Marriott Hotel", roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", 100, 10));
    rooms.add(new Room("Marriott Hotel", roomTypes.get(1), "Habitación doble con 2 camas, minibar, aire acondicionado y desayuno incluido.", 150, 7));
    rooms.add(new Room("Marriott Hotel", roomTypes.get(2), "Habitación triple con vista al jardín, baño privado y Wi-Fi gratuito.", 200, 5));
    rooms.add(new Room("Marriott Hotel", roomTypes.get(3), "Suite con cama king size, sala de estar y bañera de hidromasaje.", 300, 3));
    rooms.add(new Room("Marriott Hotel", roomTypes.get(4), "Suite Deluxe con acceso exclusivo al spa y terraza con vista panorámica.", 500, 2));

    rooms.add(new Room("Hilton Garden Inn", roomTypes.get(0), "Estudio moderno con cama individual, aire acondicionado y Wi-Fi gratuito.", 120, 12));
    rooms.add(new Room("Hilton Garden Inn", roomTypes.get(1), "Habitación doble con balcón y vista a la ciudad.", 180, 8));
    rooms.add(new Room("Hilton Garden Inn", roomTypes.get(2), "Habitación triple con minibar y acceso a la piscina.", 240, 6));
    rooms.add(new Room("Hilton Garden Inn", roomTypes.get(3), "Suite con sala de estar, jacuzzi y desayuno incluido.", 350, 4));
    rooms.add(new Room("Hilton Garden Inn", roomTypes.get(4), "Suite Deluxe con terraza privada y acceso al gimnasio.", 450, 2));

    rooms.add(new Room("Holiday Inn", roomTypes.get(0), "Habitación sencilla con baño privado y TV por cable.", 110, 20));
    rooms.add(new Room("Holiday Inn", roomTypes.get(1), "Habitación doble con aire acondicionado y desayuno continental.", 160, 15));
    rooms.add(new Room("Holiday Inn", roomTypes.get(2), "Habitación triple con vista al mar y balcón privado.", 220, 10));
    rooms.add(new Room("Holiday Inn", roomTypes.get(3), "Suite con bañera de hidromasaje y minibar incluido.", 310, 5));
    rooms.add(new Room("Holiday Inn", roomTypes.get(4), "Suite Deluxe con terraza, piscina privada y vista al océano.", 520, 3));

    rooms.add(new Room("Ritz-Carlton", roomTypes.get(0), "Habitación sencilla con cama queen, aire acondicionado y escritorio.", 130, 8));
    rooms.add(new Room("Ritz-Carlton", roomTypes.get(1), "Habitación doble con vista panorámica y acceso al spa.", 200, 6));
    rooms.add(new Room("Ritz-Carlton", roomTypes.get(2), "Habitación triple con cocina equipada y acceso a la piscina climatizada.", 280, 4));
    rooms.add(new Room("Ritz-Carlton", roomTypes.get(3), "Suite con sala de estar, jacuzzi privado y balcón con vista al mar.", 400, 3));
    rooms.add(new Room("Ritz-Carlton", roomTypes.get(4), "Suite Deluxe con servicio de mayordomo y terraza privada.", 600, 2));

    rooms.add(new Room("Sheraton", roomTypes.get(0), "Cabaña rústica con chimenea y vistas a la montaña.", 140, 20));
    rooms.add(new Room("Sheraton", roomTypes.get(1), "Habitación doble en casa de campo con acceso al spa.", 200, 15));
    rooms.add(new Room("Sheraton", roomTypes.get(2), "Habitación triple con desayuno incluido y actividades al aire libre.", 250, 10));
    rooms.add(new Room("Sheraton", roomTypes.get(3), "Suite con jacuzzi al aire libre y vista panorámica.", 400, 5));
    rooms.add(new Room("Sheraton", roomTypes.get(4), "Suite Deluxe en finca con terraza privada y piscina climatizada.", 550, 3));

    // Apartamentos
    rooms.add(new Room("ApartaEstudio El Jardín", roomTypes.get(0), "Estudio moderno con cocina completamente equipada, cama individual, baño privado, balcón con vistas al jardín y Wi-Fi gratuito.", 170, 12));
    rooms.add(new Room("ApartaEstudio El Jardín", roomTypes.get(1), "Estudio con cama doble, cocina compacta, baño privado y acceso a zona de lavandería.", 190, 10));
    rooms.add(new Room("ApartaEstudio El Jardín", roomTypes.get(2), "Apartamento de 1 habitación con balcón y vista a la ciudad, ideal para parejas.", 220, 8));
    rooms.add(new Room("ApartaEstudio El Jardín", roomTypes.get(3), "Penthouse pequeño con terraza privada, cama queen size y sala de estar con TV.", 300, 5));

    rooms.add(new Room("ApartaSuites Vista Panorámica", roomTypes.get(0), "Apartamento de 2 habitaciones, cocina equipada, baño privado y sala con balcón.", 350, 6));
    rooms.add(new Room("ApartaSuites Vista Panorámica", roomTypes.get(1), "Apartamento moderno con 2 habitaciones, comedor y terraza con vista panorámica.", 380, 5));
    rooms.add(new Room("ApartaSuites Vista Panorámica", roomTypes.get(2), "Apartamento de lujo con 3 dormitorios, jacuzzi privado y balcón amplio.", 450, 4));
    rooms.add(new Room("ApartaSuites Vista Panorámica", roomTypes.get(3), "Penthouse exclusivo con acceso a piscina privada y servicio de mayordomo.", 700, 2));

    rooms.add(new Room("Residencias Sunset Place", roomTypes.get(0), "Apartamento tipo loft con cocina abierta, cama doble y baño con ducha amplia.", 200, 15));
    rooms.add(new Room("Residencias Sunset Place", roomTypes.get(1), "Apartamento de 2 habitaciones con balcón y sala de estar espaciosa.", 320, 8));
    rooms.add(new Room("Residencias Sunset Place", roomTypes.get(2), "Apartamento familiar con 3 dormitorios, sala comedor y cocina equipada.", 400, 6));
    rooms.add(new Room("Residencias Sunset Place", roomTypes.get(3), "Penthouse de lujo con jacuzzi, barbacoa en terraza y ascensor privado.", 750, 3));

    // Fincas
    rooms.add(new Room("Finca El Refugio", roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con hamacas y vista panorámica a las montañas.", 140, 30));
    rooms.add(new Room("Finca El Refugio", roomTypes.get(1), "Habitación doble con camas individuales, baño privado, chimenea y vistas al bosque.", 180, 15));
    rooms.add(new Room("Finca El Refugio", roomTypes.get(2), "Habitación familiar con 3 camas dobles, balcón con vistas a las montañas y desayuno incluido.", 250, 10));
    rooms.add(new Room("Finca El Refugio", roomTypes.get(3), "Suite con sala de estar, jacuzzi al aire libre y terraza privada con vista al valle.", 350, 5));

    rooms.add(new Room("Finca Las Colinas", roomTypes.get(0), "Cabaña pequeña con cama doble, baño privado y terraza con vistas al río.", 160, 25));
    rooms.add(new Room("Finca Las Colinas", roomTypes.get(1), "Habitación doble con decoración campestre, chimenea y balcón con vistas al jardín.", 200, 12));
    rooms.add(new Room("Finca Las Colinas", roomTypes.get(2), "Habitación triple con acceso a la piscina natural y actividades como senderismo y cabalgatas.", 270, 8));
    rooms.add(new Room("Finca Las Colinas", roomTypes.get(4), "Suite Deluxe con jacuzzi privado, acceso al spa y mirador exclusivo del atardecer.", 500, 5));

    rooms.add(new Room("Finca Mirador del Valle", roomTypes.get(0), "Cabaña acogedora con cama individual, chimenea y terraza con hamacas.", 150, 20));
    rooms.add(new Room("Finca Mirador del Valle", roomTypes.get(1), "Habitación doble con vistas panorámicas al valle y desayuno con productos locales.", 220, 10));
    rooms.add(new Room("Finca Mirador del Valle", roomTypes.get(2), "Habitación familiar con 2 camas dobles, baño privado y acceso a caminatas ecológicas.", 280, 7));
    rooms.add(new Room("Finca Mirador del Valle", roomTypes.get(4), "Suite exclusiva con piscina privada, jacuzzi al aire libre y terraza con vistas al atardecer.", 550, 3));

    return rooms;
  }

  public List<Activity> createActivities() {
    List<String> activityTypes = createSunnyDayActivities();
    List<Activity> activities = new ArrayList<>();

    activities.add(new Activity("Finca El Paraíso del Sol", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    activities.add(new Activity("Hacienda Los Senderos Dorados", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    activities.add(new Activity("Casa Campestre Vista Verde", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    activities.add(new Activity("Reserva Natural Cielo Azul", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    activities.add(new Activity("Recreo Sol y Brisa", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    activities.add(new Activity("Estancia El Refugio del Arte", activityTypes.get(0), "Taller de pintura al aire libre con paisajes naturales como inspiración, incluye materiales de pintura y refrigerio.", 190, 10));
    activities.add(new Activity("EcoLodge Pedal y Sol", activityTypes.get(1), "Paseo en bicicleta por rutas ecológicas con estaciones de descanso y paisajes naturales, incluye alquiler de bicicleta y casco.", 230, 7));
    activities.add(new Activity("Lago Tranquilo Lodge", activityTypes.get(2), "Pesca recreativa en lago tranquilo, ideal para relajarse, incluye caña de pescar, carnada y una bebida refrescante.", 200, 9));
    activities.add(new Activity("Retiro Amanecer Dorado", activityTypes.get(3), "Yoga al amanecer en un mirador natural con instructor certificado, incluye esterilla y agua purificada.", 180, 8));
    activities.add(new Activity("Finca Las Aguas Cristalinas", activityTypes.get(4), "Natación en piscina natural con áreas de descanso y acceso a cascadas cercanas, incluye toallas y refrigerio.", 210, 10));

    return activities;
  }

  public List<Hosting> createHostingWithRoomOrActivity(String typeHosting) {
    List<String> cities = createCities();
    List<String> typeOfHosting = createHostingTypes();

    List<Hosting> hostings = new ArrayList<>();

    List<Room> rooms = createRooms();

    // Hoteles
    if (typeHosting.equals(typeOfHosting.get(0))) {
      // Aquí pasas el nombre del hotel al obtener el precio mínimo
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(0), "Marriott Hotel", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(0), "Hilton Garden Inn", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(0), "Holiday Inn", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(3), typeOfHosting.get(0), "Ritz-Carlton", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(0), "Sheraton", getAverageRating(), 100, rooms));
    }

    // Apartamentos
    if (typeHosting.equals(typeOfHosting.get(1))) {
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(1), "ApartaEstudio El Jardín", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(1), "ApartaSuites Vista Panorámica", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(1), "Residencias Sunset Place", getAverageRating(), 100, rooms));
    }

    // Fincas
    if (typeHosting.equals(typeOfHosting.get(2))) {
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(2), "Finca El Refugio", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(3), typeOfHosting.get(2), "Finca Las Colinas", getAverageRating(), 100, rooms));
      hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(2), "Finca Mirador del Valle", getAverageRating(), 100, rooms));
    }

    // Actividades (Día de Sol)
    if (typeHosting.equals(typeOfHosting.get(3))) {
      List<Activity> activities = createActivities();
      hostings.add(new HostingWithActivity(cities.get(0), typeOfHosting.get(3), "Finca El Paraíso del Sol", getAverageRating(), 100 , activities));
      hostings.add(new HostingWithActivity(cities.get(1), typeOfHosting.get(3), "Hacienda Los Senderos Dorados", getAverageRating(), 100, activities));
      hostings.add(new HostingWithActivity(cities.get(2), typeOfHosting.get(3), "Casa Campestre Vista Verde", getAverageRating(), 100, activities));
    }

    return hostings;
  }

  public void printHostingWithRooms(List<Hosting> hostings) {
    for (Hosting hosting : hostings) {
      System.out.println(hosting.printHostingWithStay());
      System.out.println("----");
    }
  }

  public void printHosting(List<Hosting> hostings) {
    for (Hosting hosting : hostings) {
      System.out.println(hosting.printHosting());
      System.out.println("----");
    }
  }
  private double getAverageRating() {
    double rating = 1.0 + (Math.random() * 4.0);
    return Math.round(rating * 10.0) / 10.0;
  }
}
