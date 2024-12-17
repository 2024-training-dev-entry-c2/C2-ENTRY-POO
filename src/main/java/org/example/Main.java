package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creamos la instancia del sistema de reservas
        BookingSystem bookingSystem = new BookingSystem();

        // Iniciamos el sistema de reservas
        bookingSystem.iniciarReserva(scanner);

        scanner.close();
    }
}