import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class Apartment extends Accommodation {
    private int pricePerNight;
    private String features;
    private int roomQuantity;

    public Apartment(String name, String city, String type, float rating, boolean sunnyDay, int pricePerNight, String features, int roomQuantity) {
        super(name, city, type, rating, sunnyDay);
        this.pricePerNight = pricePerNight;
        this.features = features;
        this.roomQuantity = roomQuantity;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    @Override
    public Map<String, Object> calculateStayPrice(String startDate, String endDate, int roomQuantity) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        long days = ChronoUnit.DAYS.between(start, end);
        int totalBasePrice = this.pricePerNight * (int) days;
        return this.calculatePrice(totalBasePrice,start, end);
    }

    @Override
    public String showAccomodation(String startDate, String endDate, int roomQuantity) {
        Map<String, Object>  price = calculateStayPrice(startDate, endDate, roomQuantity);
        String priceString = "Precio base: " + price.get("basePrice") + '\n' +
                "Tipo de ajuste: " + price.get("adjustmentType") + '\n' +
                "Valor del ajuste: " + price.get("adjustmentValue") + '\n' +
                "Precio final: " + price.get("finalPrice") + '\n' ;
        return "Características: " + this.features + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight + '\n'+ priceString;
    }
}
