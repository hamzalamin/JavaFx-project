package com.wora.javafxproject.repositories.interfaces;

import com.wora.javafxproject.models.entities.Customer;
import com.wora.javafxproject.repositories.GenericRepository;

import java.util.Optional;

public interface CustomerRepository extends GenericRepository<Customer, Integer> {
    Optional<Customer> findByEmail(String email);
}