package com.example.bookservice.core.handler;

import com.example.components.bookcontract.BookFindByTitleRequest;
import com.example.components.bookcontract.BookView;
import com.example.bookservice.core.BookService;
import com.example.bookservice.core.converter.BookConverter;
import com.example.bookservice.core.dao.Book;
import com.example.bookservice.core.mapper.BookMapper;
import com.example.libs.common.error.ResourceNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindByTitleHandler {
    private final BookService service;
    private final BookConverter converter;
    private final BookMapper mapper;

    public FindByTitleHandler(BookService service,
                              BookConverter converter,
                              BookMapper mapper) {
        this.service = service;
        this.converter = converter;
        this.mapper = mapper;
    }

    public List<BookView> handle(BookFindByTitleRequest req) {
        List<Book> books = service.findByTitle(mapper.applyFindByTitleRequest(new Book(), req).getTitle());
        if (books.isEmpty()) {
            throw new ResourceNotFoundException("No such title: " + req.title());
        }
        return books.stream().map(converter::toBookView).toList();
    }
}
