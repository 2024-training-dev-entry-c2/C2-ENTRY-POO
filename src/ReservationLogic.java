import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class ReservationLogic {
    private Reservation[] reservations;
    private int reservationCount;
    private Lodging[] availableLodgings;

    // Constructor
    public ReservationLogic() {
        reservations = new Reservation[10];
        reservationCount = 0;

        // Inicializar alojamientos
        initializeLodgings();
    }

    // Metodo para inicializar alojamientos
    private void initializeLodgings() {
        availableLodgings = new Lodging[6];

        // Nombres de hoteles originales
        String[] names = {
                "Hotel Grand Salon", "Villa San Marcos", "Finca el Azul",
                "Florida Tropical", "Oasis Tropical", "Hotel Globo de oro"
        };

        String[] locations = {
                "Medellin", "Medellin", "Bogota",
                "Santa Fe", "Girardota", "Medellin"
        };

        String[] types = {
                "Hotel", "Apartamento", "Finca",
                "Dia de Sol", "Dia de Sol", "Hotel"
        };
        String[][] roomDescriptions = {
                // Para Hotel Grand Salon
                {
                        "- Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio. Precio: $100 por noche",
                        "- Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha. Precio: $125 por noche",
                        "- Habitación deluxe con 1 cama king size, baño privado con jacuzzi, terraza con vista al mar, aire acondicionado y TV de pantalla plana. Precio: $250 por noche",
                        "- Habitación premium con 2 camas dobles, vista panorámica al océano, minibar, y baño con ducha de lluvia. Precio: $180 por noche",
                        "- Habitación de lujo con 1 cama king size, sala de estar, aire acondicionado, vista al mar y desayuno incluido. Precio: $300 por noche"
                },

                // Para Villa San Marcos
                {
                        "- Habitación familiar con 2 camas matrimoniales, terraza privada, cocina pequeña, baño completo, vista al jardín. Precio: $180 por noche",
                        "- Habitación King con 3 camas, dos matrimoniales y una individual, terraza privada, cocina pequeña, baño completo, vista al jardín, Jacuzzi. Precio: $280 por noche",
                        "- Habitación de lujo con cama king size, jacuzzi privado, vista a las montañas, terraza con comedor y cocina. Precio: $350 por noche",
                        "- Habitación con 2 camas individuales, decoración rústica, cocina equipada, baño privado y vista al jardín. Precio: $200 por noche",
                        "- Habitación romántica con cama king size, chimenea, jacuzzi privado, y terraza con vista al jardín. Precio: $250 por noche"
                },

                // Para Finca el Azul
                {
                        "- Habitación rústica con 2 camas individuales, ventanas amplias, baño privado, vista a los campos, decoración tradicional. Precio: $320 por noche",
                        "- Habitación con cama queen size, chimenea, baño privado con bañera, y vista a los campos. Precio: $280 por noche",
                        "- Habitación de campo con 1 cama king size, decoración rústica, baño privado y terraza. Precio: $250 por noche",
                        "- Habitación deluxe con 2 camas dobles, cocina equipada, baño privado y vistas espectaculares a los campos. Precio: $300 por noche",
                        "- Habitación premium con 1 cama king size, terraza privada, jacuzzi al aire libre, y cocina. Precio: $350 por noche"
                },

                // Para Florida Tropical
                {
                        "- Actividades como Mesas de Ping Pong, Piscina, Canchas de Voley, y Futbol, Juegos de mesa. Incluye Almuerzo y Refrigerio. Precio: $115 por dia",
                        "- Actividades como Caminatas guiadas, Zona de Camping, Rutas en bicicletas, Yoga al aire libre. Incluye Almuerzo y Refrigerio. Precio: $130 por dia",
                        "- Actividades acuáticas, Botes de remo, Lago, Snorkel y Yoga. Incluye Almuerzo y Refrigerio. Precio: $140 por dia",
                        "- Paquete de actividades al aire libre como Rutas de Senderismo, Bicicletas, Pesca, y Voleibol. Incluye Almuerzo y Refrigerio. Precio: $125 por dia",
                        "- Actividades para niños, Piscina Infantil, Juegos de mesa, y Zonas de recreo. Incluye Almuerzo y Refrigerio. Precio: $110 por dia"
                },

                // Para Oasis Tropical
                {
                        "- Actividades como Botes de remo, Lago, Natación, Juegos de Salón, Pesca, Rutas de Bicicleta, Voleibol. Incluye Desayuno, Almuerzo, Refrigerio. Precio: $120 por dia",
                        "- Actividades de aventura como Caminatas, Pesca, Botes, y Zonas de Relax. Incluye Desayuno, Almuerzo, Refrigerio. Precio: $140 por dia",
                        "- Actividades acuáticas, Windsurf, Kayak, Natación, y Voleibol en la playa. Incluye Desayuno, Almuerzo, Refrigerio. Precio: $160 por dia",
                        "- Excursiones al aire libre, Rutas de Senderismo, Pesca, Botes, y Observación de aves. Incluye Desayuno, Almuerzo, Refrigerio. Precio: $135 por dia",
                        "- Actividades de entretenimiento, Teatro al aire libre, Rutas de bicicletas, y Caminatas nocturnas. Incluye Desayuno, Almuerzo, Refrigerio. Precio: $130 por dia"
                },

                // Para Hotel Globo de oro
                {
                        "- Habitación doble con 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio. Precio: $150 por noche",
                        "- Habitación sencilla con vista al mar, aire acondicionado, TV de pantalla plana y ducha. Precio: $100 por noche",
                        "- Habitación familiar con 2 camas matrimoniales, vista panorámica al océano, aire acondicionado, y baño con ducha de lluvia. Precio: $200 por noche",
                        "- Habitación deluxe con cama king size, vista al mar, jacuzzi privado, minibar y aire acondicionado. Precio: $220 por noche",
                        "- Habitación premium con cama king size, terraza privada con vista al mar, aire acondicionado, y baño con bañera. Precio: $250 por noche"
                }
        };



        double[] ratings = {3.4, 4.3, 4.4, 4.0, 4.2, 3.4};

        int[] prices = {125, 180, 320, 115, 120, 100};

        int[] availableRooms = {5, 5, 5, 5, 5, 5};

        // Crear instancias de alojamientos
        for (int i = 0; i < names.length; i++) {
            final int index = i;
            availableLodgings[i] = new Lodging(names[index], locations[index], types[index],
                    ratings[index], prices[index], availableRooms[index],
                    roomDescriptions[index]) {
                @Override
                public double calculateFinalPrice(int days) {
                    return getPrice() * days;
                }
            };
        }
    }

    // Metodo para añadir reservación
    public void addReservation(Reservation reservation) {
        if (reservationCount < reservations.length) {
            reservations[reservationCount++] = reservation;
        }
    }

    // Metodo para mostrar reservaciones
    public void displayReservations() {
        System.out.println("\n----- REGISTRO DE RESERVAS -----");
        for (int i = 0; i < reservationCount; i++) {
            Reservation data = reservations[i];
//            System.out.println("Nro de la Reserva " + (i + 1) + ":");
            System.out.println("Alojamiento: " + data.getLodging().getName());
            System.out.println("Habitación: " + data.getSelectedRoom());
            System.out.println("Nombre: " + data.getUserName() + " " + data.getUserLastName());
            System.out.println("Correo" + data.getUserEmail());
            System.out.println("");
            System.out.println("-----------------------------");
        }
    }

    // Metodo para realizar una reservación con interfaz de usuario
    public void makeReservation(Scanner scanner) {
        // 1. Mostramos los alojamientos y cual desea elejir
        System.out.println("Cuidades Disponibles:");
        String[] lodgingTypes = {"Hotel", "Apartamento", "Granja", "Dia de Sol"};
        for (int i = 0; i < lodgingTypes.length; i++) {
            System.out.println((i + 1) + ". " + lodgingTypes[i]);
        }
        System.out.println("------ Ingresa los datos de alojamiento ------");
        System.out.print("Que alojamiento deseas elejir: ");
        int lodgingTypeIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear buffer
        String selectedLodgingType = lodgingTypes[lodgingTypeIndex];

        // 2. Ciudad
        System.out.print("Ingresa la Ciudad: ");
        String city = scanner.nextLine();

        // 3. Fechas
        System.out.print("Dia de Inicio: ");
        int checkInDay = scanner.nextInt();
        System.out.print("Dia Final: ");
        int checkOutDay = scanner.nextInt();
        int totalDays = checkOutDay - checkInDay;

        // 4. Personas
        System.out.print("Numero total de adultos: ");
        int adults = scanner.nextInt();
        System.out.print("Numeros total de niños: ");
        int children = scanner.nextInt();

        // 5. Habitaciones que alojara
        System.out.print("Numero total de habitaciones: ");
        int rooms = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        // 6. Filtramos los alojamientos basado en lo que el usuario ingresa
        // Declara una lista que almacenará objetos de alojamiento y crea una lista vacia que sirve para guardar los alojamientos que cumplan los criterios
        List<Lodging> availableLodgings = new ArrayList<>();
        for (Lodging lodging : this.availableLodgings) {
            if (lodging.getType().equals(selectedLodgingType) &&
                    lodging.getLocation().equalsIgnoreCase(city) &&
                    lodging.checkAvailability(rooms)) {
                availableLodgings.add(lodging);
            }
        }

        // 7. Se muestran los alojamientos disponibles de lo contrario nos muestra un error
        if (availableLodgings.isEmpty()) {
            System.out.println("No hay alojamientos que cumplan con tus requerimientos");
            return;
        }

        System.out.println("-----[ Alojamiento disponible en " + city + " ]-----");
        for (int i = 0; i < availableLodgings.size(); i++) {
            Lodging lodging = availableLodgings.get(i);
            double basePrice = lodging.getPrice();
            double finalPrice = lodging.calculateFinalPrice(totalDays);

            System.out.println((i + 1) + ". " + "----------------------------------------+");
            System.out.println(" | Nombre: " + lodging.getName());
            System.out.println(" | " + "Tipo de Alojamiento: " + ". " + lodging.getType());
            System.out.println(" | " + "Ciudad: " + ". " + city);
            System.out.println(" | " + "Rating: " + lodging.getRating());
            System.out.println(" | " + "Precio por estadia: " + basePrice);
            System.out.println(" | " + "Precio final: " + finalPrice);
            System.out.println(" +------------------------------------------+");

        }

        // 8. Seleccion de Alojamiento
        System.out.print("Selecciona un alojamientos: ");
        int lodgingChoice = scanner.nextInt() - 1;
        scanner.nextLine(); //

        Lodging selectedLodging = availableLodgings.get(lodgingChoice);

        // 9. Confirmar reservasion
        System.out.println("Has seleccionado: " + selectedLodging.getName());
        System.out.print("Quieres continuar con la reservacion? (Si/No): ");
        String confirmation = scanner.nextLine().toLowerCase();

        if (!confirmation.equals("si")) {
            System.out.println("Reservacion cancelada");
            return;
        }

        // 10. Seleccionar una habitacion
        System.out.println("Habitaciones disponibles:");
        String[] availableRooms = selectedLodging.getRoomDescriptions();
        for (int i = 0; i < availableRooms.length; i++) {
            if (!availableRooms[i].equals("Ocupada")) {
                System.out.println((i + 1) + ". " + availableRooms[i]);
            }
        }

        System.out.print("Selecciona una habitacion: ");
        int roomChoice = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear buffer

        String selectedRoom = availableRooms[roomChoice];

        if (!selectedLodging.markRoomAsOccupied(selectedRoom)) {
            System.out.println("Error: La habitación seleccionada ya está ocupada.");
            return;
        }

        // 11. Confirmar la habitacion seleccionada
        System.out.println("Habitacion Seleccionada: " + selectedRoom);
        System.out.print("Deseas alojarte en esta habitacion? (Si/No): ");
        String roomConfirmation = scanner.nextLine().toLowerCase();

        if (!roomConfirmation.equals("si")) {
            System.out.println("Reservasion cancelada");
            return;
        }

        // 12. Pedimos la informacion del usuario para la reserva
        System.out.print("Nombre Completo: ");
        String firstName = scanner.nextLine();

        System.out.print("Apellidos: ");
        String lastName = scanner.nextLine();

        System.out.print("Correo Electronico: ");
        String email = scanner.nextLine();

        System.out.print("Nacionalidad: ");
        String nationality = scanner.nextLine();

        System.out.print("Numero de Telefono: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Hora de llegada: ");
        String arrivalTime = scanner.nextLine();

        // Se crea y se agrega la reserva
        Reservation newReservation = new Reservation(
                selectedLodging, firstName, lastName,
                email, nationality, phoneNumber,
                arrivalTime, checkInDay, checkOutDay,
                adults, children, rooms, selectedRoom
        );

        addReservation(newReservation);
        System.out.println("La reservacion se ha creado con exito!");
    }

}