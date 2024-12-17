package example.hotel;

import java.util.ArrayList;

public class CalculadorPrecios {
    public double calcularPrecioBase(Alojamiento alojamiento) {
        ArrayList<Habitacion> habitaciones = alojamiento.getHabitaciones();

        if (habitaciones == null || habitaciones.isEmpty()) {
            return 0;
        }

        // Encontrar la habitación con el precio más bajo
        double precioBase = habitaciones.get(0).getPrecio();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getPrecio() < precioBase) {
                precioBase = habitacion.getPrecio();
            }
        }

        return precioBase;
    }

    public double calcularAumentoODescuento(Alojamiento alojamiento, String fechaInicio, String fechaFin) {
        int diaInicio = Integer.parseInt(fechaInicio.substring(0, 2));
        int diaFin = Integer.parseInt(fechaFin.substring(0, 2));

        double precioBase = calcularPrecioBase(alojamiento);

        double precioTotal = precioBase * (diaFin - diaInicio + 1);

        double aumentoODescuento = 0.0;
        if (diaInicio >= 25) {

            aumentoODescuento = precioTotal * 0.15;
        } else if (diaInicio >= 10 && diaFin <= 15) {

            aumentoODescuento = precioTotal * 0.10;
        } else if (diaInicio >= 5 && diaFin <= 10) {

            aumentoODescuento = -precioTotal * 0.08;
        }

        return aumentoODescuento;
    }
}


