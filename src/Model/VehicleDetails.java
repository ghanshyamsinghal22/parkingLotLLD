package Model;

public class VehicleDetails {
    Integer floor;
    Integer slotNum;
    Vehicle vehicle;

    public VehicleDetails(Integer floor, Integer slotNum, Vehicle vehicle) {
        this.floor = floor;
        this.slotNum = slotNum;
        this.vehicle = vehicle;
    }


    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(Integer slotNum) {
        this.slotNum = slotNum;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
