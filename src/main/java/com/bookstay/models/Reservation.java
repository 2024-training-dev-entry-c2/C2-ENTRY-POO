package com.bookstay.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Reservation {
    private String name;
    private String lastname;
    private LocalDate birthDay;
    private String email;
    private int numberPhone;
    private String nationality;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime arrivedTime;
    private int adults;
    private int children;
    private List<Room> rooms;

    public Reservation(String name, String lastname, LocalDate birthDay, String email, int numberPhone, String nationality, LocalDate startDate, LocalDate endDate, LocalTime arrivedTime, int adults, int children) {
        this.name = name;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.numberPhone = numberPhone;
        this.nationality = nationality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.arrivedTime = arrivedTime;
        this.adults = adults;
        this.children = children;
    }

    public Reservation(String name, String lastname, LocalDate birthDay, String email, int numberPhone, String nationality, LocalDate startDate, LocalDate endDate, int adults, int children, List<Room> rooms) {
        this.name = name;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.numberPhone = numberPhone;
        this.nationality = nationality;
        this.startDate = startDate;
        this.endDate = endDate;
        this.adults = adults;
        this.children = children;
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Reserva de: " + name + " " + lastname +
                "\nEmail: " + email +
                "\nFecha de llegada: " + startDate +
                "\nFecha de salida: " + endDate +
                "\nNúmero de adultos: " + adults +
                "\nNúmero de niños: " + children +
                "\nHabitaciones: " + (rooms != null ? rooms.toString() : "N/A");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
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

    public LocalTime getArrivedTime() {
        return arrivedTime;
    }

    public void setArrivedTime(LocalTime arrivedTime) {
        this.arrivedTime = arrivedTime;
    }

    public int getAdults() {
        return adults;
    }

    public void setAdults(int adults) {
        this.adults = adults;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
