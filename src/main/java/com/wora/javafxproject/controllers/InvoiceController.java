package com.wora.javafxproject.controllers;


import com.wora.javafxproject.HelloApplication;
import com.wora.javafxproject.models.entities.Invoice;
import com.wora.javafxproject.models.entities.Order;
import com.wora.javafxproject.models.enums.OrderStatus;
import com.wora.javafxproject.repositories.interfaces.InvoiceRepository;
import com.wora.javafxproject.repositories.interfaces.OrderRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

import java.sql.SQLException;

public class InvoiceController {
    private InvoiceRepository invoiceRepository;
    private OrderRepository orderRepository;

    @FXML
    private ComboBox<Order> orderComboBox;
    @FXML private TableView<Invoice> invoicesTable;
    @FXML private Label totalAmountLabel;
    @FXML private DatePicker invoiceDatePicker;

    @FXML
    public void initialize() {
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
    public void deleteInvoice() throws SQLException {
        Invoice selectedInvoice = invoicesTable.getSelectionModel().getSelectedItem();
        if (selectedInvoice != null) {
            invoiceRepository.delete(selectedInvoice.getId());
            loadInvoices();
        }
    }

    public void goToProducts() {
        HelloApplication.navigateTo("products-view.fxml");
    }

    public void goToOrders() {
        HelloApplication.navigateTo("orders-view.fxml");
    }
}