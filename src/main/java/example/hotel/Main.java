package example.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {

    static String[] hotelNombres = new String[100];
    static String[] tipoAlojamiento = new String[100];
    static String[] ciudades = new String[100];
    static int[] calificaciones = new int[100];
    static double[] precios = new double[100];

    static int[] habitacionHotelID = new int[500];
    static String[] habitacionTipos = new String[500];
    static String[] habitacionCaracteristicas = new String[500];
    static double[] habitacionPrecios = new double[500];
    static boolean[][][] habitacionDisponibilidad = new boolean[500][10][366]; // [Habitación][Año][Día del año]

    static String[] nombresReservas = new String[100];
    static String[] emailsReservas = new String[100];
    static String[] hotelesReservas = new String[100];
    static String[] habitacionesReservas = new String[100];
    static LocalDate[] fechasInicioReservas = new LocalDate[100];
    static LocalDate[] fechasFinReservas = new LocalDate[100];
    static int totalReservas = 0; // Contador de reservas

    public static void main(String[] args) {
        inicializarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a HotelApp!");
        mostrarMenu(scanner);
    }

    public static void inicializarDatos() {
        inicializarHoteles();
        inicializarHabitaciones();
        inicializarDisponibilidad();
    }

    public static void inicializarHoteles() {
        agregarHotel(0, "Hotel Buenos Aires", "Hotel", "Buenos Aires", 4, 50.0);
        agregarHotel(1, "Hotel Mar del Plata", "Hotel", "Mar del Plata", 3, 60.0);
        agregarHotel(2, "Apartamento Cordoba", "Apartamento", "Cordoba", 2, 40.0);
        agregarHotel(3, "Finca Rosario", "Finca", "Rosario", 5, 100.0);
        agregarHotel(4, "Día de Sol Buenos Aires", "Día de Sol", "Buenos Aires", 4, 70.0);
        agregarHotel(5, "Día de Sol Mar del Plata", "Día de Sol", "Mar del Plata", 3, 80.0);
    }

    public static void agregarHotel(int index, String nombre, String alojamiento, String ciudad, int calificacion, double precio) {
        hotelNombres[index] = nombre;
        tipoAlojamiento[index] = alojamiento;
        ciudades[index] = ciudad;
        calificaciones[index] = calificacion;
        precios[index] = precio;
    }

    public static void inicializarHabitaciones() {
        agregarHabitacion(0, 0, "Single", "2 camas simples, aire acondicionado, WiFi", 50.0);
        agregarHabitacion(1, 0, "Double", "1 cama doble, aire acondicionado, TV", 75.0);
        agregarHabitacion(2, 1, "Suite", "1 cama king size, jacuzzi, TV de pantalla plana", 120.0);
        agregarHabitacion(3, 2, "Single", "2 camas simples, desayuno incluido, WiFi", 55.0);
        agregarHabitacion(4, 4, "Activities", "Piscinas, excursiones y juegos familiares", 150.0);
        agregarHabitacion(5, 5, "Activities", "Spa, actividades al aire libre y recreación", 140.0);
    }

    public static void agregarHabitacion(int index, int hotelID, String tipo, String caracteristicas, double precio) {
        habitacionHotelID[index] = hotelID;
        habitacionTipos[index] = tipo;
        habitacionCaracteristicas[index] = caracteristicas;
        habitacionPrecios[index] = precio;
    }

    public static void inicializarDisponibilidad() {
        for (int i = 0; i < habitacionDisponibilidad.length; i++) {
            for (int j = 0; j < 366; j++) {
                for (int k = 0; k < 10; k++) { // Máximo 10 años distintos de disponibilidad
                    habitacionDisponibilidad[i][k][j] = true;
                }
            }
        }
    }

    public static void mostrarMenu(Scanner scanner) {
        int opcion = 0;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Realizar una reserva");
            System.out.println("2. Actualizar una reserva");
            System.out.println("3. Cancelar una reserva");
            System.out.println("4. Mostrar todas las reservas");
            System.out.println("5. Salir");

            opcion = solicitarNumero(scanner, "Ingrese su opción: ");
            switch (opcion) {
                case 1 -> realizarReserva(scanner);
                case 2 -> actualizarReserva(scanner);
                case 3 -> cancelarReserva(scanner);
                case 4 -> mostrarReservas(); // Nueva opción para mostrar reservas
                case 5 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    public static void realizarReserva(Scanner scanner) {
        System.out.println("\n--- Realizar una Reserva ---");

        // Selección de ciudad
        System.out.println("Seleccione una ciudad:");
        String[] ciudadesUnicas = eliminarDuplicados(ciudades);
        int ciudadElegida = listarOpciones(scanner, ciudadesUnicas);

        // Selección de tipo de alojamiento
        System.out.println("Seleccione el tipo de alojamiento:");
        String[] tiposAlojamientoUnicos = eliminarDuplicados(tipoAlojamiento);
        int tipoAlojamientoElegido = listarOpciones(scanner, tiposAlojamientoUnicos);

        // Solicitar datos de la estadía
        LocalDate fechaInicio = solicitarFecha(scanner, "Ingrese la fecha de ingreso (dd/MM/yyyy): ");
        LocalDate fechaSalida = solicitarFecha(scanner, "Ingrese la fecha de salida (dd/MM/yyyy): ");

        while (!fechaSalida.isAfter(fechaInicio)) {
            System.out.println("La fecha de salida debe ser posterior a la fecha de ingreso.");
            fechaSalida = solicitarFecha(scanner, "Ingrese la fecha de salida nuevamente (dd/MM/yyyy): ");
        }

        // Filtrar hoteles disponibles
        String[] hotelesDisponibles = filtrarHoteles(ciudadElegida, tipoAlojamientoElegido);

        if (hotelesDisponibles.length == 0) {
            System.out.println("No hay hoteles disponibles con las opciones seleccionadas.");
            return;
        }

        System.out.println("Seleccione un hotel disponible:");
        int hotelElegido = listarOpciones(scanner, hotelesDisponibles);

        // Filtrar habitaciones disponibles
        String[] habitaciones = filtrarHabitaciones(hotelElegido);

        if (habitaciones.length == 0) {
            System.out.println("No hay habitaciones disponibles en el hotel seleccionado.");
            return;
        }

        System.out.println("Seleccione una habitación:");
        int habitacionElegida = listarOpciones(scanner, habitaciones);

        // Cálculo de costos (precio total, ajustes y precio final)
        double precioPorNoche = habitacionPrecios[habitacionElegida];
        long diasEstadia = ChronoUnit.DAYS.between(fechaInicio, fechaSalida);
        double precioTotal = precioPorNoche * diasEstadia;

        double ajuste = calcularDescuento(fechaInicio, fechaSalida, precioPorNoche);
        double precioFinal = precioTotal + (ajuste * diasEstadia);

        // Mostrar el resumen
        System.out.println("\n--- Resumen de la Reserva ---");
        System.out.printf("Hotel: %s%n", hotelNombres[habitacionHotelID[habitacionElegida]]);
        System.out.printf("Habitación: %s - Características: %s%n", habitacionTipos[habitacionElegida], habitacionCaracteristicas[habitacionElegida]);
        System.out.printf("Precio por noche: $%.2f%n", precioPorNoche);
        System.out.printf("Días de estadía: %d%n", diasEstadia);
        System.out.printf("Precio total (antes de ajustes): $%.2f%n", precioTotal);
        System.out.printf("Ajuste por descuento/aumento (por noche): %s $%.2f%n", ajuste > 0 ? "+" : "-", Math.abs(ajuste));
        System.out.printf("Precio final: $%.2f%n", precioFinal);

        // Confirmar la reserva
        System.out.println("\n¿Desea confirmar esta reserva? (Si/No): ");
        String confirmacion = scanner.next();
        if (!confirmacion.equalsIgnoreCase("Si")) {
            System.out.println("Reserva cancelada.");
            return;
        }

        // Solicitar datos personales
        System.out.println("\n--- Complete los datos personales para finalizar la reserva ---");
        System.out.print("Ingrese su Nombre: ");
        scanner.nextLine();  // Limpiar el buffer
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su Email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su Número de Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese su Hora Aproximada de Llegada (HH:mm): ");
        String horaLlegada = scanner.nextLine();

        // Guardar la reserva
        nombresReservas[totalReservas] = nombre + " " + apellido;
        emailsReservas[totalReservas] = email;
        hotelesReservas[totalReservas] = hotelNombres[habitacionHotelID[habitacionElegida]];
        habitacionesReservas[totalReservas] = habitacionTipos[habitacionElegida];
        fechasInicioReservas[totalReservas] = fechaInicio;
        fechasFinReservas[totalReservas] = fechaSalida;

        totalReservas++;

        System.out.println("\nReserva confirmada con éxito. ¡Gracias por usar HotelApp!");
    }

    public static void actualizarReserva(Scanner scanner) {
        System.out.println("\n--- Actualizar una Reserva no ha sido implementado---");
    }

    public static void cancelarReserva(Scanner scanner) {
        System.out.println("\n--- Cancelar una Reserva no ha sido implementado---");
    }

    public static void realizarBloqueoHabitaciones(int habitacion, LocalDate inicio, LocalDate fin) {
        int año = inicio.getYear() - LocalDate.now().getYear(); // Año relativo
        int diaInicio = inicio.getDayOfYear();
        int diaFin = fin.getDayOfYear();

        for (int dia = diaInicio; dia <= diaFin; dia++) {
            habitacionDisponibilidad[habitacion][año][dia] = false;
        }
    }

    public static String[] eliminarDuplicados(String[] lista) {
        String[] listaUnica = new String[lista.length];
        int indiceUnico = 0;

        for (String item : lista) {
            if (item == null) {
                continue; // Ignorar elementos nulos
            }
            boolean encontrado = false;

            // Comprobar si ya está en la lista única
            for (int i = 0; i < indiceUnico; i++) {
                if (item.equals(listaUnica[i])) {
                    encontrado = true;
                    break;
                }
            }

            // Si no está duplicado, agregarlo a la lista única
            if (!encontrado) {
                listaUnica[indiceUnico++] = item;
            }
        }

        // Crear un array del tamaño exacto con los elementos únicos
        String[] resultado = new String[indiceUnico];
        System.arraycopy(listaUnica, 0, resultado, 0, indiceUnico);
        return resultado;
    }

    public static int listarOpciones(Scanner scanner, String[] opciones) {
        for (int i = 0; i < opciones.length && opciones[i] != null; i++) {
            System.out.printf("%d. %s%n", i + 1, opciones[i]);
        }
        int seleccion = solicitarNumero(scanner, "Elija el número correspondiente: ") - 1;
        return seleccion;
    }

    public static String[] filtrarHoteles(int ciudadElegida, int tipoElegido) {
        String[] resultado = new String[100];
        int indice = 0;

        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudades[ciudadElegida]) && tipoAlojamiento[i].equals(tipoAlojamiento[tipoElegido])) {
                resultado[indice++] = String.format("%s - Precio Base: $%.2f - Calificación: %d estrellas",
                        hotelNombres[i], precios[i], calificaciones[i]);
            }
        }
        String[] hotelesFiltrados = new String[indice];
        System.arraycopy(resultado, 0, hotelesFiltrados, 0, indice);
        return hotelesFiltrados;
    }

    public static String[] filtrarHabitaciones(int hotelElegido) {
        String[] resultado = new String[100];
        int indice = 0;

        for (int i = 0; i < habitacionHotelID.length && habitacionTipos[i] != null; i++) {
            if (habitacionHotelID[i] == hotelElegido) {
                // Formatear la información de cada habitación
                resultado[indice++] = String.format("%s - Precio por noche: $%.2f - Características: %s",
                        habitacionTipos[i], habitacionPrecios[i], habitacionCaracteristicas[i]);
            }
        }

        // Crear un array ajustado al tamaño de los resultados
        String[] habitacionesFiltradas = new String[indice];
        System.arraycopy(resultado, 0, habitacionesFiltradas, 0, indice);
        return habitacionesFiltradas;
    }

    public static double calcularDescuento(LocalDate inicio, LocalDate fin, double precioBase) {
        boolean aumento15 = false;
        boolean aumento10 = false;
        boolean descuento8 = false;

        // Iterar por cada día de la estadía
        LocalDate fecha = inicio;
        while (!fecha.isAfter(fin)) {
            int dia = fecha.getDayOfMonth();

            // Verificar si pertenece a los últimos 5 días del mes
            if (dia >= fecha.lengthOfMonth() - 4) {
                aumento15 = true;
            }

            // Verificar si pertenece al rango del 10 al 15 del mes
            if (dia >= 10 && dia <= 15) {
                aumento10 = true;
            }

            // Verificar si pertenece al rango del 5 al 10 del mes
            if (dia >= 5 && dia < 10) {
                descuento8 = true;
            }

            // Avanzar al próximo día
            fecha = fecha.plusDays(1);
        }

        // Aplicar las reglas de descuento/aumento
        if (aumento15) {
            return precioBase * 0.15; // Aumento del 15%
        } else if (aumento10) {
            return precioBase * 0.10; // Aumento del 10%
        } else if (descuento8) {
            return -precioBase * 0.08; // Descuento del 8%
        }

        // Si no se cumple ninguna condición, no hay ajuste
        return 0;
    }

    public static LocalDate solicitarFecha(Scanner scanner, String mensaje) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = null;
        while (fecha == null) {
            System.out.print(mensaje);
            try {
                fecha = LocalDate.parse(scanner.next(), formato);
            } catch (Exception e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }
        return fecha;
    }

    public static int solicitarNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un número válido.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static void mostrarReservas() {
        System.out.println("\n--- Lista de Reservas Guardadas ---");
        if (totalReservas == 0) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (int i = 0; i < totalReservas; i++) {
            System.out.printf("Reserva %d:%n", i + 1);
            System.out.printf("  Nombre: %s%n", nombresReservas[i]);
            System.out.printf("  Email: %s%n", emailsReservas[i]);
            System.out.printf("  Hotel: %s%n", hotelesReservas[i]);
            System.out.printf("  Habitación: %s%n", habitacionesReservas[i]);
            System.out.printf("  Fecha Inicio: %s%n", fechasInicioReservas[i]);
            System.out.printf("  Fecha Fin: %s%n%n", fechasFinReservas[i]);
        }
    }
}