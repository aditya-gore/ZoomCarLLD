package model.User;

import model.Inventory;
import model.Vehicle.Vehicle;
import model.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static model.Inventory.getInventory;

public class Admin extends User{
    public Admin(String email) {
        super(email, true);
    }

    public Admin(String email, String password) {
        super(email, password, true);
    }
    public void addVehicle(Vehicle vehicle){
        try{
            Map<VehicleType, List<Vehicle>> inventory = getInventory();
            VehicleType type = vehicle.getType();
            String name = vehicle.getRegistrationNumber();
            List<Vehicle> current = inventory.getOrDefault(type, new ArrayList<>());
            current.add(vehicle);
            inventory.put(type,current);
            System.out.println(name +" added successfully");
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    public void removeVehicle (String registrationNumber){
        try{
            Map<VehicleType, List<Vehicle>> inventory = getInventory();
            boolean isReleased = false;
            for (List<Vehicle> v:
                 inventory.values()) {
                for (Vehicle vi:
                     v) {
                    if(vi.getRegistrationNumber().equals(registrationNumber)){
                        this.deleteVehicle(vi.getType(),vi);
                        isReleased = true;
                    }
                }
            }
            if(!isReleased) {
                System.out.println(registrationNumber + "not found!");
            }
        } catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }

    }
    private void deleteVehicle(VehicleType type, Vehicle vehicle){
        List<Vehicle> current = Inventory.getInventory().getOrDefault(type,new ArrayList<>());
        current.remove(vehicle);
        Inventory.getInventory().put(type, current);
    }
}
