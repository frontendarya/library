package com.example.bookservice.core.handler;

import com.example.bookservice.core.BookService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteBookByIdHandler {
    private final BookService service;

    public DeleteBookByIdHandler(BookService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer bookId) {
        service.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        service.delete(bookId);
    }
}
