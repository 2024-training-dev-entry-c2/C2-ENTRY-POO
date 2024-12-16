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
    static LocalDate[] fechaNacimientoReservas = new LocalDate[100];
    static String[] hotelesReservas = new String[100];
    static String[] habitacionesReservas = new String[100];
    static LocalDate[] fechasInicioReservas = new LocalDate[100];
    static LocalDate[] fechasFinReservas = new LocalDate[100];
    static int[] cantidadAdultosReservas = new int[100];
    static int[] cantidadNiniosReservas = new int[100];
    static int[] cantidadHabitacionesReservas = new int[100];
    static int totalReservas = 0;
    static int[][] hotelReservas = new int[100][100];
    static int[] totalReservasPorHotel = new int[100];

    public static void main(String[] args) {
        inicializarDatos();
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido a HotelApp!");
        mostrarMenu(scanner);
    }

    /* Metodos de Inicialización de Datos */

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

        for (int i = 0; i < totalReservasPorHotel.length; i++) {
            totalReservasPorHotel[i] = 0;
        }

        for (int i = 0; i < hotelReservas.length; i++) {
            for (int j = 0; j < hotelReservas[i].length; j++) {
                hotelReservas[i][j] = -1;
            }
        }
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
        agregarHabitacion(2, 3, "Suite", "1 cama king size, jacuzzi, TV de pantalla plana", 120.0);
        agregarHabitacion(3, 2, "Single", "2 camas simples, desayuno incluido, WiFi", 55.0);
        agregarHabitacion(4, 4, "Activities", "Piscinas, excursiones, juegos familiares, incluye almuerzo", 150.0);
        agregarHabitacion(5, 5, "Activities", "Spa, actividades al aire libre, recreación, incluye refrigerio", 140.0);
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
                for (int k = 0; k < 10; k++) {
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
            System.out.println("4. Mostrar reservas por Hotel (DEV)");
            System.out.println("5. Salir");

            opcion = solicitarNumero(scanner, "Ingrese su opción: ");
            switch (opcion) {
                case 1 -> realizarReserva(scanner);
                case 2 -> actualizarReserva(scanner);
                case 3 -> cancelarReserva(scanner);
                case 4 -> mostrarReservasHotel(scanner);
                case 5 -> System.out.println("Saliendo de la aplicación...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 5);
    }

    /* Metodos de Creacion de Reserva */
    public static void realizarReserva(Scanner scanner) {
        System.out.println("\n--- Realizar una Reserva ---");

        System.out.println("Seleccione una ciudad:");
        String[] ciudadesUnicas = eliminarDuplicados(ciudades);
        int ciudadElegida = listarOpciones(scanner, ciudadesUnicas);

        System.out.println("Seleccione el tipo de alojamiento:");
        String[] tiposAlojamientoUnicos = eliminarDuplicados(tipoAlojamiento);
        int tipoAlojamientoElegido = listarOpciones(scanner, tiposAlojamientoUnicos);

        int cantidadAdultos = solicitarNumero(scanner, "Ingrese la cantidad de adultos: ");
        int cantidadNinios = solicitarNumero(scanner, "Ingrese la cantidad de niños: ");

        int cantidadHabitaciones = solicitarNumero(scanner, "Ingrese la cantidad de habitaciones: ");

        LocalDate fechaInicio = solicitarFecha(scanner, "Ingrese la fecha de ingreso (dd/MM/yyyy): ");
        LocalDate fechaSalida = solicitarFecha(scanner, "Ingrese la fecha de salida (dd/MM/yyyy): ");
        while (!fechaSalida.isAfter(fechaInicio)) {
            System.out.println("La fecha de salida debe ser posterior a la fecha de ingreso.");
            fechaSalida = solicitarFecha(scanner, "Ingrese la fecha de salida nuevamente (dd/MM/yyyy): ");
        }

        String[] hotelesDisponibles = filtrarHoteles(ciudadElegida, tipoAlojamientoElegido, ciudadesUnicas, tiposAlojamientoUnicos);

        if (hotelesDisponibles.length == 0) {
            System.out.println("No hay hoteles disponibles con las opciones seleccionadas.");
            return;
        }

        System.out.println("Seleccione un hotel disponible:");
        int hotelElegido = listarOpciones(scanner, hotelesDisponibles);

        String[] habitaciones = filtrarHabitaciones(hotelElegido, hotelesDisponibles);

        if (habitaciones.length == 0) {
            System.out.println("No hay habitaciones disponibles en el hotel seleccionado.");
            return;
        }

        System.out.println("Seleccione una habitación:");
        int habitacionElegida = listarOpciones(scanner, habitaciones);

        double precioPorNoche = habitacionPrecios[habitacionElegida];
        long diasEstadia = ChronoUnit.DAYS.between(fechaInicio, fechaSalida);
        double precioTotal = precioPorNoche * diasEstadia;

        double ajuste = calcularDescuento(fechaInicio, fechaSalida, precioPorNoche);
        double precioFinal = precioTotal + (ajuste * diasEstadia);

        System.out.println("\n--- Resumen de la Reserva ---");
        System.out.printf("Hotel: %s%n", hotelNombres[habitacionHotelID[habitacionElegida]]);
        System.out.printf("Habitación: %s - Características: %s%n", habitacionTipos[habitacionElegida], habitacionCaracteristicas[habitacionElegida]);
        System.out.println("Cantidad de habitaciones: " + cantidadHabitaciones);
        System.out.printf("Precio por noche: $%.2f%n", precioPorNoche);
        System.out.printf("Días de estadía: %d%n", diasEstadia);
        System.out.printf("Precio total (antes de ajustes): $%.2f%n", precioTotal);
        System.out.printf("Ajuste por descuento/aumento (por noche): %s $%.2f%n", ajuste > 0 ? "+" : "-", Math.abs(ajuste));
        System.out.printf("Precio final: $%.2f%n", precioFinal);

        System.out.println("\n¿Desea confirmar esta reserva? (Si/No): ");
        String confirmacion = scanner.next();
        if (!confirmacion.equalsIgnoreCase("Si")) {
            System.out.println("Reserva cancelada.");
            return;
        }

        System.out.println("\n--- Complete los datos personales para finalizar la reserva ---");
        System.out.print("Ingrese su Nombre: ");
        scanner.nextLine();
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su Fecha de Nacimiento (dd/MM/yyyy): ");
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }

        System.out.print("Ingrese su Email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su Nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su Número de Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese su Hora Aproximada de Llegada (HH:mm): ");
        String horaLlegada = scanner.nextLine();

        nombresReservas[totalReservas] = nombre + " " + apellido;
        fechaNacimientoReservas[totalReservas] = fechaNacimiento;
        emailsReservas[totalReservas] = email;
        hotelesReservas[totalReservas] = hotelNombres[habitacionHotelID[habitacionElegida]];
        habitacionesReservas[totalReservas] = habitacionTipos[habitacionElegida];
        fechasInicioReservas[totalReservas] = fechaInicio;
        fechasFinReservas[totalReservas] = fechaSalida;
        cantidadAdultosReservas[totalReservas] = cantidadAdultos;
        cantidadNiniosReservas[totalReservas] = cantidadNinios;
        cantidadHabitacionesReservas[totalReservas] = cantidadHabitaciones;

        int hotelID = habitacionHotelID[habitacionElegida];

        if (hotelID < 0 || hotelID >= hotelReservas.length || hotelNombres[hotelID] == null) {
            System.out.println("Error: ID de hotel inválido. No se puede registrar la reserva.");
            return;
        }
        hotelReservas[hotelID][totalReservasPorHotel[hotelID]] = totalReservas;
        totalReservasPorHotel[hotelID]++;

        totalReservas++;

        System.out.println("\nReserva confirmada con éxito. ¡Gracias por usar HotelApp!");
    }

    public static void cancelarReserva(Scanner scanner) {
        System.out.println("\n--- Cancelar una Reserva ---");

        System.out.print("Ingrese su Email: ");
        String email = scanner.nextLine();

        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Ingrese su Fecha de Nacimiento (dd/MM/yyyy): ");
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }

        int reservaIndex = -1;
        for (int i = 0; i < totalReservas; i++) {
            if (emailsReservas[i] != null && emailsReservas[i].equalsIgnoreCase(email) &&
                    fechaNacimientoReservas[i] != null && fechaNacimientoReservas[i].equals(fechaNacimiento)) {
                reservaIndex = i;
                break;
            }
        }

        if (reservaIndex == -1) {
            System.out.println("No se encontró ninguna reserva asociada a los datos ingresados.");
            return;
        }

        System.out.println("\nReserva encontrada:");
        mostrarDetallesReserva(reservaIndex);

        System.out.print("¿Está seguro de que desea cancelar esta reserva? (Si/No): ");
        String confirmacion = scanner.next();
        if (!confirmacion.equalsIgnoreCase("Si")) {
            System.out.println("Cancelación abortada.");
            return;
        }

        restaurarDisponibilidad(reservaIndex);

        for (int i = reservaIndex; i < totalReservas - 1; i++) {
            nombresReservas[i] = nombresReservas[i + 1];
            fechaNacimientoReservas[i] = fechaNacimientoReservas[i + 1];
            emailsReservas[i] = emailsReservas[i + 1];
            hotelesReservas[i] = hotelesReservas[i + 1];
            habitacionesReservas[i] = habitacionesReservas[i + 1];
            fechasInicioReservas[i] = fechasInicioReservas[i + 1];
            fechasFinReservas[i] = fechasFinReservas[i + 1];
            cantidadAdultosReservas[i] = cantidadAdultosReservas[i + 1];
            cantidadNiniosReservas[i] = cantidadNiniosReservas[i + 1];
            cantidadHabitacionesReservas[i] = cantidadHabitacionesReservas[i + 1];
        }

        totalReservas--;

        System.out.println("La reserva ha sido cancelada exitosamente.");
    }

    public static void restaurarDisponibilidad(int reservaIndex) {
        String hotel = hotelesReservas[reservaIndex];
        String tipoHabitacion = habitacionesReservas[reservaIndex];
        LocalDate inicio = fechasInicioReservas[reservaIndex];
        LocalDate fin = fechasFinReservas[reservaIndex];

        int hotelID = -1;
        int habitacionID = -1;

        for (int i = 0; i < hotelNombres.length; i++) {
            if (hotelNombres[i] != null && hotelNombres[i].equals(hotel)) {
                hotelID = i;
                break;
            }
        }

        for (int i = 0; i < habitacionTipos.length; i++) {
            if (habitacionHotelID[i] == hotelID && habitacionTipos[i].equals(tipoHabitacion)) {
                habitacionID = i;
                break;
            }
        }

        if (habitacionID == -1) {
            System.out.println("Error: No se pudo encontrar la habitación asociada a la reserva cancelada.");
            return;
        }

        int añoRelativo = inicio.getYear() - LocalDate.now().getYear();
        for (int dia = inicio.getDayOfYear(); dia <= fin.getDayOfYear(); dia++) {
            habitacionDisponibilidad[habitacionID][añoRelativo][dia] = true;
        }
    }

    public static void realizarBloqueoHabitaciones(int habitacion, LocalDate inicio, LocalDate fin) {
        int año = inicio.getYear() - LocalDate.now().getYear();
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
                continue;
            }
            boolean encontrado = false;

            for (int i = 0; i < indiceUnico; i++) {
                if (item.equals(listaUnica[i])) {
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                listaUnica[indiceUnico++] = item;
            }
        }

        String[] resultado = new String[indiceUnico];
        System.arraycopy(listaUnica, 0, resultado, 0, indiceUnico);
        return resultado;
    }

    public static int listarOpciones(Scanner scanner, String[] opciones) {
        for (int i = 0; i < opciones.length && opciones[i] != null; i++) {
            System.out.printf("%d. %s%n", i + 1, opciones[i]);
        }
        int seleccion;
        do {
            seleccion = solicitarNumero(scanner, "Elija el número correspondiente: ") - 1;
            if (seleccion < 0 || seleccion >= opciones.length) {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (seleccion < 0 || seleccion >= opciones.length);

        return seleccion;
    }

    public static String[] filtrarHoteles(int ciudadElegida, int tipoElegido, String[] ciudadesUnicas, String[] tiposAlojamientoUnicos) {
        String[] resultado = new String[100];
        int indice = 0;


        String ciudadSeleccionada = ciudadesUnicas[ciudadElegida];

        int indiceCiudad = 0;
        for (int i = 0; i < ciudades.length; i++) {
            if (ciudades[i].equals(ciudadSeleccionada)) {
                indiceCiudad = i;
                break;
            }
        }

        String tipoSeleccionado = tiposAlojamientoUnicos[tipoElegido];

        int indiceTipoAlojamiento = 0;
        for (int i = 0; i < tipoAlojamiento.length; i++) {
            if (tipoAlojamiento[i].equals(tipoSeleccionado)) {
                indiceTipoAlojamiento = i;
                break;
            }
        }

        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudades[indiceCiudad]) && tipoAlojamiento[i].equals(tipoAlojamiento[indiceTipoAlojamiento])) {
                resultado[indice++] = String.format("%s - Precio Base: $%.2f - Calificación: %d estrellas",
                        hotelNombres[i], precios[i], calificaciones[i]);
            }
        }

        System.out.printf("Hoteles disponibles para ciudad: %s, tipo: %s: %d resultado(s)%n", ciudadSeleccionada, tipoSeleccionado, indice);

        String[] hotelesFiltrados = new String[indice];
        System.arraycopy(resultado, 0, hotelesFiltrados, 0, indice);
        return hotelesFiltrados;
    }

    public static String[] filtrarHabitaciones(int hotelElegido, String[] hotelesDisponibles) {
        if (hotelesDisponibles == null || hotelesDisponibles.length == 0) {
            System.out.println("No hay hoteles disponibles.");
            return new String[0];
        }

        if (hotelElegido < 0 || hotelElegido >= hotelesDisponibles.length) {
            System.out.println("Error: Selección de hotel fuera de rango.");
            return new String[0];
        }

        String[] resultado = new String[100];
        int indice = 0;

        String hotelSeleccionado = hotelesDisponibles[hotelElegido];

        int indiceHotel = -1;
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (hotelSeleccionado.contains(hotelNombres[i])) {
                indiceHotel = i;
                break;
            }
        }

        if (indiceHotel == -1) {
            System.out.println("Error: No se encontró el hotel seleccionado en la base de datos.");
            return new String[0];
        }

        for (int i = 0; i < habitacionHotelID.length && habitacionTipos[i] != null; i++) {
            if (habitacionHotelID[i] == indiceHotel) {
                if (tipoAlojamiento[indiceHotel].equalsIgnoreCase("Día de Sol")) {
                    if (habitacionTipos[i].equalsIgnoreCase("Activities")) {
                        resultado[indice++] = String.format("%s - Características: %s - Precio: $%.2f",
                                habitacionTipos[i], habitacionCaracteristicas[i], habitacionPrecios[i]);
                    }
                } else {
                    resultado[indice++] = String.format("%s - Características: %s - Precio: $%.2f",
                            habitacionTipos[i], habitacionCaracteristicas[i], habitacionPrecios[i]);
                }
            }
        }

        if (indice == 0) {
            System.out.println("No hay habitaciones disponibles en el hotel seleccionado.");
            return new String[0];
        }

        String[] habitacionesFiltradas = new String[indice];
        System.arraycopy(resultado, 0, habitacionesFiltradas, 0, indice);
        return habitacionesFiltradas;
    }

    public static double calcularDescuento(LocalDate inicio, LocalDate fin, double precioBase) {
        boolean aumento15 = false;
        boolean aumento10 = false;
        boolean descuento8 = false;

        LocalDate fecha = inicio;
        while (!fecha.isAfter(fin)) {
            int dia = fecha.getDayOfMonth();

            if (dia >= fecha.lengthOfMonth() - 4) {
                aumento15 = true;
            }

            if (dia >= 10 && dia <= 15) {
                aumento10 = true;
            }

            if (dia >= 5 && dia < 10) {
                descuento8 = true;
            }

            fecha = fecha.plusDays(1);
        }

        if (aumento15) {
            return precioBase * 0.15;
        } else if (aumento10) {
            return precioBase * 0.10;
        } else if (descuento8) {
            return -precioBase * 0.08;
        }

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
        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }

    /* Metodos de Actualización de Reservas */

    public static void actualizarReserva(Scanner scanner) {
        System.out.println("\n--- Actualizar una Reserva ---");

        System.out.print("Ingrese su Email: ");
        String email = scanner.nextLine();

        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            System.out.print("Ingrese su Fecha de Nacimiento (dd/MM/yyyy): ");
            try {
                fechaNacimiento = LocalDate.parse(scanner.nextLine(), formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Por favor, intente de nuevo.");
            }
        }

        int reservaIndex = -1;
        for (int i = 0; i < totalReservas; i++) {
            if (emailsReservas[i] != null && fechaNacimientoReservas[i] != null &&
                    emailsReservas[i].equalsIgnoreCase(email) &&
                    fechaNacimientoReservas[i].equals(fechaNacimiento)) {
                reservaIndex = i;
                break;
            }
        }

        if (reservaIndex == -1) {
            System.out.println("No se encontró ninguna reserva asociada a los datos ingresados.");
            return;
        }

        System.out.println("\nReserva encontrada:");
        mostrarDetallesReserva(reservaIndex);

        String[] hotelesDisponibles = obtenerHotelesDisponiblesParaReserva(reservaIndex);

        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Fechas de Estadía");
        System.out.println("2. Hotel");
        System.out.println("3. Tipo de Habitación");
        System.out.println("4. Cantidad de Habitaciones");
        System.out.println("5. Datos Personales");
        System.out.println("6. Cancelar");
        while (true) {
            int opcion = solicitarNumero(scanner, "Ingrese su opción: ");
            switch (opcion) {
                case 1 -> actualizarFechas(scanner, reservaIndex);
                case 2 -> actualizarHotel(scanner, reservaIndex);
                case 3 -> actualizarTipoHabitacion(scanner, reservaIndex, hotelesDisponibles);
                case 4 -> actualizarCantidadHabitaciones(scanner, reservaIndex);
                case 5 -> actualizarDatosPersonales(scanner, reservaIndex);
                case 6 -> {
                    System.out.println("Actualización cancelada.");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    public static String[] obtenerHotelesDisponiblesParaReserva(int reservaIndex) {
        String ciudadReserva = null;
        String tipoAlojamientoReserva = null;

        for (int i = 0; i < hotelNombres.length; i++) {
            if (hotelNombres[i] != null && hotelNombres[i].equals(hotelesReservas[reservaIndex])) {
                ciudadReserva = ciudades[i];
                tipoAlojamientoReserva = tipoAlojamiento[i];
                break;
            }
        }

        if (ciudadReserva == null || tipoAlojamientoReserva == null) {
            System.out.println("Error: No se pudieron recuperar los datos del hotel asociado a la reserva.");
            return new String[0];
        }

        String[] hotelesDisponibles = new String[100];
        int indice = 0;
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadReserva) && tipoAlojamiento[i].equals(tipoAlojamientoReserva)) {
                hotelesDisponibles[indice++] = hotelNombres[i];
            }
        }

        String[] hotelesFiltrados = new String[indice];
        System.arraycopy(hotelesDisponibles, 0, hotelesFiltrados, 0, indice);

        return hotelesFiltrados;
    }

    public static void mostrarDetallesReserva(int reservaIndex) {
        System.out.println("Detalles de la Reserva:");
        System.out.printf("Nombre: %s%n", nombresReservas[reservaIndex]);
        System.out.printf("Email: %s%n", emailsReservas[reservaIndex]);
        System.out.printf("Fecha de Nacimiento: %s%n", fechaNacimientoReservas[reservaIndex]);
        System.out.printf("Hotel: %s%n", hotelesReservas[reservaIndex]);
        System.out.printf("Tipo de Habitación: %s%n", habitacionesReservas[reservaIndex]);
        System.out.printf("Fecha Inicio: %s%n", fechasInicioReservas[reservaIndex]);
        System.out.printf("Fecha Fin: %s%n", fechasFinReservas[reservaIndex]);
        System.out.printf("Cantidad de Habitaciones: %d%n", cantidadHabitacionesReservas[reservaIndex]);
        System.out.printf("Cantidad de Adultos: %d%n", cantidadAdultosReservas[reservaIndex]);
        System.out.printf("Cantidad de Niños: %d%n", cantidadNiniosReservas[reservaIndex]);
    }

    public static void actualizarFechas(Scanner scanner, int reservaIndex) {
        System.out.println("\n--- Actualizar Fechas de Estadía ---");

        LocalDate nuevaFechaInicio = solicitarFecha(scanner, "Ingrese la nueva fecha de ingreso (dd/MM/yyyy): ");
        LocalDate nuevaFechaFin = solicitarFecha(scanner, "Ingrese la nueva fecha de salida (dd/MM/yyyy): ");

        while (!nuevaFechaFin.isAfter(nuevaFechaInicio)) {
            System.out.println("La fecha de salida debe ser posterior a la fecha de ingreso.");
            nuevaFechaFin = solicitarFecha(scanner, "Ingrese la fecha de salida nuevamente (dd/MM/yyyy): ");
        }

        int habitacionID = -1;
        for (int i = 0; i < habitacionHotelID.length; i++) {
            if (habitacionHotelID[i] == reservaIndex) {
                habitacionID = i;
                break;
            }
        }

        if (habitacionID == -1) {
            System.out.println("Error: No se encontró la habitación asociada a la reserva.");
            return;
        }

        int añoRelativo = nuevaFechaInicio.getYear() - LocalDate.now().getYear();
        for (int dia = nuevaFechaInicio.getDayOfYear(); dia <= nuevaFechaFin.getDayOfYear(); dia++) {
            if (!habitacionDisponibilidad[habitacionID][añoRelativo][dia]) {
                System.out.println("No hay disponibilidad para las nuevas fechas seleccionadas.");
                return;
            }
        }

        fechasInicioReservas[reservaIndex] = nuevaFechaInicio;
        fechasFinReservas[reservaIndex] = nuevaFechaFin;
        System.out.println("Fechas de estadía actualizadas exitosamente.");
    }

    public static void actualizarCantidadHabitaciones(Scanner scanner, int reservaIndex) {
        System.out.println("\n--- Actualizar Cantidad de Habitaciones ---");

        int nuevaCantidadHabitaciones = solicitarNumero(scanner, "Ingrese la nueva cantidad de habitaciones: ");
        if (nuevaCantidadHabitaciones <= 0) {
            System.out.println("La cantidad de habitaciones debe ser mayor a 0.");
        } else {
            cantidadHabitacionesReservas[reservaIndex] = nuevaCantidadHabitaciones;
            System.out.println("Cantidad de habitaciones actualizada exitosamente a: " + nuevaCantidadHabitaciones);
        }
    }

    public static void actualizarTipoHabitacion(Scanner scanner, int reservaIndex, String[] hotelesDisponibles) {
        System.out.println("\n--- Actualizar Tipo de Habitación ---");

        String hotelActual = hotelesReservas[reservaIndex];

        int hotelID = -1;
        for (int i = 0; i < hotelNombres.length; i++) {
            if (hotelNombres[i] != null && hotelNombres[i].equals(hotelActual)) {
                hotelID = i;
                break;
            }
        }

        if (hotelID == -1) {
            System.out.println("Error: No se encontró el hotel asociado a la reserva actual.");
            return;
        }

        String[] habitacionesDisponibles = filtrarHabitaciones(hotelID, hotelesDisponibles);

        if (habitacionesDisponibles.length == 0) {
            System.out.println("No hay habitaciones disponibles en el hotel seleccionado.");
            return;
        }

        System.out.println("Seleccione una nueva habitación:");
        int habitacionElegida = listarOpciones(scanner, habitacionesDisponibles);

        habitacionesReservas[reservaIndex] = habitacionesDisponibles[habitacionElegida];
        System.out.println("El tipo de habitación ha sido actualizado a: " + habitacionesReservas[reservaIndex]);
    }

    public static void actualizarHotel(Scanner scanner, int reservaIndex) {
        System.out.println("\n--- Actualizar Hotel ---");

        String ciudadReserva = null;
        String tipoAlojamientoReserva = null;

        for (int i = 0; i < hotelNombres.length; i++) {
            if (hotelNombres[i] != null && hotelNombres[i].equals(hotelesReservas[reservaIndex])) {
                ciudadReserva = ciudades[i];
                tipoAlojamientoReserva = tipoAlojamiento[i];
                break;
            }
        }

        if (ciudadReserva == null || tipoAlojamientoReserva == null) {
            System.out.println("Error: No se pudieron recuperar los datos del hotel asociado a la reserva.");
            return;
        }

        String[] hotelesDisponibles = new String[100];
        int indice = 0;
        for (int i = 0; i < hotelNombres.length && hotelNombres[i] != null; i++) {
            if (ciudades[i].equals(ciudadReserva) && tipoAlojamiento[i].equals(tipoAlojamientoReserva)) {
                hotelesDisponibles[indice++] = hotelNombres[i];
            }
        }

        if (indice == 0) {
            System.out.println("No hay hoteles disponibles en la misma ciudad y tipo de alojamiento.");
            return;
        }

        String[] hotelesFiltrados = new String[indice];
        System.arraycopy(hotelesDisponibles, 0, hotelesFiltrados, 0, indice);

        System.out.println("Seleccione un nuevo hotel:");
        int hotelElegido = listarOpciones(scanner, hotelesFiltrados);

        hotelesReservas[reservaIndex] = hotelesFiltrados[hotelElegido];
        System.out.println("Hotel actualizado exitosamente a: " + hotelesReservas[reservaIndex]);
    }

    public static void actualizarDatosPersonales(Scanner scanner, int reservaIndex) {
        System.out.println("\n--- Actualizar Datos Personales ---");

        System.out.print("Ingrese su nuevo nombre: ");
        scanner.nextLine();
        String nuevoNombre = scanner.nextLine();

        System.out.print("Ingrese su nuevo email: ");
        String nuevoEmail = scanner.nextLine();

        System.out.println("Ingrese su fecha de nacimiento (dd/MM/yyyy): ");
        LocalDate nuevaFechaNacimiento = null;
        while (nuevaFechaNacimiento == null) {
            try {
                nuevaFechaNacimiento = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente de nuevo.");
            }
        }

        nombresReservas[reservaIndex] = nuevoNombre;
        emailsReservas[reservaIndex] = nuevoEmail;
        fechaNacimientoReservas[reservaIndex] = nuevaFechaNacimiento;
        System.out.println("Datos personales actualizados exitosamente.");
    }

    public static void mostrarReservasHotel(Scanner scanner) {
        System.out.println("\n--- Mostrar Reservas por Hotel ---");

        System.out.println("Seleccione un hotel:");
        int hotelID = listarOpciones(scanner, hotelNombres);

        if (hotelID < 0 || hotelID >= hotelNombres.length || hotelNombres[hotelID] == null) {
            System.out.println("Error: El hotel seleccionado no es válido.");
            return;
        }

        System.out.printf("\nReservas para el Hotel: %s%n", hotelNombres[hotelID]);

        int cantidadReservas = totalReservasPorHotel[hotelID];

        if (cantidadReservas <= 0) {
            System.out.println("No hay reservas asociadas a este hotel.");
            return;
        }

        for (int i = 0; i < cantidadReservas; i++) {
            int reservaID = hotelReservas[hotelID][i];

            if (reservaID < 0 || reservaID >= totalReservas || nombresReservas[reservaID] == null) {
                System.out.println("Error: Se encontró una reserva inválida. Saltando...");
                continue;
            }

            System.out.printf("\nReserva #%d:%n", i + 1);
            System.out.printf("Nombre del Cliente: %s%n", nombresReservas[reservaID]);
            System.out.printf("Email: %s%n", emailsReservas[reservaID]);
            System.out.printf("Fecha Inicio: %s%n", fechasInicioReservas[reservaID]);
            System.out.printf("Fecha Fin: %s%n", fechasFinReservas[reservaID]);
            System.out.printf("Habitación: %s%n", habitacionesReservas[reservaID]);
            System.out.printf("Adultos: %d | Niños: %d%n",
                    cantidadAdultosReservas[reservaID],
                    cantidadNiniosReservas[reservaID]);
        }
    }
}