package homework9.models;

import java.io.Serializable;

public class Vehicle implements Serializable {
    private int vehicleId;
    private String type;
    private int cargoCapacity;
    private boolean needsRepair;

    public Vehicle(int vehicleId, String type, int cargoCapacity) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.cargoCapacity = cargoCapacity;
        this.needsRepair = false;
    }

    public void requestRepair() {
        needsRepair = true;
    }

    public void repair() {
        needsRepair = false;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getType() {
        return type;
    }

    public int getCargoCapacity() {
        return cargoCapacity;
    }
}
