package src;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    //arreglos para definir los alojamientos
    static String[] nombreAlojamiento = {
            // Hoteles
            "hotel plaza real",
            "hotel mar y sol",
            "hotel costa azul",
            // Apartamentos
            "apartamento los pinos",
            "apartamento vista al mar",
            "apartamento el eden",
            // Fincas
            "finca la esperanza",
            "finca el refugio",
            "finca san pedro",
            // Días de Sol
            "dia de sol playa blanca",
            "dia de sol paraiso natural",
            "dia de sol los delfines"
    };

    static String[] ciudadAlojamiento = {"cartagena", "cartagena", "santa marta", "santa marta", "cartagena", "santa marta", "cartagena", "cartagena", "santa marta", "cartagena", "santa marta", "cartagena"};
    static String[] tipoAlojamiento = {"hotel", "hotel", "hotel", "apartamento", "apartamento", "apartamento", "finca", "finca", "finca", "dia de sol", "dia de sol", "dia de sol"};
    static double[] calificacionAlojamiento = {4.5, 3.8, 4.2, 4.0, 3.5, 4.7, 4.3, 5.0, 3.9, 4.8, 4.1, 3.6};

    static int[][] cantHabitacionesAlojamiento = {
            // Hoteles: [Sencilla, Doble, Gold, Premium, Suite Presidencial]
            {17, 22, 33, 10, 7},  // Hotel Plaza Real
            {12, 18, 25, 8, 5},   // Hotel Mar y Sol
            {20, 30, 40, 12, 10}, // Hotel Costa Azul

            // Apartamentos: [Sencilla, Doble, Gold, Premium, Penthouse]
            {1, 1, 1, 1, 0},   // Apartamento Los Pinos
            {2, 0, 0, 0, 0},    // Apartamento Vista al Mar
            {0, 1, 1, 1, 3},     // Apartamento El Edén

            // Fincas: [Sencilla, Doble, Gold, Premium, Suite]
            {5, 8, 10, 3, 2},     // Finca La Esperanza
            {7, 10, 15, 4, 3},    // Finca El Refugio
            {4, 6, 8, 2, 1},      // Finca San Pedro

            // Días de Sol: [Acceso Básico, Familiar, Gold, Premium, VIP]
            {30, 40, 50, 25, 20}, // Día de Sol Playa Blanca
            {20, 30, 35, 15, 10}, // Día de Sol Paraíso Natural
            {25, 35, 45, 20, 15}  // Día de Sol Los Delfines
    };

    static int[] precioAlojamientos = {150000, 100000, 80000, 50000};

    //habitaciones
    static String[][] habitaciones = {
            // Hoteles
            {"hotel", "sencilla", "La habitación sencilla tiene una cama individual, aire acondicionado, TV de pantalla plana y baño privado.", "No incluye nada", "150000"},
            {"hotel", "doble", "La habitación doble tiene dos camas individuales, aire acondicionado, TV de pantalla plana y baño privado.", "Desayuno incluido", "200000"},
            {"hotel", "gold", "La habitación Gold cuenta con una cama king-size, vista al mar, aire acondicionado, cafetera, TV de pantalla plana y bañera.", "Desayuno y almuerzo incluidos", "300000"},
            {"hotel", "premium", "La habitación Premium ofrece una cama king-size, balcón privado, acceso al spa, cafetera, minibar y aire acondicionado.", "Todo incluido (desayuno, almuerzo, cena y acceso a piscina)", "450000"},
            {"hotel", "suite presidencial", "La suite presidencial cuenta con dos habitaciones, sala de estar, cocina equipada, jacuzzi, y vista panorámica.", "Todo incluido y servicio personalizado 24/7", "700000"},

            // Apartamentos
            {"apartamento", "sencilla", "La habitación sencilla tiene una cama individual, ventilador, TV de pantalla plana y baño compartido.", "No incluye nada", "100000"},
            {"apartamento", "doble", "La habitación doble tiene una cama matrimonial, aire acondicionado, cocina pequeña y balcón.", "No incluye nada", "150000"},
            {"apartamento", "gold", "El apartamento Gold tiene dos habitaciones, cocina equipada, sala de estar y balcón con vista a la ciudad.", "No incluye nada", "250000"},
            {"apartamento", "premium", "El apartamento Premium cuenta con tres habitaciones, cocina equipada, sala de estar amplia y balcón con vista al mar.", "No incluye nada", "350000"},
            {"apartamento", "penthouse", "El Penthouse incluye tres habitaciones, terraza privada, jacuzzi y una vista 360° de la ciudad.", "No incluye nada", "500000"},

            // Fincas
            {"finca", "sencilla", "La habitación sencilla tiene una cama individual, ventilador, y baño compartido.", "No incluye nada", "80000"},
            {"finca", "doble", "La habitación doble tiene una cama matrimonial, ventilador, baño privado y acceso a jardín.", "No incluye nada", "120000"},
            {"finca", "gold", "La habitación Gold cuenta con dos camas matrimoniales, baño privado y acceso a piscina.", "No incluye nada", "200000"},
            {"finca", "premium", "La habitación Premium ofrece una cama king-size, sala de estar y balcón con vista a las montañas.", "Desayuno incluido", "300000"},
            {"finca", "suite", "La suite incluye dos habitaciones, sala de estar, jacuzzi y vista panorámica.", "Desayuno y actividades al aire libre incluidas", "400000"},

            // Días de Sol
            {"dia de sol", "acceso basico", "Acceso al alojamiento con zonas de descanso y piscinas disponibles.", "Refrigerio incluido", "50000"},
            {"dia de sol", "familiar", "Acceso al alojamiento con áreas infantiles, piscina y zonas de picnic.", "Almuerzo incluido", "80000"},
            {"dia de sol", "gold", "Acceso al alojamiento con actividades guiadas, piscina y zonas de relax.", "Almuerzo y refrigerio incluidos", "120000"},
            {"dia de sol", "premium", "Acceso al alojamiento con todas las actividades disponibles, piscina y spa.", "Almuerzo, refrigerio y actividades recreativas", "180000"},
            {"dia de sol", "vip", "Acceso exclusivo a zonas privadas, spa, actividades personalizadas y almuerzo gourmet.", "Todo incluido (almuerzo, refrigerio y actividades premium)", "250000"}
    };

    //Para las reservas
    static LocalDate[][] fechasDisponibilidad = {
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, //Hotel Plaza Real
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Hotel Mar y Sol
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)},  // Hotel Costa Azul

            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Apartamento Los Pinos
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Apartamento Vista al Mar
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Apartamento El Edén

            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Finca La Esperanza
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Finca El Refugio
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Finca San Pedro

            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Día de Sol Playa Blanca
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, // Día de Sol Paraíso Natural
            {LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31)}, //Día de Sol Los Delfines
    };

    static String[][] reservas = new String[99][99];

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== Menú Principal ===");
            System.out.println("1. Buscar Alojamientos");
            System.out.println("2. Confirmar habitaciones en un hotel");
            System.out.println("3. Reservar");
            System.out.println("4. actualizar reserva");
            System.out.println("5. salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    formularioOpcion1();
                    break;
                case 2:
                    formularioConfirmacionHabitaciones();
                    break;
                case 3:
                    formularioReserva();
                    break;
                case 4:
                    actualizarReserva();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    public static void actualizarReserva() {

        boolean reservaEncontrada = false;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento dd/mm/yy: ");
        String fechaNacimiento = scanner.nextLine();
        scanner.nextLine();

        System.out.println("\n=== Resultado de la búsqueda de reservas ===");

        // Recorrer el arreglo de reservas
        for (int i = 0; i < reservas.length; i++) {
            // Verificar si el correo electrónico coincide y la fila no está vacía
            if (reservas[i][1] != null && reservas[i][1].equals(email)) {
                reservaEncontrada = true;

                // Mostrar detalles de la reserva
                System.out.println("Reserva encontrada:");
                System.out.println("Hotel: " + reservas[i][0]);
                System.out.println("Email: " + reservas[i][1]);

                if (reservas[i][2].equals("0")) {
                    System.out.println("Tipo de habitación: " + "sencilla");
                } else if (reservas[i][2].equals("1")) {
                    System.out.println("Tipo de habitación: " + "doble");
                } else if (reservas[i][2].equals("2")) {
                    System.out.println("Tipo de habitación: " + "gold");
                } else if (reservas[i][2].equals("3")) {
                    System.out.println("Tipo de habitación: " + "premium");
                } else if (reservas[i][2].equals("4")) {
                    System.out.println("Tipo de habitación: " + "penthouse");
                }

                System.out.println("Cantidad de habitaciones: " + reservas[i][3]);
                System.out.println("Hora de llegada: " + reservas[i][4]);
                System.out.println("Fecha de inicio: " + reservas[i][5]);
                System.out.println("Fecha de fin: " + reservas[i][6]);
                System.out.println("-------------------");
                System.out.print("Quiere un cambio de habitacion[0] o de alojamiento[1]: ");
                int cambioReserva = scanner.nextInt();
                scanner.nextLine();

                if (cambioReserva == 0) {
                    if (reservas[i][2].equals("0")) {
                        System.out.println("Usted tiene...Tipo de habitación: " + "sencilla");
                    } else if (reservas[i][2].equals("1")) {
                        System.out.println("Usted tiene...Tipo de habitación: " + "doble");
                    } else if (reservas[i][2].equals("2")) {
                        System.out.println("Usted tiene...Tipo de habitación: " + "gold");
                    } else if (reservas[i][2].equals("3")) {
                        System.out.println("Usted tiene...Tipo de habitación: " + "premium");
                    } else if (reservas[i][2].equals("4")) {
                        System.out.println("Usted tiene...Tipo de habitación: " + "penthouse");
                    }
                    System.out.println("Usted tiene ...Cantidad de habitaciones: " + reservas[i][3]);

                    int tipoHabitacion = convertirStringAInt(reservas[i][2]);
                    int cantidadHabitaciones = convertirStringAInt(reservas[i][3]);


                    LocalDate fechaInicio = LocalDate.parse(reservas[i][5]);
                    LocalDate fechaFin = LocalDate.parse(reservas[i][6]);

                    int mesInicio = fechaInicio.getMonthValue();
                    int diaInicio = fechaInicio.getDayOfMonth();

                    int mesFinalizacion = fechaFin.getMonthValue();
                    int diaFinalizacion = fechaFin.getDayOfMonth();
                    // Liberar las fechas
                    liberarFechas(i, fechaInicio, fechaFin);
                    ConfirmarHabitaciones(reservas[i][0], mesInicio, diaInicio, mesFinalizacion, diaFinalizacion, 0, 0, cantidadHabitaciones);

                    System.out.println("Ingresa la habitacion que desea (sencilla[0], doble[1], gold[2], premium[3], suite presidencial[4]/penthouse[4]/suite[4]/vip[4])");
                    int nuevaHabitacion = scanner.nextInt();
                    agregarReserva(reservas[i][0], reservas[i][1], nuevaHabitacion, cantidadHabitaciones, reservas[i][4], fechaInicio, fechaFin);
                    cantHabitacionesAlojamiento[i][tipoHabitacion] += cantidadHabitaciones;


                    //eliminar la reserva
                    for (int j = 0; j < reservas[i].length; j++) {
                        reservas[i][j] = null;
                    }
                } else if (cambioReserva == 1) {

                    int tipoHabitacion = convertirStringAInt(reservas[i][2]);
                    int cantidadHabitaciones = convertirStringAInt(reservas[i][3]);
                    cantHabitacionesAlojamiento[i][tipoHabitacion] += cantidadHabitaciones;

                    LocalDate fechaInicio = LocalDate.parse(reservas[i][5]);
                    LocalDate fechaFin = LocalDate.parse(reservas[i][6]);

                    // Liberar las fechas
                    liberarFechas(i, fechaInicio, fechaFin);

                    //eliminar la reserva
                    for (int j = 0; j < reservas[i].length; j++) {
                        reservas[i][j] = null;
                    }

                    formularioReserva();
                }

                break;
            }
        }

        // Si no se encontró ninguna reserva
        if (!reservaEncontrada) {
            System.out.println("No se encontraron reservas asociadas al email ingresado.");
        }


    }


    public static void formularioConfirmacionHabitaciones() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del hotel: ");
        String nombreHotel = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de adultos: ");
        int cantAdultos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de niños: ");
        int cantNinos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el numero de habitaciones que busca: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        ConfirmarHabitaciones(nombreHotel, mesInicio, diaInicio, mesfinalizacion, mesfinalizacion, cantAdultos, cantNinos, numHabitaciones);

    }

    public static void ConfirmarHabitaciones(String nombreHotel, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones) {

        LocalDate fechaInicio = LocalDate.of(2024, mesInicio, diaInicio);
        LocalDate fechaFin = LocalDate.of(2024, mesFinalizacion, diaFinalizacion);


        for (int i = 0; i < nombreAlojamiento.length; i++) {
            if (nombreHotel.equals(nombreAlojamiento[i])) {

                if (!validarFechasDisponibles(fechaInicio, fechaFin, i)) {
                    System.out.println("No hay disponibilidad para las fechas seleccionadas.");
                    return;
                }

                System.out.println("*** Habitaciones disponibles en " + nombreHotel + " ***");
                for (int j = 0; j < cantHabitacionesAlojamiento[i].length; j++) {
                    if (cantHabitacionesAlojamiento[i][j] >= numHabitaciones) {
                        // Obtener detalles de la habitación del arreglo `habitaciones`
                        for (String[] habitacion : habitaciones) {
                            if (tipoAlojamiento[i].equals(habitacion[0]) && obtenerIndiceTipoHabitacion(habitacion[1]) == j) {
                                // Mostrar detalles de la habitación
                                System.out.println("=== Habitación " + habitacion[1] + " ===");
                                System.out.println("Características: " + habitacion[2]);
                                System.out.println("Extras: " + habitacion[3]);
                                System.out.println("Precio: $" + habitacion[4]);
                                System.out.println("--------------------------------");
                            }
                        }
                    }
                }
                return;
            }
        }

        // Si no se encuentra el hotel
        System.out.println("El hotel '" + nombreHotel + "' no existe en la base de datos.");
    }

    private static int obtenerIndiceTipoHabitacion(String tipoHabitacion) {
        switch (tipoHabitacion) {
            case "sencilla":
                return 0;
            case "doble":
                return 1;
            case "gold":
                return 2;
            case "premium":
                return 3;
            case "suite presidencial":
            case "penthouse":
            case "suite":
            case "vip":
                return 4;
            default:
                return -1; // Tipo no reconocido
        }
    }


    public static void formularioReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Formulario de Reserva ===");
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su nacionalidad: ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese su hora aproximada de llegada: ");
        String horaLlegada = scanner.nextLine();

        System.out.print("Ingrese el nombre del alojamiento: ");
        String alojamiento = scanner.nextLine();


        int tipoHabitacion = 0;
        System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], suite presidencial[4]/penthouse[4]/suite[4]/vip[4]): ");
        tipoHabitacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        reservarHabitacion(nombre, apellido, email, nacionalidad, telefono, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, horaLlegada, alojamiento, tipoHabitacion, cantidadHabitaciones);

    }

    public static void reservarHabitacion(String nombre, String apellido, String email, String nacionalidad, String telefono, int mesInicio, int diaInicio, int mesfinalizacion, int diaFinalizacion, String horaLlegada, String alojamiento, int tipoHabitacion, int cantidadHabitaciones) {

        LocalDate fechaInicio = LocalDate.of(2024, mesInicio, diaInicio);
        LocalDate fechaFin = LocalDate.of(2024, mesfinalizacion, diaFinalizacion);

        for (int i = 0; i < nombreAlojamiento.length; i++) {
            if (alojamiento.equals(nombreAlojamiento[i])) {

                if (!validarFechasDisponibles(fechaInicio, fechaFin, i)) {
                    System.out.println("No hay disponibilidad para las fechas seleccionadas.");
                    return;
                }

                if (cantHabitacionesAlojamiento[i][tipoHabitacion] >= cantidadHabitaciones) {
                    cantHabitacionesAlojamiento[i][tipoHabitacion] -= cantidadHabitaciones;

                    // Actualizar fechas de disponibilidad
                    LocalDate fechaInicioActual = fechasDisponibilidad[i][0];
                    LocalDate fechaFinActual = fechasDisponibilidad[i][1];

                    if (fechaInicio.isAfter(fechaInicioActual) && fechaFin.isBefore(fechaFinActual)) {
                        // Dividir el rango en dos (antes y después de la reserva)
                        fechasDisponibilidad[i][0] = fechaFin.plusDays(1); // Nueva fecha de inicio
                    } else if (fechaInicio.isAfter(fechaInicioActual)) {
                        // Acortar el rango inicial
                        fechasDisponibilidad[i][1] = fechaInicio.minusDays(1); // Nueva fecha de fin
                    } else if (fechaFin.isBefore(fechaFinActual)) {
                        // Acortar el rango final
                        fechasDisponibilidad[i][0] = fechaFin.plusDays(1); // Nueva fecha de inicio
                    } else {
                        // Reservación cubre todo el rango
                        fechasDisponibilidad[i][0] = null;
                        fechasDisponibilidad[i][1] = null;
                    }
                    agregarReserva(alojamiento, email, tipoHabitacion, cantidadHabitaciones, horaLlegada, fechaInicio, fechaFin);
                } else {
                    System.out.println("--------------------------------");
                    System.out.println("No hay habitaciones disponibles para este tipo de habitacion");
                }

            }
        }

    }

    public static void agregarReserva(String nombreHotel, String email, int tipoHabitacion, int cantidadHabitaciones, String horaLlegada, LocalDate fechaInicio, LocalDate fechaFin) {

        for (int i = 0; i < reservas.length; i++) {
            // Verificar si la fila está vacía
            if (reservas[i][0] == null) {
                reservas[i][0] = nombreHotel;
                reservas[i][1] = email;
                String conversorTipoHabitacion = "" + tipoHabitacion;
                reservas[i][2] = conversorTipoHabitacion;
                String conversorCantidadHabitaciones = "" + cantidadHabitaciones;
                reservas[i][3] = conversorCantidadHabitaciones;
                reservas[i][4] = horaLlegada;

                String conversorFechaInicio = "" + fechaInicio;
                reservas[i][5] = conversorFechaInicio;

                String conversorFechaFin = "" + fechaFin;
                reservas[i][6] = conversorFechaFin;

                System.out.println("Se ha realizado la reserva con éxito");
                return;
            }
        }
    }


    public static void formularioOpcion1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("En que ciudad quiere buscar alojamiento?: ");
        String ciudad = scanner.nextLine();

        System.out.print("Que tipo de alojamiento busca? (hotel, apartamento, finca, dia de sol): ");
        String alojamiento = scanner.nextLine();

        System.out.print("Ingrese el mes de inicio del hospedaje: ");
        int mesInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de inicio del hospedaje: ");
        int diaInicio = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el mes de finalizacion del hospedaje: ");
        int mesfinalizacion = scanner.nextInt();
        scanner.nextLine(); // Limpia el buffer de nueva línea

        System.out.print("Ingrese el dia de finalización del hospedaje : ");
        int diaFinalizacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de adultos: ");
        int cantAdultos = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la cantidad de niños: ");
        int cantNinos = scanner.nextInt();
        scanner.nextLine();

        int tipoHabitacion = 0;

        if (alojamiento.equals("hotel")) {
            System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], suite presidencial[4]): ");
            tipoHabitacion = scanner.nextInt();
        } else if (alojamiento.equals("apartamento")) {
            System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], penthouse[4]): ");
            tipoHabitacion = scanner.nextInt();
        } else if (alojamiento.equals("finca")) {
            System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], suite[4]): ");
            tipoHabitacion = scanner.nextInt();
        } else if (alojamiento.equals("dia de sol")) {
            System.out.print("Ingrese el tipo de habitacion que busca (sencilla[0], doble[1], gold[2], premium[3], vip[4]): ");
            tipoHabitacion = scanner.nextInt();
        }

        System.out.print("Ingrese el numero de habitaciones que busca: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        System.out.println("-------------------");

        buscarHoteles(ciudad, alojamiento, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, cantAdultos, cantNinos, tipoHabitacion, numHabitaciones);
    }


    public static void buscarHoteles(String ciudad, String alojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int tipoHabitacion, int numHabitaciones) {

        LocalDate fechaInicio = LocalDate.of(2024, mesInicio, diaInicio);
        LocalDate fechaFin = LocalDate.of(2024, mesFinalizacion, diaFinalizacion);

        System.out.println("Buscando alojamientos...");
        //String[][] alojamientosDisponibles = new String[12][12];
        System.out.println("-------------------");
        if (alojamiento.equals("dia de sol")) {
            mostrarAlojamientosConDiaDeSol(ciudad, alojamiento, fechaInicio, fechaFin, diaInicio, diaFinalizacion, numHabitaciones);
            return;
        }


        for (int i = 0; i < cantHabitacionesAlojamiento.length; i++) {
            if (cantHabitacionesAlojamiento[i][tipoHabitacion] >= numHabitaciones && ciudad.equals(ciudadAlojamiento[i]) && alojamiento.equals(tipoAlojamiento[i])) {
                if (validarFechasDisponibles(fechaInicio, fechaFin, i)) {
                    double precioBaseHabitacion = obtenerPrecioBase(alojamiento);
                    double[] preciosTotales = CalcularTotalYDescuentosOAumentos(precioBaseHabitacion, diaInicio, diaFinalizacion, numHabitaciones);

                    System.out.println("Alojamiento: " + nombreAlojamiento[i]);
                    System.out.println("Calificación: " + calificacionAlojamiento[i]);
                    System.out.println("Precio por noche: " + preciosTotales[0]);
                    System.out.println("Precio total (días): " + preciosTotales[1]);
                    System.out.println("-------------------");
                }
            }
        }
    }


    private static void mostrarAlojamientosConDiaDeSol(String ciudad, String alojamiento, LocalDate fechaInicio, LocalDate fechaFin, int diaInicio, int diaFinalizacion, int numHabitaciones) {
        System.out.println("Alojamientos con servicio de día de sol en " + ciudad + ":");
        for (int i = 0; i < ciudadAlojamiento.length; i++) {
            if (ciudad.equals(ciudadAlojamiento[i])) {
                for (int j = 0; j < habitaciones.length; j++) {
                    if (habitaciones[j][0].equals("dia de sol") && alojamiento.equals(tipoAlojamiento[i]) && validarFechasDisponibles(fechaInicio, fechaFin, i)) {
                        double precioBaseHabitacion = obtenerPrecioBase(alojamiento);
                        double[] preciosTotales = CalcularTotalYDescuentosOAumentos(precioBaseHabitacion, diaInicio, diaFinalizacion, numHabitaciones);
                        System.out.println("Nombre: " + nombreAlojamiento[i]);
                        System.out.println("Tipo: " + tipoAlojamiento[i]);
                        System.out.println("Actividades: " + habitaciones[j][2]);
                        System.out.println("Incluye: " + habitaciones[j][3]);
                        System.out.println("Precio: " + preciosTotales[0]);
                        System.out.println("Precio Aumento o descuento: " + preciosTotales[1]);
                        System.out.println("-------------------");
                        break;
                    }
                }
            }
        }
    }

    private static double obtenerPrecioBase(String tipoAlojamiento) {
        switch (tipoAlojamiento) {
            case "hotel":
                return precioAlojamientos[0];
            case "apartamento":
                return precioAlojamientos[1];
            case "finca":
                return precioAlojamientos[2];
            case "dia de sol":
                return precioAlojamientos[3];
            default:
                return 0;
        }
    }

    public static double[] CalcularTotalYDescuentosOAumentos(double precioBaseHabitacion, int diaInicio, int diaFinalizacion, int numHabitaciones) {
        double precioTotal = 0;
        double descuentoOAumento = 0;

        precioTotal = precioBaseHabitacion * numHabitaciones;

        if (diaInicio >= 26 && diaFinalizacion <= 31) {
            descuentoOAumento = precioTotal * 0.15;
            descuentoOAumento = precioTotal + descuentoOAumento;
        } else if (diaInicio >= 10 && diaFinalizacion <= 15) {
            descuentoOAumento = precioTotal * 0.1;
            descuentoOAumento = precioTotal + descuentoOAumento;
        } else if (diaInicio >= 5 && diaFinalizacion <= 10) {
            descuentoOAumento = precioTotal * 0.08;
            descuentoOAumento = precioTotal - descuentoOAumento;
        }

        double[] total = {precioTotal, descuentoOAumento};

        return total;

    }

    private static boolean validarFechasDisponibles(LocalDate fechaInicio, LocalDate fechaFin, int indiceAlojamiento) {
        LocalDate disponibleDesde = fechasDisponibilidad[indiceAlojamiento][0];
        LocalDate disponibleHasta = fechasDisponibilidad[indiceAlojamiento][1];

        return !fechaInicio.isBefore(disponibleDesde) && !fechaFin.isAfter(disponibleHasta);
    }

    public static int convertirStringAInt(String str) {
        int resultado = 0;
        boolean esNegativo = false;
        int inicio = 0;

        // Comprobar si el número es negativo
        if (str.charAt(0) == '-') {
            esNegativo = true;
            inicio = 1; // Saltar el primer carácter
        }

        // Recorrer cada carácter del String
        for (int i = inicio; i < str.length(); i++) {
            char c = str.charAt(i);

            // Convertir el carácter a su valor numérico
            int digito = c - '0'; // '0' en ASCII es 48, por lo tanto '5' - '0' = 5

            // Validar que el carácter sea un dígito
            if (digito < 0 || digito > 9) {
                throw new IllegalArgumentException("El String contiene caracteres no numéricos.");
            }

            // Agregar el dígito al resultado final
            resultado = resultado * 10 + digito;
        }

        // Si era un número negativo, cambiar el signo
        if (esNegativo) {
            resultado = -resultado;
        }

        return resultado;
    }


    public static void liberarFechas(int indice, LocalDate fechaInicio, LocalDate fechaFin) {
        // Verificar si el índice es válido

        // Rango actual de disponibilidad
        LocalDate fechaInicioActual = fechasDisponibilidad[indice][0];
        LocalDate fechaFinActual = fechasDisponibilidad[indice][1];

        // Si no hay disponibilidad previa, simplemente establecer el rango liberado
        if (fechaInicioActual == null && fechaFinActual == null) {
            fechasDisponibilidad[indice][0] = fechaInicio;
            fechasDisponibilidad[indice][1] = fechaFin;
            return;
        }

        // Verificar si las fechas liberadas son contiguas con el rango actual
        if (fechaFin.plusDays(1).equals(fechaInicioActual)) {
            // Las fechas liberadas son inmediatamente antes del rango actual
            fechasDisponibilidad[indice][0] = fechaInicio;
        } else if (fechaInicio.minusDays(1).equals(fechaFinActual)) {
            // Las fechas liberadas son inmediatamente después del rango actual
            fechasDisponibilidad[indice][1] = fechaFin;
        } else if (fechaInicio.equals(fechaInicioActual) && fechaFin.equals(fechaFinActual)) {
            // Restaurar el rango completo
            fechasDisponibilidad[indice][0] = fechaInicio;
            fechasDisponibilidad[indice][1] = fechaFin;
        }
    }


}
