package org.example.a;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

public class Main {


    //--------------------------------------DATOS DEL SISTEMA--------------------------------------

    public static LinkedList<Ciudad> listaCiudades = new LinkedList<>();
    public static LinkedList<TipoAlojamiento> listaTiposAlojamientos = new LinkedList<>();
    public static LinkedList<Alojamiento> listaAlojamiento = new LinkedList<>();
    public static LinkedList<Habitacion> listaHabitaciones = new LinkedList<>();
    public static LinkedList<RelacionHotelHabitacion> listaRelacionHotelHabitacion = new LinkedList<>();

    public static Cliente clienteSeleccionado;
    public static ReservacionCliente reservacionCliente = new ReservacionCliente();


    public static void PrecreandoDatos() {

        //-------------------Creacion de Ciudades
        listaCiudades.add(new Ciudad(1, "Cabo Polonio"));
        listaCiudades.add(new Ciudad(2, "La Paloma"));

        //-------------------Creacion de Tipo de Alojamiento
        listaTiposAlojamientos.add(new TipoAlojamiento(1, "Hotel"));
        listaTiposAlojamientos.add(new TipoAlojamiento(2, "Finca"));
        listaTiposAlojamientos.add(new TipoAlojamiento(3, "Apartamento"));
        listaTiposAlojamientos.add(new TipoAlojamiento(4, "Dia de Sol"));

        //-------------------Creacion de Alojamiento

        // Cabo Polonio
        listaAlojamiento.add(new Alojamiento(1, "Hotel Las Dunas", listaCiudades.get(0), listaTiposAlojamientos.get(0), 4.3, 150));
        listaAlojamiento.add(new Alojamiento(2, "Cabanas El Bosque", listaCiudades.get(0), listaTiposAlojamientos.get(0), 3.1, 80));
        listaAlojamiento.add(new Alojamiento(3, "Apartamento Mar del Sol", listaCiudades.get(0), listaTiposAlojamientos.get(1), 3.5, 70));
        listaAlojamiento.add(new Alojamiento(4, "Apartamento Vista Mar", listaCiudades.get(0), listaTiposAlojamientos.get(1), 3.7, 75));
        listaAlojamiento.add(new Alojamiento(5, "Cabaña Bosque Azul", listaCiudades.get(0), listaTiposAlojamientos.get(2), 3.8, 85));
        listaAlojamiento.add(new Alojamiento(6, "Cabaña Refugio del Mar", listaCiudades.get(0), listaTiposAlojamientos.get(2), 4.0, 90));
        listaAlojamiento.add(new Alojamiento(7, "Hotel Costa Dorada", listaCiudades.get(0), listaTiposAlojamientos.get(3), 4.1, 95));
        listaAlojamiento.add(new Alojamiento(8, "Hotel La Perla", listaCiudades.get(0), listaTiposAlojamientos.get(3), 4.2, 120));

        // La Paloma
        listaAlojamiento.add(new Alojamiento(9, "Cabana Los Pinos", listaCiudades.get(1), listaTiposAlojamientos.get(0), 4.0, 110));
        listaAlojamiento.add(new Alojamiento(10, "Cabanas La Paloma", listaCiudades.get(1), listaTiposAlojamientos.get(0), 4.5, 130));
        listaAlojamiento.add(new Alojamiento(11, "Apartamento Sol y Mar", listaCiudades.get(1), listaTiposAlojamientos.get(1), 4.0, 100));
        listaAlojamiento.add(new Alojamiento(12, "Finca La Paloma", listaCiudades.get(1), listaTiposAlojamientos.get(1), 3.9, 90));
        listaAlojamiento.add(new Alojamiento(13, "Cabana Los Almendros", listaCiudades.get(1), listaTiposAlojamientos.get(2), 4.1, 115));
        listaAlojamiento.add(new Alojamiento(14, "Cabanas del Mar", listaCiudades.get(1), listaTiposAlojamientos.get(2), 4.6, 140));
        listaAlojamiento.add(new Alojamiento(15, "Cabana del Lago", listaCiudades.get(1), listaTiposAlojamientos.get(3), 4.2, 125));
        listaAlojamiento.add(new Alojamiento(16, "Hotel Las Aguas", listaCiudades.get(1), listaTiposAlojamientos.get(3), 4.3, 130));

        //-------------------Creacion de Habitacion

        listaHabitaciones.add(new Habitacion(
                1,
                "Habitacion sencilla",
                "La habitacion sencilla tiene una cama matrimonial, vista al jardin, aire acondicionado, minibar, TV de pantalla plana, y bano privado",
                "Desayuno incluido",
                40
        ));

        listaHabitaciones.add(new Habitacion(
                2,
                "Habitacion doble",
                "La habitacion doble tiene 2 camas dobles, vista al mar, aire acondicionado, cafetera, TV de pantalla plana, ducha y escritorio",
                "No tiene beneficios",
                50
        ));

        listaHabitaciones.add(new Habitacion(
                3,
                "Habitacion familiar",
                "La habitacion familiar tiene 2 camas dobles, bano privado, aire acondicionado, TV de pantalla plana, escritorio, y vistas al mar",
                "Desayuno incluido, acceso a actividades familiares",
                90
        ));

        listaHabitaciones.add(new Habitacion(
                4,
                "Habitacion superior",
                "Habitacion con cama queen size, escritorio, bano con ducha y tina, aire acondicionado, TV de pantalla plana, y minibar",
                "Acceso a la piscina, desayuno incluido",
                120
        ));

        listaHabitaciones.add(new Habitacion(
                5,
                "Suite Deluxe",
                "Suite con cama king size, jacuzzi, terraza privada con vista panoramica, TV de pantalla plana, cafetera y minibar",
                "Acceso al spa, masaje gratuito",
                200
        ));

        //-------------------Creacion de Relacion Alojamiento Habitacion

        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 1, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 1, 10));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 1, 14));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 1, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 1, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 2, 3));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 2, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 2, 13));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 2, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 2, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 3, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 3, 12));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 3, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 3, 11));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 3, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 4, 2));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 4, 10));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 4, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 4, 14));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 4, 13));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 5, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 5, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 5, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 5, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 5, 3));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 6, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 6, 12));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 6, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 6, 2));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 6, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 7, 13));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 7, 10));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 7, 14));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 7, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 7, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 8, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 8, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 8, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 8, 12));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 8, 11));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 9, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 9, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 9, 3));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 9, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 9, 2));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 10, 11));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 10, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 10, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 10, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 10, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 11, 13));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 11, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 11, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 11, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 11, 10));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 12, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 12, 12));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 12, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 12, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 12, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 13, 2));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 13, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 13, 14));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 13, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 13, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 14, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 14, 3));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 14, 11));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 14, 9));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 14, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 15, 4));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 15, 10));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 15, 7));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 15, 6));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 15, 8));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(1, 16, 15));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(2, 16, 5));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(3, 16, 13));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(4, 16, 2));
        listaRelacionHotelHabitacion.add(new RelacionHotelHabitacion(5, 16, 10));

    }

    //--------------------------------------FUNCION PRINCIPAL-----------------------------------------


    //Metodo inicial
    public static void main(String[] args) throws IllegalAccessException {

        PrecreandoDatos();

        Renderizar.limpiarConsola();
        System.out.println("inicio de aplicacion");

        LinkedList<Habitacion> habitacionesDisponibles = seleccionarAlojamiento();



        Renderizar.limpiarConsola();
        System.out.println("Realizando confirmacion de la reservacion");

        Sistema.Keyboard.nextLine();
        String nombre = Sistema.ingresarTexto("Ingrese su nombre: ");
        String apellido = Sistema.ingresarTexto("Ingrese su apellido: ");
        String email = Sistema.ingresarTexto("Ingrese su email: ");
        String nacionalidad = Sistema.ingresarTexto("Ingrese su nacionalidad: ");
        System.out.println("Ingrese fecha de naciemiento: ");
        int[] fechaNacimiento = Renderizar.ingresarNacimientoFecha();
        Sistema.Keyboard.nextLine();
        String telefono = Sistema.ingresarTexto("Ingrese su telefono: ");
        String horaLlegada = Renderizar.ingresarHoraDeLlegada();


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
        Renderizar.renderizarDatosReservacionCliente(reservacionCliente);

        System.out.println("\n \n");
        actulizacionReserva(fechaNacimiento, email, habitacionesDisponibles);

        Renderizar.limpiarConsola();
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

    public static LinkedList<Habitacion> seleccionarAlojamiento() {

        String nombreCiudad = Renderizar.elegirNombreCiudad(listaCiudades);
        TipoAlojamiento tipoAlojamiento = Renderizar.elegirTipoAlojamiento(listaTiposAlojamientos);
        int cantHabitaciones = Sistema.ingresarNumero("Ingrese la cantidad de habitaciones: ");
        int cantAdultos = Renderizar.ingresarCantidadPersonas("Adultos");
        int cantNinios = Renderizar.ingresarCantidadPersonas("Ninios");
        System.out.println("Ingrese la fecha de inicio del hospedaje");
        int[] InicioHospedaje = Renderizar.ingresarFecha();
        System.out.println("Ingrese la fecha final del hospedaje");
        int[] FinalHospedaje = Renderizar.ingresarFecha();

        //Primera funcion
        LinkedList<Object> HotelesDisponibles = hotelesConLosSigientesParametros(
                nombreCiudad,
                tipoAlojamiento,
                cantHabitaciones,
                InicioHospedaje,
                FinalHospedaje,
                cantAdultos,
                cantNinios
        );


        //elegir alojamiento
        Alojamiento alojamientoSeleccionado = Renderizar.seleccionarAlojamiento(HotelesDisponibles);

        Renderizar.limpiarConsola();
        System.out.println("Habitaciones disponibles para reservar este hotel");

        //Segunda funcion
        LinkedList<Habitacion> habitacionesDisponibles = confirmarHabitaciones(
                alojamientoSeleccionado.getNombre(),
                InicioHospedaje,
                FinalHospedaje,
                cantAdultos,
                cantNinios,
                cantHabitaciones
        );

        //elegir habitacion
        Renderizar.seleccionarHabitacion(habitacionesDisponibles, reservacionCliente);

        return habitacionesDisponibles;

    }


    //---------------------------------------PRIMER METODO---------------------------------------------


    public static LinkedList<Object> hotelesConLosSigientesParametros(String ciudad, TipoAlojamiento tipoAlojamiento, int cantHabitacionesCliente, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios) {
        LinkedList<Object> nuevalistaAljamientos = new LinkedList<>();

        for (Alojamiento hotel : listaAlojamiento) {

            //Comprueba si el hotel es de la ciudad y si tiene el tipo de alojamiento
            if (!(hotel.getCiudad().getNombre().equals(ciudad) && hotel.getIdTipoDeAlojamiento().equals(tipoAlojamiento)))
                continue;


            //Calcula la cantidad de personas que iran a la habitacion
            int cantidadPersonas = cantAdultos + cantNinios;

            //Comprueba si hay habitaciones disponibles en el hotel de esa ciudad
            int[] cantidadYprecioHabitacionesDisponibles = buscarPrecioCantHabitacionesAlojamientoDisponible(hotel, cantidadPersonas);
            int cantidadHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[0];
            int minPrecioHabitacionesDisponibles = cantidadYprecioHabitacionesDisponibles[1];

            if (cantidadHabitacionesDisponibles < 1) continue;

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (cantidadHabitacionesDisponibles < cantHabitacionesCliente) continue;

            nuevalistaAljamientos.add(hotel);
            nuevalistaAljamientos.add("El precio aproximado del hotel |" + hotel.getNombre() + "| es: $ "
                    + minPrecioHabitacionesDisponibles + "\nPrecio aproximado por la fecha y la cantidad de salas elegidas: $ "
                    + calcularPrecioHabitacion(minPrecioHabitacionesDisponibles, diaInicioHospedaje, diaFinalHospedaje));
        }

        Renderizar.renderizarDatos(nuevalistaAljamientos);

        return nuevalistaAljamientos;
    }

    public static int[] buscarPrecioCantHabitacionesAlojamientoDisponible(Alojamiento alojamiento, int cantPersonas) {

        int minPrecioHabitacion = 0;
        int cantidadHabitaciones = 0;

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (RelacionHotelHabitacion unaRelacionHotelHabitacion : listaRelacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion.getIdAlojamiento() != alojamiento.getIdAlojamiento()) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion.getMaximaCantidadDePersonas() < cantPersonas) continue;

            Habitacion habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion.getIdHabitacion());
            int precioHabitacion = habitacion.getPrecio();

            if (minPrecioHabitacion == 0 || precioHabitacion < minPrecioHabitacion)
                minPrecioHabitacion = precioHabitacion;

            cantidadHabitaciones++;
        }

        return new int[]{cantidadHabitaciones, minPrecioHabitacion};
    }

    public static Habitacion obtenerHabitacionDeAlojamiento(int idHabitacion) {
        for (Habitacion unaHabitacion : listaHabitaciones) {
            if (unaHabitacion.getIdHabitacion() == idHabitacion) {
                return unaHabitacion;
            }
        }
        return null;
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


    public static LinkedList<Habitacion> confirmarHabitaciones(String nombreHotel, int[] diaInicioHospedaje, int[] diaFinalHospedaje, int cantAdultos, int cantNinios, int cantHabitacionesCliente) {
        Alojamiento alojamiento = buscarAlojamientoPorNombre(nombreHotel);
        int cantidadPersonas = cantAdultos + cantNinios;
        LinkedList<Habitacion> habitacionesDisponibles = buscarHabitacionesDisponible(alojamiento, cantidadPersonas);


        for (Habitacion unaHabitacion : habitacionesDisponibles) {

            //Comprueba que hay mas habitacinoes disponibles que las requeridas por el cliente
            if (habitacionesDisponibles.size() < cantHabitacionesCliente) continue;

            reservacionCliente.setPrecioTotal(calcularPrecioHabitacion(unaHabitacion.getPrecio(), diaInicioHospedaje, diaFinalHospedaje));

        }

        Renderizar.renderizarDatosHabitacion(habitacionesDisponibles);

        return habitacionesDisponibles;
    }

    public static LinkedList<Habitacion> buscarHabitacionesDisponible(Alojamiento alojamiento, int cantPersonas) {

        LinkedList<Habitacion> habitacionesDisponibles = new LinkedList<>();

        //Busca en todas las relaciones entre el alojamiento y las habitaciones
        for (RelacionHotelHabitacion unaRelacionHotelHabitacion : listaRelacionHotelHabitacion) {

            //Comprueba que las habitaciones sean del Alojamiento
            if (unaRelacionHotelHabitacion.getIdAlojamiento() != alojamiento.getIdAlojamiento()) continue;

            //comprueba que la habitacion tiene espacio para la cantidad de personas que lo habitaran
            if (unaRelacionHotelHabitacion.getMaximaCantidadDePersonas() < cantPersonas) continue;

            Habitacion habitacion = obtenerHabitacionDeAlojamiento(unaRelacionHotelHabitacion.getIdHabitacion());

            Sistema.mostrarDatosAtributos(habitacion);

            habitacionesDisponibles.add(habitacion);
        }

        return habitacionesDisponibles;
    }


    //--------------------------------------TERCER METODO----------------------------------------------


    public static void reservarHabitacionCliente(String nombre, String apellido, String email, String nacionalidad, String telefono, String horaDeLlegada) throws IllegalAccessException {

        clienteSeleccionado = new Cliente(1, nombre, apellido, email, nacionalidad, telefono);
        reservacionCliente.setCliente(clienteSeleccionado);
        reservacionCliente.setHoraLlegada(horaDeLlegada);

        Field[] campos = reservacionCliente.getClass().getDeclaredFields();

        for (Field campo : campos) {
            campo.setAccessible(true);

            Object valor = campo.get(reservacionCliente);
            try {
                if (valor instanceof String && ((String) valor).isEmpty()) {
                    System.out.println("ERROR al realizar la reserva");
                }
                if (valor instanceof Integer && ((int) valor) == 0) {
                    System.out.println("ERROR al realizar la reserva");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        System.out.println("Se ha realizado la reserva con exito");
    }


    //--------------------------------------CUARTO METODO----------------------------------------------


    public static void actulizacionReserva(int[] fechaNacimiento, String emailUsuario, LinkedList<Habitacion> habitacionesDisponibles) {
        boolean salir = false;
        while (!salir) {

            Sistema.Keyboard.nextLine();
            String cambiar = Sistema.ingresarTexto("Deceas cambiar tu reserva? (Y/N): ");

            if (!cambiar.equalsIgnoreCase("y")) return;

            System.out.println("------------------------------------------------");
            System.out.println("Para confirmar su identidad necesitamos algunos datos");

            System.out.println("ingrese su fecha de nacimiento: ");
            int[] fechaIngresada = Renderizar.ingresarNacimientoFecha();
            if (!Sistema.compararArrays(fechaIngresada, fechaNacimiento)) {
                Renderizar.limpiarConsola();
                System.out.println("ERROR con los datos ingresados");
                continue;
            }

            Sistema.Keyboard.nextLine();
            String emailIngresado = Sistema.ingresarTexto("ingrese su email: ");
            if (!emailIngresado.equalsIgnoreCase(emailUsuario)) {
                Renderizar.limpiarConsola();
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
                int num = Sistema.ingresarNumero("");
                switch (num) {
                    case 0 -> salirBucle = true;
                    case 1 -> actualizarHabitacion(habitacionesDisponibles);
                    case 2 -> seleccionarAlojamiento();
                }
            }
        }
    }

    public static void actualizarHabitacion(LinkedList<Habitacion> habitacionesDisponibles) {

        LinkedList<Habitacion> newHabitacionesDisponibles = new LinkedList<>();

        // Copiar las habitaciones a la nueva lista
        for (Habitacion h : habitacionesDisponibles) {
            newHabitacionesDisponibles.add(new Habitacion(h.getIdHabitacion(), h.getTitulo(), h.getDescripcion(), h.getBeneficiosHabitacion(), h.getPrecio()));
        }

        // Usar un iterador para eliminar elementos durante la iteración
        Iterator<Habitacion> iter = newHabitacionesDisponibles.iterator();
        while (iter.hasNext()) {
            Habitacion habitacion = iter.next();
            if (habitacion.getIdHabitacion() == reservacionCliente.getHabitacionCompradaDatos().getIdHabitacion()) {
                iter.remove();  // Eliminar de manera segura con el iterador
            }
        }

        Renderizar.renderizarDatosHabitacion(newHabitacionesDisponibles);

        if (newHabitacionesDisponibles.isEmpty()) {
            System.out.println("No hay mas habitaciones disponibles");
            return;
        }

        Renderizar.seleccionarHabitacion(newHabitacionesDisponibles, reservacionCliente);

        Renderizar.limpiarConsola();
    }


    //--------------------------------------FUNCIONES DE UTILIDAD--------------------------------------


    public static Alojamiento buscarAlojamientoPorNombre(String nombreAlojamiento) {
        for (Alojamiento unAlojamiento : listaAlojamiento) {
            if (unAlojamiento.getNombre().contains(nombreAlojamiento)) {
                return unAlojamiento;
            }
        }
        return null;
    }


}