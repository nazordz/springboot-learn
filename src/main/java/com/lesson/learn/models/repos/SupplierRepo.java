package com.lesson.learn.models.repos;

import com.lesson.learn.models.entities.Supplier;

import org.springframework.data.repository.CrudRepository;

public interface SupplierRepo extends CrudRepository<Supplier, String> {
    
}
