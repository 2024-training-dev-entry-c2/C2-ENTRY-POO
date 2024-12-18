package org.example;

import java.util.List;

public class Apartamento extends Alojamiento {

    protected boolean parqueadero;
    protected boolean mascota;


    public Apartamento(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }

    public Apartamento(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones, boolean mascota) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
        this.mascota = mascota;
    }

    @Override
    void escribirCondicion() {
        System.out.println("Permitido Perros: " + mascota);
    }

    public boolean ismascota() {
        return mascota;
    }

    public void setmascota(boolean mascota) {
        this.mascota = mascota;
    }


    public boolean isParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(boolean parqueadero) {
        this.parqueadero = parqueadero;
    }


}
