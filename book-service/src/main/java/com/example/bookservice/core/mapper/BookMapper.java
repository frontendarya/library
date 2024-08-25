package com.example.bookservice.core.mapper;

import com.example.components.bookcontract.BookFindByTitleRequest;
import com.example.components.bookcontract.BookRequest;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.dao.Author;
import com.example.bookservice.core.dao.Book;
import com.example.categoryservice.core.CategoryService;
import com.example.categoryservice.core.dao.Category;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class BookMapper {

    CategoryService categoryService;
    AuthorService authorService;

    public BookMapper(CategoryService categoryService,
                      AuthorService authorService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @NotNull
    public Book applyRequest(Book prototype, @NotNull BookRequest req, Category category, Set<Author> authorSet) {
        prototype.setId(req.id());
        prototype.setAuthors(authorSet);
        prototype.setTitle(req.title());
        prototype.setCategory(category);
        return prototype;
    }

    @NotNull
    public Book applyFindByTitleRequest(Book prototype, @NotNull BookFindByTitleRequest req) {
        prototype.setTitle(req.title());
        return prototype;
    }
}