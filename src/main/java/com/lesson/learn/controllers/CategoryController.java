package com.lesson.learn.controllers;

import java.util.Arrays;

import javax.validation.Valid;

import com.lesson.learn.dto.CategoryDto;
import com.lesson.learn.dto.ResponseData;
import com.lesson.learn.models.entities.Category;
import com.lesson.learn.services.CategoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody CategoryDto categoryDto, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();        
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryDto, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
    public Iterable<Category> findAll(){
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") String id) {
        return categoryService.findOne(id);
    }

    @PutMapping
    public ResponseEntity<ResponseData<Category>> update(@Valid @RequestBody CategoryDto categoryDto, Errors errors) {
        ResponseData<Category> responseData = new ResponseData<>();        
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                responseData.getMessages().add(error.getDefaultMessage());
            }
            responseData.setStatus(false);
            responseData.setPayload(null);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }
        Category category = modelMapper.map(categoryDto, Category.class);

        responseData.setStatus(true);
        responseData.setPayload(categoryService.save(category));
        return ResponseEntity.ok(responseData);
    }

    @PostMapping(value="/search/{size}/{page}")
    public Iterable<Category> findByName(
        @RequestParam("name") String name,
        @PathVariable("size") int size,
        @PathVariable("page") int page
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        return categoryService.findByName(name, pageable);
    }

    @PostMapping(value="/search/{size}/{page}/{sort}")
    public Iterable<Category> findByName(
        @RequestParam("name") String name,
        @PathVariable("size") int size,
        @PathVariable("page") int page,
        @PathVariable("sort") String sort
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name"));
        if (sort.equalsIgnoreCase("desc")) {
            pageable = PageRequest.of(page, size, Sort.by("name").descending());
        }
        return categoryService.findByName(name, pageable);
    }
    
    @PostMapping("/batch")
    public ResponseEntity<ResponseData<Iterable<Category>>> createBatch(@RequestBody Category[] categories){
        ResponseData<Iterable<Category>> responseData = new ResponseData<>();
        responseData.setPayload(categoryService.saveBatch(Arrays.asList(categories)));
        responseData.setStatus(true);
        return ResponseEntity.ok(responseData);
    }
}
