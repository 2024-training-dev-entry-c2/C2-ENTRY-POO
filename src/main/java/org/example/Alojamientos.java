package org.example;

import java.util.List;

public abstract class Alojamientos {
    private String nombre;
    private String ciudad;
    private String tipo;
    private double calificacion;

    public Alojamientos(String nombre, String ciudad, String tipo, double calificacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
    }

    public void mostrarAlojamiento() {
        System.out.println(getCiudad() + ":" + getTipo());
        System.out.println("-----------------------------------------------------------");
        System.out.println("Ciudad Seleccionada: " + getCiudad());
        System.out.println("Nombre: " + getNombre());
//        System.out.println("Precio: " + getHabitaciones().get(0).getPrecio());
        System.out.println("Calificación: " + getCalificacion() + "⭐");

    }

    public Alojamientos() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
}
