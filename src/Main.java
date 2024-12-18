import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    // Data structures
    static List<Accommodation> accommodations = new ArrayList<>();
    static List<Map<String, Object>> roomTypes = new ArrayList<>();
    static List<Map<String, String>> users = new ArrayList<>();
    static List<Map<String, Object>> bookings = new ArrayList<>();
    static List<Accommodation> selectedAccommodations = new ArrayList<>();
    static Map<String, Object> newBooking = new HashMap<>();
    static boolean canReserve = false;
    static boolean canConfirm = false;
    static int bookingIndex = 0;
    static int userIndex = 0;


    public static void getSelectedAccommodations(String city, String type, String startDate, String endDate, int roomQuantity, int adultsQuantity, int childrenQuantity){
        selectedAccommodations = new ArrayList<>();
        for (Accommodation acc : accommodations) {
            if (acc.getCity().equals(city)) {

                if(type.equals("Sunny Day")){
                    if(acc.isSunnyDay()){
                        //calculateSunnyDayPrice(selectedAccommodation, startDate, adultsQuantity, childrenQuantity);
                        selectedAccommodations.add(acc);
                    }
                }
                else {
                    if(acc.getType().equals(type)){
                        if(acc instanceof Hotel){
                            selectedAccommodations.add(acc);
                        }
                        else if(acc instanceof Farm){
                            Farm farm = (Farm) acc;
                            if(roomQuantity == farm.getRoomQuantity() && thereIsAccommodationAvailable( farm.getName(), startDate, endDate) ){
                                selectedAccommodations.add(acc);
                            }
                        }
                        else if(acc instanceof Apartment){
                            Apartment apto = (Apartment) acc;
                            if(roomQuantity == apto.getRoomQuantity() && thereIsAccommodationAvailable( apto.getName(), startDate, endDate) ){
                                selectedAccommodations.add(acc);
                            }
                        }
                    }

                }

            }
        }
    }

    public static boolean thereIsAccommodationAvailable(String name , String startDate, String endDate){
        for (Map<String, Object> booking : bookings){
            if(booking.get("accommodation").equals(name)){
                if(dateIntercept(startDate, endDate, (String) booking.get("startDate"), (String) booking.get("endDate"))){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dateIntercept(String startDate, String endDate, String bookingStartDate, String bookingEndDate) {

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        LocalDate bookingStart = LocalDate.parse(bookingStartDate);
        LocalDate bookingEnd = LocalDate.parse(bookingEndDate);

        return (start.isBefore(bookingEnd) || start.equals(bookingEnd)) &&
                (end.isAfter(bookingStart) || end.equals(bookingStart));
    }

    public static void calculateStayPrice(Map<String, Object> selectedAccommodation, String startDate, String endDate, int roomQuantity, String type, int pricePerNight ) {

        int basePrice;
        if(pricePerNight > 0){
            basePrice = pricePerNight;
        }
        else{
            basePrice = (int) selectedAccommodation.get("pricePerNight");
        }

        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        long days = ChronoUnit.DAYS.between(start, end);

        int totalBasePrice = 0;
        if(type.equals("Hotel")){
            totalBasePrice = basePrice * roomQuantity * (int) days;
        }
        else{
            totalBasePrice = basePrice * (int) days;
        }

        double discountOrIncrease = 0.0;
        String adjustmentType = "None";

        if (start.getDayOfMonth() >= 5 && end.getDayOfMonth() <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% Discount";
        } else if (start.getDayOfMonth() >= 10 && end.getDayOfMonth() <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% Increase";
        } else if (end.getDayOfMonth() > 25) {
            discountOrIncrease = 0.15 * totalBasePrice;
            adjustmentType = "15% Increase";
        }

        double finalPrice = totalBasePrice + discountOrIncrease;

        selectedAccommodation.put("basePrice", totalBasePrice);
        selectedAccommodation.put("adjustmentType", adjustmentType);
        selectedAccommodation.put("adjustmentValue", discountOrIncrease);
        selectedAccommodation.put("finalPrice", finalPrice);
    }

    public static void calculateSunnyDayPrice(Map<String, Object> selectedAccommodation, String startDate, int adultsQuantity, int childrenQuantity) {

        int pricePerson = (int) selectedAccommodation.get("pricePerson");
        int totalBasePrice = pricePerson * (adultsQuantity + childrenQuantity);

        LocalDate start = LocalDate.parse(startDate);

        double discountOrIncrease = 0.0;
        String adjustmentType = "None";

        if (start.getDayOfMonth() >= 5 && start.getDayOfMonth() <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% de descuento";
        } else if (start.getDayOfMonth() >= 10 && start.getDayOfMonth() <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% de incremento";
        } else if (start.getDayOfMonth() > 25) {
            discountOrIncrease = 0.15 * totalBasePrice;
            adjustmentType = "15% de incremento";
        }

        double finalPrice = totalBasePrice + discountOrIncrease;

        selectedAccommodation.put("basePrice", totalBasePrice);
        selectedAccommodation.put("adjustmentType", adjustmentType);
        selectedAccommodation.put("adjustmentValue", discountOrIncrease);
        selectedAccommodation.put("finalPrice", finalPrice);
    }

    public static int[] getAvailableRooms(String name , String startDate, String endDate, int[] rooms){
        int[] availableRooms = rooms.clone();

        for (Map<String, Object> booking : bookings){
            if(booking.get("accommodation").equals(name)){
                if(dateIntercept(startDate, endDate, (String) booking.get("startDate"), (String) booking.get("endDate"))){
                    int[] roomQuantity = (int[]) booking.get("roomQuantity");
                    for (int i = 0; i < availableRooms.length; i++) {
                        availableRooms[i] -= roomQuantity[i];
                        if (availableRooms[i] < 0) {
                            availableRooms[i] = 0;
                        }
                    }
                }
            }
        }

        return availableRooms;
    }

    public static Map<String, Object> confirmRooms(String name, String startDate, String endDate, int adultsQuantity, int childrenQuantity, int totalRooms){
        Map<String, Object> rooms = new HashMap<>();
        for(Accommodation acc : accommodations){
            if(acc.getName().equals(name)){
                if (acc instanceof Hotel) {
                    Hotel hotel = (Hotel) acc; // Cast to Hotel
                    int[] availableRooms = getAvailableRooms(name, startDate, endDate, hotel.getRooms());
                    int[] pricePerNight = hotel.getPricePerNight();
                    rooms.put("availableRooms", availableRooms);
                    rooms.put("pricePerNight", pricePerNight);
                    break;
                }
            }
        }
        return rooms;
    }

    public static boolean reserve(String firstName, String lastName, String email, String nationality, String phone, String birthDate, String hour){

        for(Map<String, String> user : users){
            if(user.get("email").equals(email)){
                return false;
            }
        }

        users.add(new HashMap<>(Map.of(
                "firstName", firstName,
                "lastName", lastName,
                "email", email,
                "nationality", nationality,
                "phone", phone,
                "birthDate", birthDate,
                "hour", hour
        )));

        newBooking.put("userEmail", email);
        Map<String, Object> bookingCopy = new HashMap<>();
        for (Map.Entry<String, Object> entry : newBooking.entrySet()) {
            Object valor = entry.getValue();
            bookingCopy.put(entry.getKey(), valor);
        }
        bookings.add(bookingCopy);
        canReserve = false;
        return true;
    }

    public static boolean isValidUser(String email, String birthDate){
        int index = 0;
        for(Map<String, String> user: users){
            if(user.get("email").equals(email)){
                if(user.get("birthDate").equals(birthDate)){
                    userIndex = index;
                    return true;
                }
                return false;
            }
            index++;
        }
        return false;
    }

    public static Map<String, Object> getBooking(String email){
        int index = 0;
        for(Map<String, Object> booking: bookings){
            if(booking.get("userEmail").equals(email) ){
                bookingIndex = index;
                return booking;
            }
            index++;
        }
        return null;
    }

    public static void main(String[] args) {

        // Initial data for accommodations
        Hotel hotel_1 = new Hotel("Hotel Estelar", "Manizales", "Hotel", 4.6f,  true,
                new int[]{180000, 250000, 350000, 500000, 1000000},
                new int[]{6,4,0,1,0}, 90000, 30, "Pool, Spa, Yoga", true);
        accommodations.add(hotel_1);
        Hotel hotel_2 = new Hotel("Hotel Carretero", "Manizales", "Hotel", 4.8f, false,
                new int[]{160000, 230000, 330000, 480000, 950000},
                new int[]{10, 0, 6, 3, 1},
                90000, 30, "Pool, Spa, Yoga", true);
        accommodations.add(hotel_2);

        Farm farm = new Farm("Granja Paraiso", "Manizales", "Farm", 4.4f, true,
                350000, 3, "Jardin, Piscina y Terraza", 110000,
                40, "Cabalgata, Eco paseo, Piscina", true);
        accommodations.add(farm);

        Apartment apto_1 = new Apartment("Apartamento en Milan zona G", "Manizales", "Apartment",
                4.5f, false, 250000, "Sala, Cocina, WiFi gratis, 1 cama doble y 1 cama sencilla",
                2);
        accommodations.add(apto_1);

        Apartment apto_2 = new Apartment("Apartamento en Palermo", "Manizales", "Apartment",
                4.7f, false, 280000, "Cocina, 2 baños, 2 camas dobles",
                2);
        accommodations.add(apto_2);

        // Initial data for room types
        roomTypes.add(new HashMap<>(Map.of(
                "type", "Standard",
                "features", "Cama doble, baño privado, TV, escritorio, internet básico"
        )));

        roomTypes.add(new HashMap<>(Map.of(
                "type", "Superior",
                "features", "Cama king size, baño más grande, adicionales (bata, pantuflas, minibar), vista parcial"
        )));

        roomTypes.add(new HashMap<>(Map.of(
                "type", "Deluxe",
                "features", "Cama king size, sala de estar independiente, baño de lujo con jacuzzi, vista panorámica"
        )));

        roomTypes.add(new HashMap<>(Map.of(
                "type", "Junior Suite",
                "features", "Combinación de dormitorio y pequeña sala de estar, cama king size, baño completo, sofá cama"
        )));

        roomTypes.add(new HashMap<>(Map.of(
                "type", "Presidential Suite",
                "features", "Amplia sala, comedor, cocineta, baño de lujo, servicios personalizados (mayordomo, chef privado)"
        )));

        // Initial data for users
        users.add(new HashMap<>(Map.of(
                "firstName", "John",
                "lastName", "Doe",
                "email", "john.doe@gmail.com",
                "nationality", "Colombiano",
                "phone", "3001234567",
                "birthDate", "1990-05-20"
        )));

        // Initial data for bookings
        bookings.add(new HashMap<>(Map.of(
                "userEmail", "john.doe@gmail.com",
                "accommodation", "Hotel Carretero",
                "type", "Hotel",
                "startDate", "2025-01-05",
                "endDate", "2025-01-10",
                "roomQuantity", new int[]{0, 0, 2, 0, 0},
                "totalRooms", 2,
                "totalPrice", 900000
        )));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSistema de Reservas");
            System.out.println("1. Buscar alojamiento");
            System.out.println("2. Confirmar habitaciones (hoteles)");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Actualizar reserva");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ciudad: ");
                    String city = scanner.nextLine();

                    System.out.print("Tipo de alojamiento (Hotel, Apartment, Farm, Sunny Day): ");
                    String type = scanner.nextLine();

                    String startDate;
                    String endDate="";
                    int roomQuantity = 0;
                    if(type.equals("Sunny Day")){
                        System.out.print("Fecha (YYYY-MM-DD): ");
                        startDate = scanner.nextLine();
                    }
                    else{
                        System.out.print("Fecha de inicio (YYYY-MM-DD): ");
                        startDate = scanner.nextLine();

                        System.out.print("Fecha de fin (YYYY-MM-DD): ");
                        endDate = scanner.nextLine();

                        System.out.print("Cantidad de habitaciones: ");
                        roomQuantity = scanner.nextInt();
                    }

                    System.out.print("Cantidad de adultos: ");
                    int adultsQuantity = scanner.nextInt();

                    System.out.print("Cantidad de niños: ");
                    int childrenQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    newBooking.put("startDate", startDate);
                    newBooking.put("endDate", endDate);
                    newBooking.put("adultsQuantity", adultsQuantity);
                    newBooking.put("childrenQuantity", childrenQuantity);
                    newBooking.put("totalRooms", roomQuantity);
                    newBooking.put("type", type);

                    getSelectedAccommodations(city, type, startDate, endDate, roomQuantity, adultsQuantity, childrenQuantity);

                    if (selectedAccommodations.isEmpty()) {
                        System.out.println("No se encontraron alojamientos disponibles según los criterios ingresados.");
                    } else {
                        System.out.println();
                        System.out.println("Alojamientos encontrados:");
                        int number = 1;
                        for (Accommodation accommodation : selectedAccommodations) {
                            System.out.println(number+". "+ accommodation.getName());
                            if(type.equals("Sunny Day")){
                                if(accommodation instanceof Hotel){
                                    Hotel hotel = (Hotel) accommodation;
                                    System.out.println(hotel.showSunnyDayAccommodation(startDate, adultsQuantity, childrenQuantity));
                                }
                                else if(accommodation instanceof Farm){
                                    Farm farm_1 = (Farm) accommodation;
                                    System.out.println(farm_1.showSunnyDayAccommodation(startDate, adultsQuantity, childrenQuantity));
                                }
                            }
                            else{
                                System.out.println(accommodation.showAccomodation(startDate, endDate, roomQuantity));
                            }
                            System.out.println();
                            number++;
                        }
                        System.out.print("Seleccione una opción: ");
                        int accOption = scanner.nextInt();
                        if(accOption > 0 && accOption <= selectedAccommodations.size()){
                            Accommodation acc= selectedAccommodations.get(accOption-1);
                            newBooking.put("accommodation", acc.getName());
                            if(type.equals("Hotel")){
                                canConfirm = true;
                            }
                            else{
                                if(type.equals("Sunny Day")){
                                    if(acc instanceof Hotel){
                                        Hotel hotel = (Hotel) acc;
                                        newBooking.put("totalPrice", hotel.calculateSunnyDayPrice(startDate, adultsQuantity, childrenQuantity).get("finalPrice"));
                                    }
                                    else if(acc instanceof Farm){
                                        Farm farm_1 = (Farm) acc;
                                        newBooking.put("totalPrice", farm_1.calculateSunnyDayPrice(startDate, adultsQuantity, childrenQuantity).get("finalPrice"));
                                    }

                                }
                                else{
                                    newBooking.put("totalPrice", acc.calculateStayPrice(startDate, endDate, roomQuantity).get("finalPrice"));
                                }
                                canReserve = true;
                            }
                            System.out.println("Alojamiento seleccionado: "+acc.getName());
                        }
                        else{
                            newBooking = new HashMap<>();
                            System.out.println("Opción inválida. Intente de nuevo.");
                        }
                    }
                    break;
                }
                case 2 ->{
                    if(canConfirm){
                        Map<String, Object> rooms = confirmRooms( (String) newBooking.get("accommodation"),(String) newBooking.get("startDate"),(String) newBooking.get("endDate"),(int) newBooking.get("adultsQuantity"),(int) newBooking.get("childrenQuantity"),(int) newBooking.get("totalRooms"));
                        int[] availableRooms = (int[]) rooms.get("availableRooms");
                        int[] pricePerNight = (int[]) rooms.get("pricePerNight");
                        double[] finalPrice = {0, 0, 0, 0, 0};
                        int[] roomQuantity = {0, 0, 0, 0, 0};

                        for(int i=0; i<availableRooms.length; i++){
                            if(availableRooms[i] > 0){
                                System.out.println((i+1)+". "+ roomTypes.get(i).get("type"));
                                System.out.println("Características: "+ roomTypes.get(i).get("features"));
                                System.out.println("Precio por noche: "+ pricePerNight[i]);
                                System.out.println("Habitaciones disponibles: "+ availableRooms[i]);
                                Map<String, Object> price = new HashMap<>();
                                calculateStayPrice(price,(String) newBooking.get("startDate"),(String) newBooking.get("endDate"),(int) newBooking.get("totalRooms"),"Hotel",pricePerNight[i]);
                                String priceString = "Precio base: " + price.get("basePrice") + '\n' +
                                        "Tipo de ajuste: " + price.get("adjustmentType") + '\n' +
                                        "Valor del ajuste: " + price.get("adjustmentValue") + '\n' +
                                        "Precio final: " + price.get("finalPrice") + '\n' ;
                                System.out.println(priceString);
                                finalPrice[i]= (double) price.get("finalPrice");
                            }
                            System.out.println();
                        }
                        System.out.print("Seleccione una opción: ");
                        int roomOption = scanner.nextInt();
                        if(roomOption > 0 && roomOption <= availableRooms.length){
                            if(availableRooms[roomOption-1] >= (int) newBooking.get("totalRooms") ){
                                roomQuantity[roomOption-1] = (int) newBooking.get("totalRooms");
                                newBooking.put("roomQuantity", roomQuantity);
                                newBooking.put("totalPrice", finalPrice[roomOption-1]);
                                canConfirm = false;
                                canReserve = true;
                            }
                            else{
                                System.out.println("La cantidad de habitaciones para el tipo elegido es insuficiente.");
                            }
                        }
                        else{
                            newBooking = new HashMap<>();
                            System.out.println("Opción inválida. Intente de nuevo.");
                        }

                    }
                    else{
                        System.out.println("No es posible confirmar habitaciones de hotel.");
                    }
                }
                case 3 ->{
                    if(canReserve){
                        System.out.print("Nombre: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Apellido: ");
                        String lastName = scanner.nextLine();

                        System.out.print("Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Nacionalidad: ");
                        String nationality = scanner.nextLine();

                        System.out.print("Teléfono: ");
                        String phone = scanner.nextLine();

                        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
                        String birthDate = scanner.nextLine();

                        System.out.print("Hora aproximada de llegada (HH:mm): ");
                        String hour = scanner.nextLine();

                        boolean reserved = reserve(firstName, lastName, email, nationality, phone, birthDate, hour);

                        if(reserved){
                            System.out.println("Se ha realizado la reserva con éxito.");
                        }
                        else{
                            System.out.println("Ya existe otra reserva con el mismo usuario.");
                        }
                    }
                    else{
                        System.out.println("No es posible reservar.");
                    }
                }
                case 4 ->{
                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Fecha de nacimiento: ");
                    String birthDate = scanner.nextLine();

                    if(isValidUser(email, birthDate)){
                        Map<String, Object> booking = getBooking(email);
                        if(booking == null){
                            System.out.println("El usuario no tiene reservas");
                        }
                        else{
                            System.out.println("Datos de la reserva: ");
                            String bookingString = "Alojamiento: " + booking.get("accommodation") + '\n' +
                                    "Fecha de inicio: " + booking.get("startDate") + '\n' +
                                    "Fecha de fin: " + booking.get("endDate") + '\n' +
                                    "Precio: " + booking.get("finalPrice") + '\n' ;
                            System.out.println(bookingString);

                            if(booking.get("type").equals("Hotel")){
                                System.out.println("1. Cambio de alojameinto");
                                System.out.println("2. Cambio de habitación");
                            }
                            else{
                                System.out.println("1. Cambio de alojameinto");
                            }
                            System.out.print("Seleccione una opción: ");
                            int changeOption = scanner.nextInt();
                            if(changeOption == 1){
                                bookings.remove(bookingIndex);
                                users.remove(userIndex);
                                System.out.print("Escoja un nuevo alojamiento.");
                            } else if (changeOption == 2) {
                                Map<String, Object> rooms = confirmRooms( (String) booking.get("accommodation"),(String) booking.get("startDate"),(String) booking.get("endDate"),(int) booking.get("adultsQuantity"),(int) booking.get("childrenQuantity"),(int) booking.get("totalRooms"));
                                int[] availableRooms = (int[]) rooms.get("availableRooms");
                                int[] pricePerNight = (int[]) rooms.get("pricePerNight");
                                double[] finalPrice = {0, 0, 0, 0, 0};
                                int[] roomQuantity = {0, 0, 0, 0, 0};
                                for(int i=0; i<availableRooms.length; i++){
                                    if(availableRooms[i] > 0){
                                        System.out.println((i+1)+". "+ roomTypes.get(i).get("type"));
                                        System.out.println("Características: "+ roomTypes.get(i).get("features"));
                                        System.out.println("Precio por noche: "+ pricePerNight[i]);
                                        System.out.println("Habitaciones disponibles: "+ availableRooms[i]);
                                        Map<String, Object> price = new HashMap<>();
                                        calculateStayPrice(price,(String) booking.get("startDate"),(String) booking.get("endDate"),(int) booking.get("totalRooms"),"Hotel",pricePerNight[i]);
                                        String priceString = "Precio base: " + price.get("basePrice") + '\n' +
                                                "Tipo de ajuste: " + price.get("adjustmentType") + '\n' +
                                                "Valor del ajuste: " + price.get("adjustmentValue") + '\n' +
                                                "Precio final: " + price.get("finalPrice") + '\n' ;
                                        System.out.println(priceString);
                                        finalPrice[i]= (double) price.get("finalPrice");
                                    }
                                    System.out.println();
                                }

                                int[] currentRoomQuantity = (int[]) booking.get("roomQuantity");
                                for(int i = 0; i < currentRoomQuantity.length; i++){
                                    if(currentRoomQuantity[i] != 0){
                                        System.out.println("Tiene habitaciones "+ roomTypes.get(i).get("type"));
                                        break;
                                    }
                                }
                                System.out.print("Seleccione otra opción: ");
                                int roomOption = scanner.nextInt();
                                if(roomOption > 0 && roomOption <= availableRooms.length){
                                    if(availableRooms[roomOption-1] >= (int) booking.get("totalRooms") ){
                                        roomQuantity[roomOption-1] = (int) booking.get("totalRooms");
                                        booking.put("roomQuantity", roomQuantity);
                                        booking.put("totalPrice", finalPrice[roomOption-1]);
                                    }
                                    else{
                                        System.out.println("La cantidad de habitaciones para el tipo elegido es insuficiente.");
                                    }
                                }
                                else{
                                    System.out.println("Opción inválida. Intente de nuevo.");
                                }
                            }
                        }
                    }
                    else {
                        System.out.println("Usuario inválido");
                    }
                }
                case 0 -> {
                    System.out.println("Gracias por usar el sistema. Adiós!");
                    exit = true;
                    break;
                }
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}