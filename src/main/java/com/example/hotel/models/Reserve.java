package com.example.hotel.models;


import java.time.LocalDate;
import java.time.LocalTime;

public class Reserve {
  Hosting hosting;
  Client client;
  int numberOfRooms;
  int numberOfAdults;
  int numberOfChildren;
  LocalDate startDate;
  LocalDate endDate;
  LocalTime arrivalTime;

  public Reserve(Hosting hosting, Client client, int numberOfRooms, int numberOfAdults, int numberOfChildren, LocalDate startDate, LocalDate endDate, LocalTime arrivalTime) {
    this.hosting = hosting;
    this.client = client;
    this.numberOfRooms = numberOfRooms;
    this.numberOfAdults = numberOfAdults;
    this.numberOfChildren = numberOfChildren;
    this.startDate = startDate;
    this.endDate = endDate;
    this.arrivalTime = arrivalTime;
  }

  public Reserve() {
  }

  public Hosting getHosting() {
    return hosting;
  }

  public void setHosting(Hosting hosting) {
    this.hosting = hosting;
  }

  public Client getClient() {
    return client;
  }

  public void setClient(Client client) {
    this.client = client;
  }

  public int getNumberOfRooms() {
    return numberOfRooms;
  }

  public void setNumberOfRooms(int numberOfRooms) {
    this.numberOfRooms = numberOfRooms;
  }

  public int getNumberOfAdults() {
    return numberOfAdults;
  }

  public void setNumberOfAdults(int numberOfAdults) {
    this.numberOfAdults = numberOfAdults;
  }

  public int getNumberOfChildren() {
    return numberOfChildren;
  }

  public void setNumberOfChildren(int numberOfChildren) {
    this.numberOfChildren = numberOfChildren;
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

  public LocalTime getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(LocalTime arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String printReservation() {
    return hosting.printHosting() + "\n" +
          client.printClient() + "\n" +
          "  Nombre: " + client.getName() + " " + client.getLastName() + "\n" +
          "  Email: " + client.getEmail() + "\n" +
          "  Nacionalidad: " + client.getNationality() + "\n" +
          "  Teléfono: " + client.getPhone() + "\n";
  }
}
