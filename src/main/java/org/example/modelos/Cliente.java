package org.example.modelos;

public class Cliente {
    private String nombre;
    private String apellido;
    private String email;
    private String nacionalidad;
    private String telefono;
    private String horaLlegada;

    public Cliente(String nombre, String apellido, String email, String nacionalidad, String telefono, String horaLlegada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.horaLlegada = horaLlegada;
    }

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public String getEmail() {
        return email;
    }

    public void mostrarDetalles() {
        System.out.printf("Cliente: %s, Email: %s, Nacionalidad: %s, Teléfono: %s, Hora de llegada: %s\n",
                getNombreCompleto(), email, nacionalidad, telefono, horaLlegada);
    }
}
