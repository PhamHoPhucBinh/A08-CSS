package com.model;

public class Category {
    int categoryId;
    String manufacturerName;

    public Category(int categoryId, String manufacturerName) {
        this.categoryId = categoryId;
        this.manufacturerName = manufacturerName;
    }

    public Category(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }
}
