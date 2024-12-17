package org.example;

public class Reserva {
    private String nombreCliente;
    private String emailCliente;
    private String nacionalidad;
    private int telefono;
    private Alojamiento alojamiento;
    private Habitacion habitacion;
    private String fechaNacimiento;

    public Reserva(String nombreCliente, String emailCliente,String fechaN, Alojamiento alojamiento, Habitacion habitacion) {
        this.nombreCliente = nombreCliente;
        this.emailCliente = emailCliente;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
        this.fechaNacimiento=fechaN;
    }
    public void mostrarReserva(int horaLlegada, int cantidadHabitaciones, int index) {
        System.out.println("-----------------------------------------------------");
        System.out.println("¡Reserva realizada con éxito!");
        System.out.println("Datos de la reserva:");
        System.out.println("Nombre: " + nombreCliente + " " );
        System.out.println("Email: " + emailCliente);
        System.out.println("Nacionalidad: " + nacionalidad);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Hora de llegada: " + horaLlegada + ":00");
        System.out.println("Hotel: " + alojamiento.getNombre());
        System.out.println("Habitación: " + alojamiento.getHabitaciones().get(index).getTipo());
        System.out.println("Cantidad de habitaciones reservadas: " + cantidadHabitaciones);
        System.out.println("-----------------------------------------------------");
    }
    public boolean confirmar(int horaLlegada, int cantidadHabitaciones, int index) {
        mostrarReserva(horaLlegada,cantidadHabitaciones,index);
        return habitacion.reservar() ;
    }
    @Override
    public String toString() {
        return "Cliente: " + nombreCliente + ", Email: " + emailCliente + ", Alojamiento: " + alojamiento + ", Habitación: " + habitacion;
    }





}
