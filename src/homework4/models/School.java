package homework4.models;

import homework4.constants.SchoolAccreditation;
import homework4.interfaces.FieldInitializable;

public class School extends Building implements FieldInitializable {
    private int numberOfStudents;
    private SchoolAccreditation accreditationLevel;

    public School() {
        super();
        this.numberOfStudents = 1000;
        this.accreditationLevel = SchoolAccreditation.GYMNASIUM;
    }

    public School(String address) {
        super(address);
    }

    @Override
    public void setFields(String details) {
        String[] parts = details.split(",");
        if (parts.length == 3) {
            address = parts[0];
            accreditationLevel = SchoolAccreditation.valueOf(parts[1].trim().toUpperCase());
            numberOfStudents = Integer.parseInt(parts[2].trim());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Школа");
        System.out.println("Адреса: " + super.address);
        System.out.println("Кількість учнів: " + numberOfStudents);
        System.out.println("Рівень акредитації: " + accreditationLevel);
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public SchoolAccreditation getAccreditationLevel() {
        return accreditationLevel;
    }

    public void setAccreditationLevel(SchoolAccreditation accreditationLevel) {
        this.accreditationLevel = accreditationLevel;
    }
}
