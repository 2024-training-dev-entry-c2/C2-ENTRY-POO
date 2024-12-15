package example.hotel;

public class Main {
    public static void main(String[] args) {
        // hoteles
        String hotelNombres[] = {"Hotel Buenos Aires", "Hotel Mar del Plata", "Apartamento Cordoba", "Finca Rosario", "Dia de Sol Buenos Aires", "Dia de Sol Mar del Plata"};
        String tipoAlojamiento[] = {"Hotel", "Hotel", "Apartamento", "Finca", "Dia de Sol", "Dia de Sol"};
        String ciudades[] = {"Buenos Aires", "Mar del Plata", "Cordoba", "Rosario", "Buenos Aires", "Mar del Plata"};
        int[] calificaciones = {4, 3, 2, 5, 4, 3};
        double precios[] = {100, 80, 50, 150, 120, 100};
        String[][] hotelFechasDisponibles = {
                {"2024-12-01", "2024-12-10"},
                {"2024-12-05", "2024-12-15"},
                {"2024-12-20", "2024-12-30"},
                {"2024-12-01", "2024-12-10"},
                {"2024-12-05", "2024-12-15"},
                {"2024-12-20", "2024-12-30"}
        };

        // habitaciones
        int[] habitacionHotelID = {0, 0, 1, 2, 2, 3, 4, 5};
        String[] habitacionTipos = {"Single", "Double", "Suite", "Single", "Activities", "Activities"};
        String[] habitacionCaracteristicas = {
                "2 camas simples, aire acondicionado, WiFi",
                "1 cama doble, aire acondicionado, TV",
                "1 cama king size, jacuzzi, TV de pantalla plana",
                "2 camas simples, desayuno incluido, WiFi",
                "Piscina, parque, almuerzo incluido",
                "Juegos, spa, refrigerio incluido"
        };
        double[] habitacionPrecios = {50.0, 75.0, 120.0, 55.0, 150.0, 100.0};

        // reservas
        int[] reservaID = new int[100];
        int[] reservaHotelID = new int[100];
        int[] reservaHabitacionID = new int[100];
        String[] reservaUsuario = new String[100];
        String[][] reservaFechas = new String[100][2];

    }
}