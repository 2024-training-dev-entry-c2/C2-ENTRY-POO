package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import java.util.*;

class BookingSystem {
    static List<Alojamiento> alojamientos = new ArrayList<>();
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

    public void iniciarReserva(Scanner scanner) {
        mostrarCiudades();
        mostrarTiposAlojamiento();
        int opcionConfirmarAlojamiento = -1;
        int fechaInicio = -1;
        int fechaFin = -1;
        int cantidadAdultos = -1;
        int cantidadNinos = -1;
        int cantidadHabitaciones = -1;

        while (true) {
            int seleccionCiudad = seleccionarOpcion(scanner, "Seleccionar ciudad:", ciudades);
            if (seleccionCiudad == -1) break;

            int seleccionTipo = seleccionarOpcion(scanner, "Seleccionar Tipo de Alojamiento:", tipos);
            if (seleccionTipo == -1) break;

//            int fechaInicio = obtenerEntradaValida(scanner, "Ingrese el día de inicio del hospedaje: ");
//            int fechaFin = obtenerEntradaValida(scanner, "Ingrese el día de finalización del hospedaje: ");
//            int cantidadAdultos = obtenerEntradaValida(scanner, "Ingrese la cantidad de adultos: ");
//            int cantidadNinos = obtenerEntradaValida(scanner, "Ingrese la cantidad de niños: ");
//            int cantidadHabitaciones = obtenerEntradaValida(scanner, "Ingrese la cantidad de habitaciones: ");
            //                    System.out.println(opcionesEncontrada);
            fechaInicio = 1;
            fechaFin = 5;
            cantidadAdultos = 2;
            cantidadNinos = 1;
            cantidadHabitaciones = 3;

            if (fechaInicio >= fechaFin) {
                System.out.println("Has ingresado fechas incorrectas");
            } else {
                filtrarAlojamiento(ciudades.get(seleccionCiudad), tipos.get(seleccionTipo),
                        fechaInicio, fechaFin, cantidadAdultos, cantidadNinos, cantidadHabitaciones);
            }
            int seleccionAlojamiento = seleccionarOpcion(scanner, "Selecciona Alojamiento:", alojamientosfiltradosTxt);
            if (seleccionTipo == -1) break;
            System.out.println(alojamientosFiltrados);
            System.out.println(alojamientosFiltrados.get(seleccionAlojamiento));
            confirmarHabitaciones(1);
            System.out.println("--------------------------------------------------------------\n");




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

        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && alojamiento.getTipo().equalsIgnoreCase(tipoAlojamiento)) {
                System.out.println("-----------------------------------------------------------");
                System.out.println("Ciudad Seleccionada: " + alojamiento.getCiudad());
                System.out.println("Nombre: " + alojamiento.getNombre());
                System.out.println("Precio: " + alojamiento.getHabitaciones().get(0).getPrecio());

                double precio = calcularPrecio(fechaInicio, fechaFin, cantidadHabitaciones, alojamiento.getHabitaciones().get(0).getPrecio());
                System.out.println("Calificación: " + alojamiento.getCalificacion());
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

    private double calcularPrecio(int diaInicio, int diaFin, int cantidadHabitaciones, double precioHabitacion) {
        int noches = diaFin - diaInicio + 1;
        double precioTotal = precioHabitacion * noches * cantidadHabitaciones;

        double aumentoDesc = obtenerAumentoDesc(diaInicio, diaFin);
        double precioFinal = precioTotal * (1 + aumentoDesc);

        System.out.println("Precio total: $" + precioTotal);
        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
        System.out.println("Precio final: $" + precioFinal);
        return precioFinal;
    }

    public static void confirmarHabitaciones(int indexAlojamiento) {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Alojamiento seleccionado: ");
//        mostrarHabitacionesActividades(indexAlojamiento, tipos[indexAlojamiento], diaInicio, diaFin, cantidadHabitaciones, indexAlojamiento);
        System.out.println("_____________________>");
        System.out.println("Disponibilidad de habitaciones:");
        alojamientos.get(indexAlojamiento).mostrarHabitaciones();
        System.out.println();
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

    }

    private double obtenerAumentoDesc(int diaInicio, int diaFin) {
        if (diaFin >= 25) {
            return 0.15; // Aumento del 15%
        } else if (diaInicio >= 10 && diaFin <= 15) {
            return 0.10; // Aumento del 10%
        } else if (diaInicio >= 5 && diaFin <= 10) {
            return -0.08; // Descuento del 8%
        }
        return 0.0;
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

    public int obtenerEntradaValida(Scanner scanner, int maxOption) {
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

}