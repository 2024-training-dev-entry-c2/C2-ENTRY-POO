package src;

public abstract class Alojamiento {

    private String nombre;
    private String ciudad;
    private double calificacion;
    private String tipo;

    public double calcularPrecioBase(){
        return 0.0;
    }

    public double calcularDescuentoOAumento(){
        return 0.0;
    }



}
