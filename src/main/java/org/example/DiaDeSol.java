package org.example;

import java.util.List;

public class DiaDeSol extends Alojamiento
{
    public boolean isAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(boolean almuerzo) {
        this.almuerzo = almuerzo;
    }

    boolean almuerzo;
    public DiaDeSol(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
    }
    public DiaDeSol(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones, boolean almuerzo) {
        super(nombre, ciudad, tipo, calificacion, habitaciones);
        this.almuerzo=almuerzo;
    }
}
