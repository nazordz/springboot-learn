package com.lesson.learn.models.repos;

import java.util.List;

import javax.websocket.server.PathParam;

import com.lesson.learn.models.entities.Product;
import com.lesson.learn.models.entities.Supplier;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * Example for using custom query
 */
public interface ProductRepo extends CrudRepository<Product, String> {
    
    List<Product> findByNameContains(String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product findProductByName(@PathParam("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE :name")
    public List<Product> findProductByNameLike(@PathParam("name") String name);

    @Query("FROM Product WHERE category.id = :categoryId")
    public List<Product> findProductByCategory(@PathParam("categoryId") String categoryId);

    @Query("FROM Product WHERE :supplier MEMBER OF suppliers")
    public List<Product> findProductBySupplier(@PathVariable("supplier") Supplier supplier);
}
