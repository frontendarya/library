package com.example.categoryservice.core.converter;

import com.example.components.categorycontract.CategoryView;
import com.example.components.categorycontract.CategoryViewWithBooks;
import com.example.categoryservice.core.dao.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    private final CategoryToCategoryView categoryToCategoryView;
    private final CategoryToCategoryViewWithBooks categoryToCategoryViewWithBooks;

    public CategoryConverter(CategoryToCategoryView categoryToCategoryView,
                             CategoryToCategoryViewWithBooks categoryToCategoryViewWithBooks) {
        this.categoryToCategoryView = categoryToCategoryView;
        this.categoryToCategoryViewWithBooks = categoryToCategoryViewWithBooks;
    }

    public CategoryView toView (Category category) {return categoryToCategoryView.convert(category);}

    public CategoryViewWithBooks toViewWithBooks(Category category) {return categoryToCategoryViewWithBooks.convert(category);}
}
