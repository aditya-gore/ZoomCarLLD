package model.User;

import model.Booking.Booking;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User{
    private List<Booking> bookings;
    public Customer(String email) {
        super(email, false);
        bookings = new ArrayList<>();
    }

    public Customer(String email, String password) {
        super(email, password, false);
        bookings = new ArrayList<>();
    }

    public List<Booking> getBookings() {
        return bookings;
    }
}
