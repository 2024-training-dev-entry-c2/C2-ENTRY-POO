package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.*;

class BookingSystem {
    static List<Alojamiento> alojamientos = new ArrayList<>();
    static List<Reserva> reservas = new ArrayList<>();
    private List<String> ciudades = new ArrayList<>();
    private List<String> tipos = new ArrayList<>();
    private List<Integer> alojamientosFiltrados = new ArrayList<>();
    static ArrayList<String> alojamientosfiltradosTxt = new ArrayList<>();

    public BookingSystem() {
        inicializarDatos();
    }

    private void inicializarDatos() {
        alojamientos.add(new Hotel("Hotel Paraíso", "Cartagena", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "2 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4))));

        alojamientos.add(new Hotel("Hotel Real", "Bogotá", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "3 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4)
                )));
        alojamientos.add(new Hotel("Hotel Real", "Medellín", "Hotel", 5.0,
                Arrays.asList(new Habitacion("Sencilla", "1 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Duo", "3 camas sencillas, TV, baño privado", 200000, 5, 6),
                        new Habitacion("Triple", "4 cama sencilla, TV, baño privado", 150000, 10, 4),
                        new Habitacion("Lujo", "2 cama sencilla, TV, baño privado, servicio al cuarto", 150000, 10, 4),
                        new Habitacion("Presidencial", "2 cama sencilla, TV, baño privado, Jacuzzi", 150000, 10, 4)
                )));
        alojamientos.add(new Apartamento("Apartamento Luna", "Bogotá", "Apartamento", 4.4,
                Arrays.asList(new Habitacion("Suite", "1 cama king, cocina equipada, balcón", 300000, 5, 3),
                        new Habitacion("Familiar", "2 camas dobles, sala comedor, cocina", 250000, 2, 5))));
        alojamientos.add(new Apartamento("Apartamento sol", "Medellín", "Apartamento", 4.4,
                Arrays.asList(new Habitacion("Suite", "1 cama king, cocina equipada, balcón", 300000, 5, 3),
                        new Habitacion("Familiar", "2 camas dobles, sala comedor, cocina", 250000, 2, 5))));

        alojamientos.add(new Finca("Finca El Encanto", "Medellín", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new Finca("Finca El Capo", "Medellín", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));
        alojamientos.add(new Finca("Finca El Encanto Carta", "Cartagena", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new Finca("Finca La mojarra", "Cartagena", "Finca", 3.8,
                Arrays.asList(new Habitacion("Cabaña", "2 camas dobles, cocina, chimenea", 300000, 4, 4),
                        new Habitacion("Habitación Campestre", "1 cama king, terraza privada", 280000, 3, 3))));

        alojamientos.add(new DiaDeSol("Resort Brisa Marina", "Cartagena", "Día de Sol", 3.9,
                Arrays.asList(new Habitacion("Piscina", "Acceso a piscina y deportes acuáticos", 120000, 10, 10),
                        new Habitacion("Picnic", "Piscina/Toboganes y zona de picnic", 90000, 10, 10)), true));
        alojamientos.add(new DiaDeSol("Resort ", "Cartagena", "Día de Sol", 3.9,
                Arrays.asList(new Habitacion("Piscina", "Acceso a piscina y deportes acuáticos", 120000, 10, 10),
                        new Habitacion("Picnic", "Piscina/Toboganes y zona de picnic", 90000, 10, 10)), true));
    }

    public void iniciarReserva(Scanner scanner) {
        mostrarCiudades();
        mostrarTiposAlojamiento();
        int opcionConfirmarAlojamiento = -1;
        int menuSeleccionada = -1;
        int fechaInicio = -1;
        int fechaFin = -1;
        int cantidadAdultos = -1;
        int cantidadNinos = -1;
        int cantidadHabitaciones = -1;
        String nombre = "";
        String apellido = "";
        String email = "";
        String nacionalidad = "";
        int telefono = -1;
        String fechaNacimiento = "";
        int hora = -1;

        int seleccionCiudad = -1;
        int seleccionTipo = -1;
        int seleccionAlojamiento = -1;
        int habitacionSeleccionada = -1;

        int step = 0;
        while (true) {
            switch (step) {
                case 0:
                    step = mostrarMenuInicial(scanner);
                    break;
                case 1:
                    seleccionCiudad = seleccionarOpcion(scanner, "Seleccionar ciudad:", ciudades);
                    step = validarSeleccion(seleccionCiudad, step);
                    break;
                case 2:
                    seleccionTipo = seleccionarOpcion(scanner, "Seleccionar Tipo de Alojamiento:", tipos);
                    step = validarSeleccion(seleccionTipo, step);
                    break;
                case 3:
                    fechaInicio = obtenerEntradaValida(scanner, "Ingrese el día de inicio del hospedaje: ");
                    fechaFin = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
                    cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
                    cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
                    cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");

                    if (fechaInicio >= fechaFin) {
                        System.out.println("Has ingresado fechas incorrectas");
                    } else {
                        filtrarAlojamiento(ciudades.get(seleccionCiudad), tipos.get(seleccionTipo),
                                fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
                    }
                case 4:
                    seleccionAlojamiento = seleccionarOpcion(scanner, "Selecciona Alojamiento:", alojamientosfiltradosTxt);
                    step = (seleccionAlojamiento == -1) ? 2 : 5;
                    break;
                case 5:

                    confirmarHabitaciones(alojamientosFiltrados.get(seleccionAlojamiento), cantidadHabitaciones, fechaInicio, fechaFin);
                    habitacionSeleccionada = obtenerEntradaValida(scanner, alojamientos.get(seleccionAlojamiento).getHabitaciones().size());
                    step = (habitacionSeleccionada == -1) ? 4 : 6;
                    break;
                case 6:
                    int opcionMenuReserva = seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Hacer Reservacion", "Volver Atras", "volver a consultar alojamiento", "volver a menu inicial"});
                    step = stepTostep(opcionMenuReserva, step);
                    System.out.println(step);
                case 7:
                    nombre = obtenerEntradaValidaTexto(scanner, "Escriba su nombre: ");
                    apellido = obtenerEntradaValidaTexto(scanner, "Escriba su apellido: ");
                    fechaNacimiento = obtenerEntradaValidaTexto(scanner, "Escriba su Fecha de Nacimiento dd/MM/yyyy : ");
                    nacionalidad = obtenerEntradaValidaTexto(scanner, "Escriba su Nacionalidad: ");
                    email = obtenerEntradaValidaTexto(scanner, "Escriba su email: ");
                    telefono = obtenerEntradaValida(scanner, "Escriba su telefono: ");
                    hora = obtenerEntradaValida(scanner, "Escriba la hora de llegada: ");

                    if (hora >= 0 && hora <= 24) {
                        step++;
                    } else {
                        System.out.println("algun dato esta mal, reescriba nuevamente los datos");
                    }
                    break;
                case 8:
                    Reserva reserva = new Reserva(nombre, email, fechaNacimiento, alojamientos.get(alojamientosFiltrados.get(seleccionAlojamiento)), alojamientos.get(alojamientosFiltrados.get(seleccionAlojamiento)).getHabitaciones().get(habitacionSeleccionada),telefono);
                    if (reserva.confirmar(hora, cantidadHabitaciones, alojamientosFiltrados.get(seleccionAlojamiento))) {
                        reservas.add(reserva);
                        System.out.println("Reserva realizada con éxito: \n" + reserva.toString());
                        step = 0;
                    } else {
                        System.out.println("No se pudo realizar la reserva.");
                    }

                    break;
                case 9:
//                    int opcionAutenticar = seleccionarOpcionMenu(scanner, "Proceso a seguir:", new String[]{"Autenticar"});
                    autenticarYActualizarReserva();
                    step = 0;
                    break;

            }

        }
    }

    private void mostrarCiudades() {
        ciudades.clear();
        for (Alojamiento alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.getCiudad())) {
                ciudades.add(alojamiento.getCiudad());
            }
        }
    }

    private void mostrarTiposAlojamiento() {
        tipos.clear();
        for (Alojamiento alojamiento : alojamientos) {
            if (!tipos.contains(alojamiento.getTipo())) {
                tipos.add(alojamiento.getTipo());
            }
        }
    }

    public void filtrarAlojamiento(String ciudad, String tipoAlojamiento, int fechaInicio, int fechaFin,
                                   int cantidadAdultos, int cantidadNinos, int cantidadHabitaciones) {
        System.out.println("Alojamientos disponibles en " + ciudad + ":");

        boolean encontrados = false;
        int contador = 0;
        alojamientosFiltrados.clear();
        alojamientosfiltradosTxt.clear();
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && alojamiento.getTipo().equalsIgnoreCase(tipoAlojamiento)) {
                alojamiento.mostrarAlojamiento();
                alojamiento.calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, alojamiento.getHabitaciones().get(0).getPrecio());
                alojamientosFiltrados.add(contador);
                alojamientosfiltradosTxt.add(alojamiento.getNombre());
                encontrados = true;
            }
            contador++;
        }
        if (!encontrados) {
            System.out.println("No se encontraron alojamientos en la ciudad seleccionada.");
        }
    }

    public static void confirmarHabitaciones(int indexAlojamiento, int cantidadHabitaciones, int diaInicio, int diaFinal) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Alojamiento seleccionado: ");
        System.out.println("_____________________>");
        System.out.println("Disponibilidad de habitaciones:");
        alojamientos.get(indexAlojamiento).mostrarHabitaciones(cantidadHabitaciones, diaInicio, diaFinal);

    }

    public void autenticarYActualizarReserva() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese su email para autenticarse:");
        String email = scanner.nextLine();
        System.out.println("Ingrese su fecha de nacimiento (dd/mm/yyyy):");
        String fechanNacimiento = scanner.nextLine();

        Reserva reservaEncontrada = null;
        for (Reserva reserva : reservas) {
            if (reserva.getEmailCliente().equalsIgnoreCase(email)) {
                reservaEncontrada = reserva;
                break;
            }
        }

        if (reservaEncontrada == null) {
            System.out.println("No se encontró ninguna reserva asociada a este email.");
            return;
        }

        System.out.println("Reserva encontrada: " + reservaEncontrada);
        System.out.println("Seleccione una opción para actualizar:");
        System.out.println("1. Cambiar de habitación");
        System.out.println("2. Cancelar reserva");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            Alojamiento alojamiento = reservaEncontrada.getAlojamiento();
            alojamiento.mostrarHabitaciones();
            System.out.println("Seleccione la nueva habitación:");
            int nuevaHabitacionSeleccionada = scanner.nextInt() - 1;

            if (nuevaHabitacionSeleccionada >= 0 && nuevaHabitacionSeleccionada < alojamiento.getHabitaciones().size()) {
                Habitacion nuevaHabitacion = alojamiento.getHabitaciones().get(nuevaHabitacionSeleccionada);
                if (nuevaHabitacion.reservar()) {
                    reservaEncontrada.getHabitacion().cancelar();
                    reservaEncontrada.setHabitacion(nuevaHabitacion);
                    System.out.println("Habitación actualizada con éxito." + reservaEncontrada);
                    System.out.println();
                } else {
                    System.out.println("No hay disponibilidad en la habitación seleccionada.");
                }
            } else {
                System.out.println("Selección inválida.");
            }
        } else if (opcion == 2) {
            reservas.remove(reservaEncontrada);
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    public int seleccionarOpcion(Scanner scanner, String mensaje, List<String> opciones) {
        mostrarOpciones(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.size());
    }

    public void mostrarOpciones(String mensaje, List<String> opciones) {
        System.out.println("-----------------------------------");
        System.out.println(mensaje);
        for (int i = 0; i < opciones.size(); i++) {
            System.out.println((i + 1) + ". " + opciones.get(i));
        }
        System.out.println((opciones.size() + 1) + ". Volver");
    }

    public static int seleccionarOpcionMenu(Scanner scanner, String mensaje, String[] opciones) {
        mostrarOpcionesMenu(mensaje, opciones);
        return obtenerEntradaValida(scanner, opciones.length);
    }

    public static void mostrarOpcionesMenu(String mensaje, String[] opciones) {
        System.out.println(mensaje);
        for (int i = 0; i < opciones.length; i++) {
            System.out.println((i + 1) + ". " + opciones[i]);
        }
        System.out.println((opciones.length + 1) + ". Volver");
    }

    static public int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion = -1;
        while (true) {
            System.out.print("Ingrese un número: ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion - 1;
                }
                if (opcion == (maxOption + 1)) {
                    return -1;
                } else {
                    System.out.println("Opción no válida. Debe estar entre 1 y " + (maxOption + 1) + ".");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }

    public int obtenerEntradaValida(Scanner scanner, String mensaje) {
        int opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextInt();
                if (opcion >= 0) {
                    return opcion;
                }
                System.out.println("La cantidad no puede ser negativa.");
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un número.");
                scanner.next();
            }
        }
    }

    public static String obtenerEntradaValidaTexto(Scanner scanner, String mensaje) {
        String opcion;
        while (true) {
            System.out.print(mensaje);
            try {
                opcion = scanner.nextLine();
                if (!Objects.equals(opcion, "")) {
                    return opcion;  // Aceptamos solo valores no negativos
                }
                System.out.println(opcion);
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, ingrese un texto.");
                scanner.next(); // Limpiar el buffer
            }
        }
    }

    private static int validarSeleccion(int seleccion, int pasoActual) {
        return (seleccion == -1) ? pasoActual - 1 : pasoActual + 1;
    }

    private int stepTostep(int opcionMenuReserva, int step) {

        switch (opcionMenuReserva) {
            case 0:
                step++; // Hacer Reservacion
                break;
            case 1:
                step--; // Volver Atras
                break;
            case 2:
                step = 1; // Volver a consultar alojamiento
                break;
            case 3:
                step = 0; // Volver a menu inicial
                break;
            case 5:
                step--;
                break;
            default:
                System.out.println("Opción inválida, intenta de nuevo.");
                step = 4;

                break;

        }
        return step;
    }

    private int mostrarMenuInicial(Scanner scanner) {
        String[] opciones = {"Consultar y reservar", "Autenticar y Actualizar"};
        int seleccion = seleccionarOpcionMenu(scanner, "___Bienvenido a Booking Hotel___", opciones);
        return (seleccion == 0) ? 1 : (seleccion == 1 ? 9 : 0);
    }
}