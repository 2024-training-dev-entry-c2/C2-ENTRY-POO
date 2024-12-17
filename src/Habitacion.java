public class Habitacion {

    protected String tiposDeHabitaciones;
    protected String caracteristicasHabitaciones;
    protected double precioPorNochePorTipoHabitacion;
    protected int habitacionesDisponibles;

    public Habitacion(String tiposDeHabitaciones, String caracteristicasHabitaciones, double precioPorNochePorTipoHabitacion, int habitacionesDisponibles) {
        this.tiposDeHabitaciones = tiposDeHabitaciones;
        this.caracteristicasHabitaciones = caracteristicasHabitaciones;
        this.precioPorNochePorTipoHabitacion = precioPorNochePorTipoHabitacion;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    public String getTiposDeHabitaciones() {
        return tiposDeHabitaciones;
    }

    public void setTiposDeHabitaciones(String tiposDeHabitaciones) {
        this.tiposDeHabitaciones = tiposDeHabitaciones;
    }

    public String getCaracteristicasHabitaciones() {
        return caracteristicasHabitaciones;
    }

    public void setCaracteristicasHabitaciones(String caracteristicasHabitaciones) {
        this.caracteristicasHabitaciones = caracteristicasHabitaciones;
    }

    public double getPrecioPorNochePorTipoHabitacion() {
        return precioPorNochePorTipoHabitacion;
    }

    public void setPrecioPorNochePorTipoHabitacion(double precioPorNochePorTipoHabitacion) {
        this.precioPorNochePorTipoHabitacion = precioPorNochePorTipoHabitacion;
    }

    public int getHabitacionesDisponibles() {
        return habitacionesDisponibles;
    }

    public void setHabitacionesDisponibles(int habitacionesDisponibles) {
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    // metodo para mostrar la información de la habitación
    public void mostrarHabitacionesDisponibles() {
        System.out.println("Tipo de habitacion: " + tiposDeHabitaciones + "\nCaracterísticas: " + caracteristicasHabitaciones +
                "\nPrecio por noche: " + precioPorNochePorTipoHabitacion + "\nNumero de habitaciones disponibles: " + habitacionesDisponibles);
    }
}
