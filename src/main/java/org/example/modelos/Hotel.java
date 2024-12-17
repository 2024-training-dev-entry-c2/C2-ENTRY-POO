package org.example.modelos;

import java.util.List;

public class Hotel extends Alojamiento {
    private boolean diaDeSol;
    private String actividades;
    private boolean incluyeAlmuerzo;
    private boolean incluyeRefrigerio;
    private List<Habitacion> habitaciones;

    public Hotel(String nombre, String ciudad, float calificacion, double precioPorNoche, boolean diaDeSol,
                 String actividades, boolean incluyeAlmuerzo, boolean incluyeRefrigerio, List<Habitacion> habitaciones) {
        super(nombre, ciudad, calificacion, precioPorNoche);
        this.diaDeSol = diaDeSol;
        this.actividades = actividades;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.incluyeRefrigerio = incluyeRefrigerio;
        this.habitaciones = habitaciones;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("Hotel: %s, Ciudad: %s, Calificación: %.1f, Precio por noche: %.2f\n", getNombre(), getCiudad(), getCalificacion(), getPrecioPorNoche());
        System.out.printf("Día de Sol: %b, Actividades: %s, Almuerzo incluido: %b, Refrigerio incluido: %b\n", diaDeSol, actividades, incluyeAlmuerzo, incluyeRefrigerio);
        System.out.println("Habitaciones Disponibles:");
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarDetalles();
        }
    }

    public boolean cumpleCriterios(String ciudad, boolean filtrarDiaDeSol, int cantidadHabitaciones) {
        return getCiudad().equalsIgnoreCase(ciudad) && (!filtrarDiaDeSol || diaDeSol) && hayHabitacionesDisponibles(cantidadHabitaciones);
    }

    private boolean hayHabitacionesDisponibles(int cantidad) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.tieneDisponibilidad(cantidad)) {
                return true;
            }
        }
        return false;
    }

    public double getPrecioHabitacionMasBarata() {
        double minimo = Double.MAX_VALUE;
        for (Habitacion habitacion : habitaciones) {
            minimo = Math.min(minimo, habitacion.getPrecio());
        }
        return minimo;
    }

    public void confirmarDisponibilidad(int cantidadHabitaciones) {
        System.out.println("\nHabitaciones disponibles:");
        boolean disponible = false;

        // Recorre todas las habitaciones para verificar disponibilidad
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.tieneDisponibilidad(cantidadHabitaciones)) {
                disponible = true;
                habitacion.mostrarDetalles(); // Muestra detalles de la habitación disponible
            }
        }

        // Si no hay habitaciones disponibles
        if (!disponible) {
            System.out.println("No hay habitaciones disponibles que cumplan con la cantidad solicitada.");
        }
    }

}
