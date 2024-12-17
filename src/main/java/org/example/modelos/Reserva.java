package org.example.modelos;

import org.example.interfaces.Reservable;
import java.time.LocalDate;

public class Reserva implements Reservable {
    private Hotel hotel;
    private String cliente;
    private int cantidadHabitaciones;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    // Constructor que recibe un objeto Hotel
    public Reserva(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public void reservar(String cliente, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;

        System.out.printf("Reserva confirmada para %s en el hotel %s desde %s hasta %s.%n",
                cliente, hotel.getNombre(), fechaInicio, fechaFin);
    }
}
