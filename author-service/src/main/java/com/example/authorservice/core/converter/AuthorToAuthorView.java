package com.example.authorservice.core.converter;

import com.example.components.authorcontract.AuthorView;
import com.example.authorservice.core.dao.Author;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorView implements Converter<Author, AuthorView> {

    @Override
    public AuthorView convert(Author source) {
        return new AuthorView(
                source.getId(),
                source.getLastname(),
                source.getFirstname(),
                source.getMiddlename(),
                source.getNative()
        );
    }
}
