import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public abstract class Accommodation {

    private String name;
    private String city;
    private String type;
    private float rating;
    private boolean sunnyDay;

    public Accommodation(String name, String city, String type, float rating, boolean sunnyDay) {
        this.name = name;
        this.city = city;
        this.type = type;
        this.rating = rating;
        this.sunnyDay = sunnyDay;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public boolean isSunnyDay() {
        return sunnyDay;
    }

    public String getType() {
        return type;
    }

    public float getRating() {
        return rating;
    }

    public  Map<String, Object> calculatePrice(int totalBasePrice, LocalDate start, LocalDate end){
        double discountOrIncrease = 0.0;
        String adjustmentType = "None";

        if (start.getDayOfMonth() >= 5 && end.getDayOfMonth() <= 10) {
            discountOrIncrease = -0.08 * totalBasePrice;
            adjustmentType = "8% de descuento";
        } else if (start.getDayOfMonth() >= 10 && end.getDayOfMonth() <= 15) {
            discountOrIncrease = 0.10 * totalBasePrice;
            adjustmentType = "10% de incremento";
        } else if (end.getDayOfMonth() > 25) {
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

    public abstract Map<String, Object> calculateStayPrice(String startDate, String endDate, int roomQuantity);

    public abstract String showAccomodation(String startDate, String endDate, int roomQuantity);
}
