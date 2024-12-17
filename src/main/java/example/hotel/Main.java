package example.hotel;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        InicializadorDatos catalogo = new InicializadorDatos();
        ArrayList<Alojamiento> alojamientos = catalogo.inicializarAlojamientos();
        ArrayList<Reserva> reservas = new ArrayList<>();

        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();

    }
}
