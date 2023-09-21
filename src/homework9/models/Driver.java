package homework9.models;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Driver implements Serializable {
    private int driverId;
    private String name;
    private int experience;
    private double money;
    private Boolean isBusy;
    private List<Trip> trips;
    private Vehicle vehicle;

    public Driver(int driverId, String name, int experience) {
        this.driverId = driverId;
        this.name = name;
        this.experience = experience;
        this.trips = new ArrayList<>();
        isBusy = false;
    }

    public void requestRepair() {
        if (vehicle != null) {
            vehicle.requestRepair();
        }
    }

    public void logTrip(Trip trip) {
        trips.add(trip);
        money += trip.getEarnings();
        isBusy = false;

        try (FileWriter writer = new FileWriter("driver_log.txt", true)) {
            writer.write("Driver " + name + " completed trip " + trip.getTripId() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getTotalCargo() {
        int totalCargo = 0;
        for (Trip trip : trips) {
            totalCargo += trip.getCargoQuantity();
        }
        return totalCargo;
    }

    public int getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }
    public int getExperience() {
        return experience;
    }
    public double getMoney() {
        return money;
    }

    public Boolean isBusy() {
        return isBusy;
    }

    public void setBusy(Boolean busy) {
        isBusy = busy;
    }
}
