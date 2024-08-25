package com.example.bookservice.core.handler;

import com.example.components.bookcontract.BookView;
import com.example.bookservice.core.BookService;
import com.example.bookservice.core.converter.BookConverter;
import com.example.bookservice.core.dao.Book;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindBookByIdHandler {
    private final BookService service;
    private final BookConverter converter;

    public FindBookByIdHandler(BookService service,
                               BookConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public BookView handle(Integer id) {
        Book book = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toBookView(book);
    }
}
