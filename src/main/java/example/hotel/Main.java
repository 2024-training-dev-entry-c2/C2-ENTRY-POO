package example.hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hoteles
        String[] hotelNombres = new String[100];
        String[] tipoAlojamiento = new String[100];
        String[] ciudades = new String[100];
        int[] calificaciones = new int[100];
        double[] precios = new double[100];
        String[][] hotelFechasDisponibles = new String[100][2];

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

        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a HotelApp!");
        showMenu(scanner);

        // Habitaciones
        int[] habitacionHotelID = new int[500];
        String[] habitacionTipos = new String[500];
        String[] habitacionCaracteristicas = new String[500];
        double[] habitacionPrecios = new double[500];

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

        // Reservas
        int[] reservaID = new int[100];
        int[] reservaHotelID = new int[100];
        int[] reservaHabitacionID = new int[100];
        String[] reservaUsuario = new String[100];
        String[][] reservaFechas = new String[100][2];
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
                case 1 -> System.out.println("Realizar una reserva");
                case 2 -> System.out.println("Actualizar una reserva");
                case 3 -> System.out.println("Cancelar una reserva");
                case 4 -> System.out.println("Salir");
                default -> {
                    System.out.println("Opción inválida");
                }

            }
        } while (option != 4);
    }


}