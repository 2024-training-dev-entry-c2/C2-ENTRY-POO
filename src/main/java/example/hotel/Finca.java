package example.hotel;

import java.util.ArrayList;

public class Finca extends Alojamiento {
    private ArrayList<Habitacion> habitaciones;

    public Finca(String nombre, String ciudad, int calificacion, ArrayList<String> fechasDisponibles, ArrayList<Habitacion> habitaciones) {
        super(nombre, ciudad, calificacion, fechasDisponibles);
        this.habitaciones = habitaciones;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Finca: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarDetalles();
        }
    }

    @Override
    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}