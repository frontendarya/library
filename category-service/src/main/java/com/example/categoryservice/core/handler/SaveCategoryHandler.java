package com.example.categoryservice.core.handler;

import com.example.components.categorycontract.CategoryRequest;
import com.example.components.categorycontract.CategoryView;
import com.example.categoryservice.core.converter.CategoryConverter;
import com.example.categoryservice.core.dao.Category;
import com.example.categoryservice.core.mapper.CategoryMapper;
import com.example.categoryservice.core.CategoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveCategoryHandler {
    private final CategoryService service;
    private final CategoryMapper mapper;
    private final CategoryConverter converter;

    public SaveCategoryHandler(CategoryService service,
                               CategoryMapper mapper,
                               CategoryConverter converter) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Transactional
    public CategoryView handle(CategoryRequest req) {
        var category = req.id() == null ? new Category() :
                service.findById(req.id()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        category = mapper.applyRequest(category, req);
        category = service.save(category);
        return converter.toView(category);
    }
}
