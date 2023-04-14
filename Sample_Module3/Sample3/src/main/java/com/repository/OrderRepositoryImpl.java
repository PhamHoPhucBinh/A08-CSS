package com.repository;

import com.model.Order;
import com.model.Product;
import static com.utility.Connection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.getConnection;

public class OrderRepositoryImpl implements OrderRepository {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    private static final String SELECT_ALL_ORDER = "SELECT * FROM `order` WHERE IsDelete = FALSE;";
    private static final String INSERT_ORDER_SQL = "INSERT INTO `order`( orderDate, productId, quantity) VALUES ( ?, ?, ?);";
    private static final String UPDATE_ORDER_SQL = "update `order` set orderDate = ?,productId = ?, quantity =? where orderId = ?;";
    private static final String SELECT_ORDER_BY_ID = "select orderId,orderDate,productId,quantity from `order` where orderId =?;";
    private static final String SOFT_DELETE_ORDER = "update `order` set IsDelete = TRUE where orderId =?;";

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                Date orderDate = new Date(rs.getDate("orderDate").getTime());
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                Product product = productRepository.findById(productId);
                boolean isDelete = rs.getBoolean("isDelete");
                orderList.add(new Order(orderId, orderDate, product, quantity, isDelete));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return orderList;
    }

    @Override
    public Order findById(int orderId) {
        Order order = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_BY_ID);) {
            preparedStatement.setInt(1, orderId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Date orderDate = rs.getDate("orderDate");
                int productId = rs.getInt("productId");
                int quantity = rs.getInt("quantity");
                boolean isDelete = rs.getBoolean("isDelete");
                Product product = productRepository.findById(productId);
                order = new Order(orderId, orderDate, product, quantity, isDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return order;
    }

    @Override
    public void add(Order order) {
        System.out.println(INSERT_ORDER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER_SQL)) {
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            preparedStatement.setInt(2, order.getProduct().getProductId());
            preparedStatement.setInt(3, order.getQuantity());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Order order) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER_SQL)) {
            statement.setDate(1, new java.sql.Date(order.getOrderDate().getTime()));
            statement.setInt(2, order.getProduct().getProductId());
            statement.setInt(3, order.getQuantity());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean softDelete(int orderId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SOFT_DELETE_ORDER);) {
            statement.setInt(1, orderId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
