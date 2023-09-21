package homework9.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import java.io.*;

public class Dispatcher {
    private List<Trip> trips;
    private List<Driver> drivers;
    private List<Vehicle> vehicles;

    public Dispatcher() {
        trips = new ArrayList<>();
        drivers = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public void addTrip(Trip trip) {
        trips.add(trip);
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void assignDriverToTrip(Trip trip) {
        drivers.sort(Comparator.comparingInt(Driver::getExperience));
        Driver selectedDriver = null;
        for (Driver driver : drivers) {
            if (driver.getExperience() >= trip.getRequiredExperience() && !driver.isBusy()) {
                selectedDriver = driver;
                driver.setBusy(true);
                break;
            }
        }

        if (selectedDriver == null) {
            System.out.println("Не знайдено водія з потрібним досвідо або ж усі водії заняті.");
            return;
        }

        Vehicle selectedVehicle = null;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getCargoCapacity() >= trip.getCargoQuantity()) {
                selectedVehicle = vehicle;
                break;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Не знайдено автомобіля з необхідною грузопідйомністю.");
            return;
        }

        selectedDriver.assignVehicle(selectedVehicle);
        trip.assignDriver(selectedDriver);

        trips.add(trip);
    }


    public void completeTrip(Trip trip) {
        trip.completeTrip();

        logTripEvent(trip);
    }

    public void saveDriversToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("drivers.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(drivers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDriversFromFile() {
        try (FileInputStream fileIn = new FileInputStream("drivers.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            drivers = (List<Driver>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveTripsToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("trips.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(trips);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTripsFromFile() {
        try (FileInputStream fileIn = new FileInputStream("trips.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            trips = (List<Trip>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveVehiclesToFile() {
        try (FileOutputStream fileOut = new FileOutputStream("vehicles.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(vehicles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadVehiclesFromFile() {
        try (FileInputStream fileIn = new FileInputStream("vehicles.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            vehicles = (List<Vehicle>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveAllDataToFile() {
        saveDriversToFile();
        saveTripsToFile();
        saveVehiclesToFile();
    }

    public void loadAllDataFromFile() {
        loadDriversFromFile();
        loadTripsFromFile();
        loadVehiclesFromFile();
    }

    private void logTripEvent(Trip trip) {
        try (FileWriter writer = new FileWriter("dispatcher_log.txt", true)) {
            writer.write("Trip " + trip.getTripId() + " completed by driver " + trip.getDriver().getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, Integer> calculateCargoPerDestination() {
        Map<String, Integer> cargoPerDestination = new HashMap<>();
        for (Trip trip : trips) {
            String destination = trip.getDestination();
            int cargoQuantity = trip.getCargoQuantity();
            cargoPerDestination.put(destination, cargoPerDestination.getOrDefault(destination, 0) + cargoQuantity);
        }
        return cargoPerDestination;
    }

    public void printCargoPerDriverStatistics() {
        for (Driver driver : drivers) {
            int totalCargo = driver.getTotalCargo();
            System.out.println(driver.getName() + " transported " + totalCargo + " units of cargo.");
        }
    }

    // Виведення кількості грузів для кожного пункту назначення
    public void printCargoPerDestinationStatistics() {
        Map<String, Integer> cargoPerDestination = calculateCargoPerDestination();
        for (Map.Entry<String, Integer> entry : cargoPerDestination.entrySet()) {
            System.out.println("Destination " + entry.getKey() + " received " + entry.getValue() + " units of cargo.");
        }
    }

    public void printMoneyPerDriverStatistics() {
        for (Driver driver: drivers) {
            System.out.println(driver.getName() + "'s capital equals " + driver.getMoney());
        }
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}