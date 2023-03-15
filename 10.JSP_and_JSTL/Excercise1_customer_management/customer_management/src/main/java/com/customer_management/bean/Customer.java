package com.customer_management.bean;

public class Customer {
    private String id;
    private String name;
    private String dayOfBirth;
    private String address;
    private String image;

    public Customer(String id, String name, String dayOfBirth, String address, String image) {
        this.id = id;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.image = image;
    }

    public Customer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
