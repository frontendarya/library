package com.example.authorservice.core.handler;

import com.example.authorservice.core.AuthorService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteAuthorByIdHandler {
    private final AuthorService service;

    public DeleteAuthorByIdHandler(AuthorService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer authorId) {
        service.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
        service.delete(authorId);
    }
}
