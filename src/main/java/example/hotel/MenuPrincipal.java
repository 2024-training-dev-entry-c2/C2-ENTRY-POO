package example.hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner;
    private ArrayList<Alojamiento> alojamientos;
    private ArrayList<Reserva> reservas;
    private GestorReservas gestorReservas;
    private GestorVisualizacion gestorVisualizacion;

    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
        this.alojamientos = InicializadorDatos.inicializarAlojamientos();
        this.reservas = new ArrayList<>();
        this.gestorReservas = new GestorReservas();
        this.gestorVisualizacion = new GestorVisualizacion();
    }

    public void mostrarMenu() {
        while (true) {
            gestorVisualizacion.mostrarMenuPrincipal();
            int opcion = obtenerOpcionUsuario();

            switch (opcion) {
                case 1:
                    gestorReservas.realizarReserva(alojamientos, reservas, scanner);
                    break;
                case 2:
                    gestorReservas.actualizarReserva(alojamientos, reservas, scanner);
                    break;
                case 3:
                    gestorReservas.cancelarReserva(reservas, scanner);
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
    }

    private int obtenerOpcionUsuario() {
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir nueva línea
        return opcion;

    }
}