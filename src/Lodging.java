public class Lodging {
    private String name;
    private String location;
    private String type;
    private double rating;
    private int price;
    private int avaliableRooms;
    private String[] roomDescriptions;

    // Constructor
    public Lodging(String nombre, String ubicacion, String tipo,
                       double calificacion, int precio,
                       int habitacionesDisponibles, String[] descripcionesHabitaciones) {
        this.name = nombre;
        this.location = ubicacion;
        this.type = tipo;
        this.rating = calificacion;
        this.price = precio;
        this.avaliableRooms = habitacionesDisponibles;
        this.roomDescriptions = descripcionesHabitaciones;
    }

    // Getters y setters
    public String getName() { return name; }
    public void setName(String nombre) { this.name = nombre; }
    public String getLocation() { return location; }
    public void setLocation(String ubicacion) { this.location = ubicacion; }
    public String getType() { return location; }
    public void setType(String tipo) { this.type = tipo; }
    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating; }
    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }
    public int getavaliableRooms() { return avaliableRooms; }
    public void setRoomDescriptions(int avaliableRooms) {
        this.avaliableRooms = avaliableRooms;
    }
    public String[] getRoomDescriptions() { return roomDescriptions; }
    public void setRoomDescriptions(String[] roomDescriptions) {
        this.roomDescriptions = roomDescriptions;
    }

    // Metodo para mostrar detalles del alojamiento
    public void mostrarDetalles() {
        System.out.println("Nombre: " + name);
        System.out.println("Ubicación: " + location);
        System.out.println("Tipo: " + type);
        System.out.println("Calificación: " + rating);
        System.out.println("Precio: " + price);
        System.out.println("Habitaciones Disponibles: " + avaliableRooms);
    }
}