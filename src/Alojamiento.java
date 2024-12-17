import java.time.LocalDate;

public abstract class Alojamiento {

    protected String nombreAlojamiento;
    protected String ciudadDestino;
    protected int maxAdultos;
    protected int maxNinos;
    protected boolean ofreceDiaDeSol;
    protected double calificacion;
    protected String actividades;
    protected boolean incluyeAlmuerzo;
    protected boolean incluyeRefrigerio;
    protected Habitacion[] habitaciones;

    public Alojamiento(String nombreAlojamiento, String ciudadDestino, int maxAdultos, int maxNinos, boolean ofreceDiaDeSol, double calificacion, String actividades, boolean incluyeAlmuerzo, boolean incluyeRefrigerio, Habitacion[] habitaciones) {
        this.nombreAlojamiento = nombreAlojamiento;
        this.ciudadDestino = ciudadDestino;
        this.maxAdultos = maxAdultos;
        this.maxNinos = maxNinos;
        this.ofreceDiaDeSol = ofreceDiaDeSol;
        this.calificacion = calificacion;
        this.actividades = actividades;
        this.habitaciones = habitaciones;
        this.incluyeAlmuerzo = incluyeAlmuerzo;
        this.incluyeRefrigerio = incluyeRefrigerio;

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

    public boolean isIncluyeAlmuerzo() {
        return incluyeAlmuerzo;
    }

    public void setIncluyeAlmuerzo(boolean incluyeAlmuerzo) {
        this.incluyeAlmuerzo = incluyeAlmuerzo;
    }

    public boolean isIncluyeRefrigerio() {
        return incluyeRefrigerio;
    }

    public void setIncluyeRefrigerio(boolean incluyeRefrigerio) {
        this.incluyeRefrigerio = incluyeRefrigerio;
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Habitacion[] habitaciones) {
        this.habitaciones = habitaciones;
    }

    // metodo abstracto que debe ser implementado por las clases hijas
    public abstract void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas, int adultos, int ninos, boolean incluyeAlmuerzo, boolean incluyeRefrigerio);

    public abstract void mostrarInfo(LocalDate inicioEstadia, LocalDate finEstadia);

    // metodo para calcular el precio total de la estadía
    public double calcularPrecioTotal(LocalDate inicioEstadia, LocalDate finEstadia, int habitacionesSolicitadas) {
        // Calculando los días de estadía
        long diferenciaEnDias = finEstadia.toEpochDay() - inicioEstadia.toEpochDay();

        // Verificando que la estadía tenga al menos un día
        if (diferenciaEnDias <= 0) {
            System.out.println("Debe alojarse como mínimo un día");
            return 0.0;
        }

        // Usando el precio de la primera habitación
        double precioBase = habitaciones[0].getPrecioPorNochePorTipoHabitacion();
        double totalPrecioBase = precioBase * habitacionesSolicitadas * diferenciaEnDias;  // Calculando el valor total de la estadía

        // Calculando descuentos o incrementos basados en las fechas de la estadía
        double incrementoPrecio = 0.0;
        double descuentoPrecio = 0.0;

        // Verificando si los días de estadía están dentro de los últimos 5 días del mes
        if (ultimosCincoDiasDelMes(inicioEstadia, finEstadia)) {
            incrementoPrecio = totalPrecioBase * 0.15;
            totalPrecioBase += incrementoPrecio;
        }

        // Verificando si los días de estadía están entre el 10 y el 15 del mes
        if (diasEntreElDiezYQuince(inicioEstadia, finEstadia)) {
            incrementoPrecio = totalPrecioBase * 0.10;
            totalPrecioBase += incrementoPrecio;
        }

        // Verificando si los días de estadía están entre el 5 y el 10 del mes
        if (diasEntreElCincoYDiez(inicioEstadia, finEstadia)) {
            descuentoPrecio = totalPrecioBase * 0.08;
            totalPrecioBase -= descuentoPrecio;
        }

        return totalPrecioBase;  // Retornamos el precio final con los descuentos o incrementos aplicados
    }

    // func para verificar si los ultimos 5 dias de la estadia caen dentro de un mes
    private static boolean ultimosCincoDiasDelMes(LocalDate inicioEstadia, LocalDate finEstadia) {

        // obteniendo el ultimo dia del mes para la fecha de fin estadia
        int lastDayOfMonth = finEstadia.lengthOfMonth();

        // verificando si los ultimos 5 dias del mes estan dentro del rango de fechas
        return (finEstadia.getDayOfMonth() >= lastDayOfMonth - 4 || inicioEstadia.getDayOfMonth() >= lastDayOfMonth - 4 );
    }

    // func para verificar si los dias de estadia estan entre el 10 al 15 del mes
    private static boolean diasEntreElDiezYQuince(LocalDate inicioEstadia, LocalDate finEstadia) {

        // verificando si alguna de las fechas cae entre el 10 y el 15 del mes
        return ((inicioEstadia.getDayOfMonth() <= 15 && inicioEstadia.getDayOfMonth() >= 10) ||
                (finEstadia.getDayOfMonth() <= 15 && finEstadia.getDayOfMonth() >= 10));
    }

    // func para verificar si los dias de estadia estan entre del 5 al 10 del mes
    private static boolean diasEntreElCincoYDiez(LocalDate inicioEstadia, LocalDate finEstadia) {

        // verificando si alguna de las fechas cae entre el 5 y el 10 del mes
        return ((inicioEstadia.getDayOfMonth() <= 10 && inicioEstadia.getDayOfMonth() >= 5) ||
                (finEstadia.getDayOfMonth() <= 10 && finEstadia.getDayOfMonth() >= 5));
    }

    public void mostrarInfoActividadesYAdicionales(int adultos, int ninos, boolean incluyeAlmuerzo, boolean incluyeRefrigerio) {
        // Mostrar actividades si ofrece día de sol
        if (ofreceDiaDeSol) {
            System.out.println("Actividades disponibles:");
            for (String actividad : actividades.split(",")) { // Dividimos por comas
                System.out.println("- " + actividad.trim());
            }
        }

        // Precios de almuerzo y refrigerio adicionales
        double precioAlmuerzo = 20.0;
        double precioRefrigerio = 10.0;

        int totalPersonas = adultos + ninos;
        double precioTotalAlmuerzo = precioAlmuerzo * totalPersonas;
        double precioTotalRefrigerio = precioRefrigerio * totalPersonas;

        if (incluyeAlmuerzo) {
            System.out.println("Incluye almuerzo.");
            System.out.println("Si desea incluir el almuerzo, el valor por persona es: $" + precioAlmuerzo +
                    "\nEn total por " + totalPersonas + " persona(s) es: $" + precioTotalAlmuerzo);
            System.out.println("** El valor por almuerzo NO está incluido en el precio total. Debe pagarlo en el establecimiento. **");
        }

        if (incluyeRefrigerio) {
            System.out.println("Incluye refrigerio.");
            System.out.println("Si desea incluir el refrigerio, el valor por persona es: $" + precioRefrigerio +
                    "\nEn total por " + totalPersonas + " persona(s) es: $" + precioTotalRefrigerio);
            System.out.println("** El valor por refrigerio NO está incluido en el precio total. Debe pagarlo en el establecimiento. **");
        }
    }

    // metodo para mostrar la información de las habitaciones disponibles
    public void mostrarHabitacionesDisponibles() {
        for (Habitacion habitacion : habitaciones) {
            habitacion.mostrarHabitacionesDisponibles();
        }
    }
}
