package src.alojamientos;

import src.clientes.Cliente;
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

    public abstract void mostrarInformacionAlojamiento(int numHabitaciones, int diaInicio, int diaFinalizacion);

    public abstract void mostrarInformacionHabitaciones(int cantHabitaciones);

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

    public boolean agregarReserva(Reserva nuevaReserva) {
        // Verificar si el arreglo de reservas está inicializado
        if (this.reservas == null) {
            this.reservas = new Reserva[99]; // Inicializamos con un máximo de 99 reservas
        }

        // Buscar una posición libre en el arreglo
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i] == null) {
                this.reservas[i] = nuevaReserva; // Agregar la reserva
                System.out.println("Reserva agregada con éxito.");
                return true; // Se agregó correctamente
            }
        }

        // Si no hay espacio disponible
        System.out.println("No hay espacio disponible para más reservas.");
        return false;
    }

    public boolean eliminarReserva(String email, String fechaNacimiento) {
        // Verificar si el arreglo de reservas está inicializado
        if (this.reservas == null || this.reservas.length == 0) {
            System.out.println("No hay reservas registradas.");
            return false;
        }

        // Buscar la reserva en el arreglo
        for (int i = 0; i < this.reservas.length; i++) {
            if (this.reservas[i] != null) { // Evitar NullPointerException
                Cliente cliente = this.reservas[i].getCliente();
                if (cliente.getEmail().equals(email) && cliente.getFechaNacimiento().equals(fechaNacimiento)) {
                    // Eliminar la reserva asignando null
                    this.reservas[i] = null;
                    System.out.println("Reserva eliminada con éxito.");
                    return true;
                }
            }
        }

        // Si no se encontró la reserva
        System.out.println("No se encontró ninguna reserva con los datos proporcionados.");
        return false;
    }



    public void restarHabitaciones(int cantHabitaciones,int tipoHabitacion){
        this.cantHabitaciones[tipoHabitacion]=this.cantHabitaciones[tipoHabitacion]-cantHabitaciones;
    }

    public void recuperarHabitaciones(int cantHabitaciones,int tipoHabitacion){
        this.cantHabitaciones[tipoHabitacion]=this.cantHabitaciones[tipoHabitacion]+cantHabitaciones;
    }

    public void encontrarReserva(String email, String fechaNacimiento) {
        if (reservas == null || reservas.length == 0) {
            System.out.println("No hay reservas registradas.");
            return;
        }

        for (Reserva reserva : reservas) {
            if (reserva != null) { // Evitar NullPointerException
                Cliente cliente = reserva.getCliente();
                if (cliente.getEmail().equals(email) && cliente.getFechaNacimiento().equals(fechaNacimiento)) {
                    System.out.println("Reserva encontrada:");
                    reserva.mostrarInfoReserva();
                    return;
                }
            }
        }

        System.out.println("No se encontró ninguna reserva con el email y fecha de nacimiento proporcionados.");
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
