package Models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Room {
    private final String type;
    private final String description;
    private final double price;
    private final int adultCapacity;
    private final int childCapacity;
    private boolean availability;
    private List<Clients> reservations;

    public Room(String type, String description, double price, int adultCapacity, int childCapacity, boolean availability) {
        this.type = type;
        this.description = description;
        this.price = price;
        this.adultCapacity = adultCapacity;
        this.childCapacity = childCapacity;
        this.availability = availability;
        this.reservations = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public String getFeatures() {
        return description;
    }

    public double getPriceNight() {
        return price;
    }

    public int getAdultCapacity() {
        return adultCapacity;
    }

    public int getChildCapacity() {
        return childCapacity;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<Clients> getReservations() {
        return reservations;
    }

    public double getPrice(double price, int[]days){
        boolean lastDays = false;
        boolean midMonth = false;
        boolean firstDays = false;

        for (int day : days) {
            if (day > 25) {
                 lastDays = true;
            }
            else if (day >= 10 && day <= 15) {
                 midMonth = true;
            }
            else if (day >= 5 && day <= 10) {
                 firstDays = true;
            }
        }

        if (lastDays) {
            price *= 1.15;
        } else if (midMonth) {
            price *= 1.10;
        } else if (firstDays) {
            price *= 0.92;
        }

        return price;
    }

    public double getPrice(double price, int day){
        boolean lastDays = false;
        boolean midMonth = false;
        boolean firstDays = false;

        if (day > 25) {
            lastDays = true;
        }
        else if (day >= 10 && day <= 15) {
            midMonth = true;
        }
        else if (day >= 5 && day <= 10) {
            firstDays = true;
        }

        if (lastDays) {
            price *= 1.15;
        } else if (midMonth) {
            price *= 1.10;
        } else if (firstDays) {
            price *= 0.92;
        }
     return  price;
    }

    public void setReservations(List<Clients> reservations) {
        this.reservations = reservations;
    }

    public int getCapacity() {
        return adultCapacity + childCapacity;
    }

    public boolean isAvailable(LocalDate startDate, LocalDate endDate) {
        for (Clients reservation : reservations) {
            if (startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate())) {
                return false;
            }
        }
        return availability;
    }

    public void addReservation(Clients reservation) {
        this.reservations.add(reservation);
    }

    public abstract String getRoomDetails();
}