package org.example.modelos;

import org.example.interfaces.Reservable;
import java.time.LocalDate;

public class Reserva implements Reservable {
    private Hotel hotel; // Composición: un objeto Hotel
    private String cliente;
    private String email; // Nuevo atributo
    private int cantidadHabitaciones;
    private String tipoHabitacion;
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

    public void reservar(String cliente, String email, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.email = email;
        this.cantidadHabitaciones = cantidadHabitaciones;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public void mostrarDetalles() {
        System.out.printf("Cliente: %s\nEmail: %s\nHotel: %s\nTipo de habitación: %s\nCantidad: %d\nFechas: %s a %s\n",
                cliente, email, hotel.getNombre(), tipoHabitacion, cantidadHabitaciones, fechaInicio, fechaFin);
    }

    public void actualizarHabitacion(String nuevaHabitacion, int cantidad) {
        this.tipoHabitacion = nuevaHabitacion;
        this.cantidadHabitaciones = cantidad;
        System.out.println("La habitación ha sido actualizada con éxito.");
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void actualizarAlojamiento(Hotel nuevoHotel, LocalDate inicio, LocalDate fin, String tipoHabitacion, int cantidad) {
        this.hotel = nuevoHotel;
        this.fechaInicio = inicio;
        this.fechaFin = fin;
        this.tipoHabitacion = tipoHabitacion;
        this.cantidadHabitaciones = cantidad;
        System.out.println("El alojamiento ha sido actualizado correctamente.");
    }


    public int getCantidadHabitaciones() { // Nuevo método
        return cantidadHabitaciones;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getEmailCliente() {
        return email;
    }

    public void cambiarHabitacion(Habitacion nuevaHabitacion, int cantidad) {
        if (nuevaHabitacion.tieneDisponibilidad(cantidad)) {
            nuevaHabitacion.reducirDisponibilidad(cantidad);
            this.tipoHabitacion = nuevaHabitacion.getTipo();
            this.cantidadHabitaciones = cantidad;
            System.out.println("La habitación ha sido actualizada con éxito.");
        } else {
            System.out.println("No hay suficiente disponibilidad para la nueva habitación seleccionada.");
        }
    }

    public boolean esConsistente() {
        return cliente != null && hotel != null && cantidadHabitaciones > 0 &&
                fechaInicio != null && fechaFin != null && !fechaInicio.isAfter(fechaFin);
    }


}
