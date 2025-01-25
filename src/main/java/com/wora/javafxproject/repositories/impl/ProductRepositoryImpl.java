package com.wora.javafxproject.repositories.impl;

import com.wora.javafxproject.config.DatabaseConnection;
import com.wora.javafxproject.models.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl  {
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getDouble("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public void addProduct(Product product) {
        String query = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
