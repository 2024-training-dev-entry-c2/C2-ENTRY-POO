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

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }



    public void mostrarHabitaciones(int cantidadHabitaciones, int diaInicio, int diaFinal) {
        System.out.println("Habitaciones en " + nombre + ":");
        for (int i = 0; i < habitaciones.size(); i++) {
            System.out.println((i + 1) + ". " + habitaciones.get(i).getTipo());
            System.out.println("Description" + habitaciones.get(i).getDescripcion());
            double precio = calcularPrecio(diaInicio, diaFinal, cantidadHabitaciones, habitaciones.get(i).getPrecio());
        }
        System.out.println("Seleccionar Habitacion");
        for (int i = 0; i < habitaciones.size(); i++){
            System.out.println((i + 1) + ". " + habitaciones.get(i).getTipo());
        }
    }

    public double calcularPrecio(int diaInicio, int diaFin, int cantidadHabitaciones, double precioHabitacion) {
        int noches = diaFin - diaInicio + 1;
        double precioTotal = precioHabitacion * noches * cantidadHabitaciones;

        double aumentoDesc = obtenerAumentoDesc(diaInicio, diaFin);
        double precioFinal = precioTotal * (1 + aumentoDesc);

        System.out.println("Precio total: $" + precioTotal);
        System.out.println("Aumento/Descuento aplicado: " + (aumentoDesc * 100) + "%");
        System.out.println("Precio final: $" + precioFinal);
        return precioFinal;
    }

    private double obtenerAumentoDesc(int diaInicio, int diaFin) {
        if (diaFin >= 25) {
            return 0.15; // Aumento del 15%
        } else if (diaInicio >= 10 && diaFin <= 15) {
            return 0.10; // Aumento del 10%
        } else if (diaInicio >= 5 && diaFin <= 10) {
            return -0.08; // Descuento del 8%
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return nombre + " - " + ciudad + " - " + tipo + " - " + calificacion + "⭐";
    }


}
