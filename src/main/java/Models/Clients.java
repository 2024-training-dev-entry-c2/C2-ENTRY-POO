package Models;

import java.time.LocalDate;

public class Clients {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final LocalDate dateBirth;
    private final String nationality;
    private final String phone;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int adultCount;
    private final int childCount;
    private final int roomCount;
    private String roomType;
    private final String arrivalTime;

    public Clients(String firstName, String lastName, String email, LocalDate dateBirth ,String nationality, String phone, LocalDate startDate, LocalDate endDate, int adultCount, int childCount,
                   int roomCount, String roomType, String arrivalTime) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateBirth= dateBirth;
        this.nationality = nationality;
        this.phone = phone;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adultCount = adultCount;
        this.childCount = childCount;
        this.roomCount = roomCount;
        this.roomType = roomType;
        this.arrivalTime = arrivalTime;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public int getAdultCount() {
        return adultCount;
    }

    public int getChildCount() {
        return childCount;
    }

    public int getRoomCount(){
        return roomCount;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String type) {
        this.roomType = type;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public String toString() {
        return "Detalles de la Reserva: \n" +
                "Cliente: " + firstName + " " + lastName + "\n" +
                "Email: " + email + "\n" +
                "Teléfono: " + phone + "\n" +
                "Nacionalidad: " + nationality + "\n" +
                "Fecha de nacimiento: " + dateBirth + "\n" +
                "Reserva: Desde " + startDate + " hasta " + endDate + "\n" +
                "Habitación: " + roomType + "\n" +
                "Adultos: " + adultCount + "\n" +
                "Menores: " + childCount;
    }
}