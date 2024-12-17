package org.example.a;

class ReservacionCliente extends Reserva {
    private Habitacion habitacionCompradaDatos;

    public ReservacionCliente() {
        super();
    }

    public ReservacionCliente(Cliente cliente, double precioTotal, String horaLlegada, Habitacion habitacionCompradaDatos) {
        super(cliente, precioTotal, horaLlegada);
        this.habitacionCompradaDatos = habitacionCompradaDatos;
    }

    public Habitacion getHabitacionCompradaDatos() {
        return habitacionCompradaDatos;
    }

    public void setHabitacionCompradaDatos(Habitacion habitacionCompradaDatos) {
        this.habitacionCompradaDatos = habitacionCompradaDatos;
    }

    @Override
    public void mostrarDetallesReserva() {
        System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
        System.out.println("Reserva de habitación: " + habitacionCompradaDatos.toString());
        System.out.println("Precio total: " + precioTotal + ", Hora de llegada: " + horaLlegada);
    }
}
