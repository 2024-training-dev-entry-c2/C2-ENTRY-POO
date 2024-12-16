package org.example;

import java.util.List;

public class Hotel extends Alojamiento{
    public Hotel(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }
}
