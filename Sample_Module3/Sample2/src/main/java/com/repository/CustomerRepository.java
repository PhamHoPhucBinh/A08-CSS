package com.repository;

import com.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int customerId);

    void add(Customer customer);

    boolean update(Customer customer);

    boolean remove(int customerId) throws SQLException;

    boolean SoftDelete(int customerId) throws SQLException;
}
