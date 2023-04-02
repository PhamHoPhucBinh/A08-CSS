package com.service;

import com.model.Customer;
import com.repository.CustomerRepository;
import com.repository.CustomerRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository repository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Customer customer) {
        repository.add(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return repository.update(customer);
    }

    @Override
    public boolean remove(int customerId) throws SQLException {
        return repository.remove(customerId);
    }

    @Override
    public boolean soft_remove(int customerId) throws SQLException {
        return repository.SoftDelete(customerId);
    }

    @Override
    public Customer findById(int customerId) {
        return repository.findById(customerId);
    }
}
