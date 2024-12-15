package example.hotel;

import java.util.Scanner;

public class Main {
    // Hoteles
    static String[] hotelNombres = new String[100];
    static String[] tipoAlojamiento = new String[100];
    static String[] ciudades = new String[100];
    static int[] calificaciones = new int[100];
    static double[] precios = new double[100];
    static String[][] hotelFechasDisponibles = new String[100][2];

    // Habitaciones
    static int[] habitacionHotelID = new int[500];
    static String[] habitacionTipos = new String[500];
    static String[] habitacionCaracteristicas = new String[500];
    static double[] habitacionPrecios = new double[500];

    // Reservas
    static int[] reservaID = new int[100];
    static int[] reservaHotelID = new int[100];
    static int[] reservaHabitacionID = new int[100];
    static String[] reservaUsuario = new String[100];
    static String[][] reservaFechas = new String[100][2];

    public static void main(String[] args) {
        hotelNombres[0] = "Hotel Buenos Aires";
        tipoAlojamiento[0] = "Hotel";
        ciudades[0] = "Buenos Aires";
        calificaciones[0] = 4;
        precios[0] = 100;
        hotelFechasDisponibles[0] = new String[]{"2024-12-01", "2024-12-10"};

        hotelNombres[1] = "Hotel Mar del Plata";
        tipoAlojamiento[1] = "Hotel";
        ciudades[1] = "Mar del Plata";
        calificaciones[1] = 3;
        precios[1] = 80;
        hotelFechasDisponibles[1] = new String[]{"2024-12-05", "2024-12-15"};

        hotelNombres[2] = "Apartamento Cordoba";
        tipoAlojamiento[2] = "Apartamento";
        ciudades[2] = "Cordoba";
        calificaciones[2] = 2;
        precios[2] = 50;
        hotelFechasDisponibles[2] = new String[]{"2024-12-20", "2024-12-30"};

        hotelNombres[3] = "Finca Rosario";
        tipoAlojamiento[3] = "Finca";
        ciudades[3] = "Rosario";
        calificaciones[3] = 5;
        precios[3] = 150;
        hotelFechasDisponibles[3] = new String[]{"2024-12-01", "2024-12-10"};

        hotelNombres[4] = "Dia de Sol Buenos Aires";
        tipoAlojamiento[4] = "Dia de Sol";
        ciudades[4] = "Buenos Aires";
        calificaciones[4] = 4;
        precios[4] = 120;
        hotelFechasDisponibles[4] = new String[]{"2024-12-05", "2024-12-15"};

        hotelNombres[5] = "Dia de Sol Mar del Plata";
        tipoAlojamiento[5] = "Dia de Sol";
        ciudades[5] = "Mar del Plata";
        calificaciones[5] = 3;
        precios[5] = 100;
        hotelFechasDisponibles[5] = new String[]{"2024-12-20", "2024-12-30"};

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

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> buscarHoteles(scanner, hotelNombres, tipoAlojamiento, ciudades, hotelFechasDisponibles);
                case 2 -> System.out.println("Actualizar una reserva");
                case 3 -> System.out.println("Cancelar una reserva");
                case 4 -> System.out.println("Salir");
                default -> {
                    System.out.println("Opción inválida");
                }
            }
        } while (option != 4);
    }

    public static void buscarHoteles(Scanner scanner, String[] hotelNombres, String[] tipoAlojamiento, String[]
            ciudades, String[][] hotelFechasDisponibles) {
        System.out.println("\n--- Búsqueda de Hoteles ---");

        String[] ciudadesDisponibles = obtenerValoresUnicos(ciudades);
        System.out.println("\nCiudades disponibles:");
        for (int i = 0; i < ciudadesDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + ciudadesDisponibles[i]);
        }
        System.out.print("Seleccione una ciudad (ingrese el número): ");
        int ciudadSeleccionada = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir la nueva línea

        // Obtener tipos de alojamiento disponibles
        String[] tiposDisponibles = obtenerValoresUnicos(tipoAlojamiento);
        System.out.println("\nTipos de alojamiento disponibles:");
        for (int i = 0; i < tiposDisponibles.length; i++) {
            System.out.println((i + 1) + ". " + tiposDisponibles[i]);
        }
        System.out.print("Seleccione un tipo de alojamiento (ingrese el número): ");
        int tipoSeleccionado = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir la nueva línea

        System.out.print("Ingrese la fecha de inicio (YYYY-MM-DD): ");
        String fechaInicio = scanner.nextLine();
        System.out.print("Ingrese la fecha de fin (YYYY-MM-DD): ");
        String fechaFin = scanner.nextLine();

        System.out.println("\n--- Resultados de la búsqueda ---");
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadesDisponibles[ciudadSeleccionada]) &&
                    tipoAlojamiento[i].equals(tiposDisponibles[tipoSeleccionado]) &&
                    hotelFechasDisponibles[i][0].compareTo(fechaInicio) <= 0 &&
                    hotelFechasDisponibles[i][1].compareTo(fechaFin) >= 0) {

                System.out.println("Hotel encontrado:");
                System.out.println("  Nombre: " + hotelNombres[i]);
                System.out.println("  Tipo: " + tipoAlojamiento[i]);
                System.out.println("  Ciudad: " + ciudades[i]);
                System.out.println("  Fechas disponibles: " + hotelFechasDisponibles[i][0] + " - " + hotelFechasDisponibles[i][1]);
                System.out.println("--------------------");
            }
        }
    }

    public static String[] obtenerValoresUnicos(String[] arr) {
        String[] unicos = new String[arr.length];
        int contador = 0;
        for (String s : arr) {
            if (s != null && !estaEnArreglo(unicos, s)) {
                unicos[contador++] = s;
            }
        }
        String[] resultado = new String[contador];
        System.arraycopy(unicos, 0, resultado, 0, contador);
        return resultado;
    }

    public static boolean estaEnArreglo(String[] arr, String valor) {
        for (String s : arr) {
            if (s != null && s.equals(valor)) {
                return true;
            }
        }
        return false;
    }
}
