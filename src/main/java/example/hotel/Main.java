package example.hotel;

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
    static String[][] reservaFechas = new String[100][2];
    static int contadorReservas = 0;

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
                        buscarHoteles(scanner, hotelNombres, tipoAlojamiento, ciudades, calificaciones, habitacionHotelID, habitacionTipos, habitacionCaracteristicas, habitacionPrecios);
                case 2 -> actualizarReserva(scanner);
                case 3 -> cancelarReserva(scanner);
                case 4 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida");
            }
        } while (option != 4);
    }

    public static void buscarHoteles(Scanner scanner, String[] hotelNombres, String[] tipoAlojamiento, String[] ciudades, int[] calificaciones, int[] habitacionHotelID, String[] habitacionTipos, String[] habitacionCaracteristicas, double[] habitacionPrecios) {
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
        System.out.print("Ingrese la fecha de inicio (DD/MM/YYYY): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (DD/MM/YYYY): ");
        String fechaFin = scanner.nextLine();

        System.out.println("\n--- Hoteles disponibles ---");
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadesDisponibles[ciudadSeleccionada]) && tipoAlojamiento[i].equals(tiposDisponibles[tipoSeleccionado])) {

                // Calcular precio total de la estadía
                double precioBase = precios[i]; // Obtener el precio base del array precios
                int diasEstadia = calcularDiasEstadia(fechaInicio, fechaFin);
                double precioTotal = precioBase * cantidadHabitaciones * diasEstadia;

                // Aplicar aumentos y descuentos
                precioTotal = aplicarAumentosYDescuentos(precioTotal, fechaInicio, fechaFin);

                System.out.println("Hotel: " + hotelNombres[i]);
                System.out.println("  Calificación: " + calificaciones[i]);
                System.out.println("  Precio por noche: " + precioBase);
                System.out.println("  Precio total: " + precioTotal);
                System.out.println("--------------------");
            }
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

    public static double aplicarAumentosYDescuentos(double precioTotal, String fechaInicio, String fechaFin) {
        // Ejemplo de lógica: aplicar un aumento del 10% si es temporada alta (diciembre-enero)
        String[] inicio = fechaInicio.split("/");
        String[] fin = fechaFin.split("/");

        int mesInicio = Integer.parseInt(inicio[1]);
        int mesFin = Integer.parseInt(fin[1]);

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

    // TODO: Implementar la función habitacionDisponible
    public static boolean habitacionDisponible(int habitacionId, String fechaInicio, String fechaFin) {
        // Implementa la lógica para verificar la disponibilidad de una habitación
        return false;
    }
}
