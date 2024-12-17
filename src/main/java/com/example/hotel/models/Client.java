package com.example.hotel.models;

public class Client {
  private String name;
  private String lastName;
  private String email;
  private String nationality;
  private String phone;

  public Client(String name, String lastName, String email, String nationality, String phone) {
    this.name = name;
    this.lastName = lastName;
    this.email = email;
    this.nationality = nationality;
    this.phone = phone;
  }

  public Client() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNationality() {
    return nationality;
  }

  public void setNationality(String nationality) {
    this.nationality = nationality;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String printClient() {
    return "  Nombre: " + name + " " + lastName + "\n" +
           "  Email: " + email + "\n" +
           "  Nacionalidad: " + nationality + "\n" +
           "  Teléfono: " + phone + "\n";
  }
}
