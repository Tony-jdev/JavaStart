package homework4.models;

public class Street {
    private Building[] buildings;

    public Street(Building[] buildings) {
        this.buildings = buildings;
    }

    public void displayStreetInfo() {
        System.out.println("Інформація про будівлі на вулиці:");

        for (Building building : buildings) {
            building.displayInfo();
            System.out.println("-------------------------");
        }
    }

    public Building[] getBuildings() {
        return buildings;
    }

    public void setBuildings(Building[] buildings) {
        this.buildings = buildings;
    }
}
