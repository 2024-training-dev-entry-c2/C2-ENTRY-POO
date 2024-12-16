package org.example;

import java.util.*;

public class Main {
    static  List<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
    static  List<Reserva> reservas = new ArrayList<Reserva>();
    static  List<String> ciudades = new ArrayList<>();

    public static void main(String[] args) {
        inicializarDatos();
        Scanner scanner = new Scanner(System.in);
        mostrarCiudades();

//


    }

    static private void inicializarDatos() {

        alojamientos.add(new Hotel("Hotel Paraíso", "Cartagena", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 camas sencillas, TV, baño privado", 200000, 5, 6))));
        alojamientos.add(new Apartamento("Apartamento Luna", "Bogotá", "Apartamento", 4.4,
                Arrays.asList(new Habitacion("Suite", "1 cama king, cocina equipada, balcón", 300000, 5, 3),
                        new Habitacion("Familiar", "2 camas dobles, sala comedor, cocina", 250000, 2, 5))));
        alojamientos.add(new Finca("Finca El Encanto", "Medellín", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));
        alojamientos.add(new DiaDeSol("Resort Brisa Marina", "Cartagena", "Día de Sol", 3.9,
                Arrays.asList(new Habitacion("Piscina", "Acceso a piscina y deportes acuáticos", 120000, 10, 10),
                        new Habitacion("Picnic", "Piscina/Toboganes y zona de picnic", 90000, 10, 10))));

    }

    static public void mostrarAlojamientosPorCiudad(String ciudad) {
        System.out.println("Alojamientos disponibles en " + ciudad + ":");
        boolean encontrados = false;
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println(alojamiento);
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron alojamientos en la ciudad seleccionada.");
        }
    }

    static public void mostrarCiudades(){
        System.out.println("Selecciona una ciudad:");
        for (Alojamiento alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.getCiudad())) {
                ciudades.add(alojamiento.getCiudad());
                System.out.println(ciudades.size() + ". " + alojamiento.getCiudad());
            }
        }
    }
//    }
//
//    public static ArrayList<Integer> buscarAlojamientos(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
//                                                        int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println("Consulta Realizada:");
//        List<Integer> alojamientoCiudad = filtrarPorSeleccion(ciudad, ciudades);
//        ArrayList<Integer> alojamientoFiltradosIndex = new ArrayList<>();
//        alojamientosfiltrados.clear();
//        int contador = 0;
//        for (int indexCiudad : alojamientoCiudad) {
//            if (tipos[indexCiudad] == tipoAlojamiento) {
//                System.out.println("/................../");
//                System.out.println("Ciudad: " + ciudad + "\n" + "\n" + "Nombre:" + nombres[indexCiudad] + "\n" + calificaciones[indexCiudad] + "⭐");
//                alojamientoFiltradosIndex.add(indexCiudad);
//                alojamientosfiltrados.add(nombres[indexCiudad]);
//                if (tipos[indexCiudad] == "Día de Sol") {
//                    mostrarHabitacionesActividades(indexCiudad, tipoAlojamiento, fechaInicio, fechaFin, cantidadHabitaciones, indexCiudad);
//                    System.out.println(incluyeAlmuerzo[indexCiudad] ? "Almuerzo: Si" : "Almuerzo: No");
//                } else {
//                    double precio = calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, preciosPorNoche[indexCiudad][0]);
//                }
//            }
//            contador++;
//        }
//        System.out.println(alojamientoFiltradosIndex);
//        return alojamientoFiltradosIndex;
//
//
//    }
//    public static void ciudadesEncontradas() {
//        ciudadesEncontradas.clear();
//        for (String ciudad : ciudades) {
//            if (!ciudadesEncontradas.contains((String) ciudad)) {
//                ciudadesEncontradas.add((String) ciudad);
//
//            }
//        }
//    }
//
//    public static void tiposAlojamientoEncontradas() {
//        tipoAlojamientos.clear();
//        for (String tipoAlojamiendo : tipos) {
//            if (!tipoAlojamientos.contains((String) tipoAlojamiendo)) {
//                tipoAlojamientos.add((String) tipoAlojamiendo);
//
//            }
//        }
//    }
//
//    public static List<Integer> filtrarPorSeleccion(String valorFiltro, String[] opciones) {
//        List<Integer> resultadoFiltro = new ArrayList<>();
//        int contador = 0;
//        for (String alojamiento : opciones) {
//            // Comprobamos si el alojamiento está en la ciudad busqueda
//            if (alojamiento == valorFiltro) {
//                resultadoFiltro.add(contador);
//            }
//            contador++;
//        }
//        return resultadoFiltro;
//    }
//
//    public static double calcularPrecio(int diaInicio, int diaFin, int cantidadHabitaciones, double precioHabitacion) {
//
//        int noches = diaFin - diaInicio + 1;
//        double precioTotal = precioHabitacion * noches * cantidadHabitaciones;
//
//        // Aplicar aumento o descuento según las fechas
//        double aumentoDesc = 0.0;
//        if (diaFin >= 25) {  // Los últimos 5 días del mes
//            aumentoDesc = 0.15;  // Aumento del 15%
//        } else if (diaInicio >= 10 && diaFin <= 15) {
//            aumentoDesc = 0.10;  // Aumento del 10%
//        } else if (diaInicio >= 5 && diaFin <= 10) {
//            aumentoDesc = -0.08;  // Descuento del 8%
//        }
//        double precioFinal = precioTotal * (1 + aumentoDesc);
//        System.out.println("Precio total: $" + precioTotal);
//        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
//        System.out.println("Precio final: $" + precioFinal);
//        return precioFinal;
//    }
//
//    public static void mostrarHabitacionesActividades(int indexAlojamiento, String tipoAlojamiento, int fechaInicio, int fechaFin, int cantidadHabitaciones, int indexCiudad) {
//        int contadorTipo = 0;
//        int contadorActividad = 1;
//        for (String[] habitacionesHotel : habitaciones[indexAlojamiento]) {
//            System.out.println(tipoAlojamiento == "Día de Sol" ?
//                    "Tipo " + contadorTipo + ":" + "\n" + "Actividad(es)" : (contadorTipo + 1) + ". " + habitaciones[indexAlojamiento][contadorTipo][0]);
//
//            if (tipoAlojamiento == "Día de Sol") {
//                for (String actividad : habitaciones[indexAlojamiento][contadorTipo]) {
//                    System.out.println(contadorActividad + ". " + actividad);
//                    contadorActividad++;
//                }
//                System.out.println("Precio:" + preciosPorNoche[indexAlojamiento][contadorTipo]);
//            } else {
//                System.out.println("Description: " + habitaciones[indexAlojamiento][contadorTipo][1]);
//                System.out.println("Max Personas: " + personasHabitacion[indexAlojamiento][contadorTipo]);
//                double precio = calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, preciosPorNoche[indexAlojamiento][contadorTipo]);
//            }
//            contadorTipo++;
//
//        }
//    }
//
//    public static void confirmarHabitaciones(String nombreHotel, int diaInicio, int diaFin, int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones, int indexAlojamiento) {
//        System.out.println("-------------------------------------------------------------------------------------");
//        System.out.println("Alojamiento seleccionado: " + nombreHotel);
//        mostrarHabitacionesActividades(indexAlojamiento, tipos[indexAlojamiento], diaInicio, diaFin, cantidadHabitaciones, indexAlojamiento);
//        System.out.println("_____________________>");
//        System.out.println("Disponibilidad de habitaciones:");
//        for (int i = 0; i < habitaciondisponibilidadDia.length; i++) {
//            if (habitaciondisponibilidadDia[i][1] == indexAlojamiento && habitaciondisponibilidadDia[i][4] == diaInicio && habitaciondisponibilidadDia[i][5] == diaFin) {
//                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
//                        + habitaciondisponibilidadDia[i][1] + " disponibles");
//            }
//        }
//        for (int i = 0; i < habitacionesDisponibles[indexAlojamiento].length; i++) {
//
//            if (habitacionesDisponibles[indexAlojamiento][i] > cantidadHabitaciones) {
//
//                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
//                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles");
//            } else {
//                System.out.println(habitaciones[indexAlojamiento][i][0] + ": "
//                        + habitacionesDisponibles[indexAlojamiento][i] + " disponibles (No Alcanzan las habitaciones disponibles)");
//            }
//
//
//        }
//
//    }
//
//    public static boolean reservarAlojamiento(int indexAlojamiento, int habitacionSeleccionada, int cantidadHabitaciones, String nombre, String apellido, String email, String nacionalidad, int telefono, int horaLlegada, int diaInicio, int diaFin, int adultos, int ninos) {
//        if (personasHabitacion[indexAlojamiento][habitacionSeleccionada] * cantidadHabitaciones >= (adultos + ninos)) {
//            if (habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada] >= cantidadHabitaciones) {
//                // Restar las habitaciones reservadas
//                habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada] -= cantidadHabitaciones;
//                // Confirmación de la reserva
//                System.out.println("-----------------------------------------------------");
//                System.out.println("¡Reserva realizada con éxito!");
//                System.out.println("Datos de la reserva:");
//                System.out.println("Nombre: " + nombre + " " + apellido);
//                System.out.println("Email: " + email);
//                System.out.println("Nacionalidad: " + nacionalidad);
//                System.out.println("Teléfono: " + telefono);
//                System.out.println("Hora de llegada: " + horaLlegada + ":00");
//                System.out.println("Hotel: " + nombres[indexAlojamiento]);
//                System.out.println("Habitación: " + habitaciones[indexAlojamiento][habitacionSeleccionada][0]);
//                System.out.println("Cantidad de habitaciones reservadas: " + cantidadHabitaciones);
//                System.out.println("-----------------------------------------------------");
//                return true;
//            } else {
//                // Mensaje de error si no hay suficientes habitaciones
//                System.out.println("-----------------------------------------------------");
//                System.out.println("Lo sentimos, no hay suficientes habitaciones disponibles.");
//                System.out.println("Habitaciones disponibles para este tipo: "
//                        + habitacionesDisponibles[indexAlojamiento][habitacionSeleccionada]);
//                System.out.println("-----------------------------------------------------");
//                return false;
//            }
//        } else {
//            System.out.println("Limite de Personas por habitacion superado");
//            return false;
//        }
//    }
//
//    public static void agregarReserva(String nombre, String email, String fechaNacimiento, int hotelID, int habitacionID) {
//        reservas[reservasCount][0] = String.valueOf(reservasCount); // ID de reserva
//        reservas[reservasCount][1] = nombre;
//        reservas[reservasCount][2] = email;
//        reservas[reservasCount][3] = fechaNacimiento;
//        reservas[reservasCount][4] = String.valueOf(hotelID);
//        reservas[reservasCount][5] = String.valueOf(habitacionID);
//        reservasCount++;
//        disponibilidadCount++;
//        System.out.println("Reserva creada con éxito. ID de reserva: " + (reservasCount - 1));
//    }
//
//    public static void autenticarYActualizarReserva(Scanner scanner) {
//        System.out.println("Ingrese su correo electrónico:");
//        String email = scanner.next();
//        System.out.println("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
//        String fechaNacimiento = scanner.next();
//
//        int reservaIndex = -1;
//
//        for (int i = 0; i < reservasCount; i++) {
//            if (reservas[i][2].equals(email) && reservas[i][3].equals(fechaNacimiento)) {
//                reservaIndex = i;
//                break;
//            }
//        }
//
//        if (reservaIndex == -1) {
//            System.out.println("Reserva no encontrada o credenciales incorrectas.");
//            return;
//        }
//
//        System.out.println("Reserva encontrada:");
//        System.out.println("Nombre: " + reservas[reservaIndex][1]);
//        System.out.println("Hotel: " + nombres[Integer.parseInt(reservas[reservaIndex][4])]);
//        System.out.println("Habitación: " + habitaciones[Integer.parseInt(reservas[reservaIndex][4])]
//                [Integer.parseInt(reservas[reservaIndex][5])][0]);
//
//
//        System.out.println("Seleccione la opción que desea realizar:");
//        System.out.println("1. Cambiar de habitación");
//        System.out.println("2. Cambiar de alojamiento");
//        int opcion = scanner.nextInt();
//
//        if (opcion == 1) {
//            cambiarHabitacion(scanner, reservaIndex);
//        } else if (opcion == 2) {
//            cambiarAlojamiento(scanner, reservaIndex);
//        } else {
//            System.out.println("Opción no válida.");
//        }
//    }
//
//    public static void cambiarHabitacion(Scanner scanner, int reservaIndex) {
//        int hotelID = Integer.parseInt(reservas[reservaIndex][4]);
//        System.out.println("Habitaciones disponibles en " + nombres[hotelID] + ":");
//
//        for (int i = 0; i < habitaciones[hotelID].length; i++) {
//            if (habitacionesDisponibles[hotelID][i] > 0) {
//                System.out.println(i + ". " + habitaciones[hotelID][i][0] + " - " + habitaciones[hotelID][i][1]);
//            }
//        }
//
//        System.out.println("Seleccione la nueva habitación:");
//        int nuevaHabitacion = scanner.nextInt();
//
//        if (habitacionesDisponibles[hotelID][nuevaHabitacion] > 0) {
//            habitacionesDisponibles[hotelID][nuevaHabitacion]--;
//            int habitacionAnterior = Integer.parseInt(reservas[reservaIndex][5]);
//            habitacionesDisponibles[hotelID][habitacionAnterior]++;
//            reservas[reservaIndex][5] = String.valueOf(nuevaHabitacion);
//            System.out.println("Cambio de habitación realizado con éxito.");
//        } else {
//            System.out.println("Habitación no disponible.");
//        }
//    }
//
//    public static void cambiarAlojamiento(Scanner scanner, int reservaIndex) {
//        int hotelID = Integer.parseInt(reservas[reservaIndex][4]);
//        int habitacionID = Integer.parseInt(reservas[reservaIndex][5]);
//        habitacionesDisponibles[hotelID][habitacionID]++;
//
//        System.out.println("La reserva ha sido cancelada. Por favor, cree una nueva reserva.");
//        reservas[reservaIndex][0] = null; // Marca como eliminada
//        main(new String[]{}); // Reinicia el proceso desde el principio
//    }
//
//    private static int validarSeleccion(int seleccion, int pasoActual) {
//        return (seleccion == -1) ? pasoActual - 1 : pasoActual + 1;
//    }
//
//    //funciones para validar y mostrar menus
//    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
//        int opcion = -1;
//        while (true) {
//            System.out.print("Ingrese un número" + ": ");
//            try {
//                opcion = scanner.nextInt();
//                if (opcion >= 1 && opcion <= maxOption) {
//                    return opcion - 1;
//                }
//                if (opcion == (maxOption + 1)) {
//                    System.out.println("close");
//                    return -1;
//                } else {
//                    System.out.println("Opción no válida. Debe estar entre 1 y " + (maxOption + 1) + ".");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                scanner.next();
//            }
//        }
//    }
//
//    public static int seleccionarOpcion(Scanner scanner, String mensaje, ArrayList<String> opciones) {
//        mostrarOpciones(mensaje, opciones);
//        return obtenerEntradaValida(scanner, opciones.size());
//    }
//
//    public static int seleccionarOpcionMenu(Scanner scanner, String mensaje, String[] opciones) {
//        mostrarOpcionesMenu(mensaje, opciones);
//        return obtenerEntradaValida(scanner, opciones.length);
//    }
//
//    public static void mostrarOpciones(String mensaje, ArrayList<String> opciones) {
//        System.out.println(mensaje);
//        for (int i = 0; i < opciones.size(); i++) {
//            System.out.println((i + 1) + ". " + opciones.get(i));
//        }
//        System.out.println((opciones.size() + 1) + ". Volver");
//    }
//
//    public static void mostrarOpcionesMenu(String mensaje, String[] opciones) {
//        System.out.println(mensaje);
//        for (int i = 0; i < opciones.length; i++) {
//            System.out.println((i + 1) + ". " + opciones[i]);
//        }
//        System.out.println((opciones.length + 1) + ". Volver");
//    }
//
//    public static int obtenerEntradaValida(Scanner scanner, String mensaje) {
//        int opcion;
//        while (true) {
//            System.out.print(mensaje);
//            try {
//                opcion = scanner.nextInt();
//                if (opcion >= 0) {
//                    return opcion;  // Aceptamos solo valores no negativos
//                }
//                System.out.println("La cantidad no puede ser negativa.");
//            } catch (InputMismatchException e) {
//                System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                scanner.next(); // Limpiar el buffer
//            }
//        }
//    }
//
//    public static String obtenerEntradaValidaTexto(Scanner scanner, String mensaje) {
//        String opcion;
//        while (true) {
//            System.out.print(mensaje);
//            try {
//                opcion = scanner.nextLine();
//                if (opcion != "") {
//                    return opcion;  // Aceptamos solo valores no negativos
//                }
//                System.out.println(opcion);
//            } catch (InputMismatchException e) {
//                System.out.println("Entrada no válida. Por favor, ingrese un texto.");
//                scanner.next(); // Limpiar el buffer
//            }
//        }
//    }
//
//    public static int obtenerSeleccionMenu(Scanner scanner, String mensaje, int opciones, String[] mensajeOpciones) {
//        int opcion;
//        while (true) {
//            System.out.print(mensaje);
//            try {
//                opcion = scanner.nextInt();
//                if (opcion >= 0) {
//                    return opcion;  // Aceptamos solo valores no negativos
//                }
//                System.out.println("La cantidad no puede ser negativa.");
//            } catch (InputMismatchException e) {
//                System.out.println("Entrada no válida. Por favor, ingrese un número.");
//                scanner.next(); // Limpiar el buffer
//            }
//        }
//    }


}