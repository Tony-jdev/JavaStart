package homework4.models;

public abstract class Building {
    protected String address;

    public Building() {
        this.address = "Address";
    }

    public Building(String address) {
        this.address = address;
    }

    public abstract void displayInfo();

    public void displaytAddress() {
        System.out.println(address);
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
