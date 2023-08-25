package homework4.models;

import homework4.interfaces.FieldInitializable;

public class ResidentialBuilding extends Building implements FieldInitializable {
    private int numberOfResidents;

    public ResidentialBuilding(String address) {
        super(address);
        numberOfResidents = 1500;
    }

    @Override
    public void setFields(String details) {
        String[] parts = details.split(",");
        if (parts.length == 2) {
            address = parts[0];
            numberOfResidents = Integer.parseInt(parts[1].trim());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Житловий будинок");
        System.out.println("Адреса: " + address);
        System.out.println("Кількість мешканців: " + numberOfResidents);
    }
}
