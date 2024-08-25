package com.example.categoryservice.core.handler;

import com.example.components.categorycontract.CategoryFindByNameRequest;
import com.example.components.categorycontract.CategoryViewWithBooks;
import com.example.categoryservice.core.converter.CategoryConverter;
import com.example.categoryservice.core.dao.Category;
import com.example.categoryservice.core.mapper.CategoryMapper;
import com.example.categoryservice.core.CategoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindByCategoryNameHandler {
    private final CategoryService service;
    private final CategoryConverter converter;
    private final CategoryMapper mapper;

    public FindByCategoryNameHandler(CategoryService service,
                                     CategoryConverter converter,
                                     CategoryMapper mapper) {
        this.service = service;
        this.converter = converter;
        this.mapper = mapper;
    }

    @Transactional
    public CategoryViewWithBooks handle(CategoryFindByNameRequest req) {
        Category category = service.findAllByCategoryName(mapper.applyFindByIdRequest(new Category(), req).getName());
        if (category == null) {
            throw new ResourceNotFoundException("Category not found");
        }else{
            return converter.toViewWithBooks(category);
        }
    }
}
