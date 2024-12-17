package src.alojamientos;

import src.habitaciones.Habitacion;
import src.reservas.Reserva;

public class DiaDeSol extends Alojamiento {

    private String actividades;
    private String extras;

    public DiaDeSol(String nombre, String ciudad, double calificacion, String tipo,String actividades,String extras) {
        this.nombre = nombre;
        this.ciudad =ciudad;
        this.calificacion=calificacion;
        this.tipo="dia de sol";
        this.habitaciones = new Habitacion[5];
        this.reservas = new Reserva[99];
        this.actividades=actividades;
        this.extras=extras;
    }

    public DiaDeSol() {
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
    public void mostrarInformacionAlojamiento() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo);
        //System.out.println("Actividades: " + this.habitaciones.caract);
        //System.out.println("Incluye: " + habitaciones[j][3]);
        //System.out.println("Precio: " + preciosTotales[0]);
        //System.out.println("Precio Aumento o descuento: " + preciosTotales[1]);
        //System.out.println("-------------------");
    }

    @Override
    public void mostrarInformacionHabitaciones() {

    }
}
