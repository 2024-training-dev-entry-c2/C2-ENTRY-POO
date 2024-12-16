package org.example;

import java.util.List;

public class Apartamento extends Alojamiento{
    public Apartamento(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }
}
