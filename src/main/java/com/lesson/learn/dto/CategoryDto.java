package com.lesson.learn.dto;

import javax.validation.constraints.NotEmpty;

public class CategoryDto {
    
    private String id;
    
    @NotEmpty(message = "Name is required")
    private String name;

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
