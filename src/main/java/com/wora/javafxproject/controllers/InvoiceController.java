package com.wora.javafxproject.controllers;


import com.wora.javafxproject.HelloApplication;
import com.wora.javafxproject.models.entities.Invoice;
import com.wora.javafxproject.models.entities.Order;
import com.wora.javafxproject.models.enums.OrderStatus;
import com.wora.javafxproject.repositories.impl.CustomerRepositoryImpl;
import com.wora.javafxproject.repositories.impl.InvoiceRepositoryImpl;
import com.wora.javafxproject.repositories.impl.OrderRepositoryImpl;
import com.wora.javafxproject.repositories.impl.ProductRepositoryImpl;
import com.wora.javafxproject.repositories.interfaces.CustomerRepository;
import com.wora.javafxproject.repositories.interfaces.InvoiceRepository;
import com.wora.javafxproject.repositories.interfaces.OrderRepository;
import com.wora.javafxproject.repositories.interfaces.ProductRepository;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;

public class InvoiceController {
    private final InvoiceRepository invoiceRepository;
    private final OrderRepository orderRepository;

    public InvoiceController() {
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        ProductRepository productRepository = new ProductRepositoryImpl();
        this.orderRepository = new OrderRepositoryImpl(customerRepository, productRepository);
        this.invoiceRepository = new InvoiceRepositoryImpl(orderRepository);
    }


    @FXML
    private ComboBox<Order> orderComboBox;
    @FXML private TableView<Invoice> invoicesTable;
    @FXML private Label totalAmountLabel;
    @FXML private DatePicker invoiceDatePicker;

    @FXML private TableColumn<Invoice, Integer> idColumn;
    @FXML private TableColumn<Invoice, Integer> orderIdColumn;
    @FXML private TableColumn<Invoice, LocalDate> invoiceDateColumn;
    @FXML private TableColumn<Invoice, Double> totalAmountColumn;

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        orderIdColumn.setCellValueFactory(cellData ->
                new SimpleObjectProperty<>(cellData.getValue().getOrder().getId()));
        invoiceDateColumn.setCellValueFactory(new PropertyValueFactory<>("invoiceDate"));
        totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

        loadOrders();
        loadInvoices();
    }

    private void loadOrders() {
        orderComboBox.setItems(
                FXCollections.observableArrayList(
                        orderRepository.findByStatus(OrderStatus.VALIDATED)
                )
        );

    }

    private void loadInvoices() {
        invoicesTable.setItems(
                FXCollections.observableArrayList(invoiceRepository.findAll())
        );
    }

    @FXML
    public void selectOrder() {
        Order selectedOrder = orderComboBox.getValue();
        if (selectedOrder != null) {
            totalAmountLabel.setText(String.format("%.2f", selectedOrder.getTotalAmount()));
        }
    }

    @FXML
    public void generateInvoice() {
        Order selectedOrder = orderComboBox.getValue();
        if (selectedOrder != null) {
            Invoice invoice = new Invoice();
            invoice.setOrder(selectedOrder);
            invoice.setInvoiceDate(invoiceDatePicker.getValue());
            invoice.setTotalAmount(selectedOrder.getTotalAmount());

            invoiceRepository.add(invoice);
            loadInvoices();
        }
    }

    @FXML
    public void updateInvoice() {
        Invoice selectedInvoice = invoicesTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice != null) {
            Order selectedOrder = orderComboBox.getValue();
            LocalDate selectedDate = invoiceDatePicker.getValue();

            if (selectedOrder != null) {
                selectedInvoice.setOrder(selectedOrder);
                selectedInvoice.setTotalAmount(selectedOrder.getTotalAmount());
            }
            if (selectedDate != null) {
                selectedInvoice.setInvoiceDate(selectedDate);
            }

            System.out.println("Selected Invoice: " + selectedInvoice.getId());
            invoiceRepository.update(selectedInvoice);

            loadInvoices();
        } else {
            showAlert("No Invoice Selected", "Please select an invoice to update.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    public void deleteInvoice() throws SQLException {
        Invoice selectedInvoice = invoicesTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice != null) {
            invoiceRepository.delete(selectedInvoice.getId());
            loadInvoices();
        }
    }

    @FXML
    public void goToProducts() {
        HelloApplication.navigateTo("products-view.fxml");
    }

    @FXML
    public void goToOrders() {
        HelloApplication.navigateTo("order-view.fxml");
    }

    @FXML
    public void goToCustomer() {
        HelloApplication.navigateTo("customer-view.fxml");
    }

    @FXML
    public void goToInvoices() {
        HelloApplication.navigateTo("invoice-view.fxml");
    }

}