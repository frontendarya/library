package com.example.authorservice.core.handler;

import com.example.components.authorcontract.AuthorView;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.converter.AuthorConverter;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindAuthorByIdHandler {
    private final AuthorService service;
    private final AuthorConverter converter;

    public FindAuthorByIdHandler(AuthorService service,
                                 AuthorConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public AuthorView handle(Integer id) {
        return service.findById(id)
                .map(converter::toAuthorView)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }
}
