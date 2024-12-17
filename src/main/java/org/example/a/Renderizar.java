package org.example.a;

import java.util.LinkedList;

public class Renderizar {

    //Formularios

    public static String elegirNombreCiudad(LinkedList<Ciudad> listaCiudades) {
        boolean salir = false;
        String nombreCiudad = "";
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Realize su reserva de habitaciones");
            System.out.println("Elija la ciudad de el hotel al que desea viajar");
            for (int i = 0; i < listaCiudades.size(); i++) {
                System.out.println(i + 1 + ". ciudad:  " + listaCiudades.get(i).getNombre());
            }
            System.out.println("\n");
            int num = Sistema.ingresarNumero("Eliga una opción: ");
            Renderizar.limpiarConsola();

            if (num > listaCiudades.size() || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            nombreCiudad = listaCiudades.get(num - 1).getNombre();
            salir = true;
        }

        return nombreCiudad;
    }

    public static TipoAlojamiento elegirTipoAlojamiento( LinkedList<TipoAlojamiento> listaTiposAlojamientos) {
        boolean salir = false;
        TipoAlojamiento tipoAlojamiento = null;
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Elija el tipo de alojamiento que desea");
            for (int i = 0; i < listaTiposAlojamientos.size(); i++) {
                System.out.println(i + 1 + ". tipos de alojamientos:  " + listaTiposAlojamientos.get(i).getNombre());
            }
            System.out.println("\n");
            int num = Sistema.ingresarNumero("Eliga una opción: ");

            Renderizar.limpiarConsola();

            if (num > listaTiposAlojamientos.size() || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            tipoAlojamiento = listaTiposAlojamientos.get(num - 1);
            salir = true;
        }

        return tipoAlojamiento;
    }

    public static int ingresarCantidadPersonas(String tipoPersona) {
        System.out.println("-----------------------------");

        int cantPersonas = 0;

        boolean salir = false;
        while (!salir) {
            cantPersonas = Sistema.ingresarNumero("Ingrese la cantidad de " + tipoPersona + ": ");

            if (cantPersonas < 0) {
                System.out.println("No es un numero válido");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("cantPersonas: " + cantPersonas);

        Renderizar.limpiarConsola();

        return cantPersonas;
    }

    public static int[] ingresarNacimientoFecha() {

        int dia = 0;
        int mes = 0;
        int anio = 0;

        boolean salir = false;
        while (!salir) {

            dia = Sistema.ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                Renderizar.limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            mes = Sistema.ingresarNumero("Ingrese el mes: ");
            if (mes < 1 || mes > 12) {
                System.out.println("Error ingrese los datos nuevamente");

                continue;
            }

            anio = Sistema.ingresarNumero("Ingrese el anio: ");
            if (anio > 2006) {
                Renderizar.limpiarConsola();
                System.out.println("Error necesita ser mayor de edad");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Anio: " + anio);

        Renderizar.limpiarConsola();

        return new int[]{dia, mes, anio};
    }

    public static int[] ingresarFecha() {

        int dia = 0;
        int mes = 0;
        int anio = 0;

        boolean salir = false;
        while (!salir) {

            dia = Sistema.ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                Renderizar.limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            mes = Sistema.ingresarNumero("Ingrese el mes: ");
            if (mes < 1 || mes > 12) {
                System.out.println("Error ingrese los datos nuevamente");

                continue;
            }

            anio = Sistema.ingresarNumero("Ingrese el anio: ");
            if (anio <= 2024) {
                Renderizar.limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Anio: " + anio);

        Renderizar.limpiarConsola();

        return new int[]{dia, mes, anio};
    }

    public static Alojamiento seleccionarAlojamiento(LinkedList<Object> alojamientosDisponibles) {
        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            int idAlojamiento = Sistema.ingresarNumero("Ingrese la id del alojamiento a reservar: ");

            for (Object unObjeto : alojamientosDisponibles) {
                if (unObjeto instanceof Alojamiento) {
                    Alojamiento unAlojamiento = (Alojamiento) unObjeto;
                    if (unAlojamiento.getIdAlojamiento() == idAlojamiento) {
                        return unAlojamiento;
                    }
                }
            }
            System.out.println("Alojamiento no encontrado");
        }
        return null;
    }

    public static void seleccionarHabitacion(LinkedList<Habitacion> habitaciones, ReservacionCliente reservacionCliente) {
        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            int idHabitacion = Sistema.ingresarNumero("Ingrese la id de la habitacion a reservar: ");


            for (int i = 0; i < habitaciones.size(); i++) {
                if (habitaciones.get(i).getIdHabitacion() == idHabitacion) {

                    reservacionCliente.setHabitacionCompradaDatos(habitaciones.get(i));
                    System.out.println("Habitacion seleccionada con exito");
                    return;
                }
            }

            //limpiarConsola();
            System.out.println("Habitacion no encontrada");
        }

    }

    public static String ingresarHoraDeLlegada() {
        boolean salir = false;
        String horaLlegada = "";
        while (!salir) {
            int hora = Sistema.ingresarNumero("Ingrese la hora (0 a 23): ");
            if (hora < 0 || hora > 23) {
                System.out.println("Error con la hora");
                continue;
            }

            int minutos = Sistema.ingresarNumero("Ingrese los minutos (0 a 59): ");
            if (minutos < 0 || minutos > 59) {
                System.out.println("Error con los minutos");
                continue;
            }

            horaLlegada = hora + ":" + minutos;
            salir = true;
        }
        return horaLlegada;
    }


    //Funciones de sistema

    public static void renderizarDatos(String[][] mostrarDato) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (String atributo : unDato) {
                System.out.println(atributo);
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatos(LinkedList<Object> mostrarDato) {
        System.out.println("------------------------------------------------");
        for (Object unDato : mostrarDato) {

            if (!(unDato instanceof String)) {
                Sistema.mostrarDatosAtributos(unDato);
                continue;
            }
            System.out.println(unDato);

            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatosHabitacion(LinkedList<Habitacion> mostrarDato) {
        System.out.println("------------------------------------------------");
        for (Object unDato : mostrarDato) {

            if (!(unDato instanceof String)) {
                Sistema.mostrarDatosAtributos(unDato);
                continue;
            }
            System.out.println(unDato);

            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatosReservacionCliente(ReservacionCliente mostrarDato) {
        System.out.println("------------------------------------------------");

        System.out.println("El Cliente: "+ mostrarDato.getCliente().getNombre());
        System.out.println("El Precio Total: "+ mostrarDato.getPrecioTotal());
        System.out.println("La Hora de Llegada: "+ mostrarDato.getHoraLlegada());
        if (mostrarDato.getHabitacionCompradaDatos() != null)
            System.out.println("La Habitacion comprada es : "+ mostrarDato.getHabitacionCompradaDatos().getTitulo());
        else System.out.println("No hay habitacion comprada por ahora.");
        System.out.println("------------------------------------------------");

    }

    public static void renderizarDatos(LinkedList<LinkedList<String>> mostrarDato, String[] atributos, String a) {
        System.out.println("------------------------------------------------");
        for (LinkedList<String> unDato : mostrarDato) {
            for (int i = 0; i < unDato.size(); i++) {
                System.out.println(atributos[i] + ": " + unDato.get(i));
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void limpiarConsola() {
        // Imprime 50 líneas en blanco para simular la limpieza
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
