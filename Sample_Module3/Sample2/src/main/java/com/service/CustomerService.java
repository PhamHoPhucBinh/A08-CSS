package com.service;

import com.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int customerId);
    void add(Customer customer);
    boolean update(Customer customer);
    boolean remove(int customerId) throws SQLException;

//    List<Customer> findByProductName(String productName);
}
