package com.model;

import java.util.Date;

public class Customer {
private int customerId;
private String customerName;
private  Date birthday;
private String address;
private String phone;
private Product product;

private boolean IsDelete;

    public Customer(int customerId, String customerName, Date birthday, String address, String phone, Product product, boolean isDelete) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.product = product;
        this.IsDelete = isDelete;
    }

    public Customer(String customerName, Date birthday, String address, String phone, Product product, boolean isDelete) {
        this.customerName = customerName;
        this.birthday = birthday;
        this.address = address;
        this.phone = phone;
        this.product = product;
        this.IsDelete = isDelete;
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product productId) {
        this.product = product;
    }

    public boolean isDelete() {
        return IsDelete;
    }

    public void setDelete(boolean delete) {
        IsDelete = delete;
    }
}
