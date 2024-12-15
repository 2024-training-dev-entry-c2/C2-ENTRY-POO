package com.bookstay;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Global variables
    static List<List<String>> lodgings = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        showMenu();
    }

    /* ############################### INITIALIZE DATA ############################### */
    public static void initializeData() {
        // Lodging structure: [Name, City, Category, Rating, Price, Description, MaxPeople, Rooms, Activities, Meals, ReservationData]
        // Room structure: " Name | Description | Price | MaxAdults | MaxChildren | Quantily "

        // Hoteles
        addLodging("Hotel Mar Azul", "Cartagena", "Hotel", "4.9", "",
                "Hotel frente al mar con excelentes comodidades", "",
                "Habitación Estándar|La habitación estándar cuenta con 1 cama queen, aire acondicionado, minibar, baño privado y TV de pantalla plana.|200000|2|1|10;" +
                        "Habitación Deluxe|La habitación deluxe tiene cama king, balcón con vista al mar, cafetera, y servicio de habitaciones las 24 horas.|400000|2|2|5;" +
                        "Suite|La suite incluye una sala de estar separada, jacuzzi, minibar surtido, y vistas panorámicas al océano.|800000|2|2|3;" +
                        "Junior Suite|Habitación amplia con sofá cama, jacuzzi, minibar y vistas al mar.|600000|2|2|4;" +
                        "Presidential Suite|Suite de lujo con varias habitaciones, jacuzzi privado, y vistas completas al océano.|1200000|4|2|2",
                "", "", "");

        addLodging("Hotel Los Andes", "Bogotá", "Hotel", "4.6", "",
                "Hotel moderno con vistas a la ciudad", "",
                "Habitación Estándar|Una opción económica y cómoda con una cama queen, baño privado y TV por cable.|200000|2|1|10;" +
                        "Habitación Deluxe|Amplia habitación con cama king, vistas a la ciudad y minibar incluido.|400000|2|2|5;" +
                        "Suite|La suite cuenta con una sala de estar privada, jacuzzi, y escritorio para trabajo.|800000|2|2|3;" +
                        "Habitación Familiar|Habitación grande con cama queen, sofá cama, baño privado y área de estar.|500000|4|2|6;" +
                        "Presidential Suite|Gran suite con varias habitaciones, jacuzzi privado y vistas panorámicas.|1200000|4|3|2",
                "", "", "");

        addLodging("Hotel Bahia Blanca", "Santa Marta", "Hotel", "4.7", "",
                "Hotel cerca de la playa con piscina y spa", "",
                "Habitación Estándar|Habitación con cama king, TV por cable, aire acondicionado y baño privado.|250000|2|1|12;" +
                        "Habitación Deluxe|Habitación con vistas al mar, minibar y jacuzzi privado.|500000|2|2|6;" +
                        "Suite Presidencial|Suite amplia con sala de estar, jacuzzi, y vistas al océano.|1000000|2|2|2;" +
                        "Habitación Superior|Con cama queen, minibar y baño privado, ideal para estancias largas.|300000|2|1|8;" +
                        "Habitación Conectada|Habitaciones comunicadas para familias grandes, con 2 camas queen y 2 baños privados.|550000|4|2|5",
                "", "", "");

        addLodging("Hotel Mirador del Valle", "Medellín", "Hotel", "4.8", "",
                "Hotel con una vista espectacular de la ciudad", "",
                "Habitación Estándar|Habitación con cama queen, escritorio y baño privado.|220000|2|1|8;" +
                        "Habitación Deluxe|Habitación con vistas a las montañas, minibar y cafetera.|400000|2|2|4;" +
                        "Suite|Suite con salón independiente, jacuzzi y minibar.|850000|2|2|3;" +
                        "Junior Suite|Habitación más espaciosa con sofá cama, jacuzzi, y minibar.|600000|2|2|4;" +
                        "Suite Presidencial|Suite con varias habitaciones, jacuzzi privado y vistas panorámicas de la ciudad.|1500000|4|3|2",
                "", "", "");

        addLodging("Hotel Costa Dorada", "Cartagena", "Hotel", "4.5", "",
                "Hotel frente a la playa con restaurante y gimnasio", "",
                "Habitación Estándar|Habitación con cama queen, aire acondicionado, TV por cable y baño privado.|200000|2|1|10;" +
                        "Habitación Deluxe|Habitación con vistas al mar, minibar y escritorio.|400000|2|2|6;" +
                        "Suite Familiar|Suite con 2 habitaciones, sala de estar y vista al océano.|600000|4|2|4;" +
                        "Habitación Ejecutiva|Con cama king, escritorio de trabajo y minibar.|450000|2|2|5;" +
                        "Suite Presidencial|Gran suite con sala de estar, jacuzzi y vistas completas al mar.|1200000|4|3|2",
                "", "", "");

        // Apartaments
        addLodging("Apartamento Playa", "Cartagena", "Apartamento", "4.7", "500000",
                "Apartamento moderno con vista al océano", "6", "", "", "", "");

        addLodging("Apartamento Mirador", "Bogotá", "Apartamento", "4.6", "350000",
                "Apartamento con vistas panorámicas de la ciudad", "4", "", "", "", "");

        addLodging("Apartamento Acapulco", "Cartagena", "Apartamento", "4.8", "600000",
                "Apartamento con vista al mar y piscina privada", "5", "", "", "", "");

        addLodging("Apartamento Pinares", "Santa Marta", "Apartamento", "4.5", "400000",
                "Apartamento de lujo con terraza privada", "8", "", "", "", "");

        addLodging("Apartamento Estrella", "Medellín", "Apartamento", "4.7", "550000",
                "Apartamento moderno con acceso a gimnasio y piscina", "4", "", "", "", "");

        // Farm Stays
        addLodging("Finca El Bosque", "Armenia", "Finca", "4.8", "800000",
                "Finca tranquila rodeada de bosque", "10", "", "", "", "");

        addLodging("Finca Los Pinos", "Pereira", "Finca", "4.9", "900000",
                "Finca con vistas a la montaña y espacios amplios", "12", "", "", "", "");

        addLodging("Finca Valle Verde", "Manizales", "Finca", "4.6", "750000",
                "Finca ideal para retiros y actividades al aire libre", "8", "", "", "", "");

        addLodging("Finca El Paraíso", "Caldas", "Finca", "4.7", "850000",
                "Finca en un valle tranquilo rodeado de naturaleza", "14", "", "", "", "");

        addLodging("Finca Los Robles", "Quindío", "Finca", "4.8", "950000",
                "Finca con senderos ecológicos y vista panorámica", "10", "", "", "", "");

        // Day Resorts
        addLodging("Día de Sol Caribe", "San Andrés", "Día de sol", "5.0", "200000",
                "Disfruta del sol, playa y actividades acuáticas", "4", "", "Snorkeling, paseos en bote, kayak, yoga en la playa", "Almuerzo con platos típicos, cena a la carta", "");

        addLodging("Día de Sol Tulum", "Tulum", "Día de sol", "4.9", "220000",
                "Un día de sol con actividades en la Riviera Maya", "2", "", "Tour en cenotes, paseos en bicicleta, actividades acuáticas", "Comida mexicana tradicional, bebidas incluidas", "");

        addLodging("Día de Sol Santa Marta", "Santa Marta", "Día de sol", "5.0", "180000",
                "Relájate en la playa con actividades acuáticas", "6", "", "Surf, paddleboard, snorkeling, caminatas", "Almuerzo buffet, cena en restaurante exclusivo", "");

        addLodging("Día de Sol Cartagena", "Cartagena", "Día de sol", "4.8", "150000",
                "Disfruta del sol en las playas más bellas", "5", "", "Bicicross, deportes acuáticos, yoga", "Comida local, bebidas tropicales", "");

        addLodging("Día de Sol Isla Barú", "Cartagena", "Día de sol", "4.9", "210000",
                "Un día de sol con todas las comodidades frente al mar", "8", "", "Kayak, excursión a la isla, pesca", "Comida caribeña, cócteles", "");
    }

    public static void addLodging(String name, String city, String category, String rating, String price, String description, String maxPeople, String rooms, String activities, String meals, String reservationData) {
        lodgings.add(Arrays.asList(name, city, category, rating, price, description, maxPeople, rooms, activities, meals, reservationData));
    }

    /* ################################# PRINT MENU ################################# */
    public static void showMenu(){

        System.out.println("\n         ___|_|_|_|_|_|_|_|_|_|_|_|_|_|_|_|___    ");
        System.out.println("        |                                     |    ");
        System.out.println("        |      Bienvenido(a) a Book Stay      |    ");
        System.out.println("        |_____________________________________|    ");
        System.out.println("               |     |     |     |     |          \n");

        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("*----------------------- Menú -----------------------*");
            System.out.println("| 1. Buscar alojamiento.                             | ");
            System.out.println("| 2. Hacer una reservación.                          | ");
            System.out.println("| 3. Modificar una reservación.                      | ");
            System.out.println("| 0. Salir.                                          | ");
            System.out.println("*----------------------------------------------------*\n");

            System.out.println("Ingresa el número de la opción que deseas realizar: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option){
                case 1:
                    System.out.println("\n*------------------ Buscar Alojamiento --------------*");
                    System.out.println("¿A cuál ciudad deseas ir?: ");
                    String city = input.nextLine();
                    System.out.println("¿Qué tipo de alojamiento buscas?: ");
                    String category = input.nextLine();
                    System.out.println("Escribe el día inicial de la estadía (YYYY-MM-dd): ");
                    String startDay = input.nextLine();
                    System.out.println("Escribe el día final de la estadía (YYYY-MM-dd): ");
                    String endDay = input.nextLine();
                    System.out.println("Cantidad de adultos: ");
                    int adults = input.nextInt();
                    input.nextLine();
                    System.out.println("Cantidad de niños: ");
                    int children = input.nextInt();
                    input.nextLine();

                    int roomsRequired;
                    if(category.equalsIgnoreCase("Hotel")){
                        System.out.println("Cantidad de habitaciones: ");
                        roomsRequired = input.nextInt();
                        input.nextLine();
                    }else {
                        roomsRequired = 0;
                    }

                    List<List<String>> results = searchLodgings(city, category, startDay, endDay, adults, children, roomsRequired);
                    System.out.println("\nLos resultados obtenidos en la búsqueda son: \n");
                    for(List<String> result : results){
                        printLodgingInformation(result, startDay, endDay, roomsRequired);
                    }

                    System.out.println("\n¿Desea hacer una reservación? (Si - No)");
                    String response = input.nextLine();

                    if(response.equalsIgnoreCase("Si")){
                        System.out.println("\n*------------------ Iniciar la Reservación --------------*");
                        System.out.println("*-- Confirmación de datos");
                    }else{
                        System.out.println("Serás redirigido(a) al menú principal. Espera un momento...");
                    }
                    break;
                case 3:
                    System.out.println("Hacer una reservación");
                    break;
                case 5:
                    System.out.println("Modificar una reservación");
                    break;
                case 0:
                    System.out.println("¡Gracias por usar nuestros servicios!");
                    return;
                default:
                    System.out.println("Opción no válida, rectifica el menú.");
                    break;
            }
        }


    }

    /* ################################# SEARCH DATA ################################# */
    public static List<List<String>> searchLodgings(String city, String category, String startDate, String endDate, int adults, int children, int roomsNeeded) {
        List<List<String>> results = new ArrayList<>();
        for (List<String> lodging : lodgings) {  // Check each lodging on the list
            String lodgingCity = lodging.get(1);
            String lodgingCategory = lodging.get(2);

            if (lodgingCity.equalsIgnoreCase(city) && lodgingCategory.equalsIgnoreCase(category)) {
                int totalPeople = adults + children;

                if (lodgingCategory.equalsIgnoreCase("Hotel")) {
                    String roomsInfo = lodging.get(7);
                    String[] roomTypes = roomsInfo.split(";");
                    int roomsAvailable = 0;

                    for (String roomType : roomTypes) { // Validate which room types are valid and how many are available
                        String[] roomDetails = roomType.split("\\|");
                        int maxAdults = Integer.parseInt(roomDetails[3]);
                        int maxChildren = Integer.parseInt(roomDetails[4]);
                        int roomCount = Integer.parseInt(roomDetails[5]);

                        // Calculate currently reserved rooms for this room type
                        int reservedRooms = countReservedRooms(lodging.get(10), roomDetails[0], startDate, endDate);

                        if (totalPeople <= (maxAdults + maxChildren) && (roomCount - reservedRooms) > 0) {
                            roomsAvailable += (roomCount - reservedRooms);
                        }
                    }

                    if (roomsAvailable >= roomsNeeded) {
                        results.add(lodging);
                    }
                } else {
                    int maxPeople = Integer.parseInt(lodging.get(6));
                    int reservedCapacity = countReservedCapacity(lodging.get(10), startDate, endDate);

                    if ((totalPeople + reservedCapacity) <= maxPeople) {
                        results.add(lodging);
                    }
                }
            }
        }
        return results;
    }

    // Auxiliary method to count how many reserved rooms there are of that type in the hotel
    private static int countReservedRooms(String reservationData, String roomType, String startDate, String endDate) {
        if (reservationData.isEmpty()) return 0;
        int reservedCount = 0;
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        String[] reservations = reservationData.split(";");

        for (String reservation : reservations) {
            String[] details = reservation.split(",");
            if (details.length > 8 && details[7].equalsIgnoreCase(roomType)) {
                LocalDate reservationStart = LocalDate.parse(details[3]);
                LocalDate reservationEnd = LocalDate.parse(details[4]);

                if (datesOverlap(start, end, reservationStart, reservationEnd)) {
                    reservedCount++;
                }
            }
        }
        return reservedCount;
    }

    // Auxiliary method to count how many spaces are reserved in the other types of accommodation: Farm Stay, Apartment and Day Resort.
    private static int countReservedCapacity(String reservationData, String startDate, String endDate) {
        if (reservationData.isEmpty()) return 0;
        int totalReserved = 0;
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        String[] reservations = reservationData.split(";");

        for (String reservation : reservations) {
            String[] details = reservation.split(",");
            if (details.length > 6) {
                LocalDate reservationStart = LocalDate.parse(details[3]);
                LocalDate reservationEnd = LocalDate.parse(details[4]);

                if (datesOverlap(start, end, reservationStart, reservationEnd)) {
                    totalReserved += Integer.parseInt(details[5]) + Integer.parseInt(details[6]);
                }
            }
        }
        return totalReserved;
    }

    // Auxiliary method to check if dates cross between reservations
    private static boolean datesOverlap(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return (start1.isBefore(end2) || start1.equals(end2)) && (end1.isAfter(start2) || end1.equals(start2));
    }

    // Method to print the information of the lodgings
    public static void printLodgingInformation(List<String> lodging, String startDate, String endDate, int roomsNeeded) {
        System.out.println("+----------------------------------+");
        System.out.println(lodging.get(0));  // Lodging name
        System.out.println("Calificación: " + lodging.get(3));  // Rating

        float pricePerNight = 0;
        float baseTotalPrice = 0;
        float adjustment = calculateDiscountOrIncrement(startDate, endDate);

        if (lodging.get(2).equalsIgnoreCase("Hotel")) {
            String roomsInfo = lodging.get(7);
            String[] roomTypes = roomsInfo.split(";");
            int lowerPrice = Integer.MAX_VALUE;

            for (String roomType : roomTypes) {
                String[] roomDetails = roomType.split("\\|");
                int roomPrice = Integer.parseInt(roomDetails[2]);
                if (roomPrice < lowerPrice) {
                    lowerPrice = roomPrice;
                }
            }
            pricePerNight = lowerPrice;
            baseTotalPrice = pricePerNight * roomsNeeded * calculateDaysBetween(startDate, endDate);

        } else {
            pricePerNight = Float.parseFloat(lodging.get(4));
            baseTotalPrice = pricePerNight * calculateDaysBetween(startDate, endDate);
        }

        float adjustedTotalPrice = baseTotalPrice + (baseTotalPrice * adjustment);

        System.out.println("Precio por noche: " + pricePerNight);
        System.out.println("Precio base total: " + baseTotalPrice);
        System.out.println("Precio total ajustado: " + adjustedTotalPrice);
        System.out.println("+----------------------------------+\n");
    }

    // Method for calculating increase or discount in price of lodging
    public static float calculateDiscountOrIncrement(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        LocalDate range1Start = LocalDate.of(start.getYear(), start.getMonth(), 5);
        LocalDate range1End = LocalDate.of(start.getYear(), start.getMonth(), 10);
        LocalDate range2Start = LocalDate.of(start.getYear(), start.getMonth(), 10);
        LocalDate range2End = LocalDate.of(start.getYear(), start.getMonth(), 15);
        LocalDate range3Start = LocalDate.of(start.getYear(), start.getMonth(), 26);
        LocalDate range3End = LocalDate.of(start.getYear(), start.getMonth(), 31);

        if ((start.isAfter(range1Start) || start.equals(range1Start)) && (end.isBefore(range1End) || end.equals(range1End))) {
            return -0.08f;
        } else if ((start.isAfter(range2Start) || start.equals(range2Start)) && (end.isBefore(range2End) || end.equals(range2End))) {
            return 0.10f;
        } else if ((start.isAfter(range3Start) || start.equals(range3Start)) && (end.isBefore(range3End) || end.equals(range3End))) {
            return 0.15f;
        }
        return 0;
    }

    // Method for calculating the number of days between two dates
    public static long calculateDaysBetween(String startDate, String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return ChronoUnit.DAYS.between(start, end);
    }

}
