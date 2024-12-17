package example.hotel;

import java.util.ArrayList;

public abstract class Alojamiento {
    private String nombre;
    private String ciudad;
    private int calificacion;
    private ArrayList<String> fechasDisponibles;

    public Alojamiento(String nombre, String ciudad, int calificacion, ArrayList<String> fechasDisponibles) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.calificacion = calificacion;
        this.fechasDisponibles = fechasDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public ArrayList<String> getFechasDisponibles() {
        return fechasDisponibles;
    }

    public abstract void mostrarDetalles();

    public abstract ArrayList<Habitacion> getHabitaciones();
}