package lib;

import Models.Hotel;
import Services.HotelService;

import java.util.ArrayList;
import java.util.List;

public class FindCities {

    public static List<String> findCities(HotelService hotelService) {
        List<String> cities = new ArrayList<>();
        for (Hotel hotel : hotelService.getHotels()) {

            if (!cities.contains(hotel.getCity())) {
                cities.add(hotel.getCity());
            }

        }

        return cities;

    }
}