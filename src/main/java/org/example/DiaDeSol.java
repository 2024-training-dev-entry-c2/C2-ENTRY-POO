package org.example;

import java.util.List;

public class DiaDeSol extends Alojamiento
{
    boolean almuerzo;

    public DiaDeSol(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }

    @Override
    void escribirCondicion() {
        System.out.println("Almuerzo disponible:" + almuerzo);
    }

    public DiaDeSol(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones, boolean almuerzo) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
        this.almuerzo=almuerzo;
    }
    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

}
