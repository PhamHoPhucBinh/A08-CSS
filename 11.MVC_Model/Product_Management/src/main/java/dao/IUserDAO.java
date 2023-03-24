package dao;

import bean.Product;

import java.sql.SQLDataException;
import java.sql.SQLException;

public interface IUserDAO {
public void insertProduct( Product product) throws SQLException;

}
