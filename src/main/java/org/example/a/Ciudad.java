package org.example.a;

public class Ciudad {

    private int id;
    private String nombre;

    //Contructor
    public Ciudad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
