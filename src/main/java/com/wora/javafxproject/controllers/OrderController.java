package com.wora.javafxproject.controllers;

import com.wora.javafxproject.HelloApplication;
import com.wora.javafxproject.models.entities.Customer;
import com.wora.javafxproject.models.entities.Order;
import com.wora.javafxproject.models.entities.OrderItem;
import com.wora.javafxproject.models.entities.Product;
import com.wora.javafxproject.models.enums.OrderStatus;
import com.wora.javafxproject.repositories.impl.CustomerRepositoryImpl;
import com.wora.javafxproject.repositories.impl.OrderRepositoryImpl;
import com.wora.javafxproject.repositories.impl.ProductRepositoryImpl;
import com.wora.javafxproject.repositories.interfaces.CustomerRepository;
import com.wora.javafxproject.repositories.interfaces.OrderRepository;
import com.wora.javafxproject.repositories.interfaces.ProductRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

public class OrderController {
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;

    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> id;
    @FXML
    private TableColumn<Order, String> customer;
    @FXML
    private TableColumn<Order, String> orderDate;
    @FXML
    private TableColumn<Order, String> status;
    @FXML
    private TableColumn<Order, Double> totalAmount;

    @FXML
    private ComboBox<Customer> customerComboBox;
    @FXML
    private ComboBox<Product> productComboBox;
    @FXML
    private TextField quantityField;
    @FXML
    private TableView<OrderItem> orderItemsTable;
    @FXML
    private Label totalAmountLabel;

    private Order currentOrder = new Order();

    public OrderController() {
        this.customerRepository = new CustomerRepositoryImpl();
        this.productRepository = new ProductRepositoryImpl();
        this.orderRepository = new OrderRepositoryImpl(customerRepository, productRepository);
    }

    @FXML
    public void initialize() {
        id.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getId()));
        customer.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCustomer().getFirstName()));
        orderDate.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getOrderDate().toString()));
        status.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getStatus().toString()));
        totalAmount.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getTotalAmount()));

        loadCustomers();
        loadProducts();
        setupOrderItemsTable();
        loadOrders();
    }

    private void loadOrders() {
        ObservableList<Order> orders = FXCollections.observableArrayList(orderRepository.findAll());
        orderTable.setItems(orders);
    }

    private void loadCustomers() {
        customerComboBox.setItems(FXCollections.observableArrayList(customerRepository.findAll()));
    }

    private void loadProducts() {
        productComboBox.setItems(FXCollections.observableArrayList(productRepository.findAll()));
    }

    private void setupOrderItemsTable() {
        TableColumn<OrderItem, String> productColumn = new TableColumn<>("Product");
        productColumn.setCellValueFactory(new PropertyValueFactory<>("product"));

        TableColumn<OrderItem, Integer> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<OrderItem, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        orderItemsTable.getColumns().addAll(productColumn, quantityColumn, priceColumn);
    }

    @FXML
    public void addOrderItem() {
        Product selectedProduct = productComboBox.getValue();
        int quantity = Integer.parseInt(quantityField.getText());

        OrderItem orderItem = new OrderItem(selectedProduct, quantity);
        currentOrder.addOrderItem(orderItem);

        orderItemsTable.setItems(FXCollections.observableArrayList(currentOrder.getOrderItems()));
        totalAmountLabel.setText(String.format("%.2f", currentOrder.getTotalAmount()));
    }

    @FXML
    public void createOrder() {
        currentOrder.setCustomer(customerComboBox.getValue());
        currentOrder.setOrderDate(LocalDate.now());
        currentOrder.setStatus(OrderStatus.PENDING);

        orderRepository.add(currentOrder);
        loadOrders();
        resetOrder();
    }

    private void resetOrder() {
        currentOrder = new Order();
        orderItemsTable.getItems().clear();
        totalAmountLabel.setText("0.00");
    }

    @FXML
    public void updateOrderStatus() {
        Order selectedOrder = orderTable.getSelectionModel().getSelectedItem();
        if (selectedOrder != null) {
            selectedOrder.setStatus(OrderStatus.VALIDATED);
            orderRepository.update(selectedOrder);
            loadOrders();
        }
    }

    @FXML
    public void goToProducts() {
        HelloApplication.navigateTo("product-view.fxml");
    }

    @FXML
    public void goToInvoices() {
        HelloApplication.navigateTo("invoice-view.fxml");
    }
}