import model.Inventory;
import model.User.Admin;
import model.User.Customer;
import model.User.User;
import model.Vehicle.Vehicle;
import model.Vehicle.VehicleStatus;
import model.Vehicle.VehicleType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Admin admin = new Admin("admin@admin.com","admin@123");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            String command = scanner.nextLine();
            String[] commands = command.split(" ");
            String commandType = commands[0];
            switch (commandType) {
                case "CREATE_ACCOUNT":
                    User user = new Customer(commands[1],commands[2]);
                    System.out.println("Added "+ user.getEmail());
                    break;
                case "ADD_Vehicle":
                    if(commands[1].equals(admin.getEmail()) &&
                            commands[2].equals(admin.getPassword())){
                        // add vehicle
                        VehicleType vehicleType = VehicleType.valueOf(commands[4]);
                        VehicleStatus vehicleStatus = VehicleStatus.valueOf(commands[6]);
                        admin.addVehicle(new Vehicle(commands[3], vehicleType,
                                commands[5], vehicleStatus, commands[7]));
                    } else {
                        System.out.println("Only Admin can add a new vehicle!");
                    }
                    break;
                case "REMOVE_VEHICLE":
                    if(commands[1].equals(admin.getEmail()) &&
                            commands[2].equals(admin.getPassword())){
                        // Remove vehicle
                        admin.removeVehicle(commands[3]);
                    } else {
                        System.out.println("Only Admin can remove a vehicle!");
                    }
                    break;
                case "SHOW_VEHICLES":
                    Inventory.showAvailableVehicles();
                    break;
                case "CREATE_BOOKING":
                    System.out.println("---In Progress---");
                    Customer cx = new Customer(commands[1], commands[2]);
                    break;
                case "ADD_DEVICES":
                    System.out.println("---In Progress---");
                   break;
                case "CANCEL_BOOKING":
                    System.out.println("---In Progress---");
                    break;
                case "PICKUP_VEHICLE":
                    System.out.println("---In Progress---");
                    break;
                case "RETURN_VEHICLE":
                    System.out.println("---In Progress---");
                    break;
                case "GET_BOOKED_VEHICLES":
                    System.out.println("---In Progress---");
                    break;
                case "CREATE_INVOICE":
                    System.out.println("---In Progress---");
                    break;
            }
        }
    }
}
