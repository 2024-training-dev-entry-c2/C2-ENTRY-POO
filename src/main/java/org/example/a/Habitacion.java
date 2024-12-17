package org.example.a;

public class Habitacion {
    private int idHabitacion;
    private String titulo;
    private String descripcion;
    private String beneficiosHabitacion;
    private int precio;

    // Constructor
    public Habitacion(int idHabitacion, String titulo, String descripcion, String beneficiosHabitacion, int precio) {
        this.idHabitacion = idHabitacion;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.beneficiosHabitacion = beneficiosHabitacion;
        this.precio = precio;
    }

    //Getters y Setters
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getBeneficiosHabitacion() {
        return beneficiosHabitacion;
    }

    public void setBeneficiosHabitacion(String beneficiosHabitacion) {
        this.beneficiosHabitacion = beneficiosHabitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }
}
