import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;

public class Main {

    // declaracion global de los arreglos
    static String[] nombreDelAlojamiento = {"Starlight Hotel", "Cosmos", "Blue Moon", "Dark Sun Hotel", "Andromeda Hotel"};
    static String[] ciudadDestino = {"Cartagena", "Venecia", "Porto", "Munich", "Cartagena"};
    static String[] tipoDeAlojamiento = {"Hotel", "Apartamento", "Finca", "Hotel", "Hotel"};
    static boolean[] ofreceDiaDeSol = {true, false, false, true, false};
    static int[] maximoAdultos = {4, 2, 2, 6, 4};
    static int[] maximoNinos = {2, 2, 0, 1, 2};
    static int[] habitacionesDisponibles = {3, 5, 1, 7, 3};
    static double[] calificacionDelHotel = {5.0, 4.5, 3.5, 4.8, 4.7};
    static double[] precioPorNoche = {100.0, 120.0, 80.0, 150.0, 90.0}; //precio de la habitacion mas simple
    static String[][] actividades = {
            {"Excursion", "Deportes acuaticos", "Caminatas"},
            {},
            {},
            {"Excursion", "Deportes acuaticos"},
            {}
    };
    static boolean[] incluyeAlmuerzo = {true, false, false, true, false};
    static boolean[] incluyeRefrigerio = {false, false, false, true, false};

    public static void main(String[] args) {

        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // solicito datos al usuario
        System.out.println("Ingrese la ciudad destino:");
        String ciudad = scanner.nextLine();

        System.out.println("Ingrese el tipo de alojamiento que desea (Ejemplo: Hotel, Apartamento, Finca, Dia de Sol):");
        String tipo = scanner.nextLine();

        // solicito las fechas de inicio y fin de la estadia
        System.out.println("Ingrese la fecha de inicio de la estadia (en formato AAAA-MM-DD):");
        String fechaInicioString = scanner.nextLine();
        Date inicioEstadia = convertirStringADate(fechaInicioString);

        System.out.println("Ingrese la fecha de fin de la estadia (en formato AAAA-MM-DD):");
        String fechaFinString = scanner.nextLine();
        Date finEstadia = convertirStringADate(fechaFinString);

        // solicito la cantidad de adultos, ninos y habitaciones
        System.out.println("Ingrese la cantidad de adultos que se van a hospedar:");
        int adultos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de ninos que se van a hospedar:");
        int ninos = scanner.nextInt();

        System.out.println("Ingrese la cantidad de habitaciones que desea:");
        int habitaciones = scanner.nextInt();

        // llamo la func de bucarHotel con los parametros dados por el usuario
        buscarHotel(ciudad, tipo, inicioEstadia, finEstadia, adultos, ninos, habitaciones);

        // se cierra el scanner para evitar problemas con la gestion de los recursos
        scanner.close();
    }

    // func para convertir la fecha de String a Date
    private static Date convertirStringADate(String fechaString) {
        try {
            // formato esperado: "AAAA-MM-DD" "YYYY-MM-DD"
            String[] fechaPartes = fechaString.split("-");
            int anio = Integer.parseInt(fechaPartes[0]);
            int mes = Integer.parseInt(fechaPartes[1]) - 1; // los meses en Java son 0=Enero 11=Diciembre
            int dia = Integer.parseInt(fechaPartes[2]);

            Calendar calendario = Calendar.getInstance();
            calendario.set(anio, mes, dia);
            return calendario.getTime();
        } catch (Exception e) {
            System.out.println("Error al ingresar la fecha. El formato debe ser YYYY-MM-DD.");
            return null;
        }
    }

    // METODO PARA BUSCAR HOTEL SEGUN REQUERIMIENTOS DEL USUARIO
    public static void buscarHotel(String ciudad, String tipo, Date inicioEstadia, Date finEstadia, int adultos, int ninos, int habitaciones) {

        boolean hotelEncontrado = false;

        // calculando los dias de estadia
        long diferenciaEnMilisegundos = finEstadia.getTime() - inicioEstadia.getTime();
        long diferenciaEnDias = diferenciaEnMilisegundos / (1000 * 60 * 60 * 24); // conversion de milisegundos a días

        // el alojamiento debe ser de un dia o mas
        if (diferenciaEnDias <= 0) {
            System.out.println("Debe alojarse como minimo un dia");
            return;
        }

        // recorro el arreglo de hoteles para relacionarlo con los demas arreglos por su posicion y comparo los datos con los proporcionados por el usuario
        for (int i = 0; i < nombreDelAlojamiento.length; i++) {
            if (((tipo.equalsIgnoreCase("Dia de Sol") &&
                    ofreceDiaDeSol[i]) || tipoDeAlojamiento[i].equalsIgnoreCase(tipo)) &&
                    ciudadDestino[i].equalsIgnoreCase(ciudad) &&
                    maximoAdultos[i] >= adultos &&
                    maximoNinos[i] >= ninos &&
                    habitacionesDisponibles[i] >= habitaciones) {
                hotelEncontrado = true;

                // usando el precio de la habitación más simple
                double precioBase = precioPorNoche[i];
                double totalPrecioBase = precioBase * habitaciones * diferenciaEnDias;  // calculo del valor total de la estadia

                // declaro las variables de descuento o incremento del valor de la estadia
                double descuentoPrecio = 0.0;
                double incrementoPrecio = 0.0;

                // verifico si los dias de estadia estan dentro de los ultimos 5 dias del mes llamando la func ultimosCincoDiasDelMes
                if (ultimosCincoDiasDelMes(inicioEstadia, finEstadia)) {
                    incrementoPrecio = totalPrecioBase * 0.15; // aumento del 15% del valor total
                    totalPrecioBase *= 1.15;
                }

                // verifico si los dias de estadia comprenden el 10 al 15 del mes llamando la func diasEntreElDiezYQuince
                if (diasEntreElDiezYQuince(inicioEstadia, finEstadia)) {
                    incrementoPrecio = totalPrecioBase * 0.10; // aumento del 10% del valor total
                    totalPrecioBase *= 1.10;
                }

                // verifico si los dias de la estadia comprenden del 5 al 10 del mes llamando la func diasEntreElCincoYDiez
                if (diasEntreElCincoYDiez(inicioEstadia, finEstadia)) {
                    descuentoPrecio = totalPrecioBase * 0.08; // descuento del 8% del valor total
                    totalPrecioBase *= 0.92;
                }

                // muestro en consola la info para el usuario
                System.out.println("Alojamiento encontrado:");
                System.out.println("Alojamiento: " + nombreDelAlojamiento[i]);
//                 System.out.println("Ciudad: " + ciudadDestino[i]);
//                 System.out.println("Tipo: " + tipoDeAlojamiento[i]);
                System.out.println("Calificacion de: " + calificacionDelHotel[i] + " estrellas");
                System.out.println("Precio base por noche: $" + precioBase);
                System.out.println("Precio total base por " + diferenciaEnDias + " dia(s) y " + habitaciones + " habitacion(es): $" + totalPrecioBase);

                // muestra actividades disponibles si ofrece Dia de Sol
                if (ofreceDiaDeSol[i]) {
                    System.out.println("Actividades disponibles:");
                    for (String actividad : actividades[i]) {
                        System.out.println("- " + actividad);
                    }
                }

                // precios de almuerzo y refrigerio adicionales
                double precioAlmuerzo = 20.0;
                double precioRefrigerio = 10.0;

                int totalPersonas = adultos + ninos;

                double precioTotalAlmuerzo = precioAlmuerzo * totalPersonas;
                double precioTotalRefrigerio = precioRefrigerio * totalPersonas;

                if (incluyeAlmuerzo[i]) {
                    System.out.println("Incluye almuerzo.");
                    System.out.println("Si desea incluir el almuerzo, el valor por persona es: $" + precioAlmuerzo +
                            "En total por " + totalPersonas + " persona(s) es $" + precioTotalAlmuerzo);
                    System.out.println("** El valor por almuerzo NO esta incluido en el precio total. Debe pagarlo en el establecimiento. **");
                }

                if(incluyeRefrigerio[i]) {
                    System.out.println("Incluye refrigerio.");
                    System.out.println("Si desea incluir el refrigerio, el valor por persona es: $" + precioRefrigerio +
                            "En total por " + totalPersonas + " persona(s) es $" + precioTotalRefrigerio);
                    System.out.println("** El valor por refrigerio NO esta incluido en el precio total. Debe pagarlo en el establecimiento. **");
                }

//                if (descuentoPrecio > 0) {
//                    System.out.println("Descuento aplicado (8%): -$" + descuentoPrecio);
//                }
//                if (incrementoPrecio > 0) {
//                    System.out.println("Aumento aplicado: +$" + incrementoPrecio);
//                }
//
//                 System.out.println("Max Adultos: " + maximoAdultos[i]);
//                 System.out.println("Max Niños: " + maximoNinos[i]);
//                 System.out.println("Habitaciones disponibles: " + habitacionesDisponibles[i]);
                System.out.println("--------------------------");
            }
        }

        if (!hotelEncontrado) {
            System.out.println("No se encontraron alojamientos que coincidan con su busqueda.");
        }
    }

    // Calendar es una clase que da los metodos para convertir, manipular y analizar fechas y horas
    // func para verificar si los ultimos 5 dias de la estadia caen dentro de un mes
    private static boolean ultimosCincoDiasDelMes(Date inicioEstadia, Date finEstadia) {
        Calendar empezarCalendario = Calendar.getInstance();
        empezarCalendario.setTime(inicioEstadia);

        Calendar finalizarCalendario = Calendar.getInstance();
        finalizarCalendario.setTime(finEstadia);

        // obteniendo el ultimo dia del mes para la fecha de fin estadia
        int lastDayOfMonth = finalizarCalendario.getActualMaximum(Calendar.DAY_OF_MONTH);

        // verificando si los ultimos 5 dias del mes estan dentro del rango de fechas
        return (finalizarCalendario.get(Calendar.DAY_OF_MONTH) >= lastDayOfMonth - 4);
    }

    // func para verificar si los dias de estadia estan entre el 10 al 15 del mes
    private static boolean diasEntreElDiezYQuince(Date inicioEstadia, Date finEstadia) {
        Calendar empezarCalendario = Calendar.getInstance();
        empezarCalendario.setTime(inicioEstadia);

        Calendar finalizarCalendario = Calendar.getInstance();
        finalizarCalendario.setTime(finEstadia);

        // verificando si alguna de las fechas cae entre el 10 y el 15 del mes
        return (empezarCalendario.get(Calendar.DAY_OF_MONTH) <= 15 && finalizarCalendario.get(Calendar.DAY_OF_MONTH) >= 10);
    }

    // func para verificar si los dias de estadia estan entre del 5 al 10 del mes
    private static boolean diasEntreElCincoYDiez(Date inicioEstadia, Date finEstadia) {
        Calendar empezarCalendario = Calendar.getInstance();
        empezarCalendario.setTime(inicioEstadia);

        Calendar finalizarCalendario = Calendar.getInstance();
        finalizarCalendario.setTime(finEstadia);

        // verificando si alguna de las fechas cae entre el 5 y el 10 del mes
        return (empezarCalendario.get(Calendar.DAY_OF_MONTH) <= 10 && finalizarCalendario.get(Calendar.DAY_OF_MONTH) >= 5);
    }

    // METODO PARA CONFIRMAR HABITACIONES
}
