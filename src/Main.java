
import java.util.*;

public class Main {

    static List<Map<String, Object>> hoteles = new ArrayList<>();
    static List<Map<String, Object>> reservas = new ArrayList<>();

    public static void main(String[] args) {
        datosHoteles();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("Aplicación Booking Hoteles\n");

        System.out.println("1. Buscar hoteles");

        System.out.println("2. Confirmar habitaciones disponibles");

        System.out.println("3. Reservar");

        System.out.println("4. Actualizar reserva");

        System.out.println("5. Salir");

        System.out.print("Elige una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        while (opcion != 5) {
            switch (opcion) {
                case 1:
                    buscarHoteles(scanner);
                    break;

                case 2:
                    confirmarHabitaciones(scanner);
                    break;

                case 3:
                    realizarReserva(scanner);
                    break;

                case 4:
                    actualizarReserva(scanner);
                    break;

                case 5:
                    System.out.println("Gracias por usar la aplicación Booking Hoteles");
                    break;

                default:
                    System.out.println("Opción no válida");
                    break;

            }

            System.out.println("Aplicación Booking Hoteles");

            System.out.println("1. -- Buscar hoteles --");

            System.out.println("2. -- Confirmar habitaciones disponibles  --");

            System.out.println("3. -- Reservar --");

            System.out.println("4. -- Actualizar reserva --");

            System.out.println("5. -- Salir --");

            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();

            scanner.nextLine();
        }

        scanner.close();
    }

    static void datosHoteles() {
        Map<String, Object> hotel1 = new HashMap<>();
        hotel1.put("nombre", "Hotel playa");

        hotel1.put("ciudad", "Cartagena");

        hotel1.put("tipo", "Hotel");

        hotel1.put("calificacion", 5);

        hotel1.put("precio", 200000);

        hotel1.put("habitaciones", 10);

        hoteles.add(hotel1);

        Map<String, Object> hotel2 = new HashMap<>();
        hotel2.put("nombre", "Finca villa");

        hotel2.put("ciudad", "Medellin");

        hotel2.put("tipo", "Finca");

        hotel2.put("calificacion", 4);

        hotel2.put("precio", 150000);

        hotel2.put("habitaciones", 5);
        hoteles.add(hotel2);

        Map<String, Object> hotel3 = new HashMap<>();
        hotel3.put("nombre", "Apartamento Poblado");

        hotel3.put("ciudad", "Medellin");

        hotel3.put("tipo", "Apartamento");

        hotel3.put("calificacion", 3);

        hotel3.put("precio", 100000);

        hotel3.put("habitaciones", 8);

        hoteles.add(hotel3);

        Map<String, Object> hotel4 = new HashMap<>();
        hotel4.put("nombre", "Club colonial");

        hotel4.put("ciudad", "Medellin");

        hotel4.put("tipo", "Dia de Sol");

        hotel4.put("calificacion", 5);

        hotel4.put("precio", 50000);

        hotel4.put("habitaciones", 20);

        hotel4.put("actividades", "Piscina, Zona verde, Deportes acuáticos");

        hotel4.put("almuerzo", true);

        hoteles.add(hotel4);

        Map<String, Object> hotel5 = new HashMap<>();
        hotel5.put("nombre", "Hotel Poblado");

        hotel5.put("ciudad", "Medellin");

        hotel5.put("tipo", "Hotel");

        hotel5.put("calificacion", 2);

        hotel5.put("precio", 150000);

        hotel5.put("habitaciones", 15);

        hoteles.add(hotel5);

        Map<String, Object> hotel6 = new HashMap<>();
        hotel6.put("nombre", "finca solar");

        hotel6.put("ciudad", "Cartagena");

        hotel6.put("tipo", "Finca");

        hotel6.put("calificacion", 2);

        hotel6.put("precio", 400000);

        hotel6.put("habitaciones", 8);

        hoteles.add(hotel6);

        Map<String, Object> hotel7 = new HashMap<>();
        hotel7.put("nombre", "El paraiso club");

        hotel7.put("ciudad", "Cartagena");

        hotel7.put("tipo", "Dia de Sol");

        hotel7.put("calificacion", 5);

        hotel7.put("precio", 900000);

        hotel7.put("habitaciones", 18);

        hoteles.add(hotel7);

        Map<String, Object> hotel8 = new HashMap<>();
        hotel8.put("nombre", "El paraiso");

        hotel8.put("ciudad", "Cartagena");

        hotel8.put("tipo", "Apartamento");

        hotel8.put("calificacion", 4);

        hotel8.put("precio", 350000);

        hotel8.put("habitaciones", 5);

        hoteles.add(hotel8);

        Map<String, Object> hotel9 = new HashMap<>();
        hotel9.put("nombre", "La esperanza");

        hotel9.put("ciudad", "Medellin");

        hotel9.put("tipo", "Dia de Sol");

        hotel9.put("calificacion", 4);

        hotel9.put("precio", 70000);

        hotel9.put("habitaciones", 13);

        hotel9.put("actividades", "Piscina, Zona verde, Deportes acuáticos");

        hotel9.put("almuerzo", false);

        hoteles.add(hotel9);

        Map<String, Object> hotel10 = new HashMap<>();
        hotel10.put("nombre", "Descanso total");

        hotel10.put("ciudad", "Cartagena");

        hotel10.put("tipo", "Dia de Sol");

        hotel10.put("calificacion", 4);

        hotel10.put("precio", 70000);

        hotel10.put("habitaciones", 13);

        hotel10.put("actividades", "Piscina, Zona verde, Deportes acuáticos");

        hotel10.put("almuerzo", false);

        hoteles.add(hotel10);
    }

    static void buscarHoteles(Scanner scanner) {
        System.out.print("Ingrese la ciudad: ");
        String ciudad = scanner.nextLine();

        System.out.print("Ingrese el tipo de alojamiento (Hotel, Apartamento, Finca, Dia de Sol): ");
        String tipo = scanner.nextLine();

        System.out.print("Cantidad de adultos: ");
        int cantidadAdultos = scanner.nextInt();

        System.out.print("Cantidad de niños: ");
        int cantidadNiños = scanner.nextInt();

        System.out.print("Ingrese el día de inicio (01-31): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el día de finalización (01-31): ");
        int fin = scanner.nextInt();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int habitaciones = scanner.nextInt();

        List<Map<String, Object>> resultados = new ArrayList<>();

        for (Map<String, Object> hotel : hoteles) {
            if (hotel.get("ciudad").equals(ciudad) && hotel.get("tipo").equals(tipo)) {

                if ((int) hotel.get("habitaciones") >= habitaciones) {
                    resultados.add(hotel);
                }

            }
        }

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron hoteles disponibles con los datos ingresados.");
            return;
        }


        for (Map<String, Object> hotel : resultados) {
            int precioPorNoche = (int) hotel.get("precio");

            int dias = fin - inicio + 1;

            int parcial = fin - inicio + 1;

            int precioParcial = precioPorNoche * parcial;

            int precioTotal = precioPorNoche * dias * habitaciones;

            if (fin >= 26) {
                int aumento = (int) (precioTotal * 0.15);
                precioTotal += aumento;
                System.out.println("* Se aplica un aumento del 15% por hospedarse los últimos días del mes. Monto: $" + aumento);

            } else if (inicio >= 10 && inicio <= 15) {
                int aumento = (int) (precioTotal * 0.10);
                precioTotal += aumento;
                System.out.println("* Se aplica un aumento del 10% por hospedarse del 10 al 15. Monto: $" + aumento);
            } else if (inicio >= 5 && inicio <= 10) {

                int descuento = (int) (precioTotal * 0.08);
                precioTotal -= descuento;
                System.out.println("* Se aplica un descuento del 8% por hospedarse del 5 al 10. Monto: $" + descuento);
            }


            System.out.printf("\nHotel: %s\nCalificación: %d estrellas\nPrecio por noche: $%,d\nPrecio total: $%,d\n",
                    hotel.get("nombre"), hotel.get("calificacion"), precioPorNoche, precioTotal);
            System.out.println("Precio parcial $: " + precioParcial * habitaciones);
            if (hotel.get("tipo").equals("Dia de Sol")){
                System.out.println("Actividades" + hotel.get("actividades"));
                System.out.println( "incluye almuerzo?" + hotel.get("almuerzo"));

            }
        }
    }

    static void confirmarHabitaciones(Scanner scanner) {
        System.out.print("Ingrese el nombre del hotel: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el día de inicio (01-31): ");
        int inicio = scanner.nextInt();

        System.out.print("Ingrese el día de finalización (01-31): ");
        int fin = scanner.nextInt();

        System.out.print("Cantidad de adultos: ");
        int cantidadAdultos = scanner.nextInt();

        System.out.print("Cantidad de niños: ");
        int cantidadNiños = scanner.nextInt();

        System.out.print("Ingrese la cantidad de habitaciones: ");
        int habitaciones = scanner.nextInt();

        for (Map<String, Object> hotel : hoteles) {

            if (hotel.get("nombre").equals(nombre)) {

                int disponibles = (int) hotel.get("habitaciones");

                if (habitaciones <= disponibles) {
                    System.out.printf("Habitaciones disponibles: %d.\nCaracterísticas: Básicas. Precio por noche: $%,d.\n",
                            disponibles, hotel.get("precio"));

                } else {
                    System.out.println("No hay suficientes habitaciones disponibles.");
                }

                return;

            }
        }
        System.out.println("No se encontró el hotel.");
    }




    static void realizarReserva(Scanner scanner) {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();

        System.out.print("Ingrese su nacionalidad (pais): ");
        String nacionalidad = scanner.nextLine();

        System.out.print("Ingrese su fecha de nacimiento (año-mes-dia): ");
        String fechaNacimiento = scanner.nextLine();

        System.out.print("Ingrese su número de teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Ingrese la hora aproximada de llegada (0-23): ");
        int hora = scanner.nextInt();



        System.out.print("Ingrese el nombre del hotel: ");
        scanner.nextLine();
        String nombreHotel = scanner.nextLine();
        System.out.print("Ingrese el día de inicio (01-31): ");

        int inicio = scanner.nextInt();
        System.out.print("Ingrese el día de finalización (01-31): ");

        int fin = scanner.nextInt();
        System.out.print("Ingrese la cantidad de habitaciones: ");

        int habitaciones = scanner.nextInt();




        for (Map<String, Object> hotel : hoteles) {

            if (hotel.get("nombre").equals(nombreHotel)) {
                int disponibles = (int) hotel.get("habitaciones");

                if (habitaciones <= disponibles) {
                    reservas.add(new HashMap<>() {{
                        put("cliente", new HashMap<String, Object>() {{
                            put("nombre", nombre);

                            put("apellido", apellido);

                            put("email", email);

                            put("nacionalidad", nacionalidad);

                            put("telefono", telefono);

                            put("hora", hora);

                            put("fecha", fechaNacimiento);

                        }});

                        put("hotel", nombreHotel);
                        put("inicio", inicio);
                        put("fin", fin);
                        put("habitaciones", habitaciones);
                    }});

                    hotel.put("habitaciones", disponibles - habitaciones);
                    System.out.println("Reserva realizada con éxito.");
                    return;
                } else {
                    System.out.println("No hay suficientes habitaciones disponibles.");
                }
                return;
            }
        }


        System.out.println("No se encontró el hotel.");

    }

    static void actualizarReserva(Scanner scanner) {
        System.out.print("Ingrese su email: ");
        String email = scanner.nextLine();
        System.out.print("Ingrese su fecha de nacimiento (año-mes-dia): ");
        String fechaNacimiento = scanner.nextLine();

        for (Map<String, Object> reserva : reservas) {
            Map<String, Object> cliente = (Map<String, Object>) reserva.get("cliente");
            if (cliente.get("email").equals(email) && cliente.get("fecha").equals(fechaNacimiento)) {
                System.out.println("Reserva encontrada:");

                System.out.printf("Hotel: %s, Fecha inicio: %d, Fecha fin: %d, Habitaciones: %d\n",

                        reserva.get("hotel"), reserva.get("inicio"), reserva.get("fin"), reserva.get("habitaciones"));

                System.out.println("¿Qué desea actualizar? 1. -- Cambiar habitación 2. -- Cambiar alojamiento");
                int opcionCambio = scanner.nextInt();
                scanner.nextLine();

                if (opcionCambio == 1) {
                    cambiarHabitacion(scanner, reserva);

                } else if (opcionCambio == 2) {
                    reservas.remove(reserva);

                    System.out.println("Reserva eliminada. Realice una nueva reserva.");

                    realizarReserva(scanner);
                } else {

                    System.out.println("Opción no válida.");
                }
                return;
            }
        }


        System.out.println("No se encontró una reserva con el email y fecha proporcionadas.");
    }



    static void cambiarHabitacion(Scanner scanner, Map<String, Object> reserva) {
        System.out.print("Ingrese la nueva cantidad de habitaciones: ");
        int nuevasHabitaciones = scanner.nextInt();

        String nombreHotel = (String) reserva.get("hotel");

        for (Map<String, Object> hotel : hoteles) {

            if (hotel.get("nombre").equals(nombreHotel)) {
                int habitacionesDisponibles = (int) hotel.get("habitaciones");

                int habitacionesActuales = (int) reserva.get("habitaciones");


                if (nuevasHabitaciones > habitacionesActuales) {
                    int habitacionesNecesarias = nuevasHabitaciones - habitacionesActuales;

                    if (habitacionesNecesarias > habitacionesDisponibles) {
                        System.out.println("No hay suficientes habitaciones disponibles.");
                        return;
                    }
                }

                hotel.put("habitaciones", habitacionesDisponibles + habitacionesActuales - nuevasHabitaciones);

                reserva.put("habitaciones", nuevasHabitaciones);

                System.out.println("Cambio de habitaciones realizado con éxito.");
                return;
            }
        }
        System.out.println("No se encontró el hotel asociado a la reserva.");
    }


}

