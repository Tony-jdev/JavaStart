package homework4.models;

import homework4.interfaces.FieldInitializable;

public class Hospital extends Building implements FieldInitializable {
    private String name;
    private int capacity;

    public Hospital() {
        super();
        this.name = "name";
        this.capacity = 3000;
    }

    public Hospital(String address) {
        super(address);
    }

    @Override
    public void setFields(String details) {
        String[] parts = details.split(",");
        if (parts.length == 3) {
            address = parts[0];
            name = parts[1].trim();
            capacity = Integer.parseInt(parts[2].trim());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Лікарня");
        System.out.println("Повна назва: " + name);
        System.out.println("Адреса: " + super.address);
        System.out.println("Вмістимість: " + capacity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
