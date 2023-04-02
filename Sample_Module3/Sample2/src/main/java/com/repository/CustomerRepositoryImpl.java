package com.repository;

import com.model.Customer;
import com.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.utility.Connection.getConnection;

public class CustomerRepositoryImpl implements CustomerRepository {
    private ProductRepository productRepository = new ProductRepositoryImpl();

    private static final String SELECT_ALL_CUSTOMER = "select * from customer \n;";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer( name , birthday, address, phone, product_id) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set name = ?,birthday= ?, address =?,phone=? , product_id =? where customer_id = ?;";
    private static final String SELECT_CUSTOMER_BY_ID = "select customer_id,name,birthday,address,product_id from customer where customer_id =?;";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customer_id = ?;";

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
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String customerName = rs.getString("name");
                Date birthday = new Date(rs.getDate("birthday").getTime());
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int productId = rs.getInt("product_id");
                Product product = productRepository.findById(productId);
                customerList.add(new Customer(customerId, customerName, birthday, address, phone, product));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customerList;
    }

    @Override
    public Customer findById(int customerId) {
        Customer customer = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, customerId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("customer_id");
                Date birthday = rs.getDate("birthday");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                int productId = rs.getInt("product_id");
                Product product = productRepository.findById(productId);
                customer = new Customer(customerId, name, birthday, address, phone, product);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return customer;
    }

    @Override
    public void add(Customer customer) {
        System.out.println(INSERT_CUSTOMER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setDate(2, new java.sql.Date(customer.getBirthday().getTime()));
            preparedStatement.setString(3, customer.getAddress());
            preparedStatement.setString(4, customer.getPhone());
            preparedStatement.setInt(5, customer.getProduct().getProductId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Customer customer) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setString(1, customer.getCustomerName());
            statement.setDate(2, new java.sql.Date(customer.getBirthday().getTime()));
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getPhone());
            statement.setInt(5, customer.getProduct().getProductId());
            statement.setInt(6, customer.getCustomerId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated;
    }

    @Override
    public boolean remove(int customerId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, customerId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
