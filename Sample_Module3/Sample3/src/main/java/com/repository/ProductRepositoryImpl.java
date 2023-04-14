package com.repository;

import com.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.utility.Connection.getConnection;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String SELECT_ALL_PRODUCT = "Select * from product;";
    private static final String SELECT_PRODUCT_BY_ID = "Select * from product where productId = ?;";
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
    public Product findById(int productId) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID)) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String productName = rs.getString("productName");
                String productDescription = rs.getString("productDescription");
                double productPrice = rs.getDouble("ProductPrice");
                return new Product( productName,productDescription, productPrice);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return ;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("productName");
                String productDescription = rs.getString("productDescription");
                double productPrice = rs.getDouble("ProductPrice");
                productList.add(new Product(productName,productDescription,productPrice));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }
}
