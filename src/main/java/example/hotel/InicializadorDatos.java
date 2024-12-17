package example.hotel;

import java.util.ArrayList;
import java.util.List;

public class InicializadorDatos {

    public static ArrayList<Alojamiento> inicializarAlojamientos() {
        ArrayList<Alojamiento> alojamientos = new ArrayList<>();

        ArrayList<Habitacion> habitacionesHotel = new ArrayList<>();
        habitacionesHotel.add(new Habitacion("Single", "2 camas simples, aire acondicionado, WiFi", 50.0));
        habitacionesHotel.add(new Habitacion("Double", "1 cama doble, aire acondicionado, TV", 75.0));
        habitacionesHotel.add(new Habitacion("Suite", "1 cama king size, jacuzzi, TV de pantalla plana", 120.0));
        habitacionesHotel.add(new Habitacion("Twin", "2 camas, aire acondicionado, TV", 60.0));
        habitacionesHotel.add(new Habitacion("Triple", "3 camas, aire acondicionado, WiFi", 80.0));

        ArrayList<Habitacion> habitacionesApartamento = new ArrayList<>(habitacionesHotel);
        ArrayList<Habitacion> habitacionesFinca = new ArrayList<>(habitacionesHotel);

        ArrayList<String> actividadesDiaDeSol = new ArrayList<>();
        actividadesDiaDeSol.add("Piscina");
        actividadesDiaDeSol.add("Parque");
        actividadesDiaDeSol.add("Almuerzo incluido");
        actividadesDiaDeSol.add("Juegos");
        actividadesDiaDeSol.add("Spa");

        // Alojamientos en Buenos Aires
        alojamientos.add(new Hotel("Hotel Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), habitacionesHotel));
        alojamientos.add(new Apartamento("Apartamento Buenos Aires", "Buenos Aires", 3, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), habitacionesApartamento));
        alojamientos.add(new Finca("Finca Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("05/12/2024", "15/12/2024")), habitacionesFinca));
        alojamientos.add(new DiaDeSol("Día de Sol Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("05/12/2024", "15/12/2024")), actividadesDiaDeSol));

        // Alojamientos en Mar del Plata
        alojamientos.add(new Hotel("Hotel Mar del Plata", "Mar del Plata", 3, new ArrayList<>(List.of("05/12/2024", "15/12/2024")), habitacionesHotel));
        alojamientos.add(new Apartamento("Apartamento Mar del Plata", "Mar del Plata", 2, new ArrayList<>(List.of("05/12/2024", "15/12/2024")), habitacionesApartamento));
        alojamientos.add(new Finca("Finca Mar del Plata", "Mar del Plata", 3, new ArrayList<>(List.of("05/12/2024", "15/12/2024")), habitacionesFinca));
        alojamientos.add(new DiaDeSol("Día de Sol Mar del Plata", "Mar del Plata", 3, new ArrayList<>(List.of("20/12/2024", "30/12/2024")), actividadesDiaDeSol));

        // Alojamientos en Cordoba
        alojamientos.add(new Hotel("Hotel Cordoba", "Cordoba", 3, new ArrayList<>(List.of("20/12/2024", "30/12/2024")), habitacionesHotel));
        alojamientos.add(new Apartamento("Apartamento Cordoba", "Cordoba", 2, new ArrayList<>(List.of("20/12/2024", "30/12/2024")), habitacionesApartamento));
        alojamientos.add(new Finca("Finca Cordoba", "Cordoba", 3, new ArrayList<>(List.of("20/12/2024", "30/12/2024")), habitacionesFinca));
        alojamientos.add(new DiaDeSol("Día de Sol Cordoba", "Cordoba", 3, new ArrayList<>(List.of("20/12/2024", "30/12/2024")), actividadesDiaDeSol));

        // Alojamientos en Rosario
        alojamientos.add(new Hotel("Hotel Rosario", "Rosario", 4, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), habitacionesHotel));
        alojamientos.add(new Apartamento("Apartamento Rosario", "Rosario", 3, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), habitacionesApartamento));
        alojamientos.add(new Finca("Finca Rosario", "Rosario", 5, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), habitacionesFinca));
        alojamientos.add(new DiaDeSol("Día de Sol Rosario", "Rosario", 4, new ArrayList<>(List.of("01/12/2024", "10/12/2024")), actividadesDiaDeSol));

        return alojamientos;
    }
}
