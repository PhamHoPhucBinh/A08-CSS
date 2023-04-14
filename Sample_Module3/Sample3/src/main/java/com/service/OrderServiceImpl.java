package com.service;

import com.model.Order;
import com.repository.OrderRepository;
import com.repository.OrderRepositoryImpl;
import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService{
    private OrderRepository repository = new OrderRepositoryImpl();
    @Override
    public List<Order> findAll() {
        return repository.findAll();
    }

    @Override
    public Order findById(int orderId) {
        return repository.findById(orderId);
    }

    @Override
    public void add(Order order) {
        repository.add(order);
    }

    @Override
    public boolean update(Order order) {
        return repository.update(order);
    }

    @Override
    public boolean softDelete(int orderId) throws SQLException {
        return repository.softDelete(orderId);
    }
}
