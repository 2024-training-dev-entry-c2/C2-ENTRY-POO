package example.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorReservas {
    private CalculadorPrecios calculadorPrecios;

    public GestorReservas() {
        this.calculadorPrecios = new CalculadorPrecios();
    }

    public void realizarReserva(ArrayList<Alojamiento> alojamientos, ArrayList<Reserva> reservas, Scanner scanner) {
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
        scanner.nextLine(); // Consumir nueva línea

        // Validación del índice de ciudad
        if (ciudadIndex < 0 || ciudadIndex >= ciudades.size()) {
            System.out.println("Índice de ciudad no válido. Intente nuevamente.");
            return;
        }

        String ciudadSeleccionada = ciudades.get(ciudadIndex);

        System.out.println("Tipos de alojamiento disponibles:");
        ArrayList<String> tiposAlojamiento = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equals(ciudadSeleccionada)
                    && !tiposAlojamiento.contains(alojamiento.getClass().getSimpleName())) {
                tiposAlojamiento.add(alojamiento.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
            }
        }
        for (int i = 0; i < tiposAlojamiento.size(); i++) {
            System.out.println((i + 1) + ". " + tiposAlojamiento.get(i));
        }
        System.out.println("Seleccione un tipo de alojamiento:");
        int tipoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nueva línea

        // Validación del índice de tipo de alojamiento
        if (tipoIndex < 0 || tipoIndex >= tiposAlojamiento.size()) {
            System.out.println("Índice de tipo de alojamiento no válido. Intente nuevamente.");
            return;
        }

        String tipoSeleccionado = tiposAlojamiento.get(tipoIndex);

        System.out.println("Ingrese la cantidad de adultos:");
        int cantidadAdultos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de niños:");
        int cantidadNinos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de habitaciones:");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea

        System.out.println("Ingrese el día de inicio del hospedaje (DD/MM/YYYY):");
        String fechaInicio = scanner.nextLine();

        System.out.println("Ingrese el día de finalización del hospedaje (DD/MM/YYYY):");
        String fechaFin = scanner.nextLine();

        ArrayList<Alojamiento> alojamientosDisponibles = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudadSeleccionada) && alojamiento.getClass().getSimpleName()
                    .replaceAll("([a-z])([A-Z])", "$1 $2").equalsIgnoreCase(tipoSeleccionado)) {
                alojamientosDisponibles.add(alojamiento);
            }
        }

        System.out.println("Alojamientos disponibles:");
        for (int i = 0; i < alojamientosDisponibles.size(); i++) {
            Alojamiento alojamiento = alojamientosDisponibles.get(i);
            double precioPorNoche = calculadorPrecios.calcularPrecioBase(alojamiento);
            System.out.println(
                    (i + 1) + ". " + alojamiento.getNombre() + " - " + alojamiento.getCalificacion() + " estrellas");
            System.out.println("   Precio por noche: " + precioPorNoche + " USD");
        }
        System.out.println("Seleccione un alojamiento:");
        int alojamientoIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nueva línea

        // Validación del índice de alojamiento
        if (alojamientoIndex < 0 || alojamientoIndex >= alojamientosDisponibles.size()) {
            System.out.println("Índice de alojamiento no válido. Intente nuevamente.");
            return;
        }

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
            System.out.println(
                    (i + 1) + ". " + habitaciones.get(i).getTipo() + " - " + habitaciones.get(i).getCaracteristicas()
                            + " - " + habitaciones.get(i).getPrecio() + " USD por noche");
        }
        System.out.println("Seleccione una habitación:");
        int habitacionIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consumir nueva línea

        // Validación del índice de habitación
        if (habitacionIndex < 0 || habitacionIndex >= habitaciones.size()) {
            System.out.println("Índice de habitación no válido. Intente nuevamente.");
            return;
        }

        Habitacion habitacionSeleccionada = habitaciones.get(habitacionIndex);

        // Calcular precios y mostrar resumen
        double precioTotal = habitacionSeleccionada.getPrecio() * cantidadHabitaciones;
        double aumentoODescuento = calculadorPrecios.calcularAumentoODescuento(alojamientoSeleccionado, fechaInicio,
                fechaFin);
        double precioFinal = precioTotal + aumentoODescuento;

        System.out.println("Resumen de la reserva:");
        System.out.println("Alojamiento: " + alojamientoSeleccionado.getNombre());
        System.out.println("Habitación: " + habitacionSeleccionada.getTipo());
        System.out.println("Precio por noche: " + habitacionSeleccionada.getPrecio() + " USD");
        System.out.println("Precio total: " + precioTotal + " USD");
        System.out.println("Aumento/Descuento: " + aumentoODescuento + " USD");
        System.out.println("Precio final: " + precioFinal + " USD");

        System.out.println("¿Desea confirmar su reserva? (S/N)");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            System.out.println("Ingrese su nombre:");
            String nombre = scanner.nextLine();

            System.out.println("Ingrese su apellido:");
            String apellido = scanner.nextLine();

            System.out.println("Ingrese su correo electrónico:");
            String email = scanner.nextLine();

            System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
            String fechaNacimiento = scanner.nextLine();

            String nombreCompleto = nombre + " " + apellido;

            Reserva nuevaReserva = new Reserva(reservas.size() + 1, alojamientoSeleccionado, habitacionSeleccionada,
                    nombreCompleto, email, fechaNacimiento, fechaInicio, fechaFin);
            reservas.add(nuevaReserva);

            System.out.println("¡Gracias! Su reserva ha sido confirmada.");
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    public void actualizarReserva(ArrayList<Alojamiento> alojamientos, ArrayList<Reserva> reservas, Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
        String fechaNacimiento = scanner.nextLine();

        Reserva reserva = null;
        for (Reserva r : reservas) {
            if (r.getEmail().equalsIgnoreCase(email) && r.getFechaNacimiento().equals(fechaNacimiento)) {
                reserva = r;
                break;
            }
        }

        if (reserva != null) {
            System.out.println("Reserva encontrada:");
            System.out.println("Alojamiento: " + reserva.getAlojamiento().getNombre());
            System.out.println("Habitación: " + reserva.getHabitacion().getTipo());
            System.out.println("Fecha de inicio: " + reserva.getFechaInicio());
            System.out.println("Fecha de fin: " + reserva.getFechaFin());

            System.out.println("¿Qué desea actualizar?");
            System.out.println("1. Cambiar habitación");
            System.out.println("2. Cambiar alojamiento");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            if (opcion == 1) {
                // Cambiar habitación
                ArrayList<Habitacion> habitaciones = reserva.getAlojamiento().getHabitaciones();
                System.out.println("Habitaciones disponibles:");
                for (int i = 0; i < habitaciones.size(); i++) {
                    System.out.println((i + 1) + ". " + habitaciones.get(i).getTipo() + " - "
                            + habitaciones.get(i).getCaracteristicas() + " - " + habitaciones.get(i).getPrecio()
                            + " USD por noche");
                }
                System.out.println("Seleccione una nueva habitación:");
                int habitacionIndex = scanner.nextInt() - 1;
                scanner.nextLine(); // Consumir nueva línea

                // Validación del índice de habitación
                if (habitacionIndex < 0 || habitacionIndex >= habitaciones.size()) {
                    System.out.println("Índice de habitación no válido. Intente nuevamente.");
                    return;
                }

                Habitacion nuevaHabitacion = habitaciones.get(habitacionIndex);
                reserva.setHabitacion(nuevaHabitacion);
                System.out.println("Habitación actualizada exitosamente.");
            } else if (opcion == 2) {
                // Cambiar alojamiento
                reservas.remove(reserva);
                System.out.println("Reserva eliminada. Por favor, cree una nueva reserva.");
                realizarReserva(alojamientos, reservas, scanner);
            } else {
                System.out.println("Opción no válida. Intente nuevamente.");
            }
        } else {
            System.out.println("Reserva no encontrada.");
        }
    }

    public void cancelarReserva(ArrayList<Reserva> reservas, Scanner scanner) {
        System.out.println("Ingrese su correo electrónico:");
        String email = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
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
}