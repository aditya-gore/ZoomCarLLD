package model.Vehicle;

public class Vehicle {
    VehicleType type;
    private String registrationNumber;
    private String qrCode;
    private VehicleStatus status;
    private String place;

    public Vehicle(String registrationNumber,VehicleType type, String qrCode, VehicleStatus status, String place) {
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.qrCode = qrCode;
        this.status = status;
        this.place = place;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public String getQrCode() {
        return qrCode;
    }

    public VehicleStatus getStatus() {
        return status;
    }

    public String getPlace() {
        return place;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public void setPlace(String place) {
        this.place = place;
    }

}
