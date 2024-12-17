package example.hotel;

import java.util.ArrayList;

class Hotel extends Alojamiento {
    private ArrayList<Habitacion> habitaciones;

    public Hotel(String nombre, String ciudad, int calificacion, ArrayList<String> fechasDisponibles, ArrayList<Habitacion> habitaciones) {
        super(nombre, ciudad, calificacion, fechasDisponibles);
        this.habitaciones = habitaciones;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Hotel: " + getNombre());
        System.out.println("Ciudad: " + getCiudad());
        System.out.println("Calificación: " + getCalificacion());
        System.out.println("Habitaciones:");
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarDetalles();
        }
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }
}














