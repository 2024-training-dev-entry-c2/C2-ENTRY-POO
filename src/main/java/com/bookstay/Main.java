package com.bookstay;

import com.bookstay.models.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    //Global variables
    static List<Lodging> lodgings = new ArrayList<>();

    public static void main(String[] args) {
        initializeData();
        showMenu();
    }

    /* ############################### INITIALIZE DATA ############################### */
    public static void initializeData() {
        // Hotels
        Hotel hotel1 = new Hotel("Hotel Mar Azul", "Cartagena", 4.9, "Hotel frente al mar con excelentes comodidades");
        hotel1.addRoom("Habitación Estándar", "La habitación estándar cuenta con 1 cama queen, aire acondicionado, minibar, baño privado y TV de pantalla plana.", 200000.0, 2, 8);
        hotel1.addRoom("Suite Familiar", "Amplia suite con 2 habitaciones, sala de estar y balcón con vista al mar.", 500000.0, 4, 5);
        hotel1.addRoom("Suite Premium", "Suite de lujo con jacuzzi, cama king size y minibar gratuito.", 750000.0, 2, 3);
        hotel1.addRoom("Habitación Económica", "Habitación compacta con todas las comodidades básicas.", 150000.0, 2, 10);
        hotel1.addRoom("Habitación Doble Deluxe", "Habitación espaciosa con 2 camas dobles y escritorio de trabajo.", 300000.0, 4, 6);
        lodgings.add(hotel1);

        Hotel hotel2 = new Hotel("Hotel Vista Sierra", "Medellín", 4.8, "Hotel moderno en la zona alta de Medellín con vistas a la ciudad");
        hotel2.addRoom("Habitación Estándar", "Habitación cómoda con decoración contemporánea.", 180000.0, 2, 10);
        hotel2.addRoom("Suite Ejecutiva", "Suite con escritorio, mini sala y acceso a gimnasio privado.", 400000.0, 2, 5);
        hotel2.addRoom("Suite Presidencial", "La habitación más exclusiva del hotel con spa privado.", 900000.0, 2, 2);
        hotel2.addRoom("Habitación Doble", "Habitación con 2 camas individuales y baño compartido.", 160000.0, 2, 7);
        hotel2.addRoom("Habitación Junior Suite", "Habitación intermedia con balcón y vista panorámica.", 350000.0, 3, 4);
        lodgings.add(hotel2);

        Hotel hotel3 = new Hotel("Hotel Central Park", "Bogotá", 4.6, "Hotel en el corazón financiero de Bogotá");
        hotel3.addRoom("Habitación Individual", "Habitación ideal para viajeros de negocios.", 220000.0, 1, 15);
        hotel3.addRoom("Habitación Doble", "Habitación elegante con 2 camas y baño privado.", 300000.0, 2, 10);
        hotel3.addRoom("Suite Lujo", "Suite con servicios de oficina y sala de reuniones.", 600000.0, 4, 5);
        hotel3.addRoom("Habitación Premium", "Confort y espacio con servicio a la habitación incluido.", 400000.0, 2, 8);
        hotel3.addRoom("Habitación Económica", "Espacio compacto con desayuno incluido.", 180000.0, 2, 12);
        lodgings.add(hotel3);

        Hotel hotel4 = new Hotel("Hotel Paraíso Natural", "Santa Marta", 5.0, "Hotel boutique ecológico junto a la playa Tayrona");
        hotel4.addRoom("Cabaña Estándar", "Cabaña con techo de palma y decoración natural.", 250000.0, 2, 6);
        hotel4.addRoom("Cabaña Familiar", "Amplia cabaña para grupos familiares.", 500000.0, 6, 4);
        hotel4.addRoom("Suite de Lujo", "Suite con vistas inigualables al océano.", 800000.0, 2, 3);
        hotel4.addRoom("Habitación Deluxe", "Habitación con terraza privada y hamaca.", 350000.0, 2, 8);
        hotel4.addRoom("Cabaña Eco", "Cabaña rústica con paneles solares.", 200000.0, 2, 5);
        lodgings.add(hotel4);

        Hotel hotel5 = new Hotel("Hotel Real Colonial", "Villa de Leyva", 4.7, "Hotel de arquitectura colonial con encanto histórico");
        hotel5.addRoom("Habitación Colonial", "Habitación con decoración antigua y balcón.", 280000.0, 2, 8);
        hotel5.addRoom("Suite Colonial", "Suite con chimenea y sala de estar privada.", 550000.0, 4, 5);
        hotel5.addRoom("Habitación Doble Colonial", "Amplia habitación con 2 camas dobles.", 350000.0, 4, 6);
        hotel5.addRoom("Habitación Individual", "Ideal para una persona, cómoda y funcional.", 200000.0, 1, 10);
        hotel5.addRoom("Habitación Familiar", "Habitación amplia para familias pequeñas.", 400000.0, 4, 7);
        lodgings.add(hotel5);

        // Apartments
        Apartment apartment1 = new Apartment("Apartamento Playa", "Cartagena", 4.7, "Apartamento moderno con vista al océano, 3 habitaciones, 2 baños.", 5, 500000.0);
        Apartment apartment2 = new Apartment("Apartamento Loft Centro", "Bogotá", 4.5, "Loft espacioso ubicado en el centro de la ciudad, ideal para negocios.", 2, 300000.0);
        Apartment apartment3 = new Apartment("Apartamento Familiar Medellín", "Medellín", 4.6, "Apartamento amplio para familias con zona de juegos.", 6, 400000.0);
        Apartment apartment4 = new Apartment("Penthouse Vista Mar", "Santa Marta", 4.9, "Penthouse de lujo con jacuzzi privado y vista al mar.", 4, 800000.0);
        Apartment apartment5 = new Apartment("Apartamento Colonial Centro", "Villa de Leyva", 4.8, "Apartamento de estilo colonial con patio interior.", 3, 350000.0);

        lodgings.add(apartment1);
        lodgings.add(apartment2);
        lodgings.add(apartment3);
        lodgings.add(apartment4);
        lodgings.add(apartment5);


        // Farm Stays
        FarmStay farmStay1 = new FarmStay("Finca El Bosque", "Armenia", 4.8, "Finca tranquila rodeada de bosque", 10, 800000.0);
        FarmStay farmStay2 = new FarmStay("Finca El Lago", "Guatapé", 4.9, "Finca con lago privado y zona de pesca.", 8, 900000.0);
        FarmStay farmStay3 = new FarmStay("Finca Montaña Viva", "Manizales", 4.7, "Finca en la montaña con vistas espectaculares.", 12, 1000000.0);
        FarmStay farmStay4 = new FarmStay("Finca Las Palmeras", "Cali", 4.6, "Finca con piscina y zona BBQ.", 15, 950000.0);
        FarmStay farmStay5 = new FarmStay("Finca El Refugio", "Pereira", 4.8, "Finca rodeada de naturaleza y tranquilidad.", 10, 850000.0);

        lodgings.add(farmStay1);
        lodgings.add(farmStay2);
        lodgings.add(farmStay3);
        lodgings.add(farmStay4);
        lodgings.add(farmStay5);

        // Day Resorts
        DayResort dayResort1 = new DayResort("Día de Sol Caribe", "San Andrés", 5.0, "Disfruta del sol, playa y actividades acuáticas", 200000.0);
        dayResort1.addActivity("Snorkeling");
        dayResort1.addActivity("Paseos en bote");
        dayResort1.addMeal("Almuerzo con platos típicos");
        dayResort1.addMeal("Cena a la carta");
        lodgings.add(dayResort1);


        DayResort dayResort2 = new DayResort("Aventura en la Sierra", "Sierra Nevada", 4.8, "Naturaleza y actividades extremas", 250000.0);
        dayResort2.addActivity("Escalada");
        dayResort2.addActivity("Senderismo");
        dayResort2.addMeal("Almuerzo campestre");
        lodgings.add(dayResort2);

        DayResort dayResort3 = new DayResort("Día Relax Spa", "Bogotá", 4.7, "Spa urbano con tratamientos relajantes", 180000.0);
        dayResort3.addActivity("Masaje relajante");
        dayResort3.addActivity("Piscina climatizada");
        dayResort3.addMeal("Té y snacks saludables");
        lodgings.add(dayResort3);

        DayResort dayResort4 = new DayResort("Parque Aventura", "Medellín", 4.6, "Diversión familiar con actividades recreativas", 220000.0);
        dayResort4.addActivity("Tirolesa");
        dayResort4.addActivity("Paseos en cuatrimoto");
        dayResort4.addMeal("Parrillada familiar");
        lodgings.add(dayResort4);

        DayResort dayResort5 = new DayResort("Resort Lago Azul", "Guatapé", 4.9, "Día de relajación junto al lago", 200000.0);
        dayResort5.addActivity("Kayak");
        dayResort5.addActivity("Paseos en lancha");
        dayResort5.addMeal("Almuerzo buffet");
        lodgings.add(dayResort5);
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
            System.out.println("\n*----------------------- Menú -----------------------*");
            System.out.println("| 1. Buscar y reservar alojamiento.                  | ");
            System.out.println("| 2. Consultar reservaciones realizadas.             | ");
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
                    if(category.equalsIgnoreCase("Día de Sol")){
                        System.out.println("Escribe el día de la estadía (YYYY-MM-dd): ");
                    }else{
                        System.out.println("Escribe el día inicial de la estadía (YYYY-MM-dd): ");
                    }
                    String startDay = input.nextLine();
                    LocalDate startDate = LocalDate.parse( startDay );
                    String endDay;
                    if(category.equalsIgnoreCase("Día de Sol")){
                        endDay = startDay;
                    }else{
                        System.out.println("Escribe el día final de la estadía (YYYY-MM-dd): ");
                        endDay = input.nextLine();
                    }
                    LocalDate endDate = LocalDate.parse( endDay );

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

                    List<Lodging> results = searchLodgings(city, category, startDate , endDate, adults, children, roomsRequired);
                    if(results.isEmpty()){
                        System.out.println("\nNo se han encontrado resultados a la búsqueda.");
                        System.out.println("Serás redirigido(a) al menú principal. Espera un momento...");
                        break;
                    }
                    System.out.println("\nLos resultados obtenidos en la búsqueda son: \n");
                    for(Lodging result : results){
                        printLodgingInformation(result, startDate, endDate, roomsRequired, adults, children);
                    }

                    System.out.println("\n¿Deseas hacer una reservación? (Si - No)");
                    String response = input.nextLine();

                    if(response.equalsIgnoreCase("Si")){
                        System.out.println("\n*------------------ Iniciar la Reservación --------------*");
                        System.out.println("Escribe el nombre del alojamiento en que deseas realizar la reserva: ");
                        String lodgingName = input.nextLine();
                        //List<String> availableRooms = confirmLodging(lodgingName, startDay, endDay, adults , children, roomsRequired);
                        List<String> selectedRooms = new ArrayList<>();

                        /*if (!availableRooms.isEmpty()) {
                            System.out.println("\nSelecciona cuántas habitaciones deseas reservar para cada tipo:\n");
                            int countSelectedRooms = 0;
                            for (String room : availableRooms) {
                                if(countSelectedRooms < roomsRequired){
                                    System.out.print("¿Cuántas '" + room + "' deseas reservar?: ");
                                    int count = input.nextInt();
                                    input.nextLine();
                                    if(countSelectedRooms + count > roomsRequired){
                                        System.out.println("\nHas seleccionado más habitaciones de las requeridas, se ajustará a lo establecido.");
                                        int countAdjusted = roomsRequired - countSelectedRooms;
                                        selectedRooms.add(room + " x" + countAdjusted);
                                    }else{
                                        selectedRooms.add(room + " x" + count);
                                        countSelectedRooms += count;
                                    }
                                }else{
                                    break;
                                }
                            }

                            System.out.println("\nHabitaciones seleccionadas: " + selectedRooms);
                        } else {
                            if(category.equalsIgnoreCase("Hotel")){

                                System.out.println("\nNo hay habitaciones disponibles en este hotel.");
                            }
                        }*/
                        System.out.println("\n¿Confirmas la selección? (Si - No): ");
                        String selection = input.nextLine();
                        if(selection.equalsIgnoreCase("Si")){
                            System.out.println("\n*----- Datos personales de la Reservación -----*");
                            System.out.println("Nombre: ");
                            String firstName = input.nextLine();
                            System.out.println("Apellido: ");
                            String lastName = input.nextLine();
                            System.out.println("Fecha de nacimiento (YYYY-MM-dd): ");
                            String dayBirth = input.nextLine();
                            System.out.println("Correo electrónico: ");
                            String email = input.nextLine();
                            System.out.println("Nacionalidad: ");
                            String nationality = input.nextLine();
                            System.out.println("Número de teléfono: ");
                            String phoneNumber = input.nextLine();
                            System.out.println("Hora de llegada (HH:mm): ");
                            String arrivalTime = input.nextLine();

                            //String reservationMessage = makeReservation(firstName, lastName, email, nationality, phoneNumber, arrivalTime, lodgingName, startDay, endDay, adults, children, selectedRooms, dayBirth);
                            //System.out.println(reservationMessage);
                        }else{
                            System.out.println("\nProceso de reserva cancelado.");
                            System.out.println("Serás redirigido(a) al menú principal. Espera un momento...");
                        }

                    }else{
                        System.out.println("\nSerás redirigido(a) al menú principal. Espera un momento...");
                    }
                    break;
                case 2:
                    System.out.println("\n*------------------- Consultar Reservaciones ---------------*");
                    System.out.println("Ingresa tu correo electrónico: ");
                    String email = input.nextLine();
                    System.out.println("Ingresa tu fecha de nacimiento (YYYY-MM-dd): ");
                    String dayBirth = input.nextLine();

                    //String reservationInfo = consultReservations(email, dayBirth);
                    //System.out.println(reservationInfo);
                    break;
                case 3:
                    System.out.println("\n*-------------------- Modificar Reservación ----------------*");
                    System.out.println("Ingresa tu correo electrónico: ");
                    String modEmail = input.nextLine();
                    System.out.println("Ingresa tu fecha de nacimiento (YYYY-MM-dd): ");
                    String modDayBirth = input.nextLine();

                    //modifyReservation(modEmail, modDayBirth);
                    break;
                case 0:
                    System.out.println("\n¡Gracias por usar nuestros servicios!\n");
                    return;
                default:
                    System.out.println("\nOpción no válida, rectifica el menú.");
                    break;
            }
        }


    }

    /* ################################# SEARCH DATA ################################# */
    public static List<Lodging> searchLodgings(String city, String category, LocalDate startDate, LocalDate endDate, int adults, int children, int requiredRooms) {
        List<Lodging> results = new ArrayList<>();
        int totalPeople = adults + children;

        for (Lodging lodging : lodgings) {
            if (lodging instanceof Hotel && category.equalsIgnoreCase("Hotel")) {
                Hotel hotel = (Hotel) lodging;
                if (hotel.getCity().equalsIgnoreCase(city) &&
                        hotel.isAvailable(startDate, endDate, totalPeople, requiredRooms)) {
                    results.add(hotel);
                }
            } else if (lodging.getCity().equalsIgnoreCase(city) &&
                    lodging.getCategory().equalsIgnoreCase(category) &&
                    lodging.isAvailable(startDate, endDate, totalPeople)) {
                results.add(lodging);
            }
        }
        return results;
    }



    // Method to print the information of the lodgings
    public static void printLodgingInformation(Lodging lodging, LocalDate startDate, LocalDate endDate, int adults, int children, int roomsNeeded) {
        lodging.printDetails(startDate, endDate, adults, children, roomsNeeded);
        System.out.println("+------------------------------------+\n");
    }



    // Method for calculating the number of days between two dates
    public static int calculateDaysBetween(LocalDate startDate, LocalDate endDate) {
        long days = ChronoUnit.DAYS.between(startDate, endDate);

        return (days == 0) ? 1 : (int) days;
    }

    /* ################################# CONFIRM DATA ################################# */
    /*
    public static List<String> confirmLodging(String lodgingName, String startDate, String endDate, int adults, int children, int roomsNeeded) {
        for (List<String> lodging : lodgings) {
            if (lodging.get(0).equalsIgnoreCase(lodgingName)) {
                if (lodging.get(2).equalsIgnoreCase("Hotel")) {
                    String roomsInfo = lodging.get(7);
                    String[] roomTypes = roomsInfo.split(";");
                    List<String> availableRooms = new ArrayList<>();

                    for (String roomType : roomTypes) {
                        String[] roomDetails = roomType.split("\\|");
                        int reservedRooms = countReservedRooms(lodging.get(10), roomDetails[0], startDate, endDate);
                        int availableRoomsCount = Integer.parseInt(roomDetails[5]) - reservedRooms;

                        if (availableRoomsCount > 0) {
                            System.out.println("- Nombre: " + roomDetails[0]);
                            System.out.println("  Descripción: " + roomDetails[1]);
                            System.out.println("  Habitaciones disponibles: " + availableRoomsCount);
                            availableRooms.add(roomDetails[0]);
                        }
                    }
                    return availableRooms;
                } else if (lodging.get(2).equalsIgnoreCase("Día de sol")) {
                    System.out.println("Descripción: " + lodging.get(5));
                    System.out.println("Actividades: " + lodging.get(8));
                    System.out.println("Comidas: " + lodging.get(9));
                } else {
                    System.out.println("Descripción: " + lodging.get(5));
                }
            }
        }
        return new ArrayList<>();
    }
    */
    /* ################################# MAKE RESERVATION ################################# */
    /*
    public static String makeReservation(String firstName, String lastName, String email, String nationality, String phoneNumber, String arrivalTime, String lodgingName, String startDate, String endDate, int adults, int children, List<String> selectedRooms, String dayBirth) {
        for (List<String> lodging : lodgings) {
            if (lodging.get(0).equalsIgnoreCase(lodgingName)) {
                StringBuilder reservationData = new StringBuilder(lodging.get(10));
                for (String room : selectedRooms) {
                    reservationData.append(firstName).append(",").append(lastName).append(",").append(email).append(",").append(startDate).append(",").append(endDate)
                            .append(",").append(adults).append(",").append(children).append(",").append(room).append(";");
                }
                lodging.set(10, reservationData.toString());
                reservations.add(Arrays.asList(firstName, lastName, email, nationality, phoneNumber, arrivalTime, lodgingName, startDate, endDate, String.valueOf(adults), String.valueOf(children), selectedRooms.toString(), dayBirth));
                return "Se ha realizado la reserva con éxito.";
            }
        }
        return "No se pudo realizar la reserva. El alojamiento no está disponible.";
    }

    //Method to consult the reservations
    public static String consultReservations(String email, String dayBirth) {
        StringBuilder result = new StringBuilder();
        boolean found = false;

        for (List<String> reservation : reservations) {
            if (reservation.get(2).equalsIgnoreCase(email) && reservation.get(12).equalsIgnoreCase(dayBirth)) {
                found = true;

                String lodgingName = reservation.get(6);
                String lodgingCategory = getLodgingCategory(lodgingName);

                result.append("\n*---------------- Detalles de la Reservación ----------------*\n")
                        .append("Nombre: ").append(reservation.get(0)).append(" ").append(reservation.get(1)).append("\n")
                        .append("Correo: ").append(reservation.get(2)).append("\n")
                        .append("Alojamiento: ").append(lodgingName).append("\n")
                        .append("Categoría: ").append(lodgingCategory).append("\n")
                        .append("Fecha de llegada: ").append(reservation.get(7)).append("\n")
                        .append("Fecha de salida: ").append(reservation.get(8)).append("\n");

                if (lodgingCategory.equalsIgnoreCase("Hotel")) {
                    result.append("Habitaciones reservadas: ").append(reservation.get(11)).append("\n");
                }

                result.append("Hora de llegada: ").append(reservation.get(5)).append("\n")
                        .append("Nacionalidad: ").append(reservation.get(3)).append("\n")
                        .append("Teléfono: ").append(reservation.get(4)).append("\n");
            }
        }

        if (!found) {
            return "No se encontraron reservaciones con los datos proporcionados.";
        }

        return result.toString();
    }

    // Auxiliary method for obtaining the category of a lodging by name
    private static String getLodgingCategory(String lodgingName) {
        for (List<String> lodging : lodgings) {
            if (lodging.get(0).equalsIgnoreCase(lodgingName)) {
                return lodging.get(2); // Índice de la categoría
            }
        }
        return "Desconocida"; // Si no se encuentra
    }
    */
    /* ################################# MODIFY RESERVATION ################################# */
    /*
    public static void modifyReservation(String email, String dayBirth) {
        Scanner input = new Scanner(System.in);
        boolean found = false;

        for (List<String> reservation : reservations) {
            if (reservation.get(2).equalsIgnoreCase(email) && reservation.get(12).equalsIgnoreCase(dayBirth)) {
                found = true;

                String lodgingName = reservation.get(6);
                String lodgingCategory = getLodgingCategory(lodgingName);

                System.out.println("\n*---------------- Detalles de la Reservación ----------------*\n");
                System.out.println("Alojamiento actual: " + lodgingName);
                System.out.println("Categoría: " + lodgingCategory);

                if (lodgingCategory.equalsIgnoreCase("Hotel")) {
                    System.out.println("Habitaciones reservadas: " + reservation.get(11));
                }

                System.out.println("\n¿Qué deseas modificar?");

                if (lodgingCategory.equalsIgnoreCase("Hotel")) {
                    System.out.println("1: Cambio de habitación");
                }
                System.out.println("2: Cambio de alojamiento");

                int choice = input.nextInt();
                input.nextLine();

                if (choice == 1 && lodgingCategory.equalsIgnoreCase("Hotel")) {
                    System.out.println("\nHabitaciones actuales: " + reservation.get(11));
                    System.out.println("Indica el tipo y la cantidad de habitación(es) que deseas cambiar (ejemplo: 'Habitación Estándar x1'): ");
                    String oldRoomEntry = input.nextLine();

                    String[] oldRoomDetails = oldRoomEntry.split(" x");
                    String oldRoomType = oldRoomDetails[0].trim();
                    int quantityToChange = Integer.parseInt(oldRoomDetails[1]);

                    String currentRooms = reservation.get(11);
                    int currentCount = getRoomCount(currentRooms, oldRoomType);

                    if (quantityToChange > currentCount) {
                        System.out.println("Error: No tienes suficientes habitaciones de este tipo reservadas para cambiar.");
                        return;
                    }

                    for (List<String> lodging : lodgings) {
                        if (lodging.get(0).equalsIgnoreCase(lodgingName)) {
                            System.out.println("Habitaciones disponibles:");
                            String[] roomDetails = lodging.get(7).split(";");
                            for (String room : roomDetails) {
                                String[] details = room.split("\\|");
                                System.out.println("- " + details[0] + " (Capacidad: " + details[3] + " adultos, " + details[4] + " niños)");
                            }

                            System.out.println("Selecciona la nueva habitación (ejemplo: 'Habitación Deluxe'): ");
                            String newRoomType = input.nextLine();

                            // Update reserved rooms
                            String updatedRooms = updateRoomEntry(currentRooms, oldRoomType, newRoomType, quantityToChange);
                            reservation.set(11, updatedRooms);

                            System.out.println("\nHabitaciones actualizadas con éxito.\n Nuevas habitaciones reservadas: " + updatedRooms);
                            return;
                        }
                    }
                } else if (choice == 2) {
                    reservations.remove(reservation);
                    System.out.println("\nReservación eliminada. Por favor, crea una nueva reservación.");
                    return;
                } else {
                    System.out.println("\nOpción no válida o no aplicable para esta categoría.");
                }
            }
        }

        if (!found) {
            System.out.println("No se encontró ninguna reservación con los datos proporcionados.");
        }
    }

    // Auxiliary method for counting rooms of a specific type
    private static int getRoomCount(String currentRooms, String roomType) {
        currentRooms = currentRooms.replace("[", "").replace("]", "").trim();
        String[] roomEntries = currentRooms.split(", ");
        for (String entry : roomEntries) {
            if (entry.startsWith(roomType)) {
                String[] parts = entry.split(" x");
                return Integer.parseInt(parts[1]);
            }
        }
        return 0;
    }


    // Auxiliary method for updating reserved rooms
    private static String updateRoomEntry(String currentRooms, String oldRoomType, String newRoomType, int quantityToChange) {
        StringBuilder updatedRooms = new StringBuilder();
        currentRooms = currentRooms.replace("[", "").replace("]", "").trim();
        String[] roomEntries = currentRooms.split(", ");

        for (String entry : roomEntries) {
            if (entry.startsWith(oldRoomType)) {
                String[] parts = entry.split(" x");
                int currentCount = Integer.parseInt(parts[1]);
                int remainingCount = currentCount - quantityToChange;

                if (remainingCount > 0) {
                    updatedRooms.append(oldRoomType).append(" x").append(remainingCount).append(", ");
                }
                updatedRooms.append(newRoomType).append(" x").append(quantityToChange).append(", ");
            } else {
                updatedRooms.append(entry).append(", ");
            }
        }

        if (updatedRooms.length() > 0) {
            updatedRooms.setLength(updatedRooms.length() - 2);
        }

        return "[" + updatedRooms.toString() + "]";
    }
    */
}

