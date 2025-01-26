package com.wora.javafxproject.controllers;

import com.wora.javafxproject.HelloApplication;
import com.wora.javafxproject.models.entities.Product;
import com.wora.javafxproject.repositories.interfaces.ProductRepository;
import com.wora.javafxproject.repositories.impl.ProductRepositoryImpl;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;

public class ProductController {
    private final ProductRepository productRepository;

    @FXML
    private TableView<Product> productTable;
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private ComboBox<String> categoryComboBox;
    @FXML
    private TextField stockField;
    @FXML
    private TableColumn<Product, String> name;
    @FXML
    private TableColumn<Product, Double> price;
    @FXML
    private TableColumn<Product, String> category;
    @FXML
    private TableColumn<Product, Integer> stock;

    public ProductController() {
        this.productRepository = new ProductRepositoryImpl();
    }

    @FXML
    public void initialize() {
        // Debugging: Check if FXML fields are injected correctly
        if (productTable == null || name == null || price == null || category == null || stock == null) {
            System.err.println("FXML injection failed. Check fx:id attributes in FXML file.");
            return;
        }

        // Set up category ComboBox
        categoryComboBox.getItems().addAll("Electronics", "Clothing", "Furniture", "Automotive");

        // Set up TableColumn bindings
        name.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        price.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPrice()));
        category.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
        stock.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getStock()));

        // Load products into the TableView
        loadProducts();
    }

    private void loadProducts() {
        try {
            ObservableList<Product> products = FXCollections.observableArrayList(productRepository.findAll());
            productTable.setItems(products);
        } catch (Exception e) {
            System.err.println("Error loading products: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void addProduct() {
        try {
            Product newProduct = new Product();
            newProduct.setName(nameField.getText());
            newProduct.setPrice(Double.parseDouble(priceField.getText()));
            newProduct.setCategory(categoryComboBox.getValue());
            newProduct.setStock(Integer.parseInt(stockField.getText()));

            productRepository.add(newProduct);
            loadProducts();
            clearFields();
        } catch (Exception e) {
            System.err.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void deleteProduct() {
        try {
            Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
            if (selectedProduct != null) {
                productRepository.delete(selectedProduct.getId());
                loadProducts();
            }
        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void clearFields() {
        nameField.clear();
        priceField.clear();
        categoryComboBox.setValue(null);
        stockField.clear();
    }

    @FXML
    public void goToOrders() {
        HelloApplication.navigateTo("order-view.fxml");
    }

    @FXML
    public void goToInvoices() {
        HelloApplication.navigateTo("invoice-view.fxml");
    }

    @FXML
    public void goToCustomer() {
        HelloApplication.navigateTo("customer-view.fxml");
    }
}