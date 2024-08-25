package com.example.categoryservice.core.converter;

import com.example.components.bookcontract.BookView;
import com.example.components.categorycontract.CategoryViewWithBooks;
import com.example.bookservice.core.converter.BookConverter;
import com.example.categoryservice.core.dao.Category;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryToCategoryViewWithBooks implements Converter<Category, CategoryViewWithBooks> {
    private final BookConverter bookConverter;

    public CategoryToCategoryViewWithBooks(@Lazy BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }

    @Override
    public CategoryViewWithBooks convert(Category source){
        List<BookView> books = source.getBooks().stream().map(bookConverter::toBookView).toList();

        return new CategoryViewWithBooks(
                source.getId(),
                source.getName(),
                books
        );
    }
}
