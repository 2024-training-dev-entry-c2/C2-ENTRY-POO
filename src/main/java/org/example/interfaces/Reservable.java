package org.example.interfaces;

import java.time.LocalDate;

public interface Reservable {
    void reservar(String cliente, int cantidadHabitaciones, LocalDate fechaInicio, LocalDate fechaFin);
}
