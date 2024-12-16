package org.example;

public class Reserva {
    private String nombreCliente;
    private String emailCliente;
    private Alojamiento alojamiento;
    private Habitacion habitacion;

    public Reserva(String nombreCliente, String emailCliente, Alojamiento alojamiento, Habitacion habitacion) {
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
    }
}
