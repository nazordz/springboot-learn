package com.lesson.learn.services;

import java.util.Optional;

import javax.transaction.Transactional;

import com.lesson.learn.models.entities.Category;
import com.lesson.learn.models.repos.CategoryRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category findOne(String id) {
        Optional<Category> category = categoryRepo.findById(id);;
        if (category.isPresent()) {
            return category.get();
        }
        return null;
    }

    public Iterable<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void removeOne(String id) {
        categoryRepo.deleteById(id);
    }

    public Iterable<Category> findByName(String name, Pageable pageable){
        return categoryRepo.findByNameContains(name, pageable);
    }

    public Iterable<Category> saveBatch(Iterable<Category> categories){
        return categoryRepo.saveAll(categories);
    }
}
