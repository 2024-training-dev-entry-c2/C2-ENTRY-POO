import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Hotel extends Accommodation implements ISunnyDay{
    private int[] pricePerNight;
    private int[] rooms;

    private int pricePerson;
    private int peopleQuantity;
    private String activities;
    private boolean includesLunch;

    public Hotel(String name, String city, String type, float rating, boolean sunnyDay, int[] pricePerNight, int[] rooms) {
        super(name, city, type, rating, sunnyDay);
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
    }

    public Hotel(String name, String city, String type, float rating, boolean sunnyDay, int[] pricePerNight, int[] rooms, int pricePerson, int peopleQuantity, String activities, boolean includesLunch) {
        super(name, city, type, rating, sunnyDay);
        this.pricePerNight = pricePerNight;
        this.rooms = rooms;
        this.pricePerson = pricePerson;
        this.peopleQuantity = peopleQuantity;
        this.activities = activities;
        this.includesLunch = includesLunch;
    }

    public int[] getRooms() {
        return rooms;
    }

    public int[] getPricePerNight() {
        return pricePerNight;
    }

    @Override
    public Map<String, Object> calculateStayPrice(String startDate, String endDate, int roomQuantity) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        long days = ChronoUnit.DAYS.between(start, end);
        int totalBasePrice = this.pricePerNight[0] * roomQuantity * (int) days;
        return this.calculatePrice(totalBasePrice,start, end);
    }

    @Override
    public String showAccomodation(String startDate, String endDate, int roomQuantity) {
        Map<String, Object>  price = calculateStayPrice(startDate, endDate, roomQuantity);
        String priceString = "Precio base: " + price.get("basePrice") + '\n' +
                "Tipo de ajuste: " + price.get("adjustmentType") + '\n' +
                "Valor del ajuste: " + price.get("adjustmentValue") + '\n' +
                "Precio final: " + price.get("finalPrice") + '\n' ;
        return "Calificación: " + this.getRating() + '\n' +
                "Precio por noche: " + this.pricePerNight[0] + '\n'+ priceString;

    }

    @Override
    public Map<String, Object> calculateSunnyDayPrice(String startDate, int adultsQuantity, int childrenQuantity) {
        int totalBasePrice = this.pricePerson * (adultsQuantity + childrenQuantity);
        LocalDate start = LocalDate.parse(startDate);

        double discountOrIncrease = 0.0;
        String adjustmentType = "None";

        if (start.getDayOfMonth() >= 5 && start.getDayOfMonth() <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% de descuento";
        } else if (start.getDayOfMonth() >= 10 && start.getDayOfMonth() <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% de incremento";
        } else if (start.getDayOfMonth() > 25) {
            discountOrIncrease = 0.15 * totalBasePrice;
            adjustmentType = "15% de incremento";
        }

        double finalPrice = totalBasePrice + discountOrIncrease;

        Map<String, Object> accommodation = new HashMap<>();
        accommodation.put("basePrice", totalBasePrice);
        accommodation.put("adjustmentType", adjustmentType);
        accommodation.put("adjustmentValue", discountOrIncrease);
        accommodation.put("finalPrice", finalPrice);
        return accommodation;
    }

    @Override
    public String showSunnyDayAccommodation(String startDate, int adultsQuantity, int childrenQuantity) {
        Map<String, Object>  price = calculateSunnyDayPrice(startDate, adultsQuantity, childrenQuantity);
        String priceString = "Precio base: " + price.get("basePrice") + '\n' +
                "Tipo de ajuste: " + price.get("adjustmentType") + '\n' +
                "Valor del ajuste: " + price.get("adjustmentValue") + '\n' +
                "Precio final: " + price.get("finalPrice") + '\n' ;
        return "Actividades: " + this.activities + '\n' +
                "Incluye almuerzo: " + (this.includesLunch ? "sí" : "no") + '\n' +
                "Calificación: " + this.getRating() + '\n' +
                "Precio por persona: " + this.pricePerson + '\n'+ priceString;
    }
}
