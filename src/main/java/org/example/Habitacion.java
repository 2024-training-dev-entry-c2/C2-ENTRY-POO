package org.example;

public class Habitacion implements IReservable {


    private String tipo;
    private String descripcion;
    private double precio;
    private int disponibles;
    private int capacidad;

    public void setDisponibles(int disponibles) {
        this.disponibles = disponibles;
    }

    public Habitacion(String tipo, String descripcion, double precio, int disponibles, int capacidad) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponibles = disponibles;
        this.capacidad = capacidad;
    }

    @Override
    public boolean reservar() {
        if (disponibles > 0) {
            disponibles--;
            return true;
        }
        return false;
    }

    public void cancelar() {
        disponibles++;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDisponibles() {
        return disponibles;
    }

    public int getCapacidad() {
        return capacidad;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
