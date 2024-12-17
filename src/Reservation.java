public class Reservation {
    // Atributos privados para encapsulamiento
    private Lodging lodging;  // Composición
    private String userName;
    private String userLastName;
    private String userEmail;
    private String userNationality;
    private String userPhoneNumber;
    private String userArrivalTime;
    private int startDay;
    private int finalDay;
    private int totalAdults;
    private int totalKids;
    private int totalRooms;
    private double totalPrice;
    private String selectedRoom;
    private String discount;

    // Constructor principal - inicializando los atributos es decir variables de instancia del objeto.
    public Reservation(Lodging lodging, String userName, String userLastName,
                       String userEmail, String userNationality,
                       String userPhoneNumber, String userArrivalTime,
                       int startDay, int finalDay, int totalAdults,
                       int totalKids, int totalRooms, String selectedRoom) {
        this.lodging = lodging;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userNationality = userNationality;
        this.userPhoneNumber = userPhoneNumber;
        this.userArrivalTime = userArrivalTime;
        this.startDay = startDay;
        this.finalDay = finalDay;
        this.totalAdults = totalAdults;
        this.totalKids = totalKids;
        this.totalRooms = totalRooms;
        this.selectedRoom = selectedRoom;
        this.totalPrice = calculateTotalPrice();
//        this.discount = discount;

        // Reducir habitaciones disponibles al crear reserva
        lodging.reduceAvailableRooms(totalRooms);
    }

    // Metodo para calcular precio total
    private double calculateTotalPrice() {
        int totalDays = finalDay - startDay;
        double basePrice = lodging.calculateFinalPrice(totalDays);
//        String totalIncreaseOrDecrease = "";
        // Lógica de incrementos/descuentos similar a tu código original
        if (startDay >= 27 && finalDay <= 31) {
            basePrice += basePrice * 0.15;
//            discount = "Aumento del 15%";
        } else if (startDay >= 10 && finalDay <= 15) {
            basePrice += basePrice * 0.10;
//            discount = "Aumento del 10%";
        } else if (startDay >= 5 && finalDay <= 10) {
            basePrice -= basePrice * 0.08;
//            discount = "Descuento del 8%";
        }

        return basePrice;
    }

    // Metodo para generar ID de reservación
    public String generateReservationId() {
        return userName.substring(0, 3) +
                userLastName.substring(0, 3) +
                startDay + finalDay;
    }

    // Metodo para cancelar reserva
    public void cancelReservation() {
        // Liberar habitaciones
        lodging.increaseAvailableRooms(totalRooms);
    }

    // Getters y Setters para todos los atributos
    // (Implementar todos los getters y setters)

    public Lodging getLodging() {
        return lodging;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public String getUserNationality() {
        return userNationality;
    }

    public String getSelectedRoom() {
        return selectedRoom;
    }


}