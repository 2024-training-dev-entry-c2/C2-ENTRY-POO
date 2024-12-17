package com.example.hotel.services.interfaces;

import com.example.hotel.models.Hosting;
import com.example.hotel.models.Reserve;
import com.example.hotel.models.Stay;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface IReserveService {
  Reserve createReservation(Hosting hosting, List<Stay> stays, int numberOfRooms, int numberOfAdults, int numberOfChildren, String name, String lastName, String email, String nationality, String phone, LocalTime arrivalTime, LocalDate startDate, LocalDate endDate);
  void getReservation(Reserve reservation);
  void addReservations(List<Reserve> reservations, Reserve reservation);
  Reserve selectedReservation(List<Reserve> reservations, String email);
  void printReservations(List<Reserve> reservations, String email);
  void removeReservation(List<Reserve> reservations, Reserve reservationToRemove);
  Stay selectedRoom(Reserve reservation);
  Reserve updateRoomInReservation(Reserve reservation, Stay oldStay, Stay newStay);
}
