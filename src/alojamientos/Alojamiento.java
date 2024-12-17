package src.alojamientos;

import src.habitaciones.Habitacion;
import src.reservas.Reserva;

public abstract class Alojamiento {

    protected String nombre;
    protected String ciudad;
    protected double calificacion;
    protected String tipo;
    protected Habitacion[] habitaciones;
    protected Reserva[] reservas;

    //metodos abstractos
    public abstract double calcularPrecioBase();

    public abstract double calcularDescuentoOAumento();

    public abstract void mostrarInformacionAlojamiento();

    public abstract void mostrarInformacionHabitaciones();

    //metodos concretos
    //
    // get y set
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

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }



}
