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

  public List<Stay> createStay() {
    List<String> roomTypes = createTypesOfRoom();
    List<String> activityTypes = createSunnyDayActivities();
    List<Stay> stays = new ArrayList<>();

    // Hoteles
    stays.add(new Stay("Marriott Hotel", roomTypes.get(0), "Habitación sencilla con 1 cama, aire acondicionado, TV, baño privado y Wi-Fi gratuito.", 100, 10));
    stays.add(new Stay("Marriott Hotel", roomTypes.get(1), "Habitación doble con 2 camas, minibar, aire acondicionado y desayuno incluido.", 150, 7));
    stays.add(new Stay("Marriott Hotel", roomTypes.get(2), "Habitación triple con vista al jardín, baño privado y Wi-Fi gratuito.", 200, 5));
    stays.add(new Stay("Marriott Hotel", roomTypes.get(3), "Suite con cama king size, sala de estar y bañera de hidromasaje.", 300, 3));
    stays.add(new Stay("Marriott Hotel", roomTypes.get(4), "Suite Deluxe con acceso exclusivo al spa y terraza con vista panorámica.", 500, 2));

    stays.add(new Stay("Hilton Garden Inn", roomTypes.get(0), "Estudio moderno con cama individual, aire acondicionado y Wi-Fi gratuito.", 120, 12));
    stays.add(new Stay("Hilton Garden Inn", roomTypes.get(1), "Habitación doble con balcón y vista a la ciudad.", 180, 8));
    stays.add(new Stay("Hilton Garden Inn", roomTypes.get(2), "Habitación triple con minibar y acceso a la piscina.", 240, 6));
    stays.add(new Stay("Hilton Garden Inn", roomTypes.get(3), "Suite con sala de estar, jacuzzi y desayuno incluido.", 350, 4));
    stays.add(new Stay("Hilton Garden Inn", roomTypes.get(4), "Suite Deluxe con terraza privada y acceso al gimnasio.", 450, 2));

    stays.add(new Stay("Holiday Inn", roomTypes.get(0), "Habitación sencilla con baño privado y TV por cable.", 110, 20));
    stays.add(new Stay("Holiday Inn", roomTypes.get(1), "Habitación doble con aire acondicionado y desayuno continental.", 160, 15));
    stays.add(new Stay("Holiday Inn", roomTypes.get(2), "Habitación triple con vista al mar y balcón privado.", 220, 10));
    stays.add(new Stay("Holiday Inn", roomTypes.get(3), "Suite con bañera de hidromasaje y minibar incluido.", 310, 5));
    stays.add(new Stay("Holiday Inn", roomTypes.get(4), "Suite Deluxe con terraza, piscina privada y vista al océano.", 520, 3));

    stays.add(new Stay("Ritz-Carlton", roomTypes.get(0), "Habitación sencilla con cama queen, aire acondicionado y escritorio.", 130, 8));
    stays.add(new Stay("Ritz-Carlton", roomTypes.get(1), "Habitación doble con vista panorámica y acceso al spa.", 200, 6));
    stays.add(new Stay("Ritz-Carlton", roomTypes.get(2), "Habitación triple con cocina equipada y acceso a la piscina climatizada.", 280, 4));
    stays.add(new Stay("Ritz-Carlton", roomTypes.get(3), "Suite con sala de estar, jacuzzi privado y balcón con vista al mar.", 400, 3));
    stays.add(new Stay("Ritz-Carlton", roomTypes.get(4), "Suite Deluxe con servicio de mayordomo y terraza privada.", 600, 2));

    stays.add(new Stay("Sheraton", roomTypes.get(0), "Cabaña rústica con chimenea y vistas a la montaña.", 140, 20));
    stays.add(new Stay("Sheraton", roomTypes.get(1), "Habitación doble en casa de campo con acceso al spa.", 200, 15));
    stays.add(new Stay("Sheraton", roomTypes.get(2), "Habitación triple con desayuno incluido y actividades al aire libre.", 250, 10));
    stays.add(new Stay("Sheraton", roomTypes.get(3), "Suite con jacuzzi al aire libre y vista panorámica.", 400, 5));
    stays.add(new Stay("Sheraton", roomTypes.get(4), "Suite Deluxe en finca con terraza privada y piscina climatizada.", 550, 3));

    // Apartamentos
    stays.add(new Stay("ApartaEstudio El Jardín", roomTypes.get(0), "Estudio moderno con cocina completamente equipada, cama individual, baño privado, balcón con vistas al jardín y Wi-Fi gratuito.", 170, 12));
    stays.add(new Stay("ApartaEstudio El Jardín", roomTypes.get(1), "Estudio con cama doble, cocina compacta, baño privado y acceso a zona de lavandería.", 190, 10));
    stays.add(new Stay("ApartaEstudio El Jardín", roomTypes.get(2), "Apartamento de 1 habitación con balcón y vista a la ciudad, ideal para parejas.", 220, 8));
    stays.add(new Stay("ApartaEstudio El Jardín", roomTypes.get(3), "Penthouse pequeño con terraza privada, cama queen size y sala de estar con TV.", 300, 5));

    stays.add(new Stay("ApartaSuites Vista Panorámica", roomTypes.get(0), "Apartamento de 2 habitaciones, cocina equipada, baño privado y sala con balcón.", 350, 6));
    stays.add(new Stay("ApartaSuites Vista Panorámica", roomTypes.get(1), "Apartamento moderno con 2 habitaciones, comedor y terraza con vista panorámica.", 380, 5));
    stays.add(new Stay("ApartaSuites Vista Panorámica", roomTypes.get(2), "Apartamento de lujo con 3 dormitorios, jacuzzi privado y balcón amplio.", 450, 4));
    stays.add(new Stay("ApartaSuites Vista Panorámica", roomTypes.get(3), "Penthouse exclusivo con acceso a piscina privada y servicio de mayordomo.", 700, 2));

    stays.add(new Stay("Residencias Sunset Place", roomTypes.get(0), "Apartamento tipo loft con cocina abierta, cama doble y baño con ducha amplia.", 200, 15));
    stays.add(new Stay("Residencias Sunset Place", roomTypes.get(1), "Apartamento de 2 habitaciones con balcón y sala de estar espaciosa.", 320, 8));
    stays.add(new Stay("Residencias Sunset Place", roomTypes.get(2), "Apartamento familiar con 3 dormitorios, sala comedor y cocina equipada.", 400, 6));
    stays.add(new Stay("Residencias Sunset Place", roomTypes.get(3), "Penthouse de lujo con jacuzzi, barbacoa en terraza y ascensor privado.", 750, 3));

    // Fincas
    stays.add(new Stay("Finca El Refugio", roomTypes.get(0), "Cabaña rústica con cama sencilla, baño privado, chimenea, terraza con hamacas y vista panorámica a las montañas.", 140, 30));
    stays.add(new Stay("Finca El Refugio", roomTypes.get(1), "Habitación doble con camas individuales, baño privado, chimenea y vistas al bosque.", 180, 15));
    stays.add(new Stay("Finca El Refugio", roomTypes.get(2), "Habitación familiar con 3 camas dobles, balcón con vistas a las montañas y desayuno incluido.", 250, 10));
    stays.add(new Stay("Finca El Refugio", roomTypes.get(3), "Suite con sala de estar, jacuzzi al aire libre y terraza privada con vista al valle.", 350, 5));

    stays.add(new Stay("Finca Las Colinas", roomTypes.get(0), "Cabaña pequeña con cama doble, baño privado y terraza con vistas al río.", 160, 25));
    stays.add(new Stay("Finca Las Colinas", roomTypes.get(1), "Habitación doble con decoración campestre, chimenea y balcón con vistas al jardín.", 200, 12));
    stays.add(new Stay("Finca Las Colinas", roomTypes.get(2), "Habitación triple con acceso a la piscina natural y actividades como senderismo y cabalgatas.", 270, 8));
    stays.add(new Stay("Finca Las Colinas", roomTypes.get(4), "Suite Deluxe con jacuzzi privado, acceso al spa y mirador exclusivo del atardecer.", 500, 5));

    stays.add(new Stay("Finca Mirador del Valle", roomTypes.get(0), "Cabaña acogedora con cama individual, chimenea y terraza con hamacas.", 150, 20));
    stays.add(new Stay("Finca Mirador del Valle", roomTypes.get(1), "Habitación doble con vistas panorámicas al valle y desayuno con productos locales.", 220, 10));
    stays.add(new Stay("Finca Mirador del Valle", roomTypes.get(2), "Habitación familiar con 2 camas dobles, baño privado y acceso a caminatas ecológicas.", 280, 7));
    stays.add(new Stay("Finca Mirador del Valle", roomTypes.get(4), "Suite exclusiva con piscina privada, jacuzzi al aire libre y terraza con vistas al atardecer.", 550, 3));

    // Dia de sol
    stays.add(new Stay("Finca El Paraíso del Sol", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    stays.add(new Stay("Finca El Paraíso del Sol", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    stays.add(new Stay("Finca El Paraíso del Sol", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    stays.add(new Stay("Finca El Paraíso del Sol", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    stays.add(new Stay("Finca El Paraíso del Sol", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    stays.add(new Stay("Hacienda Los Senderos Dorados", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    stays.add(new Stay("Hacienda Los Senderos Dorados", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    stays.add(new Stay("Hacienda Los Senderos Dorados", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    stays.add(new Stay("Hacienda Los Senderos Dorados", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    stays.add(new Stay("Hacienda Los Senderos Dorados", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    stays.add(new Stay("Casa Campestre Vista Verde", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    stays.add(new Stay("Casa Campestre Vista Verde", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    stays.add(new Stay("Casa Campestre Vista Verde", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    stays.add(new Stay("Casa Campestre Vista Verde", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    stays.add(new Stay("Casa Campestre Vista Verde", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    stays.add(new Stay("Reserva Natural Cielo Azul", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    stays.add(new Stay("Reserva Natural Cielo Azul", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    stays.add(new Stay("Reserva Natural Cielo Azul", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    stays.add(new Stay("Reserva Natural Cielo Azul", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    stays.add(new Stay("Reserva Natural Cielo Azul", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    stays.add(new Stay("Recreo Sol y Brisa", activityTypes.get(0), "Picnic al aire libre con vista a las montañas y opciones de comida local, incluye almuerzo tipo picnic con bebidas frescas.", 200, 8));
    stays.add(new Stay("Recreo Sol y Brisa", activityTypes.get(1), "Cabalgata tranquila por senderos de pasto, ideal para principiantes y amantes de los caballos, incluye refrigerio ligero durante la actividad.", 250, 5));
    stays.add(new Stay("Recreo Sol y Brisa", activityTypes.get(2), "Caminata guiada por el campo con paradas en miradores naturales y paisajes únicos, incluye almuerzo campestre con productos frescos.", 180, 12));
    stays.add(new Stay("Recreo Sol y Brisa", activityTypes.get(3), "Observación de aves con binoculares y guía especializado, incluyendo especies nativas, incluye café y galletas al inicio.", 220, 6));
    stays.add(new Stay("Recreo Sol y Brisa", activityTypes.get(4), "Juegos al aire libre como voleibol, fútbol y juegos de equipo para todas las edades, incluye bebidas hidratantes y frutas.", 120, 15));

    return stays;
  }

  public List<Hosting> createHostingWithRoomOrActivity(String typeHosting) {
    List<String> cities = createCities();
    List<String> typeOfHosting = createHostingTypes();

    List<Hosting> hostings = new ArrayList<>();

    List<Stay> stays = createStay();

    // Hoteles
    if (typeHosting.equals(typeOfHosting.get(0))) {
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(0), "Marriott Hotel", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(0), "Hilton Garden Inn", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(0), "Holiday Inn", getAverageRating(), 100, 100,stays));
      hostings.add(new HostingWithRoom(cities.get(3), typeOfHosting.get(0), "Ritz-Carlton", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(0), "Sheraton", getAverageRating(), 100, 100, stays));
    }

    // Apartamentos
    if (typeHosting.equals(typeOfHosting.get(1))) {
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(1), "ApartaEstudio El Jardín", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(1), typeOfHosting.get(1), "ApartaSuites Vista Panorámica", getAverageRating(), 100, 100,  stays));
      hostings.add(new HostingWithRoom(cities.get(2), typeOfHosting.get(1), "Residencias Sunset Place", getAverageRating(), 100, 100, stays));
    }

    // Fincas
    if (typeHosting.equals(typeOfHosting.get(2))) {
      hostings.add(new HostingWithRoom(cities.get(0), typeOfHosting.get(2), "Finca El Refugio", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(3), typeOfHosting.get(2), "Finca Las Colinas", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithRoom(cities.get(4), typeOfHosting.get(2), "Finca Mirador del Valle", getAverageRating(), 100, 100, stays));
    }

    // Actividades (Día de Sol)
    if (typeHosting.equals(typeOfHosting.get(3))) {
      hostings.add(new HostingWithActivity(cities.get(0), typeOfHosting.get(3), "Finca El Paraíso del Sol", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithActivity(cities.get(1), typeOfHosting.get(3), "Hacienda Los Senderos Dorados", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithActivity(cities.get(2), typeOfHosting.get(3), "Casa Campestre Vista Verde", getAverageRating(), 100,100, stays));
      hostings.add(new HostingWithActivity(cities.get(2), typeOfHosting.get(3), "Reserva Natural Cielo Azul", getAverageRating(), 100, 100, stays));
      hostings.add(new HostingWithActivity(cities.get(3), typeOfHosting.get(3), "Recreo Sol y Brisa", getAverageRating(), 100, 100, stays));
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
