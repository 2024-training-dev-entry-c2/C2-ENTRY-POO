import Services.HotelService;
import Models.Type;
import Models.Hotel;
import Seed.Seed;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static lib.FindCities.findCities;

public class Main {
    public static void main(String[] args) {
        List<Hotel> hotelList = Seed.createHotels();
        HotelService hotelServiceInstance = new HotelService(hotelList);
        Scanner inputScanner = new Scanner(System.in);
        int userChoice = 0;

        while (userChoice != 5) {

            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("1. Explorar Hoteles");
            System.out.println("2. Ver Disponibilidad de Habitaciones");
            System.out.println("3. Hacer una Reserva");
            System.out.println("4. Modificar Reserva Existente");
            System.out.println("5. Salir");

            try {
                System.out.print("Seleccione una opción: ");
                userChoice = Integer.parseInt(inputScanner.nextLine());

                switch (userChoice) {
                    case 1:
                        exploreHotels(hotelServiceInstance, inputScanner);
                        break;
                    case 2:
                        checkRoomAvailability(hotelServiceInstance, inputScanner);
                        break;
                    case 3:
                        makeReservation(hotelServiceInstance, inputScanner);
                        break;
                    case 4:
                        updateReservation(hotelServiceInstance, inputScanner);
                        break;
                    case 5:
                        System.out.println("¡Gracias por usar nuestro sistema! ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }

    // Método para realizar una reserva
    private static void makeReservation(HotelService service, Scanner scanner) {
        try {
            System.out.println("\n--- Nueva Reserva ---");

            System.out.print("Nombre del Cliente: ");
            String firstName = scanner.nextLine();

            System.out.print("Apellido del Cliente: ");
            String surname = scanner.nextLine();

            System.out.print("Correo Electrónico: ");
            String emailAddress = scanner.nextLine();

            System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Nacionalidad: ");
            String country = scanner.nextLine();

            System.out.print("Teléfono de Contacto: ");
            String phone = scanner.nextLine();

            System.out.print("Hora de Llegada Estimada: ");
            String arrivalHour = scanner.nextLine();

            System.out.print("Fecha de Inicio de la Estadía (AAAA-MM-DD): ");
            LocalDate startStay = LocalDate.parse(scanner.nextLine());

            System.out.print("Fecha de Fin de la Estadía (AAAA-MM-DD): ");
            LocalDate endStay = LocalDate.parse(scanner.nextLine());

            System.out.print("Número de Adultos: ");
            int adultCount = Integer.parseInt(scanner.nextLine());

            System.out.print("Número de Niños: ");
            int childrenCount = Integer.parseInt(scanner.nextLine());

            String reservationResponse = service.reserve(firstName, surname, emailAddress, birthDate, country, phone,
                    arrivalHour, startStay, endStay, adultCount, childrenCount);
            System.out.println(reservationResponse);
        } catch (Exception ex) {
            System.out.println("Error: No se pudo completar la reserva. Por favor, revise los datos ingresados.");
        }
    }

    // Método para verificar habitaciones disponibles
    private static void checkRoomAvailability(HotelService service, Scanner scanner) {
        try {
            List<Hotel> availableHotels = service.getHotels();
            if (availableHotels.isEmpty()) {
                System.out.println("No existen hoteles disponibles actualmente.");
                return;
            }

            System.out.println("\n--- Lista de Hoteles Disponibles ---");
            for (int index = 0; index < availableHotels.size(); index++) {
                System.out.println((index + 1) + ". " + availableHotels.get(index).getName() + " - " + availableHotels.get(index).getCity());
            }

            System.out.print("Seleccione un hotel (ingrese el número correspondiente): ");
            int selectedHotelIndex = Integer.parseInt(scanner.nextLine());
            String chosenHotel = availableHotels.get(selectedHotelIndex - 1).getName();

            System.out.print("Fecha de Inicio (AAAA-MM-DD): ");
            LocalDate checkInDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Fecha de Fin (AAAA-MM-DD): ");
            LocalDate checkOutDate = LocalDate.parse(scanner.nextLine());

            System.out.print("Cantidad de Adultos: ");
            int numAdults = Integer.parseInt(scanner.nextLine());

            System.out.print("Cantidad de Niños: ");
            int numChildren = Integer.parseInt(scanner.nextLine());

            System.out.print("Número de Habitaciones: ");
            int roomQuantity = Integer.parseInt(scanner.nextLine());

            List<String> availableRooms = service.searchRooms(chosenHotel, checkInDate, checkOutDate, numAdults, numChildren, roomQuantity);

            System.out.println("\nHabitaciones Encontradas:");
            if (availableRooms.isEmpty()) {
                System.out.println("Lo sentimos, no hay habitaciones disponibles para las fechas seleccionadas.");
            } else {
                availableRooms.forEach(System.out::println);
            }
        } catch (Exception ex) {
            System.out.println("Error: No se pudo buscar la disponibilidad. Verifique los datos ingresados.");
        }
    }

    // Método para explorar hoteles
    private static void exploreHotels(HotelService service, Scanner scanner) {
        try {
            List<String> availableCities = findCities(service);
            System.out.println("\n--- Ciudades Disponibles ---");
            for (int index = 0; index < availableCities.size(); index++) {
                System.out.println((index + 1) + ". " + availableCities.get(index));
            }

            System.out.print("Seleccione una ciudad (ingrese el número): ");
            int cityIndex = Integer.parseInt(scanner.nextLine());
            String selectedCity = availableCities.get(cityIndex - 1);

            System.out.println("Seleccione Tipo de Alojamiento:");
            System.out.println("1. Hotel\n2. Apartamento\n3. Finca\n4. Día de Sol\n5. Todos");
            int typeSelection = Integer.parseInt(scanner.nextLine());

            Type type = switch (typeSelection) {
                case 1 -> Type.HOTEL;
                case 2 -> Type.APARTAMENTO;
                case 3 -> Type.FINCA;
                case 4 -> Type.DIA_DE_SOL;
                default -> null;
            };
            System.out.print("Fecha de Inicio (AAAA-MM-DD): ");
            LocalDate start = LocalDate.parse(scanner.nextLine());

            LocalDate end;

            if (type.equals(Type.DIA_DE_SOL)){
                end = start;
            }
            else{
                System.out.println("Fecha de Fin (AAAA-MM-DD): ");
                end= LocalDate.parse(scanner.nextLine());
            }

            System.out.print("Número de Adultos: ");
            int adults = Integer.parseInt(scanner.nextLine());

            System.out.print("Número de Niños: ");
            int kids = Integer.parseInt(scanner.nextLine());

            System.out.print("Número de Habitaciones: ");
            int roomCount = Integer.parseInt(scanner.nextLine());

            List<String> searchResults = service.searchHotels(selectedCity, type, start, end, adults, kids, roomCount);

            System.out.println("\nResultados de Búsqueda:");
            if (searchResults.isEmpty()) {
                System.out.println("No se encontraron hoteles que coincidan con su búsqueda.");
            } else {
                searchResults.forEach(System.out::println);
            }
        } catch (Exception ex) {
            System.out.println("Error: No se pudo realizar la búsqueda. Por favor, revise los datos.");
        }
    }

    // Actualización de una reserva
    private static void updateReservation(HotelService service, Scanner scanner) {
        try {
            System.out.println("\n--- Modificación de Reserva ---");

            System.out.print("Ingrese su Email: ");
            String userEmail = scanner.nextLine();

            System.out.print("Fecha de Nacimiento (AAAA-MM-DD): ");
            LocalDate birthDate = LocalDate.parse(scanner.nextLine());

            boolean exists = service.getHotels().stream()
                    .flatMap(hotel -> hotel.getClients().stream())
                    .anyMatch(client -> client.getEmail().equalsIgnoreCase(userEmail) &&
                            client.getDateBirth().equals(birthDate));

            if (!exists) {
                throw new IllegalArgumentException("No existe ninguna reserva con los datos proporcionados.");
            }

            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Habitación\n2. Alojamiento");
            int modifyOption = Integer.parseInt(scanner.nextLine());

            System.out.print("Habitación actual (Número): ");
            int oldRoom = Integer.parseInt(scanner.nextLine());

            System.out.print("Nueva Habitación (Número): ");
            int newRoom = Integer.parseInt(scanner.nextLine());

            String result = service.changeReservation(userEmail, birthDate, modifyOption, oldRoom, newRoom);
            System.out.println(result);
        } catch (Exception ex) {
            System.out.println("Error: No se pudo actualizar la reserva. Por favor, intente nuevamente.");
        }
    }
}