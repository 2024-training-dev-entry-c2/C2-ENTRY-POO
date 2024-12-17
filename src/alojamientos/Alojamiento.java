package src.alojamientos;

import src.habitaciones.Habitacion;
import src.reservas.Reserva;

public abstract class Alojamiento {

    protected String nombre;
    protected String ciudad;
    protected double calificacion;
    protected String tipo;
    protected Habitacion[] habitaciones;
    protected Reserva[] reservas;
    protected double precio;
    protected double precioTotal;
    protected int[] cantHabitaciones;

    //metodos abstractos
    public abstract double calcularPrecioBase(int numHabitaciones);

    public abstract double calcularDescuentoOAumento(int diaInicio, int diaFinalizacion);

    public abstract void mostrarInformacionAlojamiento(int numHabitacione, int diaInicio, int diaFinalizacion);

    public abstract void mostrarInformacionHabitaciones();

    //metodos concretos
    public double obtenerPrecioHabitacionMasBarata() {
        // Verificar si el arreglo está vacío o nulo
        if (habitaciones == null || habitaciones.length == 0) {
            System.out.println("No hay habitaciones disponibles.");
            return -1; // Retornar -1 como valor indicativo de que no hay habitaciones
        }

        double precioMinimo = Double.MAX_VALUE; // Iniciar con el valor máximo posible

        // Recorrer el arreglo de habitaciones
        for (Habitacion habitacion : habitaciones) {
            if (habitacion != null && habitacion.getPrecio() < precioMinimo) {
                precioMinimo = habitacion.getPrecio();
            }
        }

        return precioMinimo;
    }


    // get y set
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    public Reserva[] getReservas() {
        return reservas;
    }

    public void setReservas(Reserva[] reservas) {
        this.reservas = reservas;
    }

    public int[] getCantHabitaciones() {
        return cantHabitaciones;
    }

    public void setCantHabitaciones(int[] cantHabitaciones) {
        this.cantHabitaciones = cantHabitaciones;
    }
}
