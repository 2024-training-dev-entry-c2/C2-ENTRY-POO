package com.example.hotel.services.interfaces;

import com.example.hotel.models.Hosting;
import com.example.hotel.models.Stay;

import java.time.LocalDate;
import java.util.List;

public interface IHostingService {
  Hosting getHotelByCityAndHosting(List<Hosting> hostings, String city, String hostingType);
  List<Hosting> updatePriceHotel(List<Stay> rooms, List<Hosting> hostings, int daysBetween);
  Hosting createDesiredAccommodation(List<Stay> rooms, List<Hosting> hostings, String city, String housingType, LocalDate startDate, LocalDate endDate,
                                     int numberOfAdults, int numberOfChildren, int numberOfRooms);
  void calculatePrice(Hosting hosting, LocalDate startDate, LocalDate endDate, int numberOfRooms);
  void calculatePriceWithStays(Hosting hosting, List<Stay> stays, LocalDate startDate, LocalDate endDate, int numberOfRooms);
}
