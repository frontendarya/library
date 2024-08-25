package com.example.categoryservice.core.handler;

import com.example.categoryservice.core.CategoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteCategoryByIdHandler {
    private final CategoryService service;

    public DeleteCategoryByIdHandler(CategoryService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer categoryId) {
        service.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
        service.delete(categoryId);
    }
}
