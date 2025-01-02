package model.Booking;

import model.User.Customer;
import model.Vehicle.Vehicle;

import java.util.Date;

public class Booking {
    private Customer customer;
    private BookingStatus status;
    private Vehicle vehicle;
    private Devices[] devices;
    private String startLocation;
    private String endLocation;
    private Date bookingDay;
    private long startTime;
    private long endTime;

    public Booking(Customer customer, BookingStatus status,
                   Vehicle vehicle, Devices[] devices,
                   String startLocation, Date bookingDay) {
        this.customer = customer;
        this.status = status;
        this.vehicle = vehicle;
        this.devices = devices;
        this.startLocation = startLocation;
        this.bookingDay = bookingDay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Devices[] getDevices() {
        return devices;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public Date getBookingDay() {
        return bookingDay;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
