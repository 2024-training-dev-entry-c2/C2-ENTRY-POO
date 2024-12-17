package org.example.modelos;

public class Habitacion {
    private String tipo;
    private String descripcion;
    private double precio;
    private int disponibles;

    public Habitacion(String tipo, String descripcion, double precio, int disponibles) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibles = disponibles;
    }

    public boolean tieneDisponibilidad(int cantidad) {
        return this.disponibles >= cantidad;
    }

    public void reducirDisponibilidad(int cantidad) {
        this.disponibles -= cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void mostrarDetalles() {
        System.out.printf("Tipo: %s, Descripción: %s, Precio: %.2f, Disponibles: %d\n", tipo, descripcion, precio, disponibles);
    }

    public double getPrecio() {
        return precio;
    }

    public int getDisponibles() { // Nuevo método
        return disponibles;
    }
}
