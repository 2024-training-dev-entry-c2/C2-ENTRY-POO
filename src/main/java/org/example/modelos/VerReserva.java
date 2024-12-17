package org.example.modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VerReserva {
    private List<Reserva> reservas; // Composición: Lista de objetos Reserva

    public VerReserva() {
        this.reservas = new ArrayList<>();
    }

    // Método para agregar una reserva
    public void agregarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    // Método para ver las reservas registradas
    public void verReservas() {
        if (reservas.isEmpty()) {
            System.out.println("\nNo hay reservas registradas.");
            return;
        }

        System.out.println("\nReservas Registradas:");
        int index = 1;
        for (Reserva reserva : reservas) {
            if (reserva.esConsistente()) {
                System.out.printf("Reserva #%d:\n", index++);
                reserva.mostrarDetalles();
            } else {
                System.out.printf("Reserva #%d tiene datos inconsistentes y no será mostrada.\n", index++);
            }
        }
    }

    public Reserva buscarReservaPorEmail(String email) {
        for (Reserva reserva : reservas) {
            if (reserva != null && reserva.getEmailCliente().equalsIgnoreCase(email)) {
                return reserva;
            }
        }
        return null;
    }

}
