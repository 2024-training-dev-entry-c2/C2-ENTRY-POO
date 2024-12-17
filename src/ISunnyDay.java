import java.util.Map;

public interface ISunnyDay {
    Map<String, Object> calculateSunnyDayPrice(String startDate, int adultsQuantity, int childrenQuantity);

    String showSunnyDayAccommodation(String startDate, int adultsQuantity, int childrenQuantity);
}
