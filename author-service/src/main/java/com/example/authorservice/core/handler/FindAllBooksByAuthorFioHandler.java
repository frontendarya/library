package com.example.authorservice.core.handler;

import com.example.components.authorcontract.AuthorFindByFioRequest;
import com.example.components.authorcontract.AuthorViewWithBooks;
import com.example.authorservice.core.dao.Author;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.converter.AuthorConverter;
import com.example.authorservice.core.mapper.AuthorMapper;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindAllBooksByAuthorFioHandler {
    private final AuthorService service;
    private final AuthorMapper mapper;
    private final AuthorConverter converter;

    public FindAllBooksByAuthorFioHandler(AuthorService service,
                                          AuthorMapper mapper,
                                          AuthorConverter converter) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Transactional
    public AuthorViewWithBooks handle(AuthorFindByFioRequest req) {
        Author author = service.findAllBooksByAuthorFio(mapper.applyFindByFioRequest(new Author(), req));
        if (author == null) {
            throw new ResourceNotFoundException("Books not found");
        }
        return converter.toAuthorViewWithBooks(author);

    }
}
