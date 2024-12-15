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
    }
}