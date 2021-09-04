package com.lesson.learn.models.repos;

import com.lesson.learn.models.entities.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepo extends PagingAndSortingRepository<Category, String> {

    public Page<Category> findByNameContains(String name, Pageable pageable);
}
