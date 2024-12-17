package example.hotel;

class Reserva implements Reservable {
    private int id;
    private Alojamiento alojamiento;
    private Habitacion habitacion;
    private String usuario;
    private String email;
    private String fechaNacimiento;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(int id, Alojamiento alojamiento, Habitacion habitacion, String usuario, String email, String fechaNacimiento, String fechaInicio, String fechaFin) {
        this.id = id;
        this.alojamiento = alojamiento;
        this.habitacion = habitacion;
        this.usuario = usuario;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEmail() {
        return email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    @Override
    public void reservar(String fechaInicio, String fechaFin, int cantidadHabitaciones) {
        System.out.println("Reserva realizada para " + getAlojamiento().getNombre() + " del " + fechaInicio + " al " + fechaFin);
    }

    @Override
    public void cancelarReserva() {
        System.out.println("Reserva cancelada para " + getAlojamiento().getNombre() + " del " + fechaInicio + " al " + fechaFin);
    }

    @Override
    public void actualizarReserva(String nuevaFechaInicio, String nuevaFechaFin, int nuevaCantidadHabitaciones) {
        this.fechaInicio = nuevaFechaInicio;
        this.fechaFin = nuevaFechaFin;
        System.out.println("Reserva actualizada para " + getAlojamiento().getNombre() + " del " + nuevaFechaInicio + " al " + nuevaFechaFin);
    }
}

