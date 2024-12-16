package example.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    static String[] hotelNombres = new String[100];
    static String[] tipoAlojamiento = new String[100];
    static String[] ciudades = new String[100];
    static int[] calificaciones = new int[100];
    static double[] precios = new double[100]; // Array para almacenar los precios base de los hoteles

    static int[] habitacionHotelID = new int[500];
    static String[] habitacionTipos = new String[500];
    static String[] habitacionCaracteristicas = new String[500];
    static double[] habitacionPrecios = new double[500];
    static boolean[][][] habitacionDisponibilidad = new boolean[500][10][366]; // Disponibilidad de habitaciones

    static int[] reservaID = new int[100];
    static int[] reservaHotelID = new int[100];
    static int[] reservaHabitacionID = new int[100];
    static String[] reservaUsuario = new String[100];
    static LocalDate[][] reservaFechas = new LocalDate[100][2]; // Fechas de reserva como LocalDate
    static int contadorReservas = 0; // Contador para el ID de las reservas

    public static void main(String[] args) {

        // Inicialización de hoteles
        hotelNombres[0] = "Hotel Buenos Aires";
        tipoAlojamiento[0] = "Hotel";
        ciudades[0] = "Buenos Aires";
        calificaciones[0] = 4;
        precios[0] = 50.0; // Precio base del hotel 0

        hotelNombres[1] = "Hotel Mar del Plata";
        tipoAlojamiento[1] = "Hotel";
        ciudades[1] = "Mar del Plata";
        calificaciones[1] = 3;
        precios[1] = 60.0; // Precio base del hotel 1

        hotelNombres[2] = "Apartamento Cordoba";
        tipoAlojamiento[2] = "Apartamento";
        ciudades[2] = "Cordoba";
        calificaciones[2] = 2;
        precios[2] = 40.0; // Precio base del hotel 2

        hotelNombres[3] = "Finca Rosario";
        tipoAlojamiento[3] = "Finca";
        ciudades[3] = "Rosario";
        calificaciones[3] = 5;
        precios[3] = 100.0; // Precio base del hotel 3

        hotelNombres[4] = "Dia de Sol Buenos Aires";
        tipoAlojamiento[4] = "Dia de Sol";
        ciudades[4] = "Buenos Aires";
        calificaciones[4] = 4;
        precios[4] = 70.0; // Precio base del hotel 4

        hotelNombres[5] = "Dia de Sol Mar del Plata";
        tipoAlojamiento[5] = "Dia de Sol";
        ciudades[5] = "Mar del Plata";
        calificaciones[5] = 3;
        precios[5] = 80.0; // Precio base del hotel 5

        // Inicialización de habitaciones
        habitacionHotelID[0] = 0;
        habitacionTipos[0] = "Single";
        habitacionCaracteristicas[0] = "2 camas simples, aire acondicionado, WiFi";
        habitacionPrecios[0] = 50.0;

        habitacionHotelID[1] = 0;
        habitacionTipos[1] = "Double";
        habitacionCaracteristicas[1] = "1 cama doble, aire acondicionado, TV";
        habitacionPrecios[1] = 75.0;

        habitacionHotelID[2] = 1;
        habitacionTipos[2] = "Suite";
        habitacionCaracteristicas[2] = "1 cama king size, jacuzzi, TV de pantalla plana";
        habitacionPrecios[2] = 120.0;

        habitacionHotelID[3] = 2;
        habitacionTipos[3] = "Single";
        habitacionCaracteristicas[3] = "2 camas simples, desayuno incluido, WiFi";
        habitacionPrecios[3] = 55.0;

        habitacionHotelID[4] = 2;
        habitacionTipos[4] = "Activities";
        habitacionCaracteristicas[4] = "Piscina, parque, almuerzo incluido";
        habitacionPrecios[4] = 150.0;

        habitacionHotelID[5] = 3;
        habitacionTipos[5] = "Activities";
        habitacionCaracteristicas[5] = "Juegos, spa, refrigerio incluido";
        habitacionPrecios[5] = 100.0;

        // Inicializar la disponibilidad de las habitaciones
        for (int i = 0; i < habitacionDisponibilidad.length; i++) {
            for (int j = 0; j < habitacionDisponibilidad[i].length; j++) {
                for (int k = 0; k < habitacionDisponibilidad[i][j].length; k++) {
                    habitacionDisponibilidad[i][j][k] = true;
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a HotelApp!");
        showMenu(scanner);
    }

    public static void showMenu(Scanner scanner) {
        int option = 0;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Realizar una reserva");
            System.out.println("2. Actualizar una reserva");
            System.out.println("3. Cancelar una reserva");
            System.out.println("4. Salir");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.next();
            }
            option = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (option) {
                case 1 ->
                        buscarHoteles(scanner, hotelNombres, tipoAlojamiento, ciudades, calificaciones, precios, habitacionHotelID, habitacionTipos, habitacionCaracteristicas, habitacionPrecios);
                case 2 -> actualizarReserva(scanner);
                case 3 -> cancelarReserva(scanner);
                case 4 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 4);
    }

    public static void buscarHoteles(Scanner scanner, String[] hotelNombres, String[] tipoAlojamiento, String[] ciudades, int[] calificaciones, double[] precios, int[] habitacionHotelID, String[] habitacionTipos, String[] habitacionCaracteristicas, double[] habitacionPrecios) {
        System.out.println("\n--- Búsqueda de Hoteles ---");

        String[] ciudadesDisponibles = obtenerValoresUnicos(ciudades);
        System.out.println("\nCiudades disponibles:");
        for (int i = 0; i < ciudadesDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + ciudadesDisponibles[i]);
        }
        System.out.print("Seleccione una ciudad (ingrese el número): ");
        int ciudadSeleccionada = scanner.nextInt() - 1;
        scanner.nextLine();

        String[] tiposDisponibles = obtenerValoresUnicos(tipoAlojamiento);
        System.out.println("\nTipos de alojamiento disponibles:");
        for (int i = 0; i < tiposDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + tiposDisponibles[i]);
        }
        System.out.print("Seleccione un tipo de alojamiento (ingrese el número): ");
        int tipoSeleccionado = scanner.nextInt() - 1;
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de adultos: ");
        int cantidadAdultos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la cantidad de niños: ");
        int cantidadNinos = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine();

        LocalDate fechaInicio = null;
        LocalDate fechaFin = null;
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Validar el formato de la fecha de inicio
        while (fechaInicio == null) {
            System.out.print("Ingrese la fecha de inicio (DD/MM/YYYY): ");
            String fechaInicioStr = scanner.nextLine();
            try {
                fechaInicio = LocalDate.parse(fechaInicioStr, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }

        // Validar el formato de la fecha de fin
        while (fechaFin == null) {
            System.out.print("Ingrese la fecha de fin (DD/MM/YYYY): ");
            String fechaFinStr = scanner.nextLine();
            try {
                fechaFin = LocalDate.parse(fechaFinStr, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }

        System.out.println("\n--- Hoteles disponibles ---");
        int contadorHoteles = 0; // Contador para numerar los hoteles
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadesDisponibles[ciudadSeleccionada]) && tipoAlojamiento[i].equals(tiposDisponibles[tipoSeleccionado])) {
                contadorHoteles++;
                System.out.println(contadorHoteles + ". Hotel: " + hotelNombres[i]);
                System.out.println("  Calificación: " + calificaciones[i]);
                System.out.println("  Precio base: " + precios[i]);
            }
        }

        if (contadorHoteles > 0) {
            System.out.println((contadorHoteles + 1) + ". Salir"); // Opción para salir
            System.out.print("\nSeleccione un hotel para ver las habitaciones/servicios (ingrese el número): ");
            int opcionHotel = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            if (opcionHotel > 0 && opcionHotel <= contadorHoteles) {
                int hotelSeleccionado = opcionHotel - 1;

                // Mostrar habitaciones/servicios disponibles para el hotel seleccionado
                System.out.println("\n--- Habitaciones/servicios disponibles en " + hotelNombres[hotelSeleccionado] + " ---");
                int contadorOpciones = 0;
                for (int j = 0; j < habitacionHotelID.length; j++) {
                    // Validar habitaciones válidas (habitacionHotelID[j] debe tener un ID válido)
                    if (habitacionHotelID[j] == hotelSeleccionado && habitacionTipos[j] != null) {
                        contadorOpciones++;
                        System.out.println(contadorOpciones + ". " + habitacionTipos[j] + ":");
                        System.out.println("  Características: " + habitacionCaracteristicas[j]);
                        System.out.println("  Precio: " + habitacionPrecios[j]);
                    }
                }

                if (contadorOpciones > 0) {
                    System.out.print("\nSeleccione una habitación/servicio (ingrese el número): ");
                    int opcionHabitacion = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea

                    if (opcionHabitacion > 0 && opcionHabitacion <= contadorOpciones) {
                        int habitacionSeleccionada = -1;
                        for (int j = 0, k = 1; j < habitacionHotelID.length && habitacionHotelID[j] >= 0; j++) {
                            if (habitacionHotelID[j] == hotelSeleccionado) {
                                if (k == opcionHabitacion) {
                                    habitacionSeleccionada = j;
                                    break;
                                }
                                k++;
                            }
                        }

                        double precioHabitacion = habitacionPrecios[habitacionSeleccionada];
                        double precioTotal = precioHabitacion; // Inicialmente, el precio total es el precio de la habitación

                        // Si el precio de la habitación es mayor al precio base del hotel, mostrar el total a pagar
                        if (precioHabitacion > precios[hotelSeleccionado]) {
                            precioTotal = calcularPrecioTotal(precioHabitacion, cantidadHabitaciones, fechaInicio, fechaFin);
                            System.out.println("\nPrecio total de la estadía: " + precioTotal);
                        }

                        // Confirmar reserva
                        System.out.print("\n¿Desea confirmar la reserva? (s/n): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            LocalDate fechaInicioReserva = LocalDate.parse(fechaInicio.format(formato), formato); // Convertir fechaInicio a LocalDate
                            LocalDate fechaFinReserva = LocalDate.parse(fechaFin.format(formato), formato); // Convertir fechaFin a LocalDate
                            crearReserva(scanner, hotelSeleccionado, habitacionSeleccionada, fechaInicioReserva, fechaFinReserva, cantidadHabitaciones, precioTotal); // Pasar las fechas como LocalDate
                        }

                    } else {
                        System.out.println("Opción inválida.");
                    }
                } else {
                    System.out.println("No se encontraron habitaciones/servicios disponibles en este hotel.");
                }
            } else if (opcionHotel != contadorHoteles + 1) {
                System.out.println("Opción inválida.");
            }
        } else {
            System.out.println("No se encontraron hoteles con esos criterios.");
        }
    }

    public static int calcularDiasEstadia(String fechaInicio, String fechaFin) {
        String[] inicio = fechaInicio.split("/");
        String[] fin = fechaFin.split("/");

        int diaInicio = Integer.parseInt(inicio[0]);
        int mesInicio = Integer.parseInt(inicio[1]);
        int anioInicio = Integer.parseInt(inicio[2]);

        int diaFin = Integer.parseInt(fin[0]);
        int mesFin = Integer.parseInt(fin[1]);
        int anioFin = Integer.parseInt(fin[2]);

        int totalDias = (anioFin - anioInicio) * 365 + (mesFin - mesInicio) * 30 + (diaFin - diaInicio);
        return totalDias > 0 ? totalDias : 1; // Al menos un día
    }

    public static double aplicarAumentosYDescuentos(double precioTotal, LocalDate fechaInicio, LocalDate fechaFin) {
        // Ejemplo de lógica: aplicar un aumento del 10% si es temporada alta (diciembre-enero)
        int mesInicio = fechaInicio.getMonthValue();
        int mesFin = fechaFin.getMonthValue();

        if ((mesInicio == 12 || mesInicio == 1) || (mesFin == 12 || mesFin == 1)) {
            precioTotal *= 1.10; // Aumento del 10%
        }
        return precioTotal;
    }

    public static String[] obtenerValoresUnicos(String[] array) {
        String[] unicos = new String[array.length];
        int count = 0;

        for (String value : array) {
            if (value == null) break;

            boolean encontrado = false;
            for (int j = 0; j < count; j++) {
                if (unicos[j].equals(value)) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                unicos[count++] = value;
            }
        }

        String[] resultado = new String[count];
        System.arraycopy(unicos, 0, resultado, 0, count);
        return resultado;
    }

    // TODO: Implementar la función actualizarReserva
    public static void actualizarReserva(Scanner scanner) {
        // Implementa la lógica para actualizar una reserva
    }

    // TODO: Implementar la función cancelarReserva
    public static void cancelarReserva(Scanner scanner) {
        // Implementa la lógica para cancelar una reserva
    }

    // TODO: Implementar la función confirmarHabitaciones
    public static void confirmarHabitaciones(Scanner scanner) {
        // Implementa la lógica para confirmar las habitaciones
    }

    public static boolean habitacionDisponible(int habitacionId, LocalDate fechaInicio, LocalDate fechaFin) {
        // Verificar la disponibilidad para cada día del rango
        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
            if (!habitacionDisponibilidad[habitacionId][fecha.getYear() - 2024][fecha.getDayOfYear() - 1]) {
                return false; // La habitación no está disponible en este día
            }
        }
        return true; // La habitación está disponible en todo el rango
    }

    public static double calcularPrecioTotal(double precioHabitacion, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        double precioTotal = precioHabitacion * cantidadHabitaciones;
        long diasEstadia = ChronoUnit.DAYS.between(fechaInicio, fechaFin);

        // Aplicar aumentos y descuentos
        precioTotal = aplicarAumentosYDescuentos(precioTotal, fechaInicio, fechaFin);

        return precioTotal * diasEstadia;
    }

    public static void crearReserva(Scanner scanner, int hotelId, int habitacionId, LocalDate fechaInicio, LocalDate fechaFin, int cantidadHabitaciones, double precioTotal) {
        System.out.println("\n--- Crear Reserva ---");

        // Pedir los datos del usuario
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese su hora aproximada de llegada: ");
        String horaLlegada = scanner.nextLine();

        // Registrar la reserva
        reservaID[contadorReservas] = contadorReservas;
        reservaHotelID[contadorReservas] = hotelId;
        reservaHabitacionID[contadorReservas] = habitacionId;
        reservaUsuario[contadorReservas] = nombre + " " + apellido;
        reservaFechas[contadorReservas][0] = fechaInicio;
        reservaFechas[contadorReservas][1] = fechaFin;
        contadorReservas++;

        // TODO: Actualizar la disponibilidad de la habitación

        System.out.println("Se ha realizado la reserva con éxito. Su ID de reserva es: " + (contadorReservas - 1));
        System.out.println("NOTA: Conserve este ID. Es necesario para actualizar o cancelar la reserva.");
    }
};
