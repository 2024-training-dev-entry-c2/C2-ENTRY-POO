package org.example;

import java.util.*;

public class Main {
    static List<Alojamiento> alojamientos = new ArrayList<Alojamiento>();
    static List<Reserva> reservas = new ArrayList<Reserva>();
    static List<String> ciudades = new ArrayList<String>();
    static List<String> tipos = new ArrayList<String>();

    public static void main(String[] args) {
        inicializarDatos();
        int seleccionCiudad=-1;
        int seleccionTipo=-1;
        Scanner scanner = new Scanner(System.in);
        int step = 1;

        while (true){
            switch (step){
                case 1:
                    mostrarCiudades();
                    seleccionCiudad = obtenerEntradaValida(scanner, ciudades.size());
                    step++;
                    break;
                case 2:
                    mostrarTiposAlojamiento();
                    seleccionTipo= obtenerEntradaValida(scanner,tipos.size());
                    step++;
                case 3:

                    System.out.println(tipos.get(seleccionTipo));

                    filtrarAlojamiento(ciudades.get(seleccionCiudad), tipos.get(seleccionTipo));
                    step++;
                    break;
                case 4:

                    break;


            }



        }



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

    static public void mostrarCiudades() {
        ciudades.clear();
        System.out.println("Selecciona una ciudad:");
        for (Alojamiento alojamiento : alojamientos) {
            if (!ciudades.contains(alojamiento.getCiudad())) {
                ciudades.add(alojamiento.getCiudad());
                System.out.println(ciudades.size() + ". " + alojamiento.getCiudad());
            }
        }
    }
    static public void mostrarTiposAlojamiento() {
        tipos.clear();
        System.out.println("Selecciona tipo:");
        for (Alojamiento alojamiento : alojamientos) {
            if (!tipos.contains(alojamiento.getTipo())) {
                tipos.add(alojamiento.getTipo());
                System.out.println(tipos.size() + ". " + alojamiento.getTipo());
            }
        }
    }
    static public void filtrarAlojamiento(String ciudad,String tipoAlojamiento){

        System.out.println("Alojamientos disponibles en " + ciudad + ":");
        boolean encontrados = false;
        for (Alojamiento alojamiento : alojamientos) {
            if (alojamiento.getCiudad().equalsIgnoreCase(ciudad) && alojamiento.getTipo().equalsIgnoreCase(tipoAlojamiento)) {
                System.out.println(alojamiento);
                encontrados = true;
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron alojamientos en la ciudad seleccionada.");
        }


    }
    

    public static int obtenerEntradaValida(Scanner scanner, int maxOption) {
        int opcion = -1;
        while (true) {
            System.out.print("Ingrese un número" + ": ");
            try {
                opcion = scanner.nextInt();
                if (opcion >= 1 && opcion <= maxOption) {
                    return opcion - 1;
                }
                if (opcion == (maxOption + 1)) {
                    System.out.println("close");
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



}