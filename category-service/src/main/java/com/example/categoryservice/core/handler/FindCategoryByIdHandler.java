package com.example.categoryservice.core.handler;

import com.example.components.categorycontract.CategoryView;
import com.example.categoryservice.core.converter.CategoryConverter;
import com.example.categoryservice.core.dao.Category;
import com.example.categoryservice.core.CategoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindCategoryByIdHandler {
    private final CategoryService service;
    private final CategoryConverter converter;

    public FindCategoryByIdHandler(CategoryService service,
                                   CategoryConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public CategoryView handle(Integer id) {
        Category category = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toView(category);
    }
}
