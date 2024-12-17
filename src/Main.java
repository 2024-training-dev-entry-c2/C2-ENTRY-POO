import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static String ultimaReserva = ""; // Registro temporal de la última reserva realizada
    private static final List<String> historialReservas = new ArrayList<>(); // Registro histórico de reservas
    // confirmadas

    public static void main(String[] args) {

        // Creación de objetos de tipo Habitación
        Habitacion habitacion1 = new Habitacion("Suit Presidencial", "Habitacion con cama queen size, tv y cocina", 2, 800000);
        Habitacion habitacion2 = new Habitacion("Suit Matrimonial", "Habitacion con cama doble, tv y cocina y vista panoramica", 4, 600000);
        Habitacion habitacion3 = new Habitacion("Habitación Doble", "Habitacion con dos camas dobles, tv y cocina", 3, 400000);
        Habitacion habitacion4 = new Habitacion("Habitación Simple", "Habitacion con cama sencilla, tv y cocina", 8, 200000);
        Habitacion habitacion5 = new Habitacion("Habitación Familiar", "Habitacion con cama doble y dos camas sencillas, tv y cocina", 2, 700000);

        // Creación de objetos de tipo Alojamiento
        Alojamiento hotelTequendama = new Alojamiento("Hotel Tequendama", "Bogota", "Hotel", 4.5, 50000, "Disponibildad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero", new ArrayList<>());
        Alojamiento apartamentoCentral = new Alojamiento("Apartamento Central", "Bogota", "Apartamento", 4.0, 40000, "Disponibilidad de piscina, zona de asados y parqueadero", new ArrayList<>());
        Alojamiento hotelCaribe = new Alojamiento("Hotel Caribe", "Cartagena", "Hotel", 4.8, 60000, "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero", new ArrayList<>());
        Alojamiento casaColonial = new Alojamiento("Casa Colonial", "Cartagena", "Finca", 4.2, 35000, "Disponibilidad de piscina, salon de eventos y parqueadero", new ArrayList<>());
        Alojamiento irotamaResort = new Alojamiento("Irotama Resort", "Santa Marta", "Hotel", 5.0, 350000, "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, spa, zona de juegos, discoteca y parqueadero", new ArrayList<>());
        Alojamiento apartamentoPlaya = new Alojamiento("Apartamento Playa", "Santa Marta", "Apartamento", 3.5, 150000, "Disponibilidad de playa privada, zona de asados y parqueadero", new ArrayList<>());
        Alojamiento hotelDecameron = new Alojamiento("Hotel Decameron", "San Andres", "Hotel", 5.0, 500000, "Disponibilidad de piscina, almuerzo incluido, refrigerio para niuños, canchas deportivas, spa, zona de juegos, salon de eventos, discoteca y parqueadero", new ArrayList<>());
        Alojamiento casaVacacional = new Alojamiento("Casa Vacacional", "San Andres", "Finca", 4.1, 300000, "Mesa de billar, zona de asados y parqueadero", new ArrayList<>());
        Alojamiento ecoAmazonLodge = new Alojamiento("EcoAmazon Lodge", "Amazonas", "Hotel", 4.7, 350000, "Barra libre de cerveza, acceso dirigido al acuario, almuerzo incluido, spa, zona de juegos, recorrido dirigido por la naturaleza y grupos de avistamiento de aves", new ArrayList<>());
        Alojamiento fincaAmazonica = new Alojamiento("Finca Amazonica", "Amazonas", "Finca", 3.0, 200000, "Disponibilidad de jacuzzi, zona de asados, senderismo por la zona con vista a la naturaleza", new ArrayList<>());

        // Agregar habitaciones a los alojamientos
        hotelTequendama.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1, habitacion3, habitacion4, habitacion5)));
        apartamentoCentral.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion2)));
        hotelCaribe.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5)));
        casaColonial.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1)));
        irotamaResort.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5)));
        apartamentoPlaya.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion5)));
        hotelDecameron.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5)));
        casaVacacional.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion2)));
        ecoAmazonLodge.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1, habitacion2, habitacion3, habitacion4, habitacion5)));
        fincaAmazonica.setHabitaciones(new ArrayList<Habitacion>(List.of(habitacion1)));

        // Creación de un arreglo de objetos de tipo Alojamiento
        Alojamiento[] alojamientos = { hotelTequendama, apartamentoCentral, hotelCaribe, casaColonial, irotamaResort, apartamentoPlaya, hotelDecameron, casaVacacional, ecoAmazonLodge, fincaAmazonica };

        // Creación de arreglo de ciudades en las que se encuentran los alojamientos
        ArrayList<String> ciudades = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.ciudad)) {
                ciudades.add(alojamiento.ciudad);
            }
        };

        String[][] alojamientos_ = {
                { "Hotel Tequendama", "Bogota", "Hotel", "4.5", "50000" },
                { "Apartamento Central", "Bogota", "Apartamento", "4.0", "40000" },
                { "Hotel Caribe", "Cartagena", "Hotel", "4.8", "60000" },
                { "Casa Colonial", "Cartagena", "Finca", "4.2", "35000" },
                { "Irotama Resort", "Santa Marta", "Hotel", "5.0", "350000" },
                { "Apartamento Playa", "Santa Marta", "Apartamento", "3.5", "150000" },
                { "Hotel Decameron", "San Andres", "Hotel", "5.0", "500000" },
                { "Casa Vacacional", "San Andres", "Finca", "4.1", "300000" },
                { "EcoAmazon Lodge", "Amazonas", "Hotel", "4.7", "350000" },
                { "Finca Amazonica", "Amazonas", "Finca", "3.0", "200000" }
        };

        String[] actividadesDiaSol = {
                // Hotel Tequendama
                "Disponibildad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero",
                // Apartamento Central
                "Disponibilidad de piscina, zona de asados y parqueadero",
                // Hotel Caribe
                "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, zona de juegos y parqueadero",
                // Casa Colonial
                "Disponibilidad de piscina, salon de eventos y parqueadero",
                // Irotama Resort
                "Disponibilidad de piscina, almuerzo incluido, canchas deportivas, spa, zona de juegos, discoteca y parqueadero",
                // Apartamento Playa
                "Disponibilidad de playa privada, zona de asados y parqueadero",
                // Hotel Decameron
                "Disponibilidad de piscina, almuerzo incluido, refrigerio para niuños, canchas deportivas, spa, zona de juegos, salon de eventos, discoteca y parqueadero",
                // Casa Vacacional
                "Mesa de billar, zona de asados y parqueadero",
                // EcoAmazon Lodge
                "Barra libre de cerveza, acceso dirigido al acuario, almuerzo incluido, spa, zona de juegos, recorrido dirigido por la naturaleza y grupos de avistamiento de aves",
                // Finca Amazonica
                "Disponibilidad de jacuzzi, zona de asados, senderismo por la zona con vista a la naturaleza"

        };

        float[] precioDiaSol = {
                50000, // Hotel Tequendama
                40000, // Apartamento Central
                60000, // Hotel Caribe
                35000, // Casa Colonial
                350000, // Irotama Resort
                150000, // Apartamento Playa
                500000, // Hotel Decameron
                300000, // Casa Vacacional
                350000, // EcoAmazon Lodge
                200000 // Finca Amazónica
        };

        float[][] preciosHabitaciones = {
                { 800000, 600000, 400000, 200000, 1000000 },
                { 300000, 400000, 500000, 600000, 800000 },
                { 900000, 700000, 500000, 300000, 1100000 },
                { 200000, 300000, 500000, 350000, 800000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 },
                { 1000000, 800000, 600000, 400000, 2000000 },
                { 400000, 300000, 200000, 150000, 600000 }
        };

        int[][] disponibilidadHabitaciones = {
                { 5, 4, 10, 8, 2 },
                { 3, 2, 5, 6, 1 },
                { 6, 3, 7, 4, 2 },
                { 5, 3, 8, 7, 3 },
                { 10, 8, 6, 4, 2 },
                { 3, 2, 5, 6, 2 },
                { 8, 6, 10, 5, 2 },
                { 5, 4, 7, 3, 2 },
                { 6, 4, 7, 5, 2 },
                { 5, 3, 6, 4, 1 }
        };

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nBIENVENIDO A BOOKING COLOMBIA");
            System.out.println("1. Buscar alojamientos y disponibilidad");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Reservar Día de Sol");
            System.out.println("4. Ver historial de reservaciones");
            System.out.println("5. Gestionar reservaciones");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> buscarAlojamientos(alojamientos, ciudades, scanner);
//                case 2 -> realizarReserva(alojamientos, preciosHabitaciones, disponibilidadHabitaciones, scanner);
//                case 3 -> reservarDiaDeSol(alojamientos, precioDiaSol, actividadesDiaSol, scanner);
//                case 4 -> verHistorialReservas();
//                case 5 -> cancelarReservacion(disponibilidadHabitaciones, alojamientos); // TODO: Implementar
                case 0 -> System.out.println("Gracias por usar Booking Colombia. ¡Hasta pronto!");
                default -> System.out.println("Opción no válida, intente nuevamente.");
            }

        } while (opcion != 0);

        scanner.close();
    }

   public static void buscarAlojamientos(Alojamiento[] alojamientos, ArrayList<String> ciudades, Scanner scanner) {
    // Mostrar las opciones de ciudades
    System.out.println("Ingrese una ciudad entre las opciones disponibles:");
    for (String ciudad : ciudades) {
        System.out.print(ciudad + " | ");
    }
    System.out.println("\n"); // Salto de línea

    // Leer la ciudad escogida
    System.out.print("Ciudad: ");
    scanner.nextLine(); // Consumir el carácter de nueva línea pendiente
    String ciudadEscogida = scanner.nextLine().trim();

    // Leer el tipo de alojamiento
    System.out.println("Ingrese el tipo de alojamiento que desea buscar:");
    System.out.println("Hotel | Apartamento | Finca");
    System.out.print("Tipo: ");
    String tipoAlojamiento = scanner.nextLine().trim();

    //Leer fecha de inicio
    System.out.print("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
    System.out.println();
    LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

    //Leer fecha de fin
    System.out.print("Ingrese la fecha de finalización de la reserva (yyyy-MM-dd): ");
    System.out.println();
    LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

    //Leer cantidad de personas
    System.out.print("Ingrese la cantidad de adultos: ");
    int adultos = scanner.nextInt();

    System.out.print("Ingrese la cantidad de niños: ");
    int ninos = scanner.nextInt();

    // Buscar coincidencias
    boolean encontrado = false;

    System.out.println("\nAlojamientos disponibles en " + ciudadEscogida + " (" + tipoAlojamiento + "):");
    for (Alojamiento alojamiento : alojamientos) {
        // Filtrar por ciudad y tipo de alojamiento
        if (alojamiento.ciudad.equalsIgnoreCase(ciudadEscogida) &&
                alojamiento.tipo.equalsIgnoreCase(tipoAlojamiento)) {
            encontrado = true;
            System.out.printf("Nombre: %s | Tipo: %s | Calificación: %.1f estrellas%n",
                    alojamiento.nombre,
                    alojamiento.tipo,
                    alojamiento.calificacion);
            for (Habitacion habitacion : alojamiento.habitaciones) {
                int i = 1;
                System.out.printf("   %d. %s | Descripción: %s | Precio por noche: $%.2f%n",
                        i,
                        habitacion.nombre,
                        habitacion.descripcion,
                        habitacion.precioNoche);
            }
        }
    }
    // Si no se encontraron alojamientos
    if (!encontrado) {
        System.out.println("No se encontraron alojamientos de tipo '" + tipoAlojamiento +
                "' en la ciudad '" + ciudadEscogida + ". En las fechas seleccionadas, vuelva a intentarlo con parametros diferentes.");
        return;
    }

 //Leer la opción de reservar
System.out.print("¿Desea realizar una reserva? \n( 1: Por noches / 2: Día de sol / 3: No, gracias ): ");
int confirmar = scanner.nextInt();

switch (confirmar) {
    case 1 -> {
        System.out.print("Para continuar con la reserva por favor ingrese el nombre del alojamiento: ");
        scanner.nextLine(); // Limpiar buffer
        String nombreAlojamiento = scanner.nextLine();

        // Buscar el alojamiento seleccionado
        Alojamiento alojamientoSeleccionado = null;
        while (alojamientoSeleccionado == null) {
            for (Alojamiento alojamiento : alojamientos) {
                if (alojamiento.nombre.equalsIgnoreCase(nombreAlojamiento)) {
                    alojamientoSeleccionado = alojamiento;
                    break;
                }
            }
            if (alojamientoSeleccionado == null) {
                System.out.println("Alojamiento no encontrado, vuelva a intentarlo.");
                return;
            }
        }
        System.out.println("Escoja la habitacion en el alojamiento seleccionado: " + alojamientoSeleccionado.nombre);
        int i = 1;
        for (Habitacion habitacion : alojamientoSeleccionado.habitaciones) {
            System.out.printf("   %d. %s | Descripción: %s | Precio por noche: $%.2f  | Disponibles: %d.%n",
                    i,
                    habitacion.nombre,
                    habitacion.descripcion,
                    habitacion.precioNoche,
                    habitacion.cantidadDisponible);
            i++;
        }
        System.out.print("Seleccione el número de la habitación que desea reservar: ");
        int opcionHabitacion = scanner.nextInt() - 1;

        if (opcionHabitacion < 0 || opcionHabitacion >= alojamientoSeleccionado.habitaciones.size()) {
            System.out.println("Opción no válida.");
            return;
        } else {
            System.out.println("Ingrese su nombre para generar la reserva en la habitación " + alojamientoSeleccionado.habitaciones.get(opcionHabitacion).nombre);
            scanner.nextLine(); // Limpiar buffer
            String nombreCliente = scanner.nextLine();

            System.out.println("Ingrese su apellido: " );
            scanner.nextLine(); // Limpiar buffer
            String apellidoCliente = scanner.nextLine();

            System.out.println("Ingrese su email: ");
            scanner.nextLine(); // Limpiar buffer
            String emailCliente = scanner.nextLine();

            System.out.println("Ingrese su nacionalidad: ");
            scanner.nextLine(); // Limpiar buffer
            String nacionalidadCliente = scanner.nextLine();
            System.out.println("Ingrese su telefono: ");
            scanner.nextLine(); // Limpiar buffer
            int telefonoCliente = scanner.nextInt();
            System.out.println("Ingrese su fecha de nacimiento (yyyy-MM-dd): ");
            scanner.nextLine(); // Limpiar buffer
            LocalDate fechaNacimientoCliente = LocalDate.parse(scanner.nextLine());

            Cliente cliente = new Cliente(nombreCliente, apellidoCliente, emailCliente, nacionalidadCliente, telefonoCliente, fechaNacimientoCliente);
//            Reserva reserva = new Reserva(fechaInicio, fechaFin, adultos, ninos, cliente, alojamientoSeleccionado, ArrayList<Habitacion> List.of(alojamientoSeleccionado.habitaciones.get(opcionHabitacion)));
        }
    }
    case 2 -> {
        // Lógica para reservar Día de sol
    }
    case 3 -> {
        System.out.println("No se ha realizado ninguna reserva.");
    }
    default -> {
        System.out.println("Opción no válida.");
    }
}
}

    public static String obtenerDescripcionHabitacion(int indice) {
        return switch (indice) {
            case 0 -> "Suit Presidencial";
            case 1 -> "Suit Matrimonial";
            case 2 -> "Habitación Doble";
            case 3 -> "Habitación Simple";
            case 4 -> "Habitación Familiar";
            default -> "Habitación Desconocida";
        };
    }

    public static void realizarReserva(String[][] alojamientos, float[][] preciosHabitaciones,
                                       int[][] disponibilidadHabitaciones, Scanner scanner) {
        System.out.print("Ingrese el nombre del hotel: ");
        scanner.nextLine(); // Limpiar buffer
        String nombreHotel = scanner.nextLine();

        int indiceHotel = buscarIndiceHotel(nombreHotel, alojamientos);
        if (indiceHotel == -1) {
            System.out.println("Hotel no encontrado.");
            return;
        }

        System.out.print("Ingrese el tipo de habitación (1-5): ");
        int tipoHabitacion = scanner.nextInt() - 1;

        if (tipoHabitacion < 0 || tipoHabitacion >= preciosHabitaciones[indiceHotel].length) {
            System.out.println("Tipo de habitación no válido.");
            return;
        }

        if (disponibilidadHabitaciones[indiceHotel][tipoHabitacion] <= 0) {
            System.out.println("No hay disponibilidad para este tipo de habitación.");
            return;
        }

        disponibilidadHabitaciones[indiceHotel][tipoHabitacion]--;

        System.out.print("Ingrese su nombre: ");
        scanner.nextLine(); // Limpiar buffer
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la fecha de inicio de la reserva (yyyy-MM-dd): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese la fecha de finalización de la reserva (yyyy-MM-dd): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

        long noches = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        if (noches <= 0) {
            System.out.println("Fechas no válidas. La fecha de fin debe ser posterior a la de inicio.");
            return;
        }

        float precioBase = preciosHabitaciones[indiceHotel][tipoHabitacion];
        float precioTotal = precioBase * noches;
        float ajuste = calcularAjuste(precioTotal, fechaInicio, fechaFin);

        ultimaReserva = String.format(
                "Reserva a nombre de %s en %s \nTipo de habitación: %s, \nDel %s al %s. (%d noches) \nPrecio total: $%.2f (Ajuste aplicado: $%.2f)",
                nombre, nombreHotel, obtenerDescripcionHabitacion(tipoHabitacion), fechaInicio, fechaFin, noches,
                precioTotal + ajuste, ajuste);

        System.out.println("\n" + ultimaReserva);

        System.out.print("\n¿Desea confirmar esta reserva? (1: Sí / 2: No): ");

        int confirmar = scanner.nextInt();

        if (confirmar == 1) {
            confirmarReservacion();

        } else {
            System.out.println("La reserva no se ha guardado, vuelva a intentarlo.");
        }

    }

    public static int buscarIndiceHotel(String nombreHotel, String[][] alojamientos) {
        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i][0].equalsIgnoreCase(nombreHotel)) {
                return i;
            }
        }
        return -1;
    }

    public static float calcularAjuste(float precioTotal, LocalDate fechaInicio, LocalDate fechaFin) {
        float ajuste = 0;
        if (fechaFin.getDayOfMonth() >= 25) {
            ajuste = precioTotal * 0.15f;
        } else if (fechaInicio.getDayOfMonth() >= 10 && fechaInicio.getDayOfMonth() <= 15) {
            ajuste = precioTotal * 0.10f;
        } else if (fechaInicio.getDayOfMonth() >= 5 && fechaInicio.getDayOfMonth() <= 10) {
            ajuste = -precioTotal * 0.08f;
        }
        return ajuste;
    }

    public static void confirmarReservacion() {
        if (ultimaReserva.isEmpty()) {
            System.out.println("No hay ninguna reserva para confirmar.");
        } else {
            historialReservas.add(ultimaReserva);
            System.out.println("\nReservación confirmada y añadida al historial.");
            ultimaReserva = ""; // Limpiar la reserva temporal después de confirmar
        }
    }

    public static void verHistorialReservas() {
        if (historialReservas.isEmpty()) {
            System.out.println("No hay reservas confirmadas.");
        } else {
            System.out.println("\nHistorial de Reservas Confirmadas:");
            int index = 1; // Iniciamos de enumeracion de reservas desde 1
            for (String reserva : historialReservas) {
                System.out.printf("%d. %s%n", index, reserva);
                System.out.println("----------------------");
                index++;
            }
        }
    }

    public static void reservarDiaDeSol(String[][] alojamientos, float[] precioDiaSol, String[] actividades,
                                        Scanner scanner) {
        System.out.println("\nAlojamientos disponibles para Día de Sol:");
        for (int i = 0; i < alojamientos.length; i++) {
            System.out.printf("%d. %s | Ciudad: %s | Precio por adulto: $%.2f%n Actividades: %s%n%n",
                    i + 1, alojamientos[i][0], alojamientos[i][1], precioDiaSol[i], actividades[i]);
        }

        System.out.print("\nSeleccione el número del alojamiento donde desea reservar: ");
        int opcionHotel = scanner.nextInt() - 1;

        if (opcionHotel < 0 || opcionHotel >= alojamientos.length) {
            System.out.println("Opción no válida.");
            return;
        }

        System.out.print("Ingrese la fecha de la reserva (yyyy-MM-dd): ");
        scanner.nextLine(); // Limpiar buffer
        LocalDate fechaReserva = LocalDate.parse(scanner.nextLine());

        System.out.print("Ingrese la cantidad de adultos: ");
        int adultos = scanner.nextInt();

        System.out.print("Ingrese la cantidad de niños: ");
        int ninos = scanner.nextInt();

        float precioPorNino = precioDiaSol[opcionHotel] * 0.70f; // Descuento del 30% para niños
        float costoTotal = (adultos * precioDiaSol[opcionHotel]) + (ninos * precioPorNino);

        // Aplicar ajustes por temporada
        float ajuste = calcularAjuste(costoTotal, fechaReserva, fechaReserva);
        float costoFinal = costoTotal + ajuste;

        // Mostrar el resumen de la reserva
        System.out.println("\nResumen de la Reserva:");
        System.out.printf("Hotel: %s | Ciudad: %s%n", alojamientos[opcionHotel][0], alojamientos[opcionHotel][1]);
        System.out.printf("Fecha: %s | Adultos: %d | Niños: %d%n", fechaReserva, adultos, ninos);
        System.out.printf("Costo Total: $%.2f (Incluye ajuste de $%.2f)%n", costoFinal, ajuste);

        System.out.print("¿Desea confirmar esta reserva? (1: Sí / 2: No): ");
        int confirmar = scanner.nextInt();

        if (confirmar == 1) {
            String reserva = String.format(
                    "Día de Sol: %s | Fecha: %s | Adultos: %d | Niños: %d | Total: $%.2f | Con acceso a: %s",
                    alojamientos[opcionHotel][0], fechaReserva, adultos, ninos, costoFinal, actividades[opcionHotel]);
            historialReservas.add(reserva);
            System.out.println("¡Reserva confirmada y guardada en el historial!");
        } else {
            System.out.println("La reserva no se ha confirmado.");
        }
    }

    public static void cancelarReservacion(int[][] disponibilidadHabitaciones, String[][] alojamientos) {
        if (historialReservas.isEmpty()) {
            System.out.println("No hay reservas confirmadas para cancelar.");
            return;
        }

        // Mostrar historial numerado
        System.out.println("\nHistorial de Reservas Confirmadas:");
        int index = 1;
        for (String reserva : historialReservas) {
            System.out.printf("%d. %s%n", index, reserva);
            System.out.println("----------------------");
            index++;
        }

        // Solicitar al usuario la reserva a cancelar (opcion: numero)
        System.out.print("Ingrese el número de la reserva que desea cancelar o 0 para salir: ");
        Scanner scanner = new Scanner(System.in);
        int reservaIndex = scanner.nextInt() - 1;

        if (reservaIndex < 0 || reservaIndex >= historialReservas.size()) {
            System.out.println("Número de reserva no válido. Intente nuevamente.");
            return;
        }

        // Obtener detalles de la reserva para ajustar disponibilidad (si aplica)
        String reservaCancelada = historialReservas.get(reservaIndex);
        System.out.println("\nCancelando la siguiente reserva:");
        System.out.println(reservaCancelada);

        // Ajustar disponibilidad si es una habitación
        if (reservaCancelada.contains("Tipo de habitación")) {
            ajustarDisponibilidad(reservaCancelada, disponibilidadHabitaciones, alojamientos);
        }

        historialReservas.remove(reservaIndex);
        System.out.println("La reserva ha sido cancelada con éxito.");
    }

    private static int buscarIndiceHabitacion(String tipoHabitacion) {
        return switch (tipoHabitacion) {
            case "Suit Presidencial" -> 0;
            case "Suit Matrimonial" -> 1;
            case "Habitación Doble" -> 2;
            case "Habitación Simple" -> 3;
            case "Habitación Familiar" -> 4;
            default -> -1;
        };
    }

    private static void ajustarDisponibilidad(String reservaCancelada, int[][] disponibilidadHabitaciones,
                                              String[][] alojamientos) {
        String[] partes = reservaCancelada.split("\\n"); // Dividimos la información de la reserva por líneas
        String nombreHotel = partes[1].split(":")[1].trim(); // Extraemos el nombre del hotel
        String tipoHabitacion = partes[2].split(":")[1].trim(); // Extraemos el tipo de habitación

        int indiceHotel = buscarIndiceHotel(nombreHotel, alojamientos);
        int indiceHabitacion = buscarIndiceHabitacion(tipoHabitacion);

        if (indiceHotel != -1 && indiceHabitacion != -1) {
            disponibilidadHabitaciones[indiceHotel][indiceHabitacion]++;
            System.out.printf("La disponibilidad de '%s' en '%s' ha sido actualizada.%n",
                    tipoHabitacion, nombreHotel);
        } else {
            System.out.println("No se pudo ajustar la disponibilidad. Información inconsistente.");
        }
    }

}
