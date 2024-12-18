package Seed;

import Models.*;

import java.util.ArrayList;
import java.util.List;

public class Seed {
    public static List<Hotel> createHotels() {
        List<Hotel> hotels = new ArrayList<>();

        Hotel hotel1 = new Hotel("Hotel Nacional de Cuba", "La Habana", Type.HOTEL, 4.8, true);
        hotel1.addRoom(new PresidentialSuitRoom("Cama King, Vista al mar, Jacuzzi, AC", 500.0, 2, 2, true));
        hotel1.addRoom(new SimpleRoom( "Cama doble, Vista al jardín, AC", 180.0, 2, 0, true));
        hotel1.addRoom(new DoubleRoom( "2 camas dobles, Vista a la ciudad, AC", 220.0, 4, 0, true));
        hotel1.addRoom(new PenthouseRoom( "3 camas individuales, AC", 260.0, 3, 0, true));
        hotel1.addRoom(new EjecutiveRoom("Cama King, Vista al mar, AC", 350.0, 2, 1, true));
        hotels.add(hotel1);

        Hotel hotel2 = new Hotel("Meliá Cohíba", "La Habana", Type.HOTEL, 4.7, true);
        hotel2.addRoom(new EjecutiveRoom( "Cama King, Jacuzzi, Vista al mar, AC", 450.0, 2, 2, true));
        hotel2.addRoom(new DoubleRoom("2 camas dobles, AC", 250.0, 4, 0, true));
        hotel2.addRoom(new SimpleRoom("1 cama individual, AC", 150.0, 1, 0, true));
        hotel2.addRoom(new PenthouseRoom( "2 camas dobles, Cama extra, AC", 280.0, 5, 0, true));
        hotel2.addRoom(new PresidentialSuitRoom("Cama King, Vista a la ciudad, AC", 350.0, 2, 1, true));
        hotels.add(hotel2);

        Hotel hotel3 = new Hotel("Hotel Playa Azul", "Varadero", Type.FINCA, 4.6, true);
        hotel3.addRoom(new PresidentialSuitRoom("Cama King, Vista al océano, Jacuzzi, AC", 400.0, 2, 2, true));
        hotel3.addRoom(new SimpleRoom( "2 camas dobles, Vista a la piscina, AC", 230.0, 4, 0, true));
        hotel3.addRoom(new DoubleRoom("1 cama individual, AC", 140.0, 1, 0, true));
        hotel3.addRoom(new PenthouseRoom("2 camas dobles, Cama extra, Vista a la piscina, AC", 270.0, 5, 0, true));
        hotel3.addRoom(new EjecutiveRoom("Cama King, Vista al mar, 2 baños, AC", 380.0, 3, 2, true));
        hotels.add(hotel3);

        Hotel hotel4 = new Hotel("Hotel Saratoga", "La Habana", Type.APARTAMENTO, 4.9, true);
        hotel4.addRoom(new PenthouseRoom("Cama King, Vista panorámica, Jacuzzi, AC", 600.0, 2, 2, true));
        hotel4.addRoom(new DoubleRoom( "2 camas dobles, Vista a la ciudad, AC", 240.0, 4, 0, true));
        hotel4.addRoom(new EjecutiveRoom("Cama King, Vista al mar, Mini-bar, AC", 500.0, 2, 2, true));
        hotel4.addRoom(new SimpleRoom("1 cama individual, Vista a la ciudad, AC", 150.0, 1, 0, true));
        hotel4.addRoom(new PresidentialSuitRoom("Cama King, Vista parcial al mar, AC", 350.0, 2, 1, true));
        hotels.add(hotel4);

        Hotel hotel5 = new Hotel("Resort Playa Coco", "Ciego de Ávila", Type.DIA_DE_SOL, 4.5, true);
        hotel5.addRoom(new PresidentialSuitRoom("Cama King, Jacuzzi, Vista al océano, AC", 500.0, 2, 2, true));
        hotel5.addRoom(new SimpleRoom( "Cama doble, Vista al jardín, AC", 200.0, 2, 0, true));
        hotel5.addRoom(new DoubleRoom("2 camas dobles, Vista a la piscina, AC", 240.0, 4, 0, true));
        hotel5.addRoom(new PenthouseRoom( "3 camas individuales, Vista a la playa, AC", 280.0, 3, 0, true));
        hotel5.addRoom(new EjecutiveRoom( "Cama King, Vista al mar, 2 baños, AC", 350.0, 4, 2, true));
        hotels.add(hotel5);

        return hotels;
    }
}