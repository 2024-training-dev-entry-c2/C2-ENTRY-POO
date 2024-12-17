package org.example.a;

abstract public class Reserva {
    protected Cliente cliente;
    protected double precioTotal;
    protected String horaLlegada;

    public Reserva(Cliente cliente, double precioTotal, String horaLlegada) {
        this.cliente = cliente;
        this.precioTotal = precioTotal;
        this.horaLlegada = horaLlegada;
    }

    public Reserva() {

    }

    // Métodos abstractos para implementar en clases derivadas
    public abstract void mostrarDetallesReserva();

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
