package src;

import src.alojamientos.Apartamento;
import src.alojamientos.DiaDeSol;
import src.alojamientos.Finca;
import src.alojamientos.Hotel;
import src.habitaciones.Habitacion;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    static Hotel[] hoteles = new Hotel[3];
    static Apartamento[] apartamentos = new Apartamento[3];
    static Finca[] fincas = new Finca[3];
    static DiaDeSol[] diasDeSol = new DiaDeSol[3];

    public static void inicializarAlojamientos() {
        // Crear hoteles
        hoteles[0] = new Hotel("hotel plaza real", "cartagena", 4.5, "hotel");
        hoteles[1] = new Hotel("hotel mar y sol", "cartagena", 3.8, "hotel");
        hoteles[2] = new Hotel("hotel costa azul", "santa marta", 4.2, "hotel");

        // Crear apartamentos
        apartamentos[0] = new Apartamento("apartamento los pinos", "santa marta", 4.0, "apartamento");
        apartamentos[1] = new Apartamento("apartamento vista al mar", "cartagena", 3.5, "apartamento");
        apartamentos[2] = new Apartamento("apartamento el eden", "santa marta", 4.7, "apartamento");

        // Crear fincas
        fincas[0] = new Finca("finca la esperanza", "cartagena", 4.3, "finca");
        fincas[1] = new Finca("finca el refugio", "cartagena", 5.0, "finca");
        fincas[2] = new Finca("finca san pedro", "santa marta", 3.9, "finca");

        // Crear días de sol
        diasDeSol[0] = new DiaDeSol("dia de sol playa blanca", "cartagena", 4.8, "dia de sol", "Actividades acuáticas", "Refrigerio, Almuerzo");
        diasDeSol[1] = new DiaDeSol("dia de sol paraiso natural", "santa marta", 4.1, "dia de sol", "Natación y recreación", "Desayuno, Almuerzo");
        diasDeSol[2] = new DiaDeSol("dia de sol los delfines", "cartagena", 3.6, "dia de sol", "Shows y acceso a piscinas", "Refrigerio, Almuerzo");
    }

    public static void asignarHabitaciones() {
        // Crear habitaciones por tipo de alojamiento
        Habitacion[] habitacionesHotel = {
                new Habitacion("sencilla", "Cama individual, aire acondicionado", "Sin extras", 150000),
                new Habitacion("doble", "Dos camas individuales, aire acondicionado", "Desayuno incluido", 200000),
                new Habitacion("gold", "Cama king-size, vista al mar", "Desayuno y almuerzo incluidos", 300000),
                new Habitacion("premium", "Cama king-size, balcón, spa", "Todo incluido", 450000),
                new Habitacion("suite presidencial", "Dos habitaciones, jacuzzi", "Servicio personalizado 24/7", 700000)
        };

        Habitacion[] habitacionesApartamento = {
                new Habitacion("sencilla", "Cama individual, ventilador", "Sin extras", 100000),
                new Habitacion("doble", "Cama matrimonial, cocina pequeña", "Sin extras", 150000),
                new Habitacion("gold", "Dos habitaciones, sala de estar", "Sin extras", 250000),
                new Habitacion("premium", "Tres habitaciones, balcón al mar", "Sin extras", 350000),
                new Habitacion("penthouse", "Terraza privada, jacuzzi", "Sin extras", 500000)
        };

        Habitacion[] habitacionesFinca = {
                new Habitacion("sencilla", "Cama individual, ventilador", "Sin extras", 80000),
                new Habitacion("doble", "Cama matrimonial, jardín", "Sin extras", 120000),
                new Habitacion("gold", "Dos camas matrimoniales, piscina", "Sin extras", 200000),
                new Habitacion("premium", "Cama king-size, balcón", "Desayuno incluido", 300000),
                new Habitacion("suite", "Jacuzzi, vista panorámica", "Actividades al aire libre", 400000)
        };

        Habitacion[] habitacionesDiaDeSol = {
                new Habitacion("acceso básico", "Piscinas y zonas de descanso", "Refrigerio incluido", 50000),
                new Habitacion("familiar", "Piscina y áreas infantiles", "Almuerzo incluido", 80000),
                new Habitacion("gold", "Actividades guiadas, relax", "Almuerzo y refrigerio incluidos", 120000),
                new Habitacion("premium", "Piscina, spa y recreación", "Almuerzo y actividades", 180000),
                new Habitacion("vip", "Zonas privadas y spa", "Todo incluido", 250000)
        };

        // Asignar habitaciones a cada tipo de alojamiento
        for (Hotel hotel : hoteles) {
            hotel.setHabitaciones(habitacionesHotel);
        }
        for (Apartamento apartamento : apartamentos) {
            apartamento.setHabitaciones(habitacionesApartamento);
        }
        for (Finca finca : fincas) {
            finca.setHabitaciones(habitacionesFinca);
        }
        for (DiaDeSol dia : diasDeSol) {
            dia.setHabitaciones(habitacionesDiaDeSol);
        }
    }

    public static void asignarCantHabitaciones() {
        // Asignar cantidad de habitaciones por tipo de alojamiento
        for (Hotel hotel : hoteles) {
            hotel.setCantHabitaciones(new int[]{10, 5, 3, 2, 1}); // [Sencillas, Dobles, Gold, Premium, Suite]
        }
        for (Apartamento apartamento : apartamentos) {
            apartamento.setCantHabitaciones(new int[]{8, 6, 4, 3, 2});
        }
        for (Finca finca : fincas) {
            finca.setCantHabitaciones(new int[]{6, 4, 3, 2, 1});
        }
        for (DiaDeSol dia : diasDeSol) {
            dia.setCantHabitaciones(new int[]{12, 8, 5, 4, 3});
        }
    }

    public static void main(String[] args) {
        inicializarAlojamientos();
        asignarHabitaciones();
        asignarCantHabitaciones();
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
                    //actualizarReserva();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    /*public static void actualizarReserva() {

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


    }*/


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


        for (int i = 0; i < hoteles.length; i++) {

            if (nombreHotel.equals(hoteles[i].getNombre())) {
                hoteles[i].mostrarInformacionHabitaciones(numHabitaciones);
            } else if (nombreHotel.equals(apartamentos[i].getNombre())) {
                apartamentos[i].mostrarInformacionHabitaciones(numHabitaciones);
            } else if (nombreHotel.equals(fincas[i].getNombre())) {
                fincas[i].mostrarInformacionHabitaciones(numHabitaciones);
            } else if (nombreHotel.equals(diasDeSol[i].getNombre())) {
                diasDeSol[i].mostrarInformacionHabitaciones(numHabitaciones);
            }

        }


        /*for (int i = 0; i < nombreAlojamiento.length; i++) {
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
        }*/


    }


    /*public static void formularioReserva() {
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

    }*/

    /*public static void reservarHabitacion(String nombre, String apellido, String email, String nacionalidad, String telefono, int mesInicio, int diaInicio, int mesfinalizacion, int diaFinalizacion, String horaLlegada, String alojamiento, int tipoHabitacion, int cantidadHabitaciones) {

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

    }*/

    /*public static void agregarReserva(String nombreHotel, String email, int tipoHabitacion, int cantidadHabitaciones, String horaLlegada, LocalDate fechaInicio, LocalDate fechaFin) {

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
    }*/


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

        System.out.print("Ingrese el numero de habitaciones que busca: ");
        int numHabitaciones = scanner.nextInt();
        scanner.nextLine();

        System.out.println("-------------------");

        buscarHoteles(ciudad, alojamiento, mesInicio, diaInicio, mesfinalizacion, diaFinalizacion, cantAdultos, cantNinos,numHabitaciones);
    }


    public static void buscarHoteles(String ciudad, String alojamiento, int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion, int cantAdultos, int cantNinos, int numHabitaciones) {

        LocalDate fechaInicio = LocalDate.of(2024, mesInicio, diaInicio);
        LocalDate fechaFin = LocalDate.of(2024, mesFinalizacion, diaFinalizacion);

        System.out.println("Buscando alojamientos...");

        System.out.println("-------------------");
        if (alojamiento.equals("hotel")) {
            for (int i = 0; i < hoteles.length; i++) {
                int[] cantHabitaciones = hoteles[i].getCantHabitaciones();
                if(ciudad.equals(hoteles[i].getCiudad()) && ((cantHabitaciones[0]>=numHabitaciones) || (cantHabitaciones[1]>=numHabitaciones) || (cantHabitaciones[2]>=numHabitaciones) || (cantHabitaciones[3]>=numHabitaciones) || (cantHabitaciones[4]>=numHabitaciones))){
                    hoteles[i].mostrarInformacionAlojamiento(numHabitaciones,diaInicio,diaFinalizacion);
                }
            }
        }else if(alojamiento.equals("apartamento")){
            for (int i = 0; i < apartamentos.length; i++) {
                int[] cantHabitaciones = apartamentos[i].getCantHabitaciones();
                if(ciudad.equals(apartamentos[i].getCiudad()) && ((cantHabitaciones[0]>=numHabitaciones) || (cantHabitaciones[1]>=numHabitaciones) || (cantHabitaciones[2]>=numHabitaciones) || (cantHabitaciones[3]>=numHabitaciones) || (cantHabitaciones[4]>=numHabitaciones))){
                    apartamentos[i].mostrarInformacionAlojamiento(numHabitaciones,diaInicio,diaFinalizacion);
                }
            }
        }else if(alojamiento.equals("finca")){
            for (int i = 0; i < fincas.length; i++) {
                int[] cantHabitaciones = fincas[i].getCantHabitaciones();
                if(ciudad.equals(fincas[i].getCiudad()) && ((cantHabitaciones[0]>=numHabitaciones) || (cantHabitaciones[1]>=numHabitaciones) || (cantHabitaciones[2]>=numHabitaciones) || (cantHabitaciones[3]>=numHabitaciones) || (cantHabitaciones[4]>=numHabitaciones))){
                    fincas[i].mostrarInformacionAlojamiento(numHabitaciones,diaInicio,diaFinalizacion);
                }
            }
        }else if(alojamiento.equals("dia de sol")){
            for (int i = 0; i < diasDeSol.length; i++) {
                int[] cantHabitaciones = diasDeSol[i].getCantHabitaciones();
                if(ciudad.equals(diasDeSol[i].getCiudad()) && ((cantHabitaciones[0]>=numHabitaciones) || (cantHabitaciones[1]>=numHabitaciones) || (cantHabitaciones[2]>=numHabitaciones) || (cantHabitaciones[3]>=numHabitaciones) || (cantHabitaciones[4]>=numHabitaciones))){
                    diasDeSol[i].mostrarInformacionAlojamiento(numHabitaciones,diaInicio,diaFinalizacion);
                }
            }
        }
    }




   /* private static boolean validarFechasDisponibles(LocalDate fechaInicio, LocalDate fechaFin, int indiceAlojamiento) {
        LocalDate disponibleDesde = fechasDisponibilidad[indiceAlojamiento][0];
        LocalDate disponibleHasta = fechasDisponibilidad[indiceAlojamiento][1];

        return !fechaInicio.isBefore(disponibleDesde) && !fechaFin.isAfter(disponibleHasta);
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
    }*/


}
