package homework9.models;

import java.io.Serializable;

public class Trip implements Serializable {
    private int tripId;
    private String destination;
    private int cargoQuantity;
    private String cargoType;
    private int requiredExperience;
    private double earnings;
    private Driver driver;
    private boolean completed;

    public Trip(int tripId, String destination, int cargoQuantity, String cargoType,
                int requiredExperience, double earnings) {
        this.tripId = tripId;
        this.destination = destination;
        this.cargoQuantity = cargoQuantity;
        this.cargoType = cargoType;
        this.requiredExperience = requiredExperience;
        this.earnings = earnings;
        this.completed = false;
    }

    public void completeTrip() {
        completed = true;
        driver.logTrip(this);
    }

    public void assignDriver(Driver driver) {
        this.driver = driver;
    }

    public String getDestination() {
        return destination;
    }

    public int getCargoQuantity() {
        return cargoQuantity;
    }

    public int getTripId() {
        return tripId;
    }

    public Driver getDriver() {
        return driver;
    }

    public int getRequiredExperience() {
        return requiredExperience;
    }

    public double getEarnings() {
        return earnings;
    }

    public boolean isCompleted() {
        return completed;
    }
}
