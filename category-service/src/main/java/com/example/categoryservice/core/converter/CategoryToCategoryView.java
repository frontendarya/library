package com.example.categoryservice.core.converter;

import com.example.components.categorycontract.CategoryView;
import com.example.categoryservice.core.dao.Category;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoryToCategoryView implements Converter<Category, CategoryView> {

    @Override
    public CategoryView convert(Category source) {
        return new CategoryView(
                source.getId(),
                source.getName()
        );
    }
}
