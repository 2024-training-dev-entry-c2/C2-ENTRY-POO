public class Alojamiento {

    protected String nombreAlojamiento;
    protected String ciudadDestino;
    protected int maxAdultos;
    protected int maxNinos;
    protected boolean ofreceDiaDeSol;
    protected double calificacion;
    protected String actividades;
    protected boolean incluyeAlmuerzo;
    protected boolean incluyeRefiigerio;
    protected Habitacion[] habitaciones;


    public Alojamiento(String nombreAlojamiento, String ciudadDestino, int maxAdultos, int maxNinos, boolean ofreceDiaDeSol, double calificacion, String actividades, Habitacion[] habitaciones) {
        this.nombreAlojamiento = nombreAlojamiento;
        this.ciudadDestino = ciudadDestino;
        this.maxAdultos = maxAdultos;
        this.maxNinos = maxNinos;
        this.ofreceDiaDeSol = ofreceDiaDeSol;
        this.calificacion = calificacion;
        this.actividades = actividades;
        this.habitaciones = habitaciones;
    }

    public String getNombreAlojamiento() {
        return nombreAlojamiento;
    }

    public void setNombreAlojamiento(String nombreAlojamiento) {
        this.nombreAlojamiento = nombreAlojamiento;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public int getMaxAdultos() {
        return maxAdultos;
    }

    public void setMaxAdultos(int maxAdultos) {
        this.maxAdultos = maxAdultos;
    }

    public int getMaxNinos() {
        return maxNinos;
    }

    public void setMaxNinos(int maxNinos) {
        this.maxNinos = maxNinos;
    }

    public boolean isOfreceDiaDeSol() {
        return ofreceDiaDeSol;
    }

    public void setOfreceDiaDeSol(boolean ofreceDiaDeSol) {
        this.ofreceDiaDeSol = ofreceDiaDeSol;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    // metodo para mostrar la información de las habitaciones disponibles
    public void mostrarHabitacionesDisponibles() {
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarInfo();
        }
    }
}
