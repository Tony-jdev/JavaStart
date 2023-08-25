package homework4;

import homework4.models.*;

public class Main {
    public static void main(String[] args) {
        School school = new School();
        school.setAddress("School's address");
        school.displayInfo();

        System.out.println();

        Shop shop = new Shop();
        shop.setFields("shop address not set by constructor, SHOP, CLOTHING");
        shop.displayInfo();

        System.out.println();

        Hospital hospital = new Hospital();
        hospital.setCapacity(111111);
        hospital.displaytAddress();

        System.out.println();

        Building[] buildings = { school, shop, hospital };
        Street street = new Street(buildings);

        street.displayStreetInfo();
    }
}
