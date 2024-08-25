package com.example.authorservice.core.mapper;

import com.example.components.authorcontract.AuthorFindByFioRequest;
import com.example.components.authorcontract.AuthorRequest;
import com.example.authorservice.core.dao.Author;

import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    @NotNull
    public Author applyRequest(Author prototype, @NotNull AuthorRequest req) {
        prototype.setId(req.id());
        prototype.setLastname(req.lastname());
        prototype.setFirstname(req.firstname());
        prototype.setMiddlename(req.middlename());
        prototype.setNative(req.isNative());
        return prototype;
    }

    @NotNull
    public Author applyFindByFioRequest(Author prototype, @NotNull AuthorFindByFioRequest req) {
        prototype.setLastname(req.lastname());
        prototype.setFirstname(req.firstname());
        prototype.setMiddlename(req.middlename());
        prototype.setNative(req.isNative());
        return prototype;
    }
}
