package org.example.dao;
import org.example.model.Product;
import org.example.util.GetProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

public class DBProductDAO implements IProductDAO {
    private static GetProperties properties = new GetProperties();
    private static Connection conn;
    private static String URL = properties.getUrl();
    private static String USERNAME = properties.getUsername();
    private static String PWD = properties.getPwd();
    public DBProductDAO() {

        try {
            String connectionString = URL + "?user=" + USERNAME + "&password=" + PWD;
            conn = DriverManager.getConnection(connectionString);
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e);
            System.exit(-1);
        }
    }

    @Override
    protected void finalize() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean createProduct(Product product) {
        try (PreparedStatement myStatement =
                     conn.prepareStatement("INSERT INTO product (id, name, pieces) VALUES (?, ?, ?)"))
        {
            myStatement.setLong(1, new Random().nextLong(100000)); // parametri paikalleen
            myStatement.setString(2, product.getName()); // parametri paikalleen
            myStatement.setInt(3, product.getPieces()); // parametri paikalleen
            int x = myStatement.executeUpdate();
            if (x == 1)
                return true;
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e);
        }
        return false;
    }
    @Override
    public Product readProduct(Long id) {
        return null;
    }
    @Override
    public Product[] readProductList() {
        ArrayList<Product> productList = new ArrayList();
        try (PreparedStatement myStatement =
                     conn.prepareStatement("SELECT * FROM product"))
        {
            ResultSet resultSet = myStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPieces(resultSet.getInt("pieces"));
                productList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("SQL exception: " + e);
        }
        Product[] returnArray = new Product[productList.size()];
        return productList.toArray(returnArray);
    }
    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
