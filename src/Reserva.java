import java.time.LocalDate;

public class Reserva implements IReserva{
    private String nombreUsuario;
    private String apellidoUsuario;
    private String correoUsuario;
    private String nacionalidadUsuario;
    private int telefonoUsuario;
    private String horaLlegadaUsuario;
    private String nacimientoUsuario;
    private String[] habitacionesSeleccionadas;
    private LocalDate inicioEstadia;
    private LocalDate finEstadia;

    public Reserva(String nombreUsuario, String apellidoUsuario, String correoUsuario, String nacionalidadUsuario,
                   int telefonoUsuario, String horaLlegadaUsuario, String[] habitacionesSeleccionadas, String nacimientoUsuario, LocalDate inicioEstadia, LocalDate finEstadia) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.nacionalidadUsuario = nacionalidadUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.horaLlegadaUsuario = horaLlegadaUsuario;
        this.habitacionesSeleccionadas = habitacionesSeleccionadas;
        this.nacimientoUsuario = nacimientoUsuario;
        this.inicioEstadia = inicioEstadia;
        this.finEstadia = finEstadia;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public String[] getHabitacionesSeleccionadas() {
        return habitacionesSeleccionadas;
    }

    public String getNacimientoUsuario() {
        return nacimientoUsuario;
    }

    public LocalDate getFinEstadia() {
        return finEstadia;
    }

    public LocalDate getInicioEstadia() {
        return inicioEstadia;
    }

    @Override
    public String mostrarReserva() {
        StringBuilder infoReserva = new StringBuilder();
        infoReserva.append("Reserva a nombre de: ").append(nombreUsuario).append(" ").append(apellidoUsuario).append("\n");
        infoReserva.append("Correo: ").append(correoUsuario).append("\n");
        infoReserva.append("Nacionalidad: ").append(nacionalidadUsuario).append("\n");
        infoReserva.append("Teléfono: ").append(telefonoUsuario).append("\n");
        infoReserva.append("Hora de llegada: ").append(horaLlegadaUsuario).append("\n");
        infoReserva.append("Fecha de nacimiento: ").append(nacimientoUsuario).append("\n");
        infoReserva.append("Habitaciones seleccionadas: \n");
        for (String habitacionSeleccionada : habitacionesSeleccionadas) {
            infoReserva.append(habitacionSeleccionada).append("\n");
        }
        return infoReserva.toString();
    }

}
