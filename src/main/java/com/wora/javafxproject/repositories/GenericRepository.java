package com.wora.javafxproject.repositories.api;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T, ID> {
    void add(T entity);
    void update(T entity);
    void delete(ID id);
    Optional<T> findById(ID id);
    List<T> findAll();
}