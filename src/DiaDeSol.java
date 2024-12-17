package src;

public class DiaDeSol extends Alojamiento{


    public DiaDeSol(String nombre, String ciudad, double calificacion, String tipo) {
        this.nombre = nombre;
        this.ciudad =ciudad;
        this.calificacion=calificacion;
        this.tipo="dia de sol";
    }

    @Override
    public double calcularPrecioBase() {
        return 0;
    }

    @Override
    public double calcularDescuentoOAumento() {
        return 0;
    }

    @Override
    public String mostrarInformacionAlojamiento() {
        return "";
    }
}
