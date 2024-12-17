package src.alojamientos;

public class Apartamento extends Alojamiento {


    public Apartamento(String nombre, String ciudad, double calificacion, String tipo) {
        this.nombre = nombre;
        this.ciudad =ciudad;
        this.calificacion=calificacion;
        this.tipo="apartamento";
    }

    @Override
    public double calcularPrecioBase() {
        return 0;
    }

    @Override
    public double calcularDescuentoOAumento() {
        return 0;
    }

    @Override
    public String mostrarInformacionAlojamiento() {
        return "";
    }

    @Override
    public String mostrarInformacionHabitaciones() {
        return "";
    }
}
