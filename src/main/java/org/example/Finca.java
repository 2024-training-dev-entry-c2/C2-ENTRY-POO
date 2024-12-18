package org.example;

import java.util.List;

public class Finca extends Alojamiento{

    private boolean cabalgata;

    public Finca(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }

    public Finca(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones, boolean cabalgata) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
        this.cabalgata=cabalgata;
    }
    @Override
    void escribirCondicion() {
        System.out.println("Cabalgata:"+cabalgata);
    }

    public boolean isCabalgata() {
        return cabalgata;
    }

    public void setCabalgata(boolean cabalgata) {
        this.cabalgata = cabalgata;
    }

}
