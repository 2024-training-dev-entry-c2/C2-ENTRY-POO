package src.alojamientos;

import src.habitaciones.Habitacion;
import src.reservas.Reserva;

public class Finca extends Alojamiento {


    public Finca(String nombre, String ciudad, double calificacion, String tipo) {
        this.nombre = nombre;
        this.ciudad =ciudad;
        this.calificacion=calificacion;
        this.tipo="finca";
        this.habitaciones = new Habitacion[5];
        this.reservas = new Reserva[99];
    }

    @Override
    public double calcularPrecioBase(int numHabitaciones) {
        this.precio = this.obtenerPrecioHabitacionMasBarata()*numHabitaciones;
        return 0;
    }


    @Override
    public double calcularDescuentoOAumento(int mesInicio, int diaInicio, int mesFinalizacion, int diaFinalizacion) {
        double descuentoOAumento = 0.0;

        // Verificar si se ha calculado el precio base
        if (this.precio == 0.0) {
            System.out.println("Primero debe calcular el precio base.");
            return 0.0;
        }

        // Aplicar lógica de descuento/aumento
        if (diaInicio >= 26 && diaFinalizacion <= 31) {
            descuentoOAumento = this.precio * 0.15; // Aumento del 15%
            this.precioTotal = this.precio + descuentoOAumento;
        } else if (diaInicio >= 10 && diaFinalizacion <= 15) {
            descuentoOAumento = this.precio * 0.10; // Aumento del 10%
            this.precioTotal = this.precio + descuentoOAumento;
        } else if (diaInicio >= 5 && diaFinalizacion <= 10) {
            descuentoOAumento = this.precio * 0.08; // Descuento del 8%
            this.precioTotal = this.precio - descuentoOAumento;
        } else {
            // Sin descuento ni aumento
            this.precioTotal = this.precio;
        }

        return this.precioTotal;
    }

    @Override
    public void mostrarInformacionAlojamiento() {
        System.out.println("Alojamiento: " + this.nombre);
        System.out.println("Calificación: " + this.calificacion);
        System.out.println("Tipo: " + this.tipo);
        //System.out.println("Precio por noche: " + preciosTotales[0]);
        //System.out.println("Precio total (días): " + preciosTotales[1]);
        System.out.println("-------------------");
    }

    @Override
    public void mostrarInformacionHabitaciones() {
        for(int i=0; i<this.habitaciones.length; i++){
            habitaciones[i].mostrarInfoHabatiacion();
        }
    }
}
