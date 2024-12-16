package org.example.a;

import java.security.Key;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    //--------------------------------------DATOS DEL SISTEMA--------------------------------------


    public static Scanner Keyboard = new Scanner(System.in);

    //{titulo}
    public static String[] ciudades = {
            "Cabo Polonio",
            "La Paloma",
            "Salto",
            "Tacuarembó",
    };

    //{titulo}
    public static String[] tiposAlojamientos = {
            "Hotel",
            "Finca",
            "Apartamento",
            "Dia de Sol",
    };

    //{idAlojamiento, nombreHotel, ciudad, tipoDeAlojamiento, cantidadDeEstrellas, precio}
    public static String[][] alojamientos = {
            // Cabo Polonio
            {"1", "Hotel Las Dunas", ciudades[0], tiposAlojamientos[0], "4.3", "150"},
            {"2", "Cabanas El Bosque", ciudades[0], tiposAlojamientos[0], "3.1", "80"},
            {"3", "Apartamento Mar del Sol", ciudades[0], tiposAlojamientos[1], "3.5", "70"},
            {"4", "Apartamento Vista Mar", ciudades[0], tiposAlojamientos[1], "3.7", "75"},
            {"5", "Cabaña Bosque Azul", ciudades[0], tiposAlojamientos[2], "3.8", "85"},
            {"6", "Cabaña Refugio del Mar", ciudades[0], tiposAlojamientos[2], "4.0", "90"},
            {"7", "Hotel Costa Dorada", ciudades[0], tiposAlojamientos[3], "4.1", "95"},
            {"8", "Hotel La Perla", ciudades[0], tiposAlojamientos[3], "4.2", "120"},

            // La Paloma
            {"9", "Cabana Los Pinos", ciudades[1], tiposAlojamientos[0], "4.0", "110"},
            {"10", "Cabanas La Paloma", ciudades[1], tiposAlojamientos[0], "4.5", "130"},
            {"11", "Apartamento Sol y Mar", ciudades[1], tiposAlojamientos[1], "4.0", "100"},
            {"12", "Finca La Paloma", ciudades[1], tiposAlojamientos[1], "3.9", "90"},
            {"13", "Cabana Los Almendros", ciudades[1], tiposAlojamientos[2], "4.1", "115"},
            {"14", "Cabanas del Mar", ciudades[1], tiposAlojamientos[2], "4.6", "140"},
            {"15", "Cabana del Lago", ciudades[1], tiposAlojamientos[3], "4.2", "125"},
            {"16", "Hotel Las Aguas", ciudades[1], tiposAlojamientos[3], "4.3", "130"},

            // Salto
            {"17", "Cabana El Refugio", ciudades[2], tiposAlojamientos[0], "5.1", "120"},
            {"18", "Posada Los Sauces", ciudades[2], tiposAlojamientos[0], "4.2", "140"},
            {"19", "Hotel El Salto", ciudades[2], tiposAlojamientos[1], "3.7", "100"},
            {"20", "Finca San José", ciudades[2], tiposAlojamientos[1], "4.1", "110"},
            {"21", "Cabaña El Mirador", ciudades[2], tiposAlojamientos[2], "4.3", "125"},
            {"22", "Finca Los Olivos", ciudades[2], tiposAlojamientos[2], "4.4", "130"},
            {"23", "Hotel Los Sauces", ciudades[2], tiposAlojamientos[3], "4.2", "115"},
            {"24", "Finca El Oasis", ciudades[2], tiposAlojamientos[3], "4.0", "105"},

            // Tacuarembó
            {"25", "Posada La Estancia", ciudades[3], tiposAlojamientos[0], "4.0", "90"},
            {"26", "Hotel Tacuarembó", ciudades[3], tiposAlojamientos[0], "3.8", "110"},
            {"27", "Finca Las Aguas", ciudades[3], tiposAlojamientos[1], "4.2", "105"},
            {"28", "Apartamento Tacuarembó", ciudades[3], tiposAlojamientos[1], "3.9", "95"},
            {"29", "Cabaña El Retiro", ciudades[3], tiposAlojamientos[2], "4.3", "120"},
            {"30", "Apartamento Los Cerrillos", ciudades[3], tiposAlojamientos[2], "4.1", "100"},
            {"31", "Finca Los Valles", ciudades[3], tiposAlojamientos[3], "4.2", "110"},
            {"32", "Hotel Río Tacuarembó", ciudades[3], tiposAlojamientos[3], "3.9", "105"}
    };

    //{idHabitacion, titulo, descripcion, beneficiosHabitacion, precio}
    public static String[][] habitaciones = {
            {"1", "Habitacion sencilla",
                    "La habitacion sencilla tiene una cama matrimonial, vista al jardin, aire acondicionado, minibar, TV de pantalla plana, y bano privado",
                    "Desayuno incluido", "40"},
            {"2", "Habitacion doble",
                    "La habitacion doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio",
                    "No tiene beneficios", "50"},
            {"3", "Habitacion familiar",
                    "La habitacion familiar tiene 2 camas dobles, bano privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar",
                    "Desayuno incluido, acceso a actividades familiares", "90"},
            {"4", "Habitacion superior",
                    "Habitacion con cama queen size, escritorio, bano con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar",
                    "Acceso a la piscina, desayuno incluido", "120"},
            {"5", "Suite Deluxe",
                    "Suite con cama king size, jacuzzi, terraza privada con vista panoramica, TV de pantalla plana, cafetera y minibar",
                    "Acceso al spa, masaje gratuito", "200"}
    };

    // {idHabitacion, idAlojamiento, maximaCantidadDePersonas}
    public static int[][] relacionHotelHabitacion = {
            {1, 1, 5},   // Habitacion 1 en Hotel Las Dunas
            {2, 1, 10},  // Habitacion 2 en Cabañas El Bosque
            {3, 2, 30},  // Habitacion 3 en Apartamento Mar del Plata
            {4, 2, 7},   // Habitacion 4 en Cabaña Los Pinos
            {1, 3, 19},  // Habitacion 1 en Hotel Sol y Luna
            {2, 3, 25},  // Habitacion 2 en Hotel Sol y Luna
            {3, 4, 14},  // Habitacion 3 en Cabañas El Lago
            {4, 4, 21},  // Habitacion 4 en Cabañas El Lago
            {1, 5, 22},  // Habitacion 1 en Complejo Los Jardines
            {2, 5, 6},   // Habitacion 2 en Complejo Los Jardines
            {3, 6, 12},  // Habitacion 3 en Apartamento Mar de Plata
            {4, 6, 30},  // Habitacion 4 en Apartamento Mar de Plata
            {1, 7, 8},   // Habitacion 1 en Hotel El Refugio
            {2, 7, 18},  // Habitacion 2 en Hotel El Refugio
            {3, 8, 25},  // Habitacion 3 en Hotel Las Dunas
            {4, 8, 28},  // Habitacion 4 en Hotel Las Dunas
            {1, 9, 9},   // Habitacion 1 en Cabañas del Bosque
            {2, 9, 15},  // Habitacion 2 en Cabañas del Bosque
            {3, 10, 11}, // Habitacion 3 en Apartamento Los Pinos
            {4, 10, 20}, // Habitacion 4 en Apartamento Los Pinos
            {1, 11, 16}, // Habitacion 1 en Hotel El Sol
            {2, 11, 5},  // Habitacion 2 en Hotel El Sol
            {3, 12, 23}, // Habitacion 3 en Hotel Cielo Azul
            {4, 12, 13}, // Habitacion 4 en Hotel Cielo Azul
            {1, 13, 30}, // Habitacion 1 en Apartamento Mar del Plata
            {2, 13, 7},  // Habitacion 2 en Apartamento Mar del Plata
            {3, 14, 20}, // Habitacion 3 en Complejo Los Jardines
            {4, 14, 9},  // Habitacion 4 en Complejo Los Jardines
            {1, 15, 28}, // Habitacion 1 en Cabañas El Refugio
            {2, 15, 10}, // Habitacion 2 en Cabañas El Refugio
            {3, 16, 18}, // Habitacion 3 en Hotel Las Dunas
            {4, 16, 12}, // Habitacion 4 en Hotel Las Dunas
            {1, 17, 16}, // Habitacion 1 en Cabañas El Bosque
            {2, 17, 4},  // Habitacion 2 en Cabañas El Bosque
            {3, 18, 22}, // Habitacion 3 en Hotel Sol y Luna
            {4, 18, 31}, // Habitacion 4 en Hotel Sol y Luna
            {1, 19, 19}, // Habitacion 1 en Apartamento Los Pinos
            {2, 19, 17}, // Habitacion 2 en Apartamento Los Pinos
            {3, 20, 14}, // Habitacion 3 en Cabañas El Lago
            {4, 20, 27}, // Habitacion 4 en Cabañas El Lago
            {1, 21, 30}, // Habitacion 1 en Complejo Los Jardines
            {2, 21, 25}, // Habitacion 2 en Complejo Los Jardines
            {3, 22, 11}, // Habitacion 3 en Hotel El Refugio
            {4, 22, 32}, // Habitacion 4 en Hotel El Refugio
            {1, 23, 5},  // Habitacion 1 en Hotel Cielo Azul
            {2, 23, 21}, // Habitacion 2 en Hotel Cielo Azul
            {3, 24, 12}, // Habitacion 3 en Apartamento Mar del Plata
            {4, 24, 8},  // Habitacion 4 en Apartamento Mar del Plata
            {1, 25, 13}, // Habitacion 1 en Cabañas del Bosque
            {2, 25, 19}, // Habitacion 2 en Cabañas del Bosque
            {3, 26, 9},  // Habitacion 3 en Hotel Las Dunas
            {4, 26, 15}, // Habitacion 4 en Hotel Las Dunas
            {1, 27, 24}, // Habitacion 1 en Hotel Sol y Luna
            {2, 27, 8},  // Habitacion 2 en Hotel Sol y Luna
            {3, 28, 14}, // Habitacion 3 en Complejo Los Jardines
            {4, 28, 16}, // Habitacion 4 en Complejo Los Jardines
            {1, 29, 22}, // Habitacion 1 en Cabañas El Refugio
            {2, 29, 12}, // Habitacion 2 en Cabañas El Refugio
            {3, 30, 29}, // Habitacion 3 en Apartamento Los Pinos
            {4, 30, 17}, // Habitacion 4 en Apartamento Los Pinos
            {1, 31, 18}, // Habitacion 1 en Hotel Las Dunas
            {2, 31, 26}, // Habitacion 2 en Hotel Las Dunas
            {3, 32, 6},  // Habitacion 3 en Cabañas El Lago
            {4, 32, 13}  // Habitacion 4 en Cabañas El Lago
    };


    // {idCliente, Nombre, apellido, email, nacionalidad, número de teléfono}
    public static String[] cliente = {"", "", "", "", "", ""};

    // {cliente, precioTotal, HoraLlegada, habitacionCompradaDatos}
    public static String[][] reservacionCliente = {cliente, {""}, {""}, {""}};


    //--------------------------------------FUNCION PRINCIPAL-----------------------------------------


    //Metodo inicial
    public static void main(String[] args) {
        limpiarConsola();
        System.out.println("inicio de aplicacion");

        LinkedList<LinkedList<String>> habitacionesDisponibles = seleccionarAlojamiento();

        limpiarConsola();
        System.out.println("Realizando confirmacion de la reservacion");

        Keyboard.nextLine();
        String nombre = ingresarTexto("Ingrese su nombre: ");
        String apellido = ingresarTexto("Ingrese su apellido: ");
        String email = ingresarTexto("Ingrese su email: ");
        String nacionalidad = ingresarTexto("Ingrese su nacionalidad: ");
        System.out.println("Ingrese fecha de naciemiento: ");
        int[] fechaNacimiento = ingresarNacimientoFecha();
        Keyboard.nextLine();
        String telefono = ingresarTexto("Ingrese su telefono: ");
        String horaLlegada = ingresarHoraDeLlegada();


        //Tercera funcion
        reservarHabitacionCliente(
                nombre,
                apellido,
                email,
                nacionalidad,
                telefono,
                horaLlegada
        );
        System.out.println("\n");
        renderizarDatos(reservacionCliente);

        System.out.println("\n \n");
        actulizacionReserva(fechaNacimiento, email, habitacionesDisponibles);

        limpiarConsola();
        System.out.println("Muchas gracias por agendar su estadia en nuesto sistema \n");


        //Primer metodo precreado para testeo
        /*
        LinkedList<String[]> HotelesDisponibles = hotelesConLosSigientesParametros(
                "Cabo Polonio",
                "Finca",
                1,
                new int[]{2, 3, 2024},
                new int[]{31, 3, 2024},
                2,
                2
        );
        */

        //Segundo metodo precreado para testeo
        /*
        LinkedList<LinkedList<String>> habitacionesDisponibles = confirmarHabitaciones(
                "Cabanas El Bosque",
                new int[]{2, 3, 2024},
                new int[]{31, 3, 2024},
                2,
                2,
                1
        );
        */

        //Tercer metodo precreado para testeo
        /*
        String[] habitacionElegida = habitaciones[2];
        int[] fechaI = new int[]{2, 3, 2024};
        int[] fechaF = new int[]{31, 3, 2024};


        reservacionCliente[3] = habitacionElegida;
        reservacionCliente[1][0] = "" + calcularPrecioHabitacion(
                convertirStringAInt(habitacionElegida[4]),
                fechaI,
                fechaF
        );
        reservarHabitacionCliente(
                "Juan",
                "Perez",
                "a@a.com",
                "Uruguaya",
                "12345678",
                "8:30"
        );

        renderizarDatos(reservacionCliente);
        */

        //Cuarto metodo precreado para testeo


    }

    public static LinkedList<LinkedList<String>> seleccionarAlojamiento() {

        String nombreCiudad = elegirNombreCiudad();
        String tipoAlojamiento = elegirTipoAlojamiento();
        int cantHabitaciones = ingresarNumero("Ingrese la cantidad de habitaciones: ");
        int cantAdultos = ingresarCantidadPersonas("Adultos");
        int cantNinios = ingresarCantidadPersonas("Ninios");
        System.out.println("Ingrese la fecha de inicio del hospedaje");
        int[] InicioHospedaje = ingresarFecha();
        System.out.println("Ingrese la fecha final del hospedaje");
        int[] FinalHospedaje = ingresarFecha();

        //Primera funcion
        LinkedList<String[]> HotelesDisponibles = hotelesConLosSigientesParametros(
                nombreCiudad,
                tipoAlojamiento,
                cantHabitaciones,
                InicioHospedaje,
                FinalHospedaje,
                cantAdultos,
                cantNinios
        );

        //elegir alojamiento
        String[] alojamientoSeleccionado = seleccionarAlojamiento(HotelesDisponibles);

        limpiarConsola();
        System.out.println("Habitaciones disponibles para reservar este hotel");

        //Segunda funcion
        LinkedList<LinkedList<String>> habitacionesDisponibles = confirmarHabitaciones(
                alojamientoSeleccionado[1],
                InicioHospedaje,
                FinalHospedaje,
                cantAdultos,
                cantNinios,
                cantHabitaciones
        );

        //elegir habitacion
        seleccionarHabitacion(habitacionesDisponibles);

        return habitacionesDisponibles;
    }


    //---------------------------------------PRIMER METODO---------------------------------------------


    public static LinkedList<String[]> hotelesConLosSigientesParametros(String ciudad, String tipoAlojamiento, int cantHabitacionesCliente, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<String[]> listaHoteles = new LinkedList<>();

        for (String[] hotel : alojamientos) {
            //Comprueba si el hotel es de la ciudad y si tiene el tipo de alojamiento
            if (!(hotel[2].equals(ciudad) && hotel[3].equals(tipoAlojamiento))) continue;

            //Calcula la cantidad de personas que iran a la habitacion
            int cantidadPersonas = cantAdultos + cantNinios;

            //Comprueba si hay habitaciones disponibles en el hotel de esa ciudad
            int[] cantidadYprecioHabitacionesDisponibles = buscarPrecioCantHabitacionesAlojamientoDisponible(hotel, cantidadPersonas);
            int cantidadHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[0];
            int minPrecioHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[1];

            if (cantidadHabitacionesDisponibles < 1) continue;

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (cantidadHabitacionesDisponibles < cantHabitacionesCliente) continue;

            listaHoteles.add(hotel);
            listaHoteles.add(new String[]{"El precio aproximado del hotel |" + hotel[1] + "| es: $ "
                    + minPrecioHabitacionesDisponibles + "\nPrecio aproximado por la fecha y la cantidad de salas elegidas: $ "
                    + calcularPrecioHabitacion(minPrecioHabitacionesDisponibles, diaInicioHospedaje, diaFinalHospedaje)
            });
        }


        renderizarDatos(
                listaHoteles,
                new String[]{
                        "id",
                        "Nombre Hotel",
                        "Ciudad",
                        "Tipo de alojamiento",
                        "Estrellas",
                        "Precio"
                }
        );

        return listaHoteles;
    }

    public static int[] buscarPrecioCantHabitacionesAlojamientoDisponible(String[] alojamiento, int cantPersonas) {

        int minPrecioHabitacion = 0;
        int cantidadHabitaciones = 0;

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (int[] unaRelacionHotelHabitacion : relacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion[1] != convertirStringAInt(alojamiento[0])) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion[2] < cantPersonas) continue;

            String[] habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion[0]);
            int precioHabitacion = convertirStringAInt(habitacion[4]);

            if (minPrecioHabitacion == 0 || precioHabitacion < minPrecioHabitacion)
                minPrecioHabitacion = precioHabitacion;

            cantidadHabitaciones++;
        }

        return new int[]{cantidadHabitaciones, minPrecioHabitacion};
    }

    public static String[] obtenerHabitacionDeAlojamiento(int idHabitacion) {
        for (String[] unaHabitacion : habitaciones) {
            if (convertirStringAInt(unaHabitacion[0]) == idHabitacion) {
                return unaHabitacion;
            }
        }
        return new String[0];
    }

    public static int calcularPrecioHabitacion(int precio, int[] fechaInicial, int[] fechaFinal) {
        double precioFinal = precio;

        if ((fechaInicial[0] <= 10 && fechaFinal[0] >= 5)) {
            precioFinal = precio - (precio * 0.08);
        }

        if ((fechaInicial[0] <= 15 && fechaFinal[0] >= 10)) {
            precioFinal = precio + (precio * 0.10);
        }

        if ((fechaInicial[0] <= 31 && fechaFinal[0] >= 26)) {
            precioFinal = precio + (precio * 0.15);
        }

        return (int) precioFinal;
    }


    //--------------------------------------SEGUNDO METODO---------------------------------------------


    public static LinkedList<LinkedList<String>> confirmarHabitaciones(String nombreHotel, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios, int cantHabitacionesCliente) {
        String[] alojamiento = buscarAlojamientoPorNombre(nombreHotel);
        int cantidadPersonas = cantAdultos + cantNinios;
        LinkedList<LinkedList<String>> habitacionesDisponibles = buscarHabitacionesDisponible(alojamiento, cantidadPersonas);


        for (LinkedList<String> unaHabitacion : habitacionesDisponibles) {

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (habitacionesDisponibles.size() < cantHabitacionesCliente) continue;

            unaHabitacion.add("" + calcularPrecioHabitacion(convertirStringAInt(unaHabitacion.get(4)), diaInicioHospedaje, diaFinalHospedaje));

        }

        renderizarDatos(
                habitacionesDisponibles,
                new String[]{
                        "id",
                        "Tipo de habitacion",
                        "Descripcion",
                        "Veneficios",
                        "Precio por tipo de habitacion",
                        "El precio total de la habitacion es: $ "
                },
                ""
        );

        return habitacionesDisponibles;
    }

    public static LinkedList<LinkedList<String>> buscarHabitacionesDisponible(String[] alojamiento, int cantPersonas) {

        LinkedList<LinkedList<String>> habitacionesDisponibles = new LinkedList<>();

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (int[] unaRelacionHotelHabitacion : relacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion[1] != convertirStringAInt(alojamiento[0])) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion[2] < cantPersonas) continue;

            String[] habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion[0]);

            LinkedList<String> convercion = new LinkedList<>();

            for (String att : habitacion) {
                convercion.add(att);
            }

            habitacionesDisponibles.add(convercion);
        }

        return habitacionesDisponibles;
    }


    //--------------------------------------TERCER METODO----------------------------------------------


    public static void reservarHabitacionCliente(String nombre, String apellido, String email, String nacionalidad, String telefono, String horaDeLlegada) {

        reservacionCliente[0] = new String[]{nombre, apellido, email, nacionalidad, telefono};
        reservacionCliente[2] = new String[]{horaDeLlegada};

        for (String[] unaResCli : reservacionCliente) {
            for (String att : unaResCli) {
                if (att == "") {
                    System.out.println("ERROR al realizar la reserva");
                    return;
                }
            }
        }

        System.out.println("Se ha realizado la reserva con exito");
    }


    //--------------------------------------CUARTO METODO----------------------------------------------


    public static void actulizacionReserva(int[] fechaNacimiento, String emailUsuario, LinkedList<LinkedList<String>> habitacionesDisponibles) {
        boolean salir = false;
        while (!salir) {

            Keyboard.nextLine();
            String cambiar = ingresarTexto("Deceas cambiar tu reserva? (Y/N): ");

            if (!cambiar.equalsIgnoreCase("y")) return;

            System.out.println("------------------------------------------------");
            System.out.println("Para confirmar su identidad necesitamos algunos datos");

            System.out.println("ingrese su fecha de nacimiento: ");
            int[] fechaIngresada = ingresarNacimientoFecha();
            if (!compararArrays(fechaIngresada, fechaNacimiento)) {
                limpiarConsola();
                System.out.println("ERROR con los datos ingresados");
                continue;
            }

            Keyboard.nextLine();
            String emailIngresado = ingresarTexto("ingrese su email: ");
            if (!emailIngresado.equalsIgnoreCase(emailUsuario)) {
                limpiarConsola();
                System.out.println("ERROR con los datos ingresados");
                continue;
            }
            System.out.println("Logramos comprobar su identidad");
            boolean salirBucle = false;
            while (!salirBucle) {
                System.out.println("------------------------------------------------");
                System.out.println("Que desea cambiar: ");
                System.out.println("0. Salir");
                System.out.println("1. Cambiar Habitacion");
                System.out.println("2. Cambiar Alojamiento");
                int num = ingresarNumero("");
                switch (num) {
                    case 0 -> salirBucle = true;
                    case 1 -> actualizarHabitacion(habitacionesDisponibles);
                    case 2 -> seleccionarAlojamiento();
                }
            }
        }
    }

    public static void actualizarHabitacion(LinkedList<LinkedList<String>> habitacionesDisponibles) {

        LinkedList<LinkedList<String>> newHabitacionesDisponibles = new LinkedList<>();

        // Crear una copia profunda
        for (LinkedList<String> habitacion : habitacionesDisponibles) {
            LinkedList<String> nuevaHabitacion = new LinkedList<>(habitacion);
            newHabitacionesDisponibles.add(nuevaHabitacion);
        }

        for (LinkedList<String> habitacion : newHabitacionesDisponibles) {
            if (habitacion.get(0).equals(reservacionCliente[3][0])) {
                newHabitacionesDisponibles.remove(habitacion);
            }
        }
        renderizarDatos(
                newHabitacionesDisponibles,
                new String[]{
                        "id",
                        "Tipo de habitacion",
                        "Descripcion",
                        "Veneficios",
                        "Precio por tipo de habitacion",
                        "El precio total de la habitacion es: $ "
                },
                ""
        );
        if (newHabitacionesDisponibles.isEmpty()) {
            System.out.println("No hay mas habitaciones disponibles");
            return;
        }
        seleccionarHabitacion(newHabitacionesDisponibles);

        limpiarConsola();
    }


    //--------------------------------------RENDERIZAR FORMULARIOS-------------------------------------


    public static String elegirNombreCiudad() {
        boolean salir = false;
        String nombreCiudad = "";
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Realize su reserva de habitaciones");
            System.out.println("Elija la ciudad de el hotel al que desea viajar");
            for (int i = 0; i < ciudades.length; i++) {
                System.out.println(i + 1 + ". ciudad:  " + ciudades[i]);
            }
            System.out.println("\n");
            int num = ingresarNumero("Eliga una opción: ");
            limpiarConsola();

            if (num > ciudades.length || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            nombreCiudad = ciudades[num - 1];
            salir = true;
        }

        return nombreCiudad;
    }

    public static String elegirTipoAlojamiento() {
        boolean salir = false;
        String tipoAlojamiento = "";
        while (!salir) {
            System.out.println("-----------------------------");
            System.out.println("BIENVENIDO A Booking Hoteles");
            System.out.println("Elija el tipo de alojamiento que desea");
            for (int i = 0; i < tiposAlojamientos.length; i++) {
                System.out.println(i + 1 + ". tipos de alojamientos:  " + tiposAlojamientos[i]);
            }
            System.out.println("\n");
            int num = ingresarNumero("Eliga una opción: ");

            limpiarConsola();

            if (num > tiposAlojamientos.length || num < 0) {
                System.out.println("No es un numero válido");
                continue;
            }
            tipoAlojamiento = tiposAlojamientos[num - 1];
            salir = true;
        }

        return tipoAlojamiento;
    }

    public static int ingresarCantidadPersonas(String tipoPersona) {
        System.out.println("-----------------------------");

        int cantPersonas = 0;

        boolean salir = false;
        while (!salir) {
            cantPersonas = ingresarNumero("Ingrese la cantidad de " + tipoPersona + ": ");

            if (cantPersonas < 0) {
                System.out.println("No es un numero válido");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("cantPersonas: " + cantPersonas);

        limpiarConsola();

        return cantPersonas;
    }

    public static int[] ingresarNacimientoFecha() {

        int dia = 0;
        int mes = 0;
        int anio = 0;

        boolean salir = false;
        while (!salir) {

            dia = ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            mes = ingresarNumero("Ingrese el mes: ");
            if (mes < 1 || mes > 12) {
                System.out.println("Error ingrese los datos nuevamente");

                continue;
            }

            anio = ingresarNumero("Ingrese el anio: ");
            if (anio > 2006) {
                limpiarConsola();
                System.out.println("Error necesita ser mayor de edad");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Anio: " + anio);

        limpiarConsola();

        return new int[]{dia, mes, anio};
    }

    public static int[] ingresarFecha() {

        int dia = 0;
        int mes = 0;
        int anio = 0;

        boolean salir = false;
        while (!salir) {

            dia = ingresarNumero("Ingrese el dia: ");
            if (dia < 1 || dia > 31) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            mes = ingresarNumero("Ingrese el mes: ");
            if (mes < 1 || mes > 12) {
                System.out.println("Error ingrese los datos nuevamente");

                continue;
            }

            anio = ingresarNumero("Ingrese el anio: ");
            if (anio <= 2024) {
                limpiarConsola();
                System.out.println("Error ingrese los datos nuevamente");
                continue;
            }

            salir = true;
        }

        System.out.println("-----------------------------");
        System.out.println("Dia: " + dia);
        System.out.println("Mes: " + mes);
        System.out.println("Anio: " + anio);

        limpiarConsola();

        return new int[]{dia, mes, anio};
    }

    public static String[] seleccionarAlojamiento(LinkedList<String[]> alojamientosDisponibles) {
        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            int idAlojamiento = ingresarNumero("Ingrese la id del alojamiento a reservar: ");
            for (int i = 0; i < alojamientosDisponibles.size(); i++) {
                if (convertirStringAInt(alojamientosDisponibles.get(i)[0]) == idAlojamiento) {
                    return alojamientosDisponibles.get(i);
                }
            }
            System.out.println("Alojamiento no encontrado");
        }
        return new String[0];
    }

    public static void seleccionarHabitacion(LinkedList<LinkedList<String>> habitaciones) {
        boolean salir = false;
        while (!salir) {
            System.out.println("-----------------------------");
            int idHabitacion = ingresarNumero("Ingrese la id de la habitacion a reservar: ");
            for (int i = 0; i < habitaciones.size(); i++) {
                if (convertirStringAInt(habitaciones.get(i).getFirst()) == idHabitacion) {

                    //transforma LinkedList en String[]
                    String[] convercion = habitaciones.get(i).toArray(new String[habitaciones.size()]);

                    //Agrega la habitacion reservada a la reserva del cliente
                    reservacionCliente[3] = convercion;
                    reservacionCliente[1][0] = convercion[5];
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
            int hora = ingresarNumero("Ingrese la hora (0 a 23): ");
            if (hora < 0 || hora > 23) {
                System.out.println("Error con la hora");
                continue;
            }

            int minutos = ingresarNumero("Ingrese los minutos (0 a 59): ");
            if (minutos < 0 || minutos > 59) {
                System.out.println("Error con los minutos");
                continue;
            }

            horaLlegada = hora + ":" + minutos;
            salir = true;
        }
        return horaLlegada;
    }


    //--------------------------------------FUNCIONES DE UTILIDAD--------------------------------------


    public static String[] buscarAlojamientoPorNombre(String nombreAlojamiento) {
        for (String[] unAlojamiento : alojamientos) {
            if (unAlojamiento[1].contains(nombreAlojamiento)) {
                return unAlojamiento;
            }
        }
        return new String[0];
    }

    public static int convertirStringAInt(String str) {
        int numero = 0;
        int longitud = str.length();

        // Iterar sobre cada carácter del String
        for (int i = 0; i < longitud; i++) {
            // Obtener el valor numérico del carácter (por ejemplo, '1' -> 1)
            char c = str.charAt(i);
            int valor = c - '0';  // Resta el valor ASCII de '0' para obtener el número

            // Multiplicar el número actual por 10 (para mover los dígitos a la izquierda)
            // y sumar el valor actual
            numero = numero * 10 + valor;
        }

        return numero;
    }

    public static String ingresarTexto(String msg) {
        System.out.print(msg);
        return Keyboard.nextLine();
    }

    public static int ingresarNumero(String msg) {
        int numero = 0;
        System.out.print(msg);
        while (true) {
            if (Keyboard.hasNextInt()) {
                numero = Keyboard.nextInt();
                break;
            } else {
                System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                Keyboard.next();
            }
        }
        return numero;
    }

    public static void limpiarConsola() {
        // Imprime 50 líneas en blanco para simular la limpieza
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void renderizarDatos(String[][] mostrarDato) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (String atributo : unDato) {
                System.out.println(atributo);
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatos(LinkedList<String[]> mostrarDato) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (String atributo : unDato) {
                System.out.println(atributo);
            }
            System.out.println("------------------------------------------------");
        }
    }

    public static void renderizarDatos(LinkedList<String[]> mostrarDato, String[] atributos) {
        System.out.println("------------------------------------------------");
        for (String[] unDato : mostrarDato) {
            for (int i = 0; i < unDato.length; i++) {
                System.out.println(atributos[i] + ": " + unDato[i]);
            }
            System.out.println("------------------------------------------------");
        }
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

    public static boolean compararArrays(int[] array1, int[] array2) {
        // Verificar si ambos arreglos son nulos
        if (array1 == null || array2 == null) {
            return false; // Si alguno es nulo, no son iguales
        }

        // Verificar si tienen la misma longitud
        if (array1.length != array2.length) {
            return false; // Si no tienen la misma longitud, no son iguales
        }

        // Comparar los elementos de los dos arreglos
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false; // Si algún elemento es diferente, los arreglos no son iguales
            }
        }

        return true; // Si todos los elementos son iguales, los arreglos son iguales
    }


}