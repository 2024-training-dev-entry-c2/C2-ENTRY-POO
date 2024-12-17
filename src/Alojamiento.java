import java.util.ArrayList;

public class Alojamiento {
    public String nombre;
    public String Ciudad;
    public String tipo;
    public double calificacion;
    public float precioDiaSol;
    public String descripcionDiaSol;
    public ArrayList<Habitacion> habitaciones;

    public Alojamiento(String nombre, String Ciudad, String tipo, double calificacion, float precioDiaSol, String descripcionDiaSol, ArrayList<Habitacion> habitaciones) {
        this.nombre = nombre;
        this.Ciudad = Ciudad;
        this.tipo = tipo;
        this.calificacion = calificacion;
        this.precioDiaSol = precioDiaSol;
        this.descripcionDiaSol = descripcionDiaSol;
        this.habitaciones = habitaciones;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

}
