package Repository;

import java.util.*;

public class Floor {
    Map<String, Set<Integer>> available;
    Map<String, Set<Integer>> booked;
    public Floor(){
        available=new HashMap<>();
        booked=new HashMap<>();
    }
    // num of empty slots on floor
    public HashMap<String,Integer> emptySlotsOfEveryType(){
        HashMap<String,Integer> report =new HashMap<>();
        for(Map.Entry<String,Set<Integer>> i:available.entrySet()){
            report.put(i.getKey(),i.getValue().size());
        }
        return report;
    }

    // num of booked slots on floor
    public HashMap<String,Integer> bookedSlotsOfEveryType(){
        HashMap<String,Integer> report =new HashMap<>();
        for(Map.Entry<String,Set<Integer>> i:booked.entrySet()){
            report.put(i.getKey(),i.getValue().size());
        }
        return report;
    }

    // add slots for a vehicle type
    public void addSlots(String vehicleType,Integer numOfSlots){
        if (!available.containsKey(vehicleType)){
            available.put(vehicleType,new TreeSet<>());
            booked.put(vehicleType,new TreeSet<>());
        }
        int initialSlots=available.get(vehicleType).size()+booked.get(vehicleType).size();
        for(int i=1;i<=numOfSlots;i++) {
            available.get(vehicleType).add(initialSlots+i);
        }
        return ;
    }

    // park vehicle
    public Integer parkVehicle(String vehicleType){
        if((!available.containsKey(vehicleType)) ||available.get(vehicleType).isEmpty()){
            return 0;
        }
        Iterator<Integer> iterator = available.get(vehicleType).iterator();
        Integer slotNum=iterator.next();
        available.get(vehicleType).remove(slotNum);
        booked.get(vehicleType).add(slotNum);
        return slotNum;
    }
    // unPark vehicle
    public void unParkVehicle(Integer slotNum,String vehicleType){
        available.get(vehicleType).add(slotNum);
        booked.get(vehicleType).remove(slotNum);
        return ;
    }
}