package com.repository;

import com.model.Category;
import com.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.utility.Connection.getConnection;

public class ProductRepositoryImpl implements ProductRepository {

    private CategoryRepository categoryRepository = new CategoryRepositoryImpl();

    private static final String SELECT_ALL_PRODUCT = "SELECT * FROM product WHERE IsDelete = FALSE;";
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product( productName , productPrice, quantity, color, categoryId) VALUES (?, ?, ?, ?, ?);";
    private static final String UPDATE_PRODUCT_SQL = "update product set productName = ?,productPrice= ?, quantity =?,color=? , categoryId =? where productId = ?;";
    private static final String SELECT_PRODUCT_BY_ID = "select productId,productName,productPrice,quantity,color,categoryId from product where productId =?;";
    private static final String SOFT_DELETE_PRODUCT = "update product set IsDelete = TRUE where productId =?;";
    private static final String SEARCH_ALL_PRODUCT_NAME = "SELECT *\n" +
            "FROM product\n" +
            "WHERE productName LIKE '%Product%'\n";
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
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                String productName = rs.getString("productName");
                double productPrice = rs.getDouble("productPrice");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                boolean isDelete = rs.getBoolean("isDelete");
                Category category = categoryRepository.findById(categoryId);
                productList.add(new Product(productId, productName, productPrice, quantity, color, category, isDelete));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public Product findById(int productId) {
        Product product = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, productId);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String productName = rs.getString("productName");
                Double productPrice = rs.getDouble("productPrice");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                boolean isDelete = rs.getBoolean("isDelete");
                int categoryId = rs.getInt("categoryId");
                Category category = categoryRepository.findById(categoryId);
                product = new Product(productId, productName, productPrice, quantity, color, category, isDelete);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return product;
    }

    @Override
    public void add(Product product) {
        System.out.println(INSERT_PRODUCT_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
//            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setDouble(2,product.getProductPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategory().getCategoryId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean update(Product product) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL)) {
            statement.setString(1, product.getProductName());
            statement.setDouble(2,product.getProductPrice());
            statement.setInt(3, product.getQuantity());
            statement.setString(4, product.getColor());
            statement.setInt(5, product.getCategory().getCategoryId());
            statement.setInt(6, product.getProductId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdated = true;
    }


    @Override
    public boolean SoftDelete(int productId) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(SOFT_DELETE_PRODUCT);) {
            statement.setInt(1, productId);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public List<Product> findByProductName(String productName) {
        List<Product> productList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_ALL_PRODUCT_NAME)) {
            preparedStatement.setString(1, productName + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                double productPrice = Double.parseDouble(rs.getString("productPrice"));
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                int categoryId = rs.getInt("categoryId");
                Category category = categoryRepository.findById(categoryId);
                productList.add(new Product(productId, productName, productPrice, quantity, color, category));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return productList;

    }
}
