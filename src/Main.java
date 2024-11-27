import Model.Vehicle;
import Model.VehicleDetails;
import Service.ParkingLotService;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService=new ParkingLotService();
        Scanner scanner =new Scanner(System.in);
        System.out.println("Welcome to our parking system");
        while (true){
        String query=scanner.next();
        if(Objects.equals(query, "LOGOUT")){
            System.out.println("Have a good day !!!");
            break;
        }
        int floornum,slotnum;
        switch (query){
            case "PARK":
                String vehiclename=scanner.next();
                String color=scanner.next();
                String type=scanner.next();
                String ownername=scanner.next();
                Vehicle vehicle=new Vehicle(vehiclename,ownername,color,type);
                System.out.println(parkingLotService.parkVehicle(vehicle));
                break;
            case "UNPARK":
                System.out.println("Enter Ticket ID HERE");
                String ticket_id=scanner.next();
                System.out.println(parkingLotService.unParkVehicle(ticket_id));
                break;

            case "ADDFLOOR":
                parkingLotService.addFloor();
                System.out.println("we added a new floor successfully!!!");
                break;

            case "AVAILABLITY":
                System.out.println("Please Enter Floor No.");
                floornum= scanner.nextInt();
                parkingLotService.showAvailableNumOfSlots(floornum);
                break;

            case "UNAVAILABLITY":
                System.out.println("Please Enter Floor No.");
                floornum= scanner.nextInt();
                parkingLotService.showUnavailableNumOfSlots(floornum);
                break;

            case "ADDSLOTS":
                System.out.println("Please Enter Floor No.");
                floornum= scanner.nextInt();
                System.out.println("Please Enter num of Slots");
                slotnum= scanner.nextInt();
                System.out.println("Please Enter Vehicle Type");
                String vehicleType=scanner.next();
                parkingLotService.addSlotsToFloor(floornum,vehicleType,slotnum);
                System.out.println("slots added to the floor "+ floornum);
                break;
            default:
                System.out.println("Invalid query");

        }
        }
    }
}

// there will be commands of following type
// 1. Park
// 2. UnPark
// 3. Add floor
// 4. Add slots to floor for vehicle_type
// 5. show Availability on floor_num
// 6. show bookings on floor_num
// 7. LogOut
// 8. InvalidCommand