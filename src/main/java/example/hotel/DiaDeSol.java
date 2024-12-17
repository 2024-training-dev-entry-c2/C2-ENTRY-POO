package example.hotel;

import java.util.ArrayList;

public class DiaDeSol extends Alojamiento {
    private ArrayList<String> actividades;

    public DiaDeSol(String nombre, String ciudad, int calificacion, ArrayList<String> fechasDisponibles, ArrayList<String> actividades) {
        super(nombre, ciudad, calificacion, fechasDisponibles);
        this.actividades = actividades;
    }

    public ArrayList<String> getActividades() {
        return actividades;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Día de Sol: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Actividades:");
        for (String actividad : actividades) {
            System.out.println("- " + actividad);
        }
    }

    @Override
    public ArrayList<Habitacion> getHabitaciones() {
        return null; 
    }
}