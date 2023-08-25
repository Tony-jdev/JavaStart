package homework4.models;

import homework4.constants.ShopType;
import homework4.interfaces.FieldInitializable;

public class Shop extends Building implements FieldInitializable {
    private String shopName;
    private ShopType shopType;
    public Shop() {
        super();
        this.shopName = "name";
        this.shopType = ShopType.GROCERY;
    }

    public Shop(String address) {
        super(address);
    }

    @Override
    public void setFields(String details) {
        String[] parts = details.split(",");
        if (parts.length == 3) {
            address = parts[0];
            shopName = parts[1].trim();
            shopType = ShopType.valueOf(parts[2].trim().toUpperCase());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Магазин");
        System.out.println("Адреса: " + super.address);
        System.out.println("Назва магазину: " + shopName);
        System.out.println("Тип магазину: " + shopType);
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public ShopType getShopType() {
        return shopType;
    }

    public void setShopType(ShopType shopType) {
        this.shopType = shopType;
    }
}
