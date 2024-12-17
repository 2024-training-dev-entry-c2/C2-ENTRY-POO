package org.example.modelos;

public class Hotel extends Alojamiento {
    private boolean diaDeSol;
    private String actividades;
    private boolean incluyeAlmuerzo;
    private boolean incluyeRefrigerio;

    public Hotel(String nombre, String ciudad, float calificacion, double precioPorNoche,
                 boolean diaDeSol, String actividades, boolean incluyeAlmuerzo, boolean incluyeRefrigerio) {
        super(nombre, ciudad, calificacion, precioPorNoche);
        this.diaDeSol = diaDeSol;
        this.actividades = actividades;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.incluyeRefrigerio = incluyeRefrigerio;
    }

    @Override
    public void mostrarDetalles() {
        System.out.printf("Hotel: %s, Ciudad: %s, Calificación: %.1f, Precio: %.2f%n",
                getNombre(), getCiudad(), getCalificacion(), getPrecioPorNoche());
        System.out.printf("Día de sol: %b, Actividades: %s, Almuerzo: %b, Refrigerio: %b%n",
                diaDeSol, actividades, incluyeAlmuerzo, incluyeRefrigerio);
    }
}
