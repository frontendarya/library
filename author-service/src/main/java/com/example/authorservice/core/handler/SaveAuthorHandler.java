package com.example.authorservice.core.handler;

import com.example.components.authorcontract.AuthorRequest;
import com.example.components.authorcontract.AuthorView;
import com.example.authorservice.core.converter.AuthorConverter;
import com.example.authorservice.core.dao.Author;
import com.example.authorservice.core.AuthorService;
import com.example.authorservice.core.mapper.AuthorMapper;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveAuthorHandler {
    private final AuthorService service;
    private final AuthorMapper mapper;
    private final AuthorConverter converter;

    public SaveAuthorHandler(AuthorService service,
                             AuthorMapper mapper,
                             AuthorConverter converter) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Transactional
    public AuthorView handle(AuthorRequest req) {
        var author = req.id() == null ? new Author() :
                service.findById(req.id()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        author = mapper.applyRequest(author, req);
        service.save(author);
        return converter.toAuthorView(author);
    }
}
