package com.example.bookservice.core.handler;

import com.example.components.bookcontract.BookRequest;
import com.example.components.bookcontract.BookView;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.dao.Author;
import com.example.bookservice.core.BookService;
import com.example.bookservice.core.converter.BookConverter;
import com.example.bookservice.core.dao.Book;
import com.example.bookservice.core.mapper.BookMapper;
import com.example.categoryservice.core.CategoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class SaveBookHandler {
    private final BookService service;
    private final BookMapper mapper;
    private final BookConverter converter;
    private final CategoryService categoryService;
    private final AuthorService authorService;

    public SaveBookHandler(BookService service,
                           BookMapper mapper,
                           BookConverter converter,
                           CategoryService categoryService,
                           AuthorService authorService) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
        this.categoryService = categoryService;
        this.authorService = authorService;
    }

    @Transactional
    public BookView handle(BookRequest req) {
        Set<Author> authors = new HashSet<>();

        var book = req.id() == null ? new Book() :
                service.findById(req.id()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var category = categoryService.findById(req.categoryId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        for(Integer id : req.authorsId()){
            authors.add(authorService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found")));
        }

        book = mapper.applyRequest(book, req, category, authors);
        book = service.save(book);
        return converter.toBookView(book);
    }

}
