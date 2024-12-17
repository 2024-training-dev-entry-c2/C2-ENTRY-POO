package org.example.a;

public class RelacionHotelHabitacion {
    private int idHabitacion;
    private int idAlojamiento;
    private int maximaCantidadDePersonas;

    //Contructor
    public RelacionHotelHabitacion(int idHabitacion, int idAlojamiento, int maximaCantidadDePersonas) {
        this.idHabitacion = idHabitacion;
        this.maximaCantidadDePersonas = maximaCantidadDePersonas;
        this.idAlojamiento = idAlojamiento;
    }

    //Getters y Setters
    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public int getIdAlojamiento() {
        return idAlojamiento;
    }

    public void setIdAlojamiento(int idAlojamiento) {
        this.idAlojamiento = idAlojamiento;
    }

    public int getMaximaCantidadDePersonas() {
        return maximaCantidadDePersonas;
    }

    public void setMaximaCantidadDePersonas(int maximaCantidadDePersonas) {
        this.maximaCantidadDePersonas = maximaCantidadDePersonas;
    }
}
