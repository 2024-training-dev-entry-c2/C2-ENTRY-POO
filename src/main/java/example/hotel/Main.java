package example.hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Alojamiento> alojamientos = inicializarAlojamientos();
        ArrayList<Reserva> reservas = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Realizar reserva");
            System.out.println("2. Actualizar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            if (opcion == 1) {
                realizarReserva(alojamientos, reservas, scanner);
            } else if (opcion == 2) {
                actualizarReserva(reservas, scanner);
            } else if (opcion == 3) {
                cancelarReserva(reservas, scanner);
            } else if (opcion == 4) {
                break;
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static ArrayList<Alojamiento> inicializarAlojamientos() {
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

        alojamientos.add(new Hotel("Hotel Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("2024-12-01", "2024-12-10")), habitacionesHotel));
        alojamientos.add(new Hotel("Hotel Mar del Plata", "Mar del Plata", 3, new ArrayList<>(List.of("2024-12-05", "2024-12-15")), habitacionesHotel));
        alojamientos.add(new Apartamento("Apartamento Cordoba", "Cordoba", 2, new ArrayList<>(List.of("2024-12-20", "2024-12-30")), habitacionesApartamento));
        alojamientos.add(new Apartamento("Apartamento Rosario", "Rosario", 3, new ArrayList<>(List.of("2024-12-01", "2024-12-10")), habitacionesApartamento));
        alojamientos.add(new Finca("Finca Rosario", "Rosario", 5, new ArrayList<>(List.of("2024-12-01", "2024-12-10")), habitacionesFinca));
        alojamientos.add(new Finca("Finca Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("2024-12-05", "2024-12-15")), habitacionesFinca));
        alojamientos.add(new DiaDeSol("Dia de Sol Buenos Aires", "Buenos Aires", 4, new ArrayList<>(List.of("2024-12-05", "2024-12-15")), actividadesDiaDeSol));
        alojamientos.add(new DiaDeSol("Dia de Sol Mar del Plata", "Mar del Plata", 3, new ArrayList<>(List.of("2024-12-20", "2024-12-30")), actividadesDiaDeSol));

        return alojamientos;
    }

    private static void realizarReserva(ArrayList<Alojamiento> alojamientos, ArrayList<Reserva> reservas, Scanner scanner) {
        System.out.println("Ciudades disponibles:");
        ArrayList<String> ciudades = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.getCiudad())) {
                ciudades.add(alojamiento.getCiudad());
            }
        }
        for (int i = 0; i < ciudades.size(); i++) {
            System.out.println((i + 1) + ". " + ciudades.get(i));
        }
        System.out.println("Seleccione una ciudad:");
        int ciudadIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir nueva línea
        String ciudadSeleccionada = ciudades.get(ciudadIndex);

        System.out.println("Tipos de alojamiento disponibles:");
        ArrayList<String> tiposAlojamiento = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equals(ciudadSeleccionada) && !tiposAlojamiento.contains(alojamiento.getClass().getSimpleName())) {
                tiposAlojamiento.add(alojamiento.getClass().getSimpleName());
            }
        }
        for (int i = 0; i < tiposAlojamiento.size(); i++) {
            System.out.println((i + 1) + ". " + tiposAlojamiento.get(i));
        }
        System.out.println("Seleccione un tipo de alojamiento:");
        int tipoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir nueva línea
        String tipoSeleccionado = tiposAlojamiento.get(tipoIndex);

        System.out.println("Ingrese la cantidad de adultos:");
        int cantidadAdultos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de niños:");
        int cantidadNinos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de habitaciones:");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine();  // Consumir nueva línea

        System.out.println("Ingrese el día de inicio del hospedaje (YYYY-MM-DD):");
        String fechaInicio = scanner.nextLine();

        System.out.println("Ingrese el día de finalización del hospedaje (YYYY-MM-DD):");
        String fechaFin = scanner.nextLine();

        ArrayList<Alojamiento> alojamientosDisponibles = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudadSeleccionada) && alojamiento.getClass().getSimpleName().equalsIgnoreCase(tipoSeleccionado)) {
                alojamientosDisponibles.add(alojamiento);
            }
        }

        System.out.println("Alojamientos disponibles:");
        for (int i = 0; i < alojamientosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + alojamientosDisponibles.get(i).getNombre() + " - " + alojamientosDisponibles.get(i).getCalificacion() + " estrellas - " + calcularPrecioBase(alojamientosDisponibles.get(i)) + " USD por noche");
        }
        System.out.println("Seleccione un alojamiento:");
        int alojamientoIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir nueva línea
        Alojamiento alojamientoSeleccionado = alojamientosDisponibles.get(alojamientoIndex);

        System.out.println("Habitaciones disponibles:");
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        if (alojamientoSeleccionado instanceof Hotel) {
            habitaciones = ((Hotel) alojamientoSeleccionado).getHabitaciones();
        } else if (alojamientoSeleccionado instanceof Apartamento) {
            habitaciones = ((Apartamento) alojamientoSeleccionado).getHabitaciones();
        } else if (alojamientoSeleccionado instanceof Finca) {
            habitaciones = ((Finca) alojamientoSeleccionado).getHabitaciones();
        } else if (alojamientoSeleccionado instanceof DiaDeSol) {
            for (String actividad : ((DiaDeSol) alojamientoSeleccionado).getActividades()) {
                habitaciones.add(new Habitacion(actividad, "", 0));
            }
        }
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". " + habitaciones.get(i).getTipo() + " - " + habitaciones.get(i).getPrecio() + " USD por noche");
        }
        System.out.println("Seleccione una habitación:");
        int habitacionIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consumir nueva línea
        Habitacion habitacionSeleccionada = habitaciones.get(habitacionIndex);

        // Calcular precios y mostrar resumen
        double precioTotal = habitacionSeleccionada.getPrecio() * cantidadHabitaciones;
        double aumentoODescuento = calcularAumentoODescuento(alojamientoSeleccionado, fechaInicio, fechaFin);
        double precioFinal = precioTotal + aumentoODescuento;

        System.out.println("Resumen de la reserva:");
        System.out.println("Alojamiento: " + alojamientoSeleccionado.getNombre());
        System.out.println("Habitación: " + habitacionSeleccionada.getTipo());
        System.out.println("Precio por noche: " + habitacionSeleccionada.getPrecio() + " USD");
        System.out.println("Precio total: " + precioTotal + " USD");
        System.out.println("Aumento/Descuento: " + aumentoODescuento + " USD");
        System.out.println("Precio final: " + precioFinal + " USD");

        System.out.println("¿Desea confirmar su reserva? (sí/no)");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("sí")) {
            System.out.println("Ingrese su nombre:");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su correo electrónico:");
            String email = scanner.nextLine();

            System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
            String fechaNacimiento = scanner.nextLine();

            Reserva nuevaReserva = new Reserva(reservas.size() + 1, alojamientoSeleccionado, habitacionSeleccionada, usuario, email, fechaNacimiento, fechaInicio, fechaFin);
            reservas.add(nuevaReserva);

            System.out.println("RESERVA CONFIRMADA:");
            System.out.println(nuevaReserva);
            System.out.println("¡Gracias! Su reserva ha sido confirmada.");
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    private static double calcularPrecioBase(Alojamiento alojamiento) {
        // Implementar lógica para calcular el precio base del alojamiento
        // Por ahora, devolveremos un valor fijo como ejemplo
        return 100.0;
    }

    // Continuará en la siguiente parte...


    private static void actualizarReserva(ArrayList<Reserva> reservas, Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = scanner.nextLine();

        Reserva reserva = null;
        for (Reserva r : reservas) {
            if (r.getEmail().equalsIgnoreCase(email) && r.getFechaNacimiento().equals(fechaNacimiento)) {
                reserva = r;
                break;
            }
        }

        if (reserva != null) {
            System.out.println("Ingrese la nueva fecha de inicio del hospedaje (YYYY-MM-DD):");
            String nuevaFechaInicio = scanner.nextLine();

            System.out.println("Ingrese la nueva fecha de finalización del hospedaje (YYYY-MM-DD):");
            String nuevaFechaFin = scanner.nextLine();

            System.out.println("Ingrese la nueva cantidad de habitaciones:");
            int nuevaCantidadHabitaciones = scanner.nextInt();
            scanner.nextLine();  // Consumir nueva línea

            reserva.actualizarReserva(nuevaFechaInicio, nuevaFechaFin, nuevaCantidadHabitaciones);
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    private static void cancelarReserva(ArrayList<Reserva> reservas, Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (YYYY-MM-DD):");
        String fechaNacimiento = scanner.nextLine();

        Reserva reserva = null;
        for (Reserva r : reservas) {
            if (r.getEmail().equalsIgnoreCase(email) && r.getFechaNacimiento().equals(fechaNacimiento)) {
                reserva = r;
                break;
            }
        }

        if (reserva != null) {
            reserva.cancelarReserva();
            reservas.remove(reserva);
            System.out.println("Reserva cancelada exitosamente.");
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    private static double calcularAumentoODescuento(Alojamiento alojamiento, String fechaInicio, String fechaFin) {
        // Implementar la lógica para calcular aumentos o descuentos según las fechas
        // Por ahora, devolveremos un valor fijo como ejemplo
        return 0.0;
    }
}
