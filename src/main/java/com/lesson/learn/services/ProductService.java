package com.lesson.learn.services;

import javax.transaction.Transactional;

import com.lesson.learn.models.entities.Product;
import com.lesson.learn.models.entities.Supplier;
import com.lesson.learn.models.repos.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService {
    
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private SupplierService supplierService;

    public Product save(Product product){
        return productRepo.save(product);
    }

    public Product findOne(String id){
        Optional<Product> product = productRepo.findById(id);
        if (!product.isPresent()) {
            return null;
        }
        return product.get();
    }

    public Iterable<Product> findAll() {
        return productRepo.findAll();
    }

    public void removeOne(String id) {
        productRepo.deleteById(id);
    }

    public List<Product> findByName(String name){
        return productRepo.findByNameContains(name);
    }

    public Product findProductByName(String name){
        return productRepo.findProductByName(name);
    }
    public List<Product> findProductByNameLike(String name){
        return productRepo.findProductByNameLike("%" + name + "%");
    }

    public List<Product> findByCategory(String categoryId){
        return productRepo.findProductByCategory(categoryId);
    }

    public List<Product> findBySupplier(String supplierId){
        Supplier supplier = supplierService.findOne(supplierId);
        if (supplier == null) {
            return new ArrayList<Product>();
        }
        return productRepo.findProductBySupplier(supplier);
    }
}
