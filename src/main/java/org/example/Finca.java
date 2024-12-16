package org.example;

import java.util.List;

public class Finca extends Alojamiento{
    public Finca(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }
}
