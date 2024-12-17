package com.example.hotel.services.interfaces;

import com.example.hotel.models.Stay;

import java.time.LocalDate;
import java.util.List;

public interface IStayService {
  Stay getStaysForHousing(List<Stay> stays, String hostingName);
  List<Stay> confirmStays(List<Stay> stays, String hostingName, LocalDate startDate, LocalDate endDate, int numberOfAdults, int numberOfChildren, int numberOfRooms);
}
