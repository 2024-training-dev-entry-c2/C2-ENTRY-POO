package org.example;

import java.util.List;

public class Hotel extends Alojamiento {

    public boolean buffet;

    public Hotel(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }

    @Override
    void escribirCondicion() {
        System.out.println("Buffet: "+ buffet);
    }

    public Hotel(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones, boolean buffet) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
        this.buffet = buffet;
    }

    public boolean isBuffet() {
        return buffet;
    }

    public void setBuffet(boolean buffet) {
        this.buffet = buffet;
    }

}
