package org.example.modelos;

import org.example.interfaces.Reservable;

import java.time.LocalDate;

public class Reserva implements Reservable {
    private Hotel hotel; // Composición: un objeto Hotel
    private String cliente;
    private int cantidadHabitaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void reservar(String cliente, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Método para validar si los datos son consistentes
    public boolean esConsistente() {
        return cliente != null && hotel != null && cantidadHabitaciones > 0 &&
                fechaInicio != null && fechaFin != null && !fechaInicio.isAfter(fechaFin);
    }

    // Método para mostrar detalles de la reserva
    public void mostrarDetalles() {
        System.out.printf("Cliente: %s\nHotel: %s\nCantidad de habitaciones: %d\nFechas: %s a %s\n",
                cliente, hotel.getNombre(), cantidadHabitaciones, fechaInicio, fechaFin);
    }
}
