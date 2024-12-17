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
        // Obtener el día de inicio y fin del hospedaje
        int diaInicio = Integer.parseInt(fechaInicio.substring(0, 2));
        int diaFin = Integer.parseInt(fechaFin.substring(0, 2));

        // Calcular el precio base del alojamiento
        double precioBase = calcularPrecioBase(alojamiento);

        // Calcular el precio total de la estadía
        double precioTotal = precioBase * (diaFin - diaInicio + 1);

        // Aplicar aumentos o descuentos según las fechas
        double aumentoODescuento = 0.0;
        if (diaInicio >= 25) {
            // Si los días de estadías comprenden los 5 últimos días de un mes,
            // al precio total de la estadía se le debe aumentar el 15%.
            aumentoODescuento = precioTotal * 0.15;
        } else if (diaInicio >= 10 && diaFin <= 15) {
            // Si los días de estadía comprenden los días del 10 al 15 del mes,
            // al precio total de la estadía se le debe aumentar el 10%.
            aumentoODescuento = precioTotal * 0.10;
        } else if (diaInicio >= 5 && diaFin <= 10) {
            // Si los días de estadía comprende del 5 al 10 del mes,
            // se realiza un descuento de 8%.
            aumentoODescuento = -precioTotal * 0.08;
        }

        return aumentoODescuento;
    }
}


