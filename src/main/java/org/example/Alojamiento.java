package org.example;

import java.util.List;

abstract class Alojamiento {
    private String nombre;
    private String ciudad;
    private String tipo;
    private double calificacion;
    private List<Habitacion> habitaciones;


    public Alojamiento(String nombre, String ciudad, String tipo, double calificacion, List<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.habitaciones = habitaciones;
    }


    public String getCiudad() {
        return ciudad;
    }
    
    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void mostrarHabitaciones() {
        System.out.println("Habitaciones en " + nombre + ":");
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". " + habitaciones.get(i));
        }
    }

    @Override
    public String toString() {
        return nombre + " - " + ciudad + " - " + tipo + " - " + calificacion + "⭐";
    }


}
