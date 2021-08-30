package com.lesson.learn.models.repos;

import com.lesson.learn.models.entities.Category;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, String> {
    
}
