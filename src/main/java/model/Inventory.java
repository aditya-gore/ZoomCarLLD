package model;

import model.Vehicle.Vehicle;
import model.Vehicle.VehicleStatus;
import model.Vehicle.VehicleType;

import java.util.*;

public class Inventory {
    private static Map<VehicleType, List<Vehicle>> inventory;

    public static Map<VehicleType, List<Vehicle>> getInventory() {
        return Inventory.inventory;
    }

    public Inventory() {
        Inventory.inventory = new HashMap<>();
    }

    public static void bookVehicle (Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        List<Vehicle> current = inventory.getOrDefault(type, new ArrayList<>());
        if(current.contains(vehicle)){
            for (Vehicle v: current
                 ) {
                if(Objects.equals(v.getRegistrationNumber(), vehicle.getRegistrationNumber())) {
                   VehicleStatus currentStatus = v.getStatus();
                   if(currentStatus == VehicleStatus.IDLE){
                       v.setStatus(VehicleStatus.BOOKED);
                       System.out.println("Vehicle Booked");
                   } else {
                       System.out.println("Vehicle Already Booked");
                   }
                }
            }
        }
    }
    public static void releaseVehicle(Vehicle vehicle) {
        VehicleType type = vehicle.getType();
        List<Vehicle> current = inventory.getOrDefault(type, new ArrayList<>());
        if(current.contains(vehicle)){
            for (Vehicle v: current
            ) {
                if(Objects.equals(v.getRegistrationNumber(), vehicle.getRegistrationNumber())) {
                    VehicleStatus currentStatus = v.getStatus();
                    if(currentStatus == VehicleStatus.BOOKED){
                        v.setStatus(VehicleStatus.IDLE);
                        System.out.println("Vehicle Released");
                    } else {
                        System.out.println("Vehicle Already Idle");
                    }
                }
            }
        }
    }

    public static void showAvailableVehicles() {
        try{
            System.out.println("Vehicle Type || "+"Registration Number");
            List<VehicleType> types = new ArrayList<>(Inventory.inventory.keySet());
            if(types.size()>0){
                for (VehicleType t:
                        types) {
                    List<Vehicle> vehicles = Inventory.inventory.getOrDefault(t, new ArrayList<>());
                    System.out.print(t + " || ");
                    for (Vehicle v:
                            vehicles) {
                        if(v.getStatus() == VehicleStatus.IDLE) {
                            System.out.print(v.getRegistrationNumber());
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
