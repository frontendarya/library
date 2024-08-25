package com.example.authorservice.core.handler;

import com.example.components.authorcontract.AuthorViewWithBooks;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.converter.AuthorConverter;
import com.example.authorservice.core.dao.Author;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindAllBooksByAuthorIdHandler {
    private final AuthorService service;
    private final AuthorConverter converter;

    public FindAllBooksByAuthorIdHandler(AuthorService service,
                           AuthorConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public AuthorViewWithBooks handle(Integer id) {
        service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        Author author = service.findAllBooksByAuthorId(id);
        if (author == null) {
            throw new ResourceNotFoundException("Books not found");
        }
        return converter.toAuthorViewWithBooks(author);
    }
}
