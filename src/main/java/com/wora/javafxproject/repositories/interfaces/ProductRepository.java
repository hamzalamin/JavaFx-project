package com.wora.javafxproject.repositories.interfaces;

import com.wora.javafxproject.models.entities.Product;
import com.wora.javafxproject.repositories.GenericRepository;

import java.util.List;

public interface ProductRepository extends GenericRepository<Product, Integer> {
    List<Product> searchByKeyword(String keyword);
    List<Product> findByCategory(String category);
}
