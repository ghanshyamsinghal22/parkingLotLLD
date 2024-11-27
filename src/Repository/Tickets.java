package Repository;

import Model.Vehicle;
import Model.VehicleDetails;

import java.util.HashMap;
import java.util.Map;

public class Tickets {
    Integer ticketNum=0;
    Map<String, VehicleDetails> detailsOfParkedVehicles;
    public Tickets(){
        detailsOfParkedVehicles=new HashMap<>();
    }
    String generateTicket() {
        StringBuilder ticketId = new StringBuilder();
        ticketNum++;
        int ticketno = ticketNum;

        while (ticketno > 0) {
            int remainder = (ticketno - 1) % 26;
            ticketId.append((char) ('A' + remainder));
            ticketno = (ticketno - 1) / 26;
        }

        return ticketId.reverse().toString();
    }
    public String addVehicleInParking(Integer floor,Integer slot,Vehicle vehicle){
        VehicleDetails vehicleDetails=new VehicleDetails(floor,slot,vehicle);
        String ticket_id=generateTicket();
        detailsOfParkedVehicles.put(ticket_id,vehicleDetails);
        return ticket_id;
    }
    public VehicleDetails getDetailsFromTicket(String ticketId){
        if(detailsOfParkedVehicles.containsKey(ticketId)){
            return detailsOfParkedVehicles.get(ticketId);
        }
        return null;
    }
}
