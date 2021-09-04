package com.lesson.learn.models.repos;

import java.util.List;

import com.lesson.learn.models.entities.Supplier;

import org.springframework.data.repository.CrudRepository;
/**
 * Example for using Derived Query
 */
public interface SupplierRepo extends CrudRepository<Supplier, String> {
    
    public Supplier findByEmail(String email);

    List<Supplier> findByNameContainsOrderByNameDesc(String name);

    List<Supplier> findByNameStartingWith(String prefix);

    List<Supplier> findByNameContainsOrEmailContains(String name, String email);
}
