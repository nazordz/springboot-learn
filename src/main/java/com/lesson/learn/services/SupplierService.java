package com.lesson.learn.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.lesson.learn.models.entities.Supplier;
import com.lesson.learn.models.repos.SupplierRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SupplierService {
    
    @Autowired
    private SupplierRepo supplierRepo;

    public Supplier save(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    public Supplier findOne(String id){
        Optional<Supplier> supplier = supplierRepo.findById(id);
        if (supplier.isPresent()) {
            return supplier.get();
        }
        return null;
    }

    public Iterable<Supplier> findALl() {
        return supplierRepo.findAll();
    }

    public void removeOne(String id){
        supplierRepo.deleteById(id);
    }
}
