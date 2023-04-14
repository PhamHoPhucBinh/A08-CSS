package com.model;

import java.util.Date;

public class Order {
    int orderId;
    Date orderDate;
    Product product;
    int quantity;
    boolean isDelete;

    public Order() {
    }

    public Order(int orderId, Date orderDate, Product product, int quantity) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
    }

    public Order(Date orderDate, Product product, int quantity) {
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
    }

    public Order(int orderId, Date orderDate, Product product, int quantity, boolean isDelete) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public Order(Date orderDate, Product product, int quantity, boolean isDelete) {
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
        this.isDelete = isDelete;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
