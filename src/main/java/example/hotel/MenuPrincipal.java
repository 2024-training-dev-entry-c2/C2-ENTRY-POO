package example.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private ArrayList<Alojamiento> alojamientos;
    private ArrayList<Reserva> reservas;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.alojamientos = InicializadorDatos.inicializarAlojamientos();
        this.reservas = new ArrayList<>();
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("---- ¡Bienvenido a HotelApp! ----");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Realizar reserva");
            System.out.println("2. Actualizar reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

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

    private static double calcularPrecioBase(Alojamiento alojamiento) {
        ArrayList<Habitacion> habitaciones = alojamiento.getHabitaciones();

        if (habitaciones == null || habitaciones.isEmpty()) {
            return 0;
        }

        double precioBase = habitaciones.get(0).getPrecio();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getPrecio() < precioBase) {
                precioBase = habitacion.getPrecio();
            }
        }

        return precioBase;
    }

    private static double calcularAumentoODescuento(Alojamiento alojamiento, String fechaInicio, String fechaFin) {
        int diaInicio = Integer.parseInt(fechaInicio.substring(0, 2));
        int diaFin = Integer.parseInt(fechaFin.substring(0, 2));

        double precioBase = calcularPrecioBase(alojamiento);

        double precioTotal = precioBase * (diaFin - diaInicio + 1);

        double aumentoODescuento = 0.0;
        if (diaInicio >= 25) {
            aumentoODescuento = precioTotal * 0.15;
        } else if (diaInicio >= 10 && diaFin <= 15) {
            aumentoODescuento = precioTotal * 0.10;
        } else if (diaInicio >= 5 && diaFin <= 10) {
            // Si los días de estadía comprende del 5 al 10 del mes,
            // se realiza un descuento de 8%.
            aumentoODescuento = -precioTotal * 0.08;
        }

        return aumentoODescuento;
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
                tiposAlojamiento.add(alojamiento.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2"));
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

        System.out.println("Ingrese el día de inicio del hospedaje (DD/MM/YYYY):");
        String fechaInicio = scanner.nextLine();

        System.out.println("Ingrese el día de finalización del hospedaje (DD/MM/YYYY):");
        String fechaFin = scanner.nextLine();

        ArrayList<Alojamiento> alojamientosDisponibles = new ArrayList<>();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudadSeleccionada) && alojamiento.getClass().getSimpleName().replaceAll("([a-z])([A-Z])", "$1 $2").equalsIgnoreCase(tipoSeleccionado)) {
                alojamientosDisponibles.add(alojamiento);
            }
        }

        System.out.println("Alojamientos disponibles:");
        for (int i = 0; i < alojamientosDisponibles.size(); i++) {
            System.out.println((i + 1) + ". " + alojamientosDisponibles.get(i).getNombre() + " - " + alojamientosDisponibles.get(i).getCalificacion() + " estrellas");
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
            System.out.println((i + 1) + ". " + habitaciones.get(i).getTipo() + " - " + habitaciones.get(i).getCaracteristicas() + " - " + habitaciones.get(i).getPrecio() + " USD por noche");
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

        System.out.println("¿Desea confirmar su reserva? (S/N)");
        String confirmacion = scanner.nextLine();

        if (confirmacion.equalsIgnoreCase("S")) {
            System.out.println("Ingrese su nombre:");
            String usuario = scanner.nextLine();

            System.out.println("Ingrese su correo electrónico:");
            String email = scanner.nextLine();

            System.out.println("Ingrese su fecha de nacimiento (DD/MM/YYYY):");
            String fechaNacimiento = scanner.nextLine();

            Reserva nuevaReserva = new Reserva(reservas.size() + 1, alojamientoSeleccionado, habitacionSeleccionada, usuario, email, fechaNacimiento, fechaInicio, fechaFin);
            reservas.add(nuevaReserva);


            System.out.println("¡Gracias! Su reserva ha sido confirmada.");
        } else {
            System.out.println("Reserva cancelada.");
        }
    }

    private static void actualizarReserva(ArrayList<Reserva> reservas, Scanner scanner) {
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
            System.out.println("Ingrese la nueva fecha de inicio del hospedaje (DD/MM/YYYY):");
            String nuevaFechaInicio = scanner.nextLine();

            System.out.println("Ingrese la nueva fecha de finalización del hospedaje (DD/MM/YYYY):");
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
