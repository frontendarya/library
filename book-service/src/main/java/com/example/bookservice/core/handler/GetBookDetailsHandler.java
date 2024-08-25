package com.example.bookservice.core.handler;

import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.bookservice.core.BookService;
import com.example.bookservice.core.converter.BookConverter;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class GetBookDetailsHandler {
    private final BookService service;
    private final BookConverter converter;

    public GetBookDetailsHandler(BookService service,
                             BookConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public BookViewWithAuthorsAndCategory handle(Integer id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toBookViewWithDetails(service.getDetailsById(id));
    }
}
