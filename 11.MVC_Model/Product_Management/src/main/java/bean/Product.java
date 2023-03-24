package bean;

import java.awt.*;

public class Product {
int id;
String name;
float price;
String details;
String manufacturer;

    public Product(int id, String name, float price, String details, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.details = details;
        this.manufacturer = manufacturer;
    }
    public Product(){};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
