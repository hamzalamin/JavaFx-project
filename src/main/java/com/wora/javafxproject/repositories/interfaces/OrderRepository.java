package com.wora.javafxproject.repositories.interfaces;

import com.wora.javafxproject.models.entities.Customer;
import com.wora.javafxproject.models.entities.Order;
import com.wora.javafxproject.models.enums.OrderStatus;
import com.wora.javafxproject.repositories.GenericRepository;

import java.util.List;

public interface OrderRepository extends GenericRepository<Order, Integer> {
    List<Order> findByCustomer(Customer customer);
    List<Order> findByStatus(OrderStatus status);
}