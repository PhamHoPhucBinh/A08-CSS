package com.service;
import com.model.Order;

import java.sql.SQLException;
import java.util.List;
public interface OrderService {
    List<Order> findAll();

    Order findById(int orderId);
    void add(Order order);
    boolean update(Order order);
    boolean softDelete(int orderId) throws SQLException;

//    boolean remove(int customerId) throws SQLException;


}
