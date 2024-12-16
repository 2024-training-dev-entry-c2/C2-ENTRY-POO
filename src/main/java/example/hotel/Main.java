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
    static double[] precios = new double[100];

    static int[] habitacionHotelID = new int[500];
    static String[] habitacionTipos = new String[500];
    static String[] habitacionCaracteristicas = new String[500];
    static double[] habitacionPrecios = new double[500];
    static boolean[][][] habitacionDisponibilidad = new boolean[500][10][366];
    static int[][] habitacionesDisponibles = new int[100][5];

    static int[] reservaID = new int[100];
    static int[] reservaHotelID = new int[100];
    static int[] reservaHabitacionID = new int[100];
    static String[] reservaUsuario = new String[100];
    static LocalDate[][] reservaFechas = new LocalDate[100][2];
    static int contadorReservas = 0;

    public static void main(String[] args) {

        // Inicialización de hoteles
        hotelNombres[0] = "Hotel Buenos Aires";
        tipoAlojamiento[0] = "Hotel";
        ciudades[0] = "Buenos Aires";
        calificaciones[0] = 4;
        precios[0] = 50.0;

        hotelNombres[1] = "Hotel Mar del Plata";
        tipoAlojamiento[1] = "Hotel";
        ciudades[1] = "Mar del Plata";
        calificaciones[1] = 3;
        precios[1] = 60.0;

        hotelNombres[2] = "Apartamento Cordoba";
        tipoAlojamiento[2] = "Apartamento";
        ciudades[2] = "Cordoba";
        calificaciones[2] = 2;
        precios[2] = 40.0;

        hotelNombres[3] = "Finca Rosario";
        tipoAlojamiento[3] = "Finca";
        ciudades[3] = "Rosario";
        calificaciones[3] = 5;
        precios[3] = 100.0;

        hotelNombres[4] = "Dia de Sol Buenos Aires";
        tipoAlojamiento[4] = "Dia de Sol";
        ciudades[4] = "Buenos Aires";
        calificaciones[4] = 4;
        precios[4] = 70.0;

        hotelNombres[5] = "Dia de Sol Mar del Plata";
        tipoAlojamiento[5] = "Dia de Sol";
        ciudades[5] = "Mar del Plata";
        calificaciones[5] = 3;
        precios[5] = 80.0;

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
        for (int i = 0; i < habitacionesDisponibles.length; i++) {
            for (int j = 0; j < habitacionesDisponibles[i].length; j++) {
                habitacionesDisponibles[i][j] = 10;
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
            scanner.nextLine();

            switch (option) {
                case 1 -> buscarHoteles(scanner);
                case 2 -> actualizarReserva(scanner);
                case 3 -> cancelarReserva(scanner);
                case 4 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 4);
    }

    public static void buscarHoteles(Scanner scanner) {
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

        while (fechaInicio == null) {
            System.out.print("Ingrese la fecha de inicio (DD/MM/YYYY): ");
            String fechaInicioStr = scanner.nextLine();
            try {
                fechaInicio = LocalDate.parse(fechaInicioStr, formato);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }

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
        int contadorHoteles = 0;
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadesDisponibles[ciudadSeleccionada]) && tipoAlojamiento[i].equals(tiposDisponibles[tipoSeleccionado])) {
                contadorHoteles++;
                System.out.println(contadorHoteles + ". Hotel: " + hotelNombres[i]);
                System.out.println("  Calificación: " + calificaciones[i]);
                System.out.println("  Precio base: " + precios[i]);
            }
        }

        if (contadorHoteles > 0) {
            System.out.println((contadorHoteles + 1) + ". Salir");
            System.out.print("\nSeleccione un hotel para ver las habitaciones/servicios (ingrese el número): ");
            int opcionHotel = scanner.nextInt();
            scanner.nextLine();

            if (opcionHotel > 0 && opcionHotel <= contadorHoteles) {
                int hotelSeleccionado = opcionHotel - 1;

                System.out.println("\n--- Habitaciones/servicios disponibles en " + hotelNombres[hotelSeleccionado] + " ---");
                int contadorOpciones = 0;
                for (int j = 0; j < habitacionHotelID.length; j++) {
                    if (habitacionHotelID[j] == hotelSeleccionado && habitacionTipos[j] != null) {
                        contadorOpciones++;
                        System.out.print(contadorOpciones + ". " + habitacionTipos[j] + ": ");
                        System.out.println("Características: " + habitacionCaracteristicas[j]);
                        System.out.println("  Precio: " + habitacionPrecios[j]);
                    }
                }

                if (contadorOpciones > 0) {
                    System.out.print("\nSeleccione una habitación/servicio (ingrese el número): ");
                    int opcionHabitacion = scanner.nextInt();
                    scanner.nextLine();

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
                        double[] precioTotalConDescuentoYAumento = calcularPrecioTotal(precioHabitacion, cantidadHabitaciones, fechaInicio, fechaFin);
                        double precioTotal = precioTotalConDescuentoYAumento[0];
                        double descuento = precioTotalConDescuentoYAumento[1];
                        double aumento = precioTotalConDescuentoYAumento[2];

                        System.out.println("\n--- Usted ha seleccionado ---");
                        System.out.println("Hotel: " + hotelNombres[hotelSeleccionado]);
                        System.out.println("Habitación: " + habitacionTipos[habitacionSeleccionada] + "(" + habitacionCaracteristicas[habitacionSeleccionada] + ")");
                        System.out.println("Cantidad de habitaciones: " + cantidadHabitaciones);
                        System.out.println("Precio por noche: $" + precioHabitacion);
                        if (descuento > 0) {
                            System.out.println("Descuento aplicado: $" + Math.round(descuento));
                        }
                        if (aumento > 0) {
                            System.out.println("Aumento aplicado por alta demanda: $" + Math.round(aumento));
                        }
                        System.out.println("\nPrecio total: $" + Math.round(precioTotal));

                        System.out.print("\n¿Desea iniciar la reserva? (s/n): ");
                        String respuesta = scanner.nextLine();
                        if (respuesta.equalsIgnoreCase("s")) {
                            System.out.println("\n--- Iniciando reserva en " + hotelNombres[hotelSeleccionado] + " ---");
                            System.out.print("Ingrese su nombre: ");
                            String nombreUsuario = scanner.nextLine();
                            System.out.print("Ingrese su apellido: ");
                            String apellidoUsuario = scanner.nextLine();
                            System.out.print("Ingrese su email: ");
                            String emailUsuario = scanner.nextLine();
                            System.out.print("Ingrese su nacionalidad: ");
                            String nacionalidadUsuario = scanner.nextLine();
                            System.out.print("Ingrese su número de teléfono: ");
                            String telefonoUsuario = scanner.nextLine();
                            System.out.print("Ingrese su hora aproximada de llegada: ");
                            String horaLlegadaUsuario = scanner.nextLine();

                            System.out.println("\n--- Resumen de la reserva ---");
                            System.out.println("Hotel: " + hotelNombres[hotelSeleccionado]);
                            System.out.println("Habitación: " + habitacionTipos[habitacionSeleccionada]);
                            System.out.println("Características: " + habitacionCaracteristicas[habitacionSeleccionada]);
                            System.out.println("Precio por noche: " + precioHabitacion);
                            System.out.println("Cantidad de habitaciones: " + cantidadHabitaciones);
                            System.out.println("Fecha de inicio: " + fechaInicio.format(formato));
                            System.out.println("Fecha de fin: " + fechaFin.format(formato));
                            System.out.println("Precio total: " + Math.round(precioTotal));
                            if (descuento > 0) {
                                System.out.println("Descuento: -" + Math.round(descuento));
                            }
                            if (aumento > 0) {
                                System.out.println("Aumento: +" + Math.round(aumento));
                            }
                            System.out.println("Nombre: " + nombreUsuario);
                            System.out.println("Apellido: " + apellidoUsuario);
                            System.out.println("Email: " + emailUsuario);
                            System.out.println("Nacionalidad: " + nacionalidadUsuario);
                            System.out.println("Teléfono: " + telefonoUsuario);
                            System.out.println("Hora de llegada: " + horaLlegadaUsuario);

                            System.out.print("\n¿Desea confirmar la reserva? (s/n): ");
                            respuesta = scanner.nextLine();
                            if (respuesta.equalsIgnoreCase("s")) {
                                crearReserva(hotelSeleccionado, habitacionSeleccionada, fechaInicio, fechaFin, cantidadHabitaciones, nombreUsuario, apellidoUsuario, emailUsuario, nacionalidadUsuario, telefonoUsuario, horaLlegadaUsuario);
                            }
                        } else {
                            System.out.println("Reserva cancelada.");
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

    public static void crearReserva(int hotelId, int habitacionId, LocalDate fechaInicio, LocalDate fechaFin, int cantidadHabitaciones, String nombre, String apellido, String email, String nacionalidad, String telefono, String horaLlegada) {
        System.out.println("\n--- Crear Reserva ---");

        reservaID[contadorReservas] = contadorReservas;
        reservaHotelID[contadorReservas] = hotelId;
        reservaHabitacionID[contadorReservas] = habitacionId;
        reservaUsuario[contadorReservas] = nombre + " " + apellido;
        reservaFechas[contadorReservas][0] = fechaInicio;
        reservaFechas[contadorReservas][1] = fechaFin;
        contadorReservas++;

        int tipoHabitacion = obtenerTipoHabitacion(habitacionId);
        habitacionesDisponibles[hotelId][tipoHabitacion] -= cantidadHabitaciones;

        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
            habitacionDisponibilidad[habitacionId][fecha.getYear() - 2024][fecha.getDayOfYear() - 1] = false;
        }

        System.out.println("Se ha realizado la reserva con éxito.");
    }

    public static double[] aplicarAumentosYDescuentos(double precioTotal, LocalDate fechaInicio, LocalDate fechaFin) {
        double descuento = 0;
        double aumento = 0;

        if (fechaInicio.getDayOfMonth() >= 26 && fechaInicio.getMonth() == fechaFin.getMonth() && fechaInicio.getYear() == fechaFin.getYear()) {
            aumento = precioTotal * 0.15;
            precioTotal *= 1.15;
        } else if (fechaInicio.getDayOfMonth() >= 10 && fechaFin.getDayOfMonth() <= 15 && fechaInicio.getMonth() == fechaFin.getMonth() && fechaInicio.getYear() == fechaFin.getYear()) {
            aumento = precioTotal * 0.10;
            precioTotal *= 1.10;
        } else if (fechaInicio.getMonthValue() == 1 && fechaInicio.getDayOfMonth() >= 5 && fechaFin.getDayOfMonth() <= 10) {
            descuento = precioTotal * 0.10;
            precioTotal *= 0.90;
        }

        return new double[]{precioTotal, descuento, aumento};
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

    public static void actualizarReserva(Scanner scanner) {
        // Implementa la lógica para actualizar una reserva
    }

    public static void cancelarReserva(Scanner scanner) {
        // Implementa la lógica para cancelar una reserva
    }

    public static double[] calcularPrecioTotal(double precioHabitacion, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        long diasEstadia = ChronoUnit.DAYS.between(fechaInicio, fechaFin) + 1;
        double precioTotal = precioHabitacion * cantidadHabitaciones * diasEstadia;
        double[] resultados = aplicarAumentosYDescuentos(precioTotal, fechaInicio, fechaFin);
        return new double[]{resultados[0], resultados[1], resultados[2]};
    }

    public static int obtenerTipoHabitacion(int habitacionId) {
        return switch (habitacionTipos[habitacionId]) {
            case "Single" -> 0;
            case "Double" -> 1;
            case "Suite" -> 2;
            case "Activities" -> 3;
            default -> -1;
        };
    }
}