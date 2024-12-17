package org.example;

import org.example.modelos.Hotel;
import org.example.modelos.Reserva;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Datos iniciales de hoteles
        Hotel[] hoteles = {
                new Hotel("Hotel Sol", "Cartagena", 4.5f, 200000, true, "Natación, Paseos en bote", true, false),
                new Hotel("Hotel Luna", "Medellín", 5.0f, 350000, false, "Spa, Caminatas", false, true)
        };

        int opcion;
        do {
            System.out.println("\n¡Bienvenido a Booking Hoteles!");
            System.out.println("1. Buscar hoteles");
            System.out.println("2. Realizar una reserva");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    buscarHoteles(scanner, hoteles);
                    break;
                case 2:
                    realizarReserva(scanner, hoteles);
                    break;
                case 3:
                    System.out.println("¡Gracias por usar Booking Hoteles!");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 3);
        scanner.close();
    }

    // Método para buscar hoteles
    public static void buscarHoteles(Scanner scanner, String[] nombres, String[] ciudades, float[] calificaciones,
                                     double[] preciosPorNoche, boolean[] diaDeSol, String[] actividades,
                                     boolean[] incluyeAlmuerzo, boolean[] incluyeRefrigerio,
                                     String[][] habitacionesTipos, String[][] habitacionesDescripciones,
                                     double[][] habitacionesPrecios, int[][] habitacionesDisponibles) {
        try {
            // Entrada de ciudad
            System.out.print("Ingrese la ciudad (deje en blanco para omitir): ");
            scanner.nextLine(); // Limpia el buffer
            String ciudad = scanner.nextLine().trim();

            // Día de sol (opcional)
            System.out.print("¿Desea Día de Sol? (true/false, deje en blanco para omitir): ");
            String diaDeSolInput = scanner.nextLine().trim();
            Boolean filtrarDiaDeSol = diaDeSolInput.isEmpty() ? null : Boolean.parseBoolean(diaDeSolInput);

            // Fechas de hospedaje (opcional)
            LocalDate inicio = null, fin = null;
            System.out.print("Fecha de inicio (YYYY-MM-DD, deje en blanco para omitir): ");
            String inicioInput = scanner.nextLine().trim();
            if (!inicioInput.isEmpty()) {
                System.out.print("Fecha de fin (YYYY-MM-DD): ");
                String finInput = scanner.nextLine().trim();
                inicio = LocalDate.parse(inicioInput);
                fin = LocalDate.parse(finInput);

                if (inicio.isAfter(fin)) {
                    System.out.println("Error: La fecha de inicio no puede ser posterior a la fecha de fin.");
                    return;
                }
            }

            // Cantidad de habitaciones (opcional)
            System.out.print("Cantidad de habitaciones (deje en blanco para omitir): ");
            String cantidadInput = scanner.nextLine().trim();
            int cantidadHabitaciones = cantidadInput.isEmpty() ? 0 : Integer.parseInt(cantidadInput);

            // Filtrado y búsqueda
            System.out.println("\nHoteles disponibles:");
            boolean hotelesEncontrados = false;

            for (int i = 0; i < nombres.length; i++) {
                boolean cumpleCiudad = ciudad.isEmpty() || ciudades[i].equalsIgnoreCase(ciudad);
                boolean cumpleDiaDeSol = (filtrarDiaDeSol == null) || diaDeSol[i] == filtrarDiaDeSol;

                if (cumpleCiudad && cumpleDiaDeSol) {
                    System.out.printf("\nHotel: %s\n", nombres[i]);
                    System.out.printf("Ciudad: %s, Calificación: %.1f, Precio por noche: %.2f\n", ciudades[i], calificaciones[i], preciosPorNoche[i]);
                    System.out.printf("Actividades: %s, Almuerzo incluido: %b, Refrigerio incluido: %b\n", actividades[i], incluyeAlmuerzo[i], incluyeRefrigerio[i]);

                    // Mostrar tipos de habitaciones disponibles
                    System.out.println("Habitaciones disponibles:");
                    boolean habitacionDisponible = false;

                    for (int j = 0; j < habitacionesTipos[i].length; j++) {
                        if (cantidadHabitaciones == 0 || habitacionesDisponibles[i][j] >= cantidadHabitaciones) {
                            habitacionDisponible = true;

                            System.out.printf("- %s: %s, Precio: %.2f, Disponibles: %d\n",
                                    habitacionesTipos[i][j], habitacionesDescripciones[i][j],
                                    habitacionesPrecios[i][j], habitacionesDisponibles[i][j]);
                        }
                    }

                    if (!habitacionDisponible) {
                        System.out.println("No hay habitaciones disponibles que coincidan con la cantidad solicitada.");
                    }

                    hotelesEncontrados = true;
                }
            }

            if (!hotelesEncontrados) {
                System.out.println("No se encontraron hoteles que cumplan con los parámetros.");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    // Método para realizar reservas
    public static void realizarReserva(Scanner scanner, Hotel[] hoteles) {
        System.out.println("Seleccione un hotel para reservar:");
        for (int i = 0; i < hoteles.length; i++) {
            System.out.printf("%d. %s (%s)%n", i + 1, hoteles[i].getNombre(), hoteles[i].getCiudad());
        }

        System.out.print("Ingrese el número del hotel: ");
        int hotelIndex = scanner.nextInt() - 1;
        if (hotelIndex < 0 || hotelIndex >= hoteles.length) {
            System.out.println("Hotel no válido.");
            return;
        }

        scanner.nextLine(); // Limpia el buffer
        System.out.print("Ingrese su nombre: ");
        String cliente = scanner.nextLine();

        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        LocalDate fechaInicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        LocalDate fechaFin = LocalDate.parse(scanner.nextLine());

        if (fechaInicio.isAfter(fechaFin)) {
            System.out.println("Error: La fecha de inicio no puede ser posterior a la fecha de fin.");
            return;
        }

        System.out.print("Cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();

        Reserva reserva = new Reserva(hoteles[hotelIndex]);
        reserva.reservar(cliente, cantidadHabitaciones, fechaInicio, fechaFin);
    }
}
