package org.example;

import org.example.modelos.Habitacion;
import org.example.modelos.Hotel;
import org.example.modelos.Reserva;
import org.example.modelos.VerReserva;
import org.example.modelos.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear habitaciones para cada hotel
        List<Habitacion> habitacionesHotel1 = new ArrayList<>();
        habitacionesHotel1.add(new Habitacion("Sencilla", "1 cama, vista al mar, aire acondicionado", 100000, 5));
        habitacionesHotel1.add(new Habitacion("Doble", "2 camas dobles, vista al mar", 150000, 3));
        habitacionesHotel1.add(new Habitacion("Suite", "Cama king, jacuzzi, minibar", 300000, 2));

        List<Habitacion> habitacionesHotel2 = new ArrayList<>();
        habitacionesHotel2.add(new Habitacion("Sencilla", "1 cama, aire acondicionado, escritorio", 120000, 4));
        habitacionesHotel2.add(new Habitacion("Suite", "Cama king, jacuzzi, minibar", 500000, 1));

        // Crear hoteles
        Hotel hotel1 = new Hotel("Hotel Sol", "Cartagena", 4.5f, 200000, true, "Natación, Paseos en bote", true, false, habitacionesHotel1);
        Hotel hotel2 = new Hotel("Hotel Luna", "Medellín", 5.0f, 350000, false, "Spa, Caminatas", false, true, habitacionesHotel2);

        Hotel[] hoteles = {hotel1, hotel2};

        // Inicializar el administrador de reservas (renombrado a VerReserva)
        VerReserva verReserva = new VerReserva();

        int opcion;
        do {
            System.out.println("\n¡Bienvenido a Booking Hoteles!");
            System.out.println("1. Buscar hoteles con parámetros");
            System.out.println("2. Confirmar disponibilidad");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Ver reservas");
            System.out.println("5. Actualizar reserva"); // <-- Nueva opción agregada
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    buscarHotelesConParametros(scanner, hoteles);
                    break;
                case 2:
                    confirmarDisponibilidad(scanner, hoteles);
                    break;
                case 3:
                    realizarReserva(scanner, hoteles, verReserva);
                    break;
                case 4:
                    verReserva.verReservas();
                    break;
                case 5:
                    actualizarReserva(scanner, hoteles, verReserva); // <-- Llamada al método
                    break;
                case 6:
                    System.out.println("¡Gracias por usar Booking Hoteles!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }

    // Método para buscar hoteles con parámetros
    private static void buscarHotelesConParametros(Scanner scanner, Hotel[] hoteles) {
        try {
            System.out.print("Ingrese la ciudad: ");
            scanner.nextLine(); // Limpiar buffer
            String ciudad = scanner.nextLine();

            System.out.print("¿Desea Día de Sol? (true/false): ");
            boolean filtrarDiaDeSol = scanner.nextBoolean();

            System.out.print("Cantidad de habitaciones: ");
            int cantidadHabitaciones = scanner.nextInt();

            System.out.print("Fecha de inicio (YYYY-MM-DD): ");
            LocalDate inicio = LocalDate.parse(scanner.next());

            System.out.print("Fecha de fin (YYYY-MM-DD): ");
            LocalDate fin = LocalDate.parse(scanner.next());

            if (inicio.isAfter(fin)) {
                System.out.println("Error: La fecha de inicio no puede ser posterior a la fecha de fin.");
                return;
            }

            System.out.println("\nHoteles que cumplen con los parámetros:");
            boolean hotelesEncontrados = false;

            for (Hotel hotel : hoteles) {
                if (hotel.cumpleCriterios(ciudad, filtrarDiaDeSol, cantidadHabitaciones)) {
                    hotelesEncontrados = true;
                    int diasHospedaje = (int) (fin.toEpochDay() - inicio.toEpochDay() + 1);
                    double precioBase = hotel.getPrecioHabitacionMasBarata() * cantidadHabitaciones * diasHospedaje;

                    double ajuste = calcularAjuste(inicio, fin, precioBase);
                    double precioFinal = precioBase + ajuste;

                    hotel.mostrarDetalles();
                    System.out.printf("Precio total: %.2f (Base: %.2f, Ajuste: %.2f)\n", precioFinal, precioBase, ajuste);
                }
            }

            if (!hotelesEncontrados) {
                System.out.println("No se encontraron hoteles que cumplan con los parámetros.");
            }

        } catch (Exception e) {
            System.out.println("Error al buscar hoteles: " + e.getMessage());
        }
    }

    // Método para realizar una reserva
    private static void realizarReserva(Scanner scanner, Hotel[] hoteles, VerReserva verReserva) {
        System.out.println("Hoteles disponibles:");
        for (int i = 0; i < hoteles.length; i++) {
            System.out.printf("%d. %s (%s)\n", i + 1, hoteles[i].getNombre(), hoteles[i].getCiudad());
        }

        // Seleccionar hotel
        System.out.print("Seleccione el número del hotel: ");
        int hotelIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (hotelIndex < 0 || hotelIndex >= hoteles.length) {
            System.out.println("Error: Hotel no válido.");
            return;
        }

        Hotel hotelSeleccionado = hoteles[hotelIndex];

        // Solicitar datos del cliente
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        if (!email.matches("^[\\w.-]+@[a-zA-Z\\d.-]+\\.[a-zA-Z]{2,}$")) {
            System.out.println("Error: El email ingresado no es válido.");
            return;
        }

        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese su hora aproximada de llegada (HH:MM): ");
        String horaLlegada = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, email, nacionalidad, telefono, horaLlegada);

        // Solicitar fechas
        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
        LocalDate inicio = LocalDate.parse(scanner.nextLine());

        System.out.print("Fecha de fin (YYYY-MM-DD): ");
        LocalDate fin = LocalDate.parse(scanner.nextLine());

        if (inicio.isAfter(fin)) {
            System.out.println("Error: La fecha de inicio debe ser anterior o igual a la fecha de fin.");
            return;
        }

        // Mostrar habitaciones disponibles
        hotelSeleccionado.confirmarDisponibilidad(1); // Mostrar disponibilidad general
        System.out.print("Seleccione el tipo de habitación: ");
        String tipoHabitacion = scanner.nextLine();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        // Crear reserva
        Reserva reserva = new Reserva(hotelSeleccionado);
        reserva.reservar(cliente.getNombreCompleto(), cantidad, inicio, fin);
        verReserva.agregarReserva(reserva);

        System.out.println("¡Reserva realizada con éxito!");
        cliente.mostrarDetalles();
        System.out.printf("Hotel: %s, Tipo de habitación: %s, Fechas: %s a %s, Cantidad: %d\n",
                hotelSeleccionado.getNombre(), tipoHabitacion, inicio, fin, cantidad);
    }

    // Método para calcular ajuste en el precio
    private static double calcularAjuste(LocalDate inicio, LocalDate fin, double precioBase) {
        double ajuste = 0.0;
        if (inicio.getDayOfMonth() >= 5 && fin.getDayOfMonth() <= 10) {
            ajuste = -0.08 * precioBase; // Descuento del 8%
        } else if (inicio.getDayOfMonth() >= 10 && fin.getDayOfMonth() <= 15) {
            ajuste = 0.10 * precioBase; // Aumento del 10%
        } else if (fin.getDayOfMonth() >= 26) {
            ajuste = 0.15 * precioBase; // Aumento del 15%
        }
        return ajuste;
    }

    private static void confirmarDisponibilidad(Scanner scanner, Hotel[] hoteles) {
        System.out.print("Ingrese el nombre del hotel: ");
        String hotelNombre = scanner.nextLine();

        // Buscar el hotel y confirmar disponibilidad
        for (Hotel hotel : hoteles) {
            if (hotel.getNombre().equalsIgnoreCase(hotelNombre)) {
                System.out.print("Cantidad de habitaciones: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
                hotel.confirmarDisponibilidad(cantidad); // Llamada al método en Hotel
                return;
            }
        }
        System.out.println("El hotel ingresado no existe.");
    }

    private static void actualizarReserva(Scanner scanner, Hotel[] hoteles, VerReserva verReserva) {
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        Reserva reserva = verReserva.buscarReservaPorEmail(email);

        if (reserva == null) {
            System.out.println("No se encontró ninguna reserva asociada al email proporcionado.");
            return;
        }

        System.out.println("\nReserva encontrada:");
        reserva.mostrarDetalles();

        // Opciones de actualización
        System.out.println("¿Qué desea hacer?\n1. Cambiar habitación\n2. Cambiar alojamiento\n3. Cancelar");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                cambiarHabitacion(scanner, reserva, reserva.getHotel());
                break;
            case 2:
                cambiarAlojamiento(scanner, hoteles, reserva);
                break;
            case 3:
                System.out.println("Operación cancelada.");
                break;
            default:
                System.out.println("Opción no válida. Inténtelo de nuevo.");
        }
    }

    private static void cambiarHabitacion(Scanner scanner, Reserva reserva) {
        System.out.println("Ingrese el nuevo tipo de habitación: ");
        String nuevaHabitacion = scanner.nextLine();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        reserva.actualizarHabitacion(nuevaHabitacion, cantidad);
    }

    private static void cambiarAlojamiento(Scanner scanner, Hotel[] hoteles, Reserva reserva) {
        System.out.println("Hoteles disponibles:");
        for (int i = 0; i < hoteles.length; i++) {
            System.out.printf("%d. %s (%s)\n", i + 1, hoteles[i].getNombre(), hoteles[i].getCiudad());
        }

        // Seleccionar un nuevo hotel
        System.out.print("Seleccione el número del nuevo hotel: ");
        int hotelIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Limpiar buffer

        if (hotelIndex < 0 || hotelIndex >= hoteles.length) {
            System.out.println("Error: Hotel no válido.");
            return;
        }

        Hotel nuevoHotel = hoteles[hotelIndex];

        // Revertir la disponibilidad del hotel anterior
        System.out.println("Revirtiendo disponibilidad del hotel anterior...");
        List<Habitacion> habitacionesPrevias = reserva.getHotel().getHabitaciones();
        for (Habitacion habitacion : habitacionesPrevias) {
            if (habitacion.getTipo().equalsIgnoreCase(reserva.getTipoHabitacion())) {
                habitacion.reducirDisponibilidad(-reserva.getCantidadHabitaciones()); // Revertir disponibilidad
                break;
            }
        }

        // Seleccionar habitación en el nuevo hotel
        System.out.println("Habitaciones disponibles en el nuevo hotel:");
        nuevoHotel.confirmarDisponibilidad(reserva.getCantidadHabitaciones());

        System.out.print("Seleccione el tipo de habitación: ");
        String tipoHabitacion = scanner.nextLine();

        Habitacion nuevaHabitacion = null;
        for (Habitacion habitacion : nuevoHotel.getHabitaciones()) {
            if (habitacion.getTipo().equalsIgnoreCase(tipoHabitacion)) {
                nuevaHabitacion = habitacion;
                break;
            }
        }

        if (nuevaHabitacion == null || !nuevaHabitacion.tieneDisponibilidad(reserva.getCantidadHabitaciones())) {
            System.out.println("Error: No hay disponibilidad en la habitación seleccionada.");
            return;
        }

        // Actualizar la reserva con el nuevo alojamiento
        nuevaHabitacion.reducirDisponibilidad(reserva.getCantidadHabitaciones());
        reserva.actualizarAlojamiento(nuevoHotel, reserva.getFechaInicio(), reserva.getFechaFin(), tipoHabitacion, reserva.getCantidadHabitaciones());

        System.out.println("¡El alojamiento ha sido cambiado con éxito!");
    }

    private static void cambiarHabitacion(Scanner scanner, Reserva reserva, Hotel hotel) {
        System.out.println("Habitaciones disponibles en el hotel:");
        List<Habitacion> habitaciones = hotel.getHabitaciones();
        boolean hayDisponibilidad = false;

        // Mostrar habitaciones con disponibilidad
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.tieneDisponibilidad(reserva.getCantidadHabitaciones())) {
                System.out.printf("Tipo: %s, Precio: %.2f, Disponibles: %d\n",
                        habitacion.getTipo(), habitacion.getPrecio(), habitacion.getDisponibles());
                hayDisponibilidad = true;
            }
        }

        if (!hayDisponibilidad) {
            System.out.println("No hay habitaciones disponibles en este hotel.");
            return;
        }

        // Solicitar nuevo tipo de habitación
        System.out.print("Seleccione el nuevo tipo de habitación: ");
        String nuevoTipoHabitacion = scanner.nextLine();

        // Buscar la habitación seleccionada
        Habitacion nuevaHabitacion = null;
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getTipo().equalsIgnoreCase(nuevoTipoHabitacion)) {
                nuevaHabitacion = habitacion;
                break;
            }
        }

        if (nuevaHabitacion == null) {
            System.out.println("Error: La habitación seleccionada no existe.");
            return;
        }

        // Cambiar la habitación en la reserva
        reserva.cambiarHabitacion(nuevaHabitacion, reserva.getCantidadHabitaciones());
    }
}