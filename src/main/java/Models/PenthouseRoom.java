package Models;

public class PenthouseRoom extends Room {
    public  PenthouseRoom (String description, double price, int adultCapacity, int childCapacity, boolean availability) {
        super("Penthouse", description, price, adultCapacity, childCapacity, availability);

    }

    @Override
    public String getRoomDetails() {
        return "Habitación Simple: \n" +
                "Tipo: " + getType() + "\n" +
                "Capacidad de Adultos: " + getAdultCapacity() + "\n" +
                "Capacidad de Niños: " + getChildCapacity() + "\n" +
                "Descripción: " + getFeatures() + "\n" +
                "Precio por Noche: $" + getPriceNight();
    }


}
