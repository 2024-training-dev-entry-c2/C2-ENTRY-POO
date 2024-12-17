package org.example.interfaces;

import java.time.LocalDate;

public interface Reservable {
    void reservar(String cliente, int cantidadHabitaciones, java.time.LocalDate fechaInicio, java.time.LocalDate fechaFin);
}