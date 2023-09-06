package homework8.models;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private String color;
    private int maxSpeed;

    public Car(String name, String color, int maxSpeed) {
        this.name = name;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    public static List<Car> generateCars(int count) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            cars.add(new Car("Car" + i, "Red" + i, (int) (Math.random() * 200)));
        }
        return cars;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
