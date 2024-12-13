package org.example;


import java.util.*;


public class Main {
    static ArrayList<String> ciudades = new ArrayList<>();
    static ArrayList<String> tipoAlojamientos = new ArrayList<>();
    //alojamientos
    static List<Map<String, Object>> alojamientos = Arrays.asList(
            // Hoteles
            Map.of(
                    "nombre", "Hotel Paraíso",
                    "ciudad", "Cartagena",
                    "tipoAlojamiento", "Hotel",
                    "calificacion", 5,
                    "precioPorNoche", 200000

            ),
            Map.of(
                    "nombre", "Hotel Real",
                    "ciudad", "Bogotá",
                    "tipoAlojamiento", "Hotel",
                    "calificacion", 4,
                    "precioPorNoche", 180000
            ),
            // Apartamentos
            Map.of(
                    "nombre", "Apartamento Luna",
                    "ciudad", "Medellín",
                    "tipoAlojamiento", "Apartamento",
                    "calificacion", 4,
                    "precioPorNoche", 150000
            ),
            Map.of(
                    "nombre", "Apartamento Sol",
                    "ciudad", "Bogotá",
                    "tipoAlojamiento", "Apartamento",
                    "calificacion", 5,
                    "precioPorNoche", 180000
            ),
            // Fincas
            Map.of(
                    "nombre", "Finca El Encanto",
                    "ciudad", "Cartagena",
                    "tipoAlojamiento", "Finca",
                    "calificacion", 5,
                    "precioPorNoche", 250000
            ),
            Map.of(
                    "nombre", "Finca La Montaña",
                    "ciudad", "Medellín",
                    "tipoAlojamiento", "Finca",
                    "calificacion", 4,
                    "precioPorNoche", 220000
            )

    );


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione la ciudad donde le gustaria hospedarse");
            ciudadesEncontradas();
            int opcionCiudad = scanner.nextInt();
            if (opcionCiudad >= 1 && opcionCiudad <= ciudades.size()) {
                System.out.println("Ha seleccionado la ciudad: " + ciudades.get(opcionCiudad - 1));
                tiposAlojamientoEncontradas();
                int opcionTipoAlojamiento = scanner.nextInt();

                break;
            } else {
                System.out.println("Opción no válida. Inténtelo de nuevo. Escriba un numero entre :" + 1 + "-" + ciudades.size());
            }
        }
    }

    public static void buscarAlojamientos(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
                                          int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {


    }

    public static void ciudadesEncontradas() {
        for (Map<String, Object> alojamiento : alojamientos) {
            if (!ciudades.contains((String) alojamiento.get("ciudad"))) {
                ciudades.add((String) alojamiento.get("ciudad"));
            }
        }
        int contador = 1;
        for (String ciudad : ciudades) {
            System.out.println(contador + ". " + ciudad);
            contador++;
        }
    }

    public static void tiposAlojamientoEncontradas() {
        for (Map<String, Object> alojamiento : alojamientos) {
            if (!tipoAlojamientos.contains((String) alojamiento.get("tipoAlojamiento"))) {
                tipoAlojamientos.add((String) alojamiento.get("tipoAlojamiento"));
            }
        }
        int contador = 1;
        for (String tipoAlojamiento : tipoAlojamientos) {
            System.out.println(contador + ". " + tipoAlojamiento);
            contador++;
        }
    }

    public static List<Map<String, Object>> filtrarPorCiudad(String ciudad) {
        List<Map<String, Object>> result = new ArrayList<>();
        int contador = 1;
        for (Map<String, Object> alojamiento : alojamientos) {
            // Comprobamos si el alojamiento está en la ciudad buscada
            if (alojamiento.get("ciudad").equals(ciudad)) {
                result.add(alojamiento);

                System.out.println(contador + ". " + alojamiento.get("nombre"));
                contador++;
            }
        }

        return result;
    }


}