package Model;

public class Vehicle {


    String vehicleName;
    String ownerName;
    String colour;
    String type;
    public String getOwnerName() {
        return ownerName;
    }
    public Vehicle(String vehicleName, String ownerName, String colour, String type) {
        this.vehicleName = vehicleName;
        this.ownerName = ownerName;
        this.colour = colour;
        this.type = type;
    }
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

}
