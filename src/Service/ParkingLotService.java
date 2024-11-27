package Service;

import Model.Vehicle;
import Model.VehicleDetails;
import Repository.Floor;
import Repository.Tickets;

import java.util.*;

public class ParkingLotService {
    List<Floor> floors;
    Tickets tickets;
    public ParkingLotService(){
        floors=new ArrayList<>();
        tickets=new Tickets();
    }
    public void addFloor(){
        floors.add(new Floor());
    }
    public String parkVehicle(Vehicle vehicle){
        int i;
        for(i=0;i<floors.size();i++){
            int slotInFloor =floors.get(i).parkVehicle(vehicle.getType());
            if(slotInFloor!=0){
                return "This is Your Ticket ID"+tickets.addVehicleInParking(i,slotInFloor,vehicle);
            }
        }
        return "There is No Space currently";
    }
    public String unParkVehicle(String ticket_id){
        VehicleDetails vehicleDetails=tickets.getDetailsFromTicket(ticket_id);
        if(vehicleDetails!=null){
            floors.get(vehicleDetails.getFloor()).unParkVehicle(vehicleDetails.getSlotNum(),vehicleDetails.getVehicle().getType());
            return "freed the slot "+vehicleDetails.getSlotNum() +" of floor "+vehicleDetails.getFloor();
        }
        return "Invalid Ticket ID";
    }
    public void addSlotsToFloor(Integer floorNum,String vehicleType,Integer slotNum){
        floors.get(floorNum).addSlots(vehicleType,slotNum);
    }
    public void showAvailableNumOfSlots(Integer floorNum){
        HashMap<String,Integer> status=floors.get(floorNum).emptySlotsOfEveryType();
        for(Map.Entry<String,Integer> i:status.entrySet()){
            System.out.println("For "+i.getKey()+ "   :  " +i.getValue() + "Slots are available");
        }
    }
    public void showUnavailableNumOfSlots(Integer floorNum){
        HashMap<String,Integer> status=floors.get(floorNum).bookedSlotsOfEveryType();
        for(Map.Entry<String,Integer> i:status.entrySet()){
            System.out.println("For "+i.getKey()+ "   :  " +i.getValue() + "Slots are booked");
        }
    }
}
