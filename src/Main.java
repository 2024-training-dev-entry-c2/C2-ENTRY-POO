import java.util.Date;
import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        // definicion de los datos por hotel dependiendo de la posicione en el arreglo
        String[] nombreDelHotel = {"Starlight Hotel", "Cosmos Hotel", "Blue Moon Hotel", "Dark Sun Hotel", "Andromeda Hotel"};
        String[] ciudadDestino = {"Cartagena", "Venecia", "Porto", "Munich", "Cartagena"};
        String[] tipoDeHotel = {"Hotel", "Apartamento", "Finca", "Dia de sol", "Hotel"};
        int[] maximoAdultos = {4, 2, 2, 6, 4};
        int[] maximoNinos = {2, 2, 0, 1, 2};
        int[] habitacionesDisponibles = {3, 5, 1, 7, 3};
        double[] calificacionDelHotel = {5.0, 4.5, 3.5, 4.8, 4.7};
        double[] precioPorNoche = {100.0, 120.0, 80.0, 150.0, 90.0}; //precio de la habitacion mas simple

        // busqueda con fechas de inicio estadia y fin estadia
        Date inicioEstadia = new Date(); // fecha de inicio de estadia (hoy)
        Date finEstadia = new Date(inicioEstadia.getTime() + (7L * 24 * 60 * 60 * 1000)); // fecha de fin de estadia (7 días despues)

        buscarHotel("Cartagena", "Hotel", inicioEstadia, finEstadia, 2, 1, 1, nombreDelHotel, ciudadDestino,
                tipoDeHotel, maximoAdultos, maximoNinos, habitacionesDisponibles, calificacionDelHotel, precioPorNoche);
    }

    public static void buscarHotel(String ciudad, String tipo, Date inicioEstadia, Date finEstadia, int adultos, int ninos, int habitaciones,
                                   String[] nombreDelHotel, String[] ciudadDestino, String[] tipoDeHotel, int[] maximoAdultos,
                                   int[] maximoNinos, int[] habitacionesDisponibles, double[] calificacionDelHotel, double[] precioPorNoche) {

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
        for (int i = 0; i < nombreDelHotel.length; i++) {
            if (ciudadDestino[i].equalsIgnoreCase(ciudad) &&
                    tipoDeHotel[i].equalsIgnoreCase(tipo) &&
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

                // verifico si los días de la estadía comprenden del 5 al 10 del mes llamando la func diasEntreElCincoYDiez
                if (diasEntreElCincoYDiez(inicioEstadia, finEstadia)) {
                    descuentoPrecio = totalPrecioBase * 0.08; // descuento del 8% del valor total
                    totalPrecioBase *= 0.92;
                }

                // muestro en consola la info para el usuario
                System.out.println("Hotel encontrado:");
                System.out.println("Hotel: " + nombreDelHotel[i]);
//                 System.out.println("Ciudad: " + ciudadDestino[i]);
//                 System.out.println("Tipo: " + tipoDeHotel[i]);
                System.out.println("Calificacion de: " + calificacionDelHotel[i] + " estrellas");
                System.out.println("Precio base por noche: $" + precioBase);
                System.out.println("Precio total base por " + diferenciaEnDias + " dia(s) y " + habitaciones + " habitacion(es): $" + totalPrecioBase);

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
            System.out.println("No se encontraron hoteles que coincidan con su busqueda.");
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
}
