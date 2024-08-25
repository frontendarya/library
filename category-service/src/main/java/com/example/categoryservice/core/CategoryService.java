package com.example.categoryservice.core;

import com.example.categoryservice.core.dao.Category;
import com.example.categoryservice.core.dao.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public Category update(Integer categoryId, Category category) {
        return categoryRepository.updateById(categoryId,
                category.getName());
    }

    public Optional<Category> findById(Integer categoryId) {
        return categoryRepository.findById(categoryId);
    }

    public Category findAllByCategoryName(String name) {
        return categoryRepository.findAllByCategoryName(name.toLowerCase());
    }

    public void delete(Integer categoryId) { categoryRepository.deleteById(categoryId); }
}
