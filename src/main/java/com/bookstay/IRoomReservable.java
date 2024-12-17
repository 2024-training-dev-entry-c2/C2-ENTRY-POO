package com.bookstay;

import java.time.LocalDate;
import java.util.List;

public interface IRoomReservable {
    double calculatePrice(int adults, int children, int days, int requiredRooms);
    double calculatePrice(int adults, int children, int days, List<Room> selectedRooms);
    boolean isAvailable(LocalDate startDate, LocalDate endDate, int guests, int requiredRooms);
}
