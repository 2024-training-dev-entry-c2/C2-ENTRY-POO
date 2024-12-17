import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static Reserva[] reservas = new Reserva[100];
    static int reservaCount = 0;
    static int hotelSeleccionadoPorUsuarioIndex;
    static boolean continuarBuscandoAlojamiento = true;
    static Alojamiento[] alojamientos = new Alojamiento[5];

    public static void main(String[] args) {

        System.out.println("¡Bienvenido a Starlight Booking!");
        System.out.println("--- * --- * --- * --- * --- * ---");

        Scanner scanner = new Scanner(System.in);

        alojamientos[0] = new Hotel("Starlight Hotel", "Cartagena", 2, 4, true, 4.5, "nadar", true, true,
                new Habitacion[]{
                new Habitacion("Individual", "Cama individual", 100.0, 5),
                new Habitacion("Doble", "Cama doble", 120.0, 4),
                new Habitacion("Doble plus", "Cama King Size, baño privado", 150.0, 5),
                new Habitacion("Suite", "Cama King Size, baño privado, vistas al mar", 200.0, 3),
                new Habitacion("Presidencial", "Cama King Size, baño privado con Jacuzzi, vistas al mar", 200.50, 3)
        });
        alojamientos[1] = new Apartamento("Cosmos", "Venecia", 2, 4, false, 4.2, "", false, false,
                new Habitacion[]{
                new Habitacion("Mini", "Cama doble, cocina + mini sala + un baño compartidos", 120.0, 6),
                new Habitacion("Loft", "Cama doble, espacio abierto + cocina + un baño + sala + barra-comedor compaprtidos", 150.0, 4),
                new Habitacion("Duplex", "Cama doble, cocina + sala + comedor + un baño compartidos", 170.0, 4),
                new Habitacion("Tripex", "Cama doble, baño privado, cocina + sala + comedor compartidos", 180.25, 4),
                new Habitacion("De lujo", "Cama king, baño privado, sala con chimenea + cocina + comedor + mini bar compartidos", 200.0, 4)
                });
        alojamientos[2] = new Finca("Blue Moon", "Porto", 2, 4, false, 4.0, "", false, false,
                new Habitacion[]{
                new Habitacion("Cabaña", "Cama doble, baño privado, cocina + sala + comedor + jardin compartidos", 150.0, 9),
                new Habitacion("Urbana", "Cama King Size, baño privado, cerca a la ciudad, cocina + sala + comedor compartidos", 175.0, 7),
                new Habitacion("Rústica", "Cama King Size, baño privado, cocina + sala + comedor + mini granja compartido", 200.50, 7),
                new Habitacion("Ecológica", "Cama doble, baño privado, cocina + sala + comedor + granja + mini bosque compartidos", 220.0, 7),
                new Habitacion("Hacienda", "Cama doble, baño privado, cocina + sala + comedor + bosque, salon de eventos compartidos", 270.0, 7)
                });
        alojamientos[3] = new Hotel("Dark Sun Hotel", "Munich", 2, 4, true, 4.0, "nadar", true, false,
                new Habitacion[]{
                new Habitacion("Rubí", "Cama individual", 80.0, 9),
                new Habitacion("Esmeralda", "Cama doble", 100.0, 7),
                new Habitacion("Oro", "Cama King Size, baño privado", 150.0, 7),
                new Habitacion("Plata", "Cama King Size, baño privado, sala de estar", 200.0, 7),
                new Habitacion("Diamante", "Cama King Size, baño privado con Jacuzzi, sala de estar", 250.0, 7)
                });
        alojamientos[4] = new Hotel("Andromeda Hotel", "Cartagena", 2, 4, false, 4.0, "", false, false,
                new Habitacion[]{
                new Habitacion("Pluton", "Cama individual", 110.0, 5),
                new Habitacion("Venus", "Cama doble", 120.0, 4),
                new Habitacion("Marte", "Cama King Size, baño privado", 150.0, 5),
                new Habitacion("Saturno", "Cama King Size, baño privado, vistas al mar", 200.0, 3),
                new Habitacion("Jupiter", "Cama King Size, baño privado con Jacuzzi, vistas al mar", 200.50, 3)
                });

        do {
            // solicito datos al usuario
            System.out.println("Ingrese la ciudad destino:");
            String ciudad = scanner.nextLine();

            System.out.println("Ingrese el tipo de alojamiento que desea (Ejemplo: Hotel, Apartamento, Finca, Dia de Sol):");
            String tipo = scanner.nextLine();

            System.out.println("Ingrese la fecha de inicio de la estadia (en formato AAAA-MM-DD):");
            String fechaInicioString = scanner.nextLine();
            LocalDate inicioEstadia = convertirStringADate(fechaInicioString);

            System.out.println("Ingrese la fecha de fin de la estadia (en formato AAAA-MM-DD):");
            String fechaFinString = scanner.nextLine();
            LocalDate finEstadia = convertirStringADate(fechaFinString);

            System.out.println("Ingrese la cantidad de adultos que se van a hospedar:");
            int adultos = scanner.nextInt();

            System.out.println("Ingrese la cantidad de ninos que se van a hospedar:");
            int ninos = scanner.nextInt();

            System.out.println("Ingrese la cantidad de habitaciones que desea:");
            int habitaciones = scanner.nextInt();

            scanner.nextLine();

            buscarAlojamiento(alojamientos, ciudad, tipo, inicioEstadia, finEstadia, adultos, ninos, habitaciones);

        } while (continuarBuscandoAlojamiento);
        scanner.close();
    }

    // func para convertir la fecha de String a Date
    private static LocalDate convertirStringADate(String fechaString) {
        try {
            // formato esperado: "AAAA-MM-DD" "YYYY-MM-DD"
            String[] fechaPartes = fechaString.split("-");
            int anio = Integer.parseInt(fechaPartes[0]);
            int mes = Integer.parseInt(fechaPartes[1]) - 1; // los meses en Java son 0=Enero 11=Diciembre
            int dia = Integer.parseInt(fechaPartes[2]);

            LocalDate fecha = LocalDate.of(anio, mes, dia);
            return fecha;
        } catch (Exception e) {
            System.out.println("Error al ingresar la fecha. El formato debe ser YYYY-MM-DD.");
            return null;
        }
    }

    public static void buscarAlojamiento(Alojamiento[] alojamientos, String ciudad, String tipo, LocalDate inicioEstadia, LocalDate finEstadia, int adultos, int ninos, int habitaciones) {
        boolean alojamientoEncontrado = false;

        // calculando los dias de estadia
        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();

        // el alojamiento debe ser de un dia o mas
        if (diferenciaEnDias <= 0) {
            System.out.println("Debe alojarse como minimo un dia");
            return;
        }

        // Recorremos el arreglo de alojamientos
        for (int i = 0; i < alojamientos.length; i++) {
            Alojamiento alojamiento = alojamientos[i];

            int totalHabitacionesDisponibles = 0;
            for (int j = 0; j < alojamientos[i].getHabitaciones().length; j++) {
                totalHabitacionesDisponibles += alojamientos[i].getHabitaciones()[j].getHabitacionesDisponibles();
            }

            // Verificamos si la ciudad y el tipo coinciden con los proporcionados por el usuario
            if (((tipo.equalsIgnoreCase("Dia de Sol") &&
                alojamiento.ofreceDiaDeSol) || alojamiento.getClass().getSimpleName().equalsIgnoreCase(tipo)) &&
                alojamiento.getCiudadDestino().equalsIgnoreCase(ciudad) &&
                alojamiento.getMaxAdultos() >= adultos &&
                alojamiento.getMaxNinos() >= ninos &&
                totalHabitacionesDisponibles >= habitaciones) {
                    alojamientoEncontrado = true;
                    alojamiento.mostrarInfo(inicioEstadia, finEstadia, habitaciones, adultos, ninos, alojamiento.incluyeRefrigerio, alojamiento.incluyeAlmuerzo);
                    System.out.println("--------------------------");
            }
        }

        if (!alojamientoEncontrado) {
            System.out.println("No se encontraron alojamientos que coincidan con los criterios proporcionados.");
        }

        if (alojamientoEncontrado) {
            // solicito al usuario seleccionar un alojamiento
            Scanner scanner = new Scanner(System.in);
            System.out.println("Seleccione el alojamiento que desea (ingrese el nombre del alojamiento):");
            String hotelSeleccionadoPorUsuario = scanner.nextLine();

            // confirmar las habitaciones para el alojamiento seleccionado
            confirmarHabitaciones(alojamientos, hotelSeleccionadoPorUsuario, inicioEstadia, finEstadia, adultos, ninos, habitaciones);

            // Llamar al metodo para hacer la reserva
            System.out.println("Para proceder con la reserva, ingrese los siguientes datos:");
            // declaro las variables de datos del usuario que ingresara en el metodo
            String nombreUsuario = "", apellidoUsuario = "", correoUsuario = "", nacionalidadUsuario = "", horaLlegadaUsuario = "", nacimientoUsuario = "";
            int telefonoUsuario = 0;

            // confirmo si el usuario desea continuar con la reserva
            System.out.println("¿Desea continuar con la reserva? (Por favor digite Si o No)");
            String respuesta = scanner.nextLine();

            if (respuesta.equalsIgnoreCase("Si")) {
                // pido al usuario ingresar nuevamente cuantas habitaciones quiere reservar
                System.out.println("Ingrese nuevamente el número de habitaciones que desea reservar");
                int cantidadHabitaciones = scanner.nextInt();
                scanner.nextLine();

                // muestro los tipos de habitaciones disponibles segun el alojamiento que habia escogido el usuario
                System.out.println("Tipos de habitaciones disponibles:");
                for (int i = 0; i < alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length; i++) {
                    System.out.println((i + 1) + ". " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[i].getTiposDeHabitaciones());
                }
//                alojamientos[hotelSeleccionadoPorUsuarioIndex].mostrarHabitacionesDisponibles();


                // almaceno la cantidad de habitaciones que el usuario ingreso
                String[] habitacionesSeleccionadas = new String[cantidadHabitaciones];

                // el usuario debe seleccionar el tipo de habitacion por cada habitacion que quiera
                for (int i = 0; i < cantidadHabitaciones; i++) {
                    System.out.println("Seleccione el tipo de habitación #" + (i + 1) + ":");
                    int habitacionSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    // validando la seleccion. solo hay 5 tipos
                    if (habitacionSeleccionada < 1 || habitacionSeleccionada > alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                        i--;
                        continue;
                    }

                    int habitacionseleccionadaIndex = habitacionSeleccionada - 1;
                    // almaceno la seleccion del usuario
                    habitacionesSeleccionadas[i] = alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].getTiposDeHabitaciones();

                    // actualizo las habitaciones que quedan disponibles
                    alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].removerHabitacionesDisponibles(1);
                    System.out.println("Habitaciones disponibles actualizadas: " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionseleccionadaIndex].habitacionesDisponibles);
                }

                // solicito los datos de usuario
                System.out.println("Ingrese su nombre:");
                nombreUsuario = scanner.nextLine();

                System.out.println("Ingrese su apellido:");
                apellidoUsuario = scanner.nextLine();

                System.out.println("Ingrese su correo:");
                correoUsuario = scanner.nextLine();

                System.out.println("Ingrese su fecha de nacimiento con el formatio AAAA-MM-DD:");
                nacimientoUsuario = scanner.nextLine();

                System.out.println("Ingrese su nacionalidad:");
                nacionalidadUsuario = scanner.nextLine();

                System.out.println("Ingrese su teléfono:");
                telefonoUsuario = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese la hora de llegada (HH:mm):");
                horaLlegadaUsuario = scanner.nextLine();

                reservarAlojamiento(nombreUsuario, apellidoUsuario, correoUsuario, nacionalidadUsuario, telefonoUsuario, horaLlegadaUsuario, habitacionesSeleccionadas, nacimientoUsuario);

            } else {
            System.out.println("La reserva no se realizó.");
            }
        } else {
            System.out.println("No se encontraron alojamientos que coincidan con su busqueda. Intente nuevamente");
        }
    }


    // METODO PARA CONFIRMAR HABITACIONES
    public static void confirmarHabitaciones(Alojamiento[] alojamientos, String nombreHotel, LocalDate inicioEstadia, LocalDate finEstadia, int adultos, int ninos, int habitacionesSolicitadas) {
        boolean alojamientoEncontrado = false;

        // busco el indice del hotel seleccionado por el usuario
        int hotelIndex = -1;
        for (int i = 0; i < alojamientos.length; i++) {
            if (alojamientos[i].getNombreAlojamiento().equalsIgnoreCase(nombreHotel)) {
                hotelIndex = i;
                alojamientoEncontrado = true;
                break;
            }
        }
        if (!alojamientoEncontrado) {
            System.out.println("El hotel seleccionado no se encuentra disponible.");
            return;
        }

        hotelSeleccionadoPorUsuarioIndex = hotelIndex;

        // verifico la disponibilidad de habitaciones para las fechas seleccionadas
        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();

        if (diferenciaEnDias <= 0) {
            System.out.println("La estadia debe ser de al menos un día.");
            return;
        }

        int totalHabitacionesDisponibles = 0;
        for (int j = 0; j < alojamientos[hotelIndex].getHabitaciones().length; j++) {
            totalHabitacionesDisponibles += alojamientos[hotelIndex].getHabitaciones()[j].getHabitacionesDisponibles();
            // Verificamos si hay suficientes habitaciones disponibles
            if (totalHabitacionesDisponibles < habitacionesSolicitadas) {
                System.out.println("No hay suficientes habitaciones disponibles para la cantidad solicitada.");
                return;
            }
        }

        // Si hay habitaciones disponibles, mostramos los tipos de habitación, características y precios
        System.out.println("Tipos de habitaciones disponibles en " + alojamientos[hotelIndex].getNombreAlojamiento() + ":");

            alojamientos[hotelSeleccionadoPorUsuarioIndex].mostrarHabitacionesDisponibles();

    }

    // METODO PARA GUARDAR DATOS DEL USUARIO Y HACER LA RESERVA
    public static void reservarAlojamiento(String nombreUsuario, String apellidoUsuario, String correoUsuario, String nacionalidadUsuario, int telefonoUsuario, String horaLlegadaUsuario, String[] habitacionesSeleccionadas, String nacimientoUsuario) {

        // Crear la reserva
        Reserva reserva = new Reserva(nombreUsuario, apellidoUsuario, correoUsuario, nacionalidadUsuario, telefonoUsuario,
                horaLlegadaUsuario, habitacionesSeleccionadas, nacimientoUsuario);

        reservas[reservaCount] = reserva;
        // Confirmar la reserva
        System.out.println("\n¡Se ha realizado la reserva con éxito!: \n" + reserva);
        System.out.println("==========================================");
        menuBooking();
    }

    // METODO PARA LA GESTION Y ACTUALIZACION DE LAS RESERVAS
    public static void actualizarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su correo electrónico para autenticar su reserva:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (AAAA-MM-DD):");
        String nacimiento = scanner.nextLine();

        // busco la reserva
        boolean encontrada = false;
        int indiceReserva = -1;

        for (int i = 0; i < reservas.length; i++) {
            if (reservas[i].getCorreoUsuario().equals(correo) && reservas[i].getNacimientoUsuario().equals(nacimiento)) {
                indiceReserva = i;
                encontrada = true;
                break;
            }
        }

        if (encontrada) {
            System.out.println("\nReserva encontrada: \n" + reservas[indiceReserva].toString());

            System.out.println("¿Desea cambiar de habitación o de alojamiento? (Escriba 'habitacion' o 'alojamiento')");
            String eleccion = scanner.nextLine();

            if (eleccion.equalsIgnoreCase("habitacion")) {
                // Cambiar habitación
                System.out.println("Habitaciones actuales: ");
                for(int i = 0; i < reservas[indiceReserva].getHabitacionesSeleccionadas().length; i ++) {
                    System.out.println((i + 1) + ". " + reservas[indiceReserva].getHabitacionesSeleccionadas()[i]);
                }

                System.out.println("Escriba el nombre de la habitación que desea cambiar:");
                String habitacionActual = scanner.nextLine();

                boolean habitacionEncontrada = false;
                int indexHabitacionACambiarUsuario = 0;
                // verifica si la habitación está en la reserva
                for (int i = 0; i < reservas[indiceReserva].getHabitacionesSeleccionadas().length; i++) {
                    if (reservas[indiceReserva].getHabitacionesSeleccionadas()[i].equalsIgnoreCase(habitacionActual)) {
                        habitacionEncontrada = true;
                        indexHabitacionACambiarUsuario = i;
                        break;
                    }
                }
                if(!habitacionEncontrada) {
                    System.out.println("No se encontro la habitacion");
                    return;
                }
                int habitacionACambiarIndex = 0;
                // habitacion que el usuario va a cambiar vuelve a estar disponible
                for (int i = 0; i < alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length; i++) {
                    if (alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[i].getTiposDeHabitaciones().equalsIgnoreCase(habitacionActual)) {
                        habitacionACambiarIndex = i;
                        alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[habitacionACambiarIndex].agregarHabitacionesDisponibles(1);
                    }
                }

                // mostrar habitaciones disponibles para el cambio
                System.out.println("Habitaciones disponibles:");
                for (int i = 0; i < alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length; i++) {
                    System.out.println((i + 1) + ". " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[i].getTiposDeHabitaciones());
                }

                System.out.println("Seleccione de 1 a 5 la nueva habitación:");
                int nuevaHabitacion = scanner.nextInt();
                scanner.nextLine();

                if (hotelSeleccionadoPorUsuarioIndex != -1) {
                    // actualiza las habitaciones dispo en el alojamiento
                    alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[nuevaHabitacion - 1].removerHabitacionesDisponibles(1);
                    // actualiza la habitacion de la reserva
                    reservas[indiceReserva].getHabitacionesSeleccionadas()[indexHabitacionACambiarUsuario] = alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[nuevaHabitacion - 1].getTiposDeHabitaciones();
                    System.out.println("Habitaciones disponibles actualizadas: " + alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[nuevaHabitacion - 1].getHabitacionesDisponibles());
                    System.out.println("La habitación ha sido cambiada exitosamente.");
                } else {
                    System.out.println("Hubo un problema al actualizar la disponibilidad de habitaciones.");
                }
                menuBooking();

            } else if (eleccion.equalsIgnoreCase("alojamiento")) {
                // elimino la reserva actual
                System.out.println("Se ha eliminado la reserva actual.");
                for (int i = 0; i < reservas[indiceReserva].getHabitacionesSeleccionadas().length; i++) {
                    for (int j = 0; j < alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones().length; j++) {
                        if (alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[j].getTiposDeHabitaciones().equalsIgnoreCase(reservas[indiceReserva].getHabitacionesSeleccionadas()[i])) {
                            alojamientos[hotelSeleccionadoPorUsuarioIndex].getHabitaciones()[j].agregarHabitacionesDisponibles(1);
                        }
                    }
                }
                reservas[indiceReserva] = null;

                // Redirigir a crear una nueva reserva
                System.out.println("Redirigiendo a la creación de una nueva reserva...");
                continuarBuscandoAlojamiento = true;
            }
        } else {
            System.out.println("No se encontró una reserva con ese correo o fecha de nacimiento.");
            menuBooking();
        }
    }

    // METODO MENU
    public static void menuBooking() {
        Scanner scanner = new Scanner(System.in);
        // opciones para crear nueva, actualizar o salir del programa
        System.out.println("Elija una de las siguientes opciones: \n1. Crear una nueva reservar" +
                "\n2. Actualizar reserva \n3. salir de Starlight Booking");
        String respuestaActualizar = scanner.nextLine();

        if (respuestaActualizar.equalsIgnoreCase("1")) {
            continuarBuscandoAlojamiento = true;
            reservaCount ++;
        } else if (respuestaActualizar.equalsIgnoreCase("2")){
            actualizarReserva();
        } else {
            System.out.println("¡Gracias por reservar con Starlight Booking!");
            continuarBuscandoAlojamiento = false;
        }
    }
}
