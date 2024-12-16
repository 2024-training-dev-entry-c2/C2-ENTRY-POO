import java.util.Arrays;
import java.util.Scanner;

public class Main {
// - Lodging.java -//


//    static String[] names = {
//            "Hotel Grand Salon", "Villa San Marcos", "Finca el Azul",
//            "Florida Tropical", "Oasis Tropical", "Hotel Globo de oro"
//    };
//    static String[] locations = {
//            "Medellin", "Medellin", "Bogota",
//            "Santa Fe", "Girardota", "Medellin"
//    };
//    static String[] types = {
//            "Hotel", "Apartamento", "Finca",
//            "Dia de Sol", "Dia de Sol", "Hotel"
//    };
//    static double[] ratings = {
//            3.4, 4.3, 4.4,
//            4.0, 4.2, 3.4
//    };
//    static int[] prices = {
//            125, 180, 320,
//            115, 120, 100
//    };
//    static int[] avaliableRooms = {
//            2, 1, 1,
//            1, 1 , 2
//    };
//
//    static String[][] roomDescriptions = {
//            // Para Hotel Grand Salon
//            {"- Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio.\n Precio: $100 por noche",
//                    " - Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha.\n Precio: $125 por noche"},
//
//            // Para Villa San Marcos
//            {" - Habitación familiar con 2 camas matrimoniales, terraza privada, cocina pequeña, baño completo, vista al jardín. Precio: $180 por noche",
//                    " - Habitación King con 3 camas, dos matrimoniales y una individual, terraza privada, cocina pequeña, baño completo, vista al jardín, Jacuzzi. Precio: $280 por noche"},
//
//            // Para Finca el Azul
//            {" - Habitación rústica con 2 camas individuales, ventanas amplias, baño privado, vista a los campos, decoración tradicional. Precio: $320 por noche"},
//
//            // Para Florida Tropical
//            {" - Actividades como Mesas de Ping Pong, Piscina, Canchas de Voley, y Futbol, Juegos de mesa. \nIncluye Almuerzo y Refrigerio. Precio: $115 por dia"},
//
//            // Para Oasis Tropical
//            {" - Actividades como Botes de remo, Lago, Natación, Juegos de Salón, Pesca, Rutas de Bicicleta, Voleibol.\nIncluye Desayuno, Almuerzo, Refrigerio. Precio: $120 por dia"},
//
//            // Para Hotel Globo de oro
//            {"- Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio.\n Precio: $150 por noche",
//                    " - Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha.\n Precio: $100 por noche"},
//    };

    public static void main(String[] args) {
        System.out.println("----------[Bienvenido a Booking Hotel!]---------- \n");
        Scanner scanner = new Scanner(System.in);

        String city, lodgingType;
        int totalAdults, totalKids, totalRooms, startDay, finalDay;


        while(true) {

        System.out.println("Que deseas realizar: \n 1. Mostrar Reservas \n 2. Realizar reserva \n 3. Modificar una reserva\n");
        int menuOptions = Integer.parseInt(scanner.nextLine());

            switch (menuOptions){

                case 1:
                    mostrarReservas();
                    break;
                case 2:
                    System.out.println("Ciudades Disponibles: Medellin, Bogota, Santa Fe, Girardota");
                    System.out.println("------ Ingresa los datos de alojamiento ------");

                    System.out.print("Ciudad: ");
                    city = scanner.nextLine().toLowerCase();

                    System.out.print("Tipo de alojamiento (ej. Hotel, Apartamento, Finca, Dia de Sol): ");
                    lodgingType = scanner.nextLine().toLowerCase();

                    System.out.print("Dia de Inicio: ");
                    startDay = Integer.parseInt(scanner.nextLine());

                    System.out.print("Dia de Final: ");
                    finalDay = Integer.parseInt(scanner.nextLine());

                    System.out.print("Número total de adultos: ");
                    totalAdults = Integer.parseInt(scanner.nextLine());

                    System.out.print("Número total de niños: ");
                    totalKids = Integer.parseInt(scanner.nextLine());

                    System.out.print("Número total de habitaciones: ");
                    totalRooms = Integer.parseInt(scanner.nextLine());

//            System.out.println(Arrays.toString(avaliableRooms));

                    getReservation(city, lodgingType, startDay, finalDay, totalAdults, totalKids, totalRooms);
                    break;
                case 3:

                    updateReservation(scanner);

                    break;

            }

        }
    }

    static String[][] reservationRecords = new String[10][8];
    static int reservationCount = 0;

    // Tercer Punto - Recibir los datos para guardar la reserva como Nombre, apellido etc.


    static void updateReservation(Scanner scanner) {
        if (reservationCount == 0) {
            System.out.println("No hay reservas para actualizar.");
            return;
        }

        // Solicitar el correo electrónico y la fecha de nacimiento para autenticación
        System.out.print("Ingresa tu correo electrónico: ");
        String emailToSearch = scanner.nextLine();

        System.out.print("Ingresa tu fecha de nacimiento (DD/MM/AAAA): ");
        String userBorthDate = scanner.nextLine();

        boolean foundReservation = false;
        int reservationIndex = -1;
        int searchReservation = 0;

        // Buscar la reserva correspondiente
        for (int i = 0; i < reservationCount; i++) {
//            System.out.println("Cual reservacion deseas modificar: ");

            if (reservationRecords[i][3].equalsIgnoreCase(emailToSearch)) {
                foundReservation = true;
                reservationIndex = i;
                break;
            }
        }

        if (!foundReservation) {
            System.out.println("No se encontró ninguna reserva asociada al correo y fecha de nacimiento proporcionados.");
            return;
        }

        // Mostrar los datos de la reserva
        System.out.println("\nReserva encontrada:");
        System.out.println("Alojamiento: " + reservationRecords[reservationIndex][0]);
        System.out.println("Habitación reservada: " + reservationRecords[reservationIndex][7]);
        System.out.println("Nombre: " + reservationRecords[reservationIndex][1] + " " + reservationRecords[reservationIndex][2]);
        System.out.println("Email: " + reservationRecords[reservationIndex][3]);
        System.out.println("Nacionalidad: " + reservationRecords[reservationIndex][4]);
        System.out.println("Teléfono: " + reservationRecords[reservationIndex][5]);
        System.out.println("Hora de llegada: " + reservationRecords[reservationIndex][6]);
        System.out.println("-----------------------------");

        // Preguntar qué desea actualizar
        System.out.println("¿Qué deseas hacer?");
        System.out.println("1. Cambiar habitación");
        System.out.println("2. Eliminar reserva y liberar habitación");

        int updateOption = Integer.parseInt(scanner.nextLine());

        if (updateOption == 1) { // Cambiar habitación
            String alojamientoActual = reservationRecords[reservationIndex][0];

            // Encontrar el índice del alojamiento actual
            int hotelId = -1;
            for (int i = 0; i < Lodging.name.length; i++) {
                if (names[i].equalsIgnoreCase(alojamientoActual)) {
                    hotelId = i;
                    break;
                }
            }

            if (hotelId == -1) {
                System.out.println("Error: Alojamiento no encontrado.");
                return;
            }

            // Crear un arreglo de habitaciones disponibles
            String[] availableRooms = new String[roomDescriptions[hotelId].length];
            int availableRoomCount = 0;

            // Mostrar las habitaciones disponibles en el mismo alojamiento
            System.out.println("Habitaciones disponibles:");
            for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
                if (!roomDescriptions[hotelId][i].equals("Ocupada")) {
                    availableRooms[availableRoomCount] = roomDescriptions[hotelId][i];
                    System.out.println((availableRoomCount + 1) + ". " + availableRooms[availableRoomCount]);
                    availableRoomCount++;
                }
            }

            if (availableRoomCount == 0) {
                System.out.println("No hay habitaciones disponibles.");
                return;
            }

            // Pedir al usuario que seleccione una nueva habitación
            System.out.print("Selecciona el número de la nueva habitación: ");
            int selectedRoomIndex = Integer.parseInt(scanner.nextLine()) - 1;

            if (selectedRoomIndex < 0 || selectedRoomIndex >= availableRoomCount) {
                System.out.println("Selección inválida.");
                return;
            }

            String newRoom = availableRooms[selectedRoomIndex];

            // Verificar disponibilidad y realizar el cambio
//            for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
//                if (roomDescriptions[hotelId][i].equals(newRoom)) {
//                    // Liberar la habitación actual
//                    for (int j = 0; j < roomDescriptions[hotelId].length; j++) {
//                        if (roomDescriptions[hotelId][j].equals("Ocupada")) {
//                            // Restablecer la descripción original de la habitación
//                            roomDescriptions[hotelId][j] = reservationRecords[reservationIndex][7];
//                            avaliableRooms[hotelId]++;
//                            break;
//                        }
//                    }
//
//                    // Marcar nueva habitación como ocupada
//                    roomDescriptions[hotelId][i] = "Ocupada";
//                    avaliableRooms[hotelId]--;
//
//                    // Actualizar la reserva con la nueva habitación
//                    reservationRecords[reservationIndex][7] = newRoom;
//                    System.out.println("Habitación cambiada exitosamente.");
//                    return;
//                }
//            }
//            System.out.println("La habitación seleccionada no está disponible.");
//
//        } else if (updateOption == 2) { // Eliminar reserva y liberar habitación
//            // Encontrar el índice del alojamiento actual
//            int hotelId = -1;
//            for (int i = 0; i < names.length; i++) {
//                if (names[i].equalsIgnoreCase(reservationRecords[reservationIndex][0])) {
//                    hotelId = i;
//                    break;
//                }
//            }
//
//            if (hotelId == -1) {
//                System.out.println("Error: Alojamiento no encontrado.");
//                return;
//            }
//
//            // Liberar la habitación
//            for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
//                if (roomDescriptions[hotelId][i].equals("Ocupada")) {
//                    // Restaurar la descripción original de la habitación
//                    roomDescriptions[hotelId][i] = reservationRecords[reservationIndex][7];
//                    avaliableRooms[hotelId]++;
//                    break;
//                }
//            }

            // Eliminar la reserva moviendo los registros
            for (int i = reservationIndex; i < reservationCount - 1; i++) {
                reservationRecords[i] = reservationRecords[i + 1];
            }
            reservationCount--;

            System.out.println("Reserva eliminada. La habitación ha sido liberada.");
        } else {
            System.out.println("Opción no válida.");
        }
    }


    static void generateReservation(String selectedLodging, int startDay, int finalDay, int totalAdults, int totalKids, int totalRooms, String selectedRoom, int hotelId, int[] avaliableRooms){
        String userName,  userLastName,  userEmail,  userNationality,  userPhoneNumber, userArrivalTime;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Datos Finales para la Reservacion");

        System.out.print("Nombre de la persona que reserva: ");
        userName = scanner.nextLine();

        System.out.print("Apellido de la perosna que reserva: ");
        userLastName = scanner.nextLine();

        System.out.print("Correo Electronico: ");
        userEmail = scanner.nextLine();

        System.out.print("Nacionalidad: ");
        userNationality = scanner.nextLine();

        System.out.print("Numero de Telefono: ");
        userPhoneNumber = scanner.nextLine();

        System.out.print("Hora de llegada: ");
        userArrivalTime = scanner.nextLine();
        System.out.println(avaliableRooms[hotelId]);

        reservationRecords[reservationCount][0] = selectedLodging;
        reservationRecords[reservationCount][1] = userName;
        reservationRecords[reservationCount][2] = userLastName;
        reservationRecords[reservationCount][3] = userEmail;
        reservationRecords[reservationCount][4] = userNationality;
        reservationRecords[reservationCount][5] = userPhoneNumber;
        reservationRecords[reservationCount][6] = userArrivalTime;
        reservationRecords[reservationCount][7] = selectedRoom;

        reservationCount++;

        System.out.println("Se ha realizado la reserva con exito!");

//        mostrarReservas();
    }



    static void mostrarReservas() {
        System.out.println("\n----- REGISTRO DE RESERVAS -----");
        for (int i = 0; i < reservationCount; i++) {
            System.out.println("Reserva " + (i + 1) + ":");
            System.out.println("Alojamiento: " + reservationRecords[i][0]);
            System.out.println("Habitación reservada: " + reservationRecords[i][7]);
            System.out.println("Nombre: " + reservationRecords[i][1] + " " + reservationRecords[i][2]);
            System.out.println("Email: " + reservationRecords[i][3]);
            System.out.println("Nacionalidad: " + reservationRecords[i][4]);
            System.out.println("Teléfono: " + reservationRecords[i][5]);
            System.out.println("Hora de llegada: " + reservationRecords[i][6]);
            System.out.println("-----------------------------");
            System.out.println(Arrays.toString(avaliableRooms));
        }
    }

// Segundo punto - Reciba los datos del alojamiento donde se va a hacer la reserva
static void getAvaliableRooms(String selectedLodging, int startDay, int finalDay,
                              int totalAdults, int totalKids, int totalRooms,
                              String[][] roomDescriptions, int hotelId,
                              int[] avaliableRooms) {

    if (totalRooms > avaliableRooms[hotelId] || totalRooms <= 0) {
        System.out.println("No hay habitaciones suficientes disponibles");
        System.out.println(totalRooms + " TOTAL ROOMS");

        System.out.println(avaliableRooms[hotelId] + " AVALIABLE ROOMS AND HOTEL ID");
        return;
    }



    System.out.println("-------[ Detalles de la reserva: ]-------");
    System.out.println("Alojamiento seleccionado: " + selectedLodging);
    System.out.println("Día de inicio: " + startDay);
    System.out.println("Día final: " + finalDay);
    System.out.println("Total de adultos: " + totalAdults);
    System.out.println("Total de niños: " + totalKids);
    System.out.println("Total de habitaciones: " + totalRooms);
    System.out.println("----------------------------");
    System.out.println("Habitaciones disponibles: " + avaliableRooms[hotelId] + "\n-----------------------------");

    // Crear un nuevo arreglo temporal para mostrar solo las habitaciones disponibles
    String[] roomsToShow = new String[roomDescriptions[hotelId].length];
    int roomsToShowCount = 0;

    // Copiar solo las habitaciones disponibles
    for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
        if (!roomDescriptions[hotelId][i].equals("Ocupada")) {
            roomsToShow[roomsToShowCount] = roomDescriptions[hotelId][i];
            roomsToShowCount++;
        }
    }

    // Mostrar las habitaciones disponibles
    for (int i = 0; i < roomsToShowCount; i++) {
        System.out.println((i + 1) + ". " + roomsToShow[i]);
    }
    System.out.println("+-----------------------------+");

    Scanner scanner = new Scanner(System.in);

    System.out.println("Selecciona una opción para el " + selectedLodging + ":");
    int selectedLodgingRoom = scanner.nextInt();
    scanner.nextLine(); // Consumir salto de línea

    // Ajustar la lógica de selección para el nuevo arreglo de habitaciones disponibles
    if (selectedLodgingRoom >= 1 && selectedLodgingRoom <= roomsToShowCount) {
        System.out.println("--------------------------------------");
        System.out.println("\nHas elegido la habitación número " + selectedLodgingRoom + ":");
        System.out.println("--------------------------------------");
        System.out.println(roomsToShow[selectedLodgingRoom - 1]);
        System.out.println("¿Deseas continuar con la reserva? (si/no)");
        String continueWithLodging = scanner.nextLine();

        if (continueWithLodging.equalsIgnoreCase("si")) {
            // Actualizar la habitación seleccionada como ocupada
            for (int i = 0; i < roomDescriptions[hotelId].length; i++) {
                if (roomDescriptions[hotelId][i].equals(roomsToShow[selectedLodgingRoom - 1])) {
                    roomDescriptions[hotelId][i] = "Ocupada";
                    break;
                }
            }

            // Reducir el conteo de habitaciones disponibles
            avaliableRooms[hotelId]--;

            generateReservation(selectedLodging, startDay, finalDay,
                    totalAdults, totalKids, totalRooms,
                    roomsToShow[selectedLodgingRoom - 1],
                    hotelId, avaliableRooms);
        } else {
            System.out.println("Reserva cancelada.");
        }
    } else {
        System.out.println("La habitación que has elegido no está disponible.");
    }
}


    // Primer Punto - Metodo que reciba los parametros
    static void getReservation(String city, String lodgingType, int startDay, int finalDay,
                               int totalAdults, int totalKids, int totalRooms ) {
        Scanner scanner = new Scanner(System.in);

        //  para rastrear si se encontró alojamiento
        boolean foundLodging = false;
        //

        double finalPrice = 0;

        // Buscar alojamientos que coincidan

        int totalDays = finalDay - startDay;
        for (int i = 0; i < names.length; i++) {

            if (totalDays <= 0 || startDay < 1 || finalDay > 31) {
                System.out.println("Error: Fecha invalida, volviendo a inicio.");
                foundLodging = false;
                return;
            } else{

            // Verificar coincidencia de ciudad y tipo de alojamiento
            if (locations[i].equalsIgnoreCase(city) && types[i].equalsIgnoreCase(lodgingType)) {
                System.out.println("Alojamientos disponibles:");


                System.out.println("-----[ Alojamiento disponible en " + city + " ]-----");
                System.out.println("| Nombre: " + names[i]);
                System.out.println("| Tipo de Alojamiento: " + types[i]);
                System.out.println("| Ciudad: " + city);
                System.out.println("| Rating: " + ratings[i]);
                System.out.println("| Precio por Estadia: $" + prices[i]);

                // Calcular costo base


                int basePrice = prices[i] * totalDays;
                finalPrice = basePrice;

                // Incrementar 15% si la reserva está en los últimos 5 días del mes
                if (startDay >= 27 && finalDay <= 31) {
                    finalPrice += basePrice * 0.15;
                    System.out.println("| Incremento del 15% por reserva al final del mes.");
                }else if (startDay >= 10 && finalDay <= 15) {
                    finalPrice += basePrice * 0.10;
                    System.out.println("| Incremento del 10% por incluir días del 10 al 15.");
                }else if (startDay >= 5 && finalDay <= 10) {
                    finalPrice -= basePrice * 0.08;
                    System.out.println("| Descuento del 8% por incluir días del 5 al 10.");
                }

                System.out.printf("| Precio final: $%.2f%n", finalPrice);
                System.out.println("-----");
                foundLodging = true;
            }
            }

        }
        // Si no se encontraron alojamientos
        if (!foundLodging) {
            System.out.println("No se encontraron alojamientos que coincidan con los criterios.");
            return;
        }

        // Preguntar sobre reserva
        System.out.println("\n¿Deseas hacer una reservación? (si/no)");
        String answer = scanner.nextLine().toLowerCase();

        if (answer.equals("si")) {
            System.out.println("Escribe el nombre exacto del alojamiento:");
            String selectedLodging = scanner.nextLine().toLowerCase();

            // Verificar si el alojamiento existe
            boolean validLodging = false;
            for (int i = 0; i < names.length; i++) {
                if (names[i].equalsIgnoreCase(selectedLodging)) {
                    int hotelId = i;
                    // Llamamos al metodo getAvaliableRooms
                    getAvaliableRooms(selectedLodging, startDay, finalDay,
                            totalAdults, totalKids, totalRooms, roomDescriptions, hotelId, avaliableRooms);
                    validLodging = true;
                    break;
                }
            }

            if (!validLodging) {
                System.out.println("Alojamiento no válido.");
            }
        } else {
            System.out.println("Volviendo al inicio");
        }
    }

}

