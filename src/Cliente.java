import java.time.LocalDate;

public class Cliente {

    public String nombre;
    public String apellido;
    public String email;
    public String nacionalidad;
    public int telefono;
    public LocalDate fechaNacimiento;

    public Cliente(String nombre, String apellido, String email, String nacionalidad, int telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean autenticarUsuario ( String email, String fechaNacimiento ) {
        if ( this.email.equals(email) && this.fechaNacimiento.equals(fechaNacimiento) ) {
            return true;
        } else {
            return false;
        }

    }
}
