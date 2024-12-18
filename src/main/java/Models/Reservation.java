package Models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation<T> {

    private Client client;
    private T accommodation;
    private int numberOfRooms;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime checkInTime;


    public Reservation(Client client, T accommodation, int numberOfRooms, Room room, LocalDate startDate, LocalDate endDate, LocalTime checkInTime) {
        this.client = client;
        this.accommodation = accommodation;
        this.numberOfRooms = numberOfRooms;
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.checkInTime = checkInTime;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public T getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(T accommodation) {
        this.accommodation = accommodation;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(LocalTime checkInTime) {
        this.checkInTime = checkInTime;
    }
}