package com.wora.javafxproject.repositories.interfaces;

import com.wora.javafxproject.models.entities.Invoice;
import com.wora.javafxproject.models.entities.Order;
import com.wora.javafxproject.repositories.GenericRepository;

import java.util.Optional;

public interface InvoiceRepository extends GenericRepository<Invoice, Integer> {
    Optional<Invoice> findByOrder(Order order);
}