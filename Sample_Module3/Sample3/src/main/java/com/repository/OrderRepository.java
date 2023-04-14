package com.repository;

import com.model.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository {
    List<Order> findAll();

    Order findById(int orderId);

    void add(Order order);

    boolean update(Order order);

//    boolean remove(int orderId) throws SQLException;

    boolean softDelete(int orderId) throws SQLException;
}
