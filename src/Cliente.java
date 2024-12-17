import java.time.LocalDate;

public class Cliente {

    // Atributos privados
    private String nombre;
    private String apellido;
    private String email;
    private String nacionalidad;
    private int telefono;
    private LocalDate fechaNacimiento;

    // Constructor
    public Cliente(String nombre, String apellido, String email, String nacionalidad, int telefono, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    // Método para autenticar usuario
    public boolean autenticarUsuario(String email, String fechaNacimiento) {
        if (this.email.equals(email) && this.fechaNacimiento.toString().equals(fechaNacimiento)) {
            return true;
        } else {
            return false;
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
