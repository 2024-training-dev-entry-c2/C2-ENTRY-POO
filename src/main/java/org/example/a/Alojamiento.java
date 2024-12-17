package org.example.a;

public class Alojamiento {
    private int idAlojamiento;
    private String nombre;
    private Ciudad ciudad;
    private TipoAlojamiento tipoDeAlojamiento;
    private double cantidadDeEstrellas;
    private int precio;

    // Constructor
    public Alojamiento(int idAlojamiento, String nombre, Ciudad ciudad, TipoAlojamiento tipoDeAlojamiento, double cantidadDeEstrellas, int precio) {
        this.idAlojamiento = idAlojamiento;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoDeAlojamiento = tipoDeAlojamiento;
        this.cantidadDeEstrellas = cantidadDeEstrellas;
        this.precio = precio;
    }

    //Getters y Setters
    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreHotel) {
        this.nombre = nombreHotel;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setIdCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public TipoAlojamiento getIdTipoDeAlojamiento() {
        return tipoDeAlojamiento;
    }

    public void setIdTipoDeAlojamiento(TipoAlojamiento tipoDeAlojamiento) {
        this.tipoDeAlojamiento = tipoDeAlojamiento;
    }

    public double getCantidadDeEstrellas() {
        return cantidadDeEstrellas;
    }

    public void setCantidadDeEstrellas(double cantidadDeEstrellas) {
        this.cantidadDeEstrellas = cantidadDeEstrellas;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Alojamiento{" +
                "idAlojamiento=" + idAlojamiento +
                ", nombre='" + nombre + '\'' +
                ", ciudad=" + ciudad +
                ", tipoDeAlojamiento=" + tipoDeAlojamiento +
                ", cantidadDeEstrellas=" + cantidadDeEstrellas +
                ", precio=" + precio +
                '}';
    }
}
