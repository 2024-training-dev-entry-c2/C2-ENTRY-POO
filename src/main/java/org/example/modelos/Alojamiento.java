package org.example.modelos;

public abstract class Alojamiento {
    private String nombre;
    private String ciudad;
    private float calificacion;
    private double precioPorNoche;

    public Alojamiento(String nombre, String ciudad, float calificacion, double precioPorNoche) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calificacion = calificacion;
        this.precioPorNoche = precioPorNoche;
    }

    // Getters y setters (encapsulamiento)
    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }
    public float getCalificacion() { return calificacion; }
    public double getPrecioPorNoche() { return precioPorNoche; }

    public abstract void mostrarDetalles(); // Método abstracto
}
