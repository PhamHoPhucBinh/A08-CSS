package com.model;

public class Product {
    int productId;
    String productName;
    Double productPrice;
    int quantity;
    String color;
    Category category;
    Boolean isDelete;

    public Product() {
    }

    public Product(int productId, String productName, Double productPrice, int quantity, String color, Category category, Boolean isDelete) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.isDelete = isDelete;
    }

    public Product(String productName, Double productPrice, int quantity, String color, Category category, Boolean isDelete) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.isDelete = isDelete;
    }

    public Product(String productName, Double productPrice, int quantity, String color, Category category) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int productId, String productName, Double productPrice, int quantity, String color, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Product(int productId, String productName, double productPrice, int quantity, String color, Category category) {

    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }
}
