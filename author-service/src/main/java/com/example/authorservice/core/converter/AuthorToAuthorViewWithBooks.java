package com.example.authorservice.core.converter;

import com.example.components.authorcontract.AuthorViewWithBooks;
import com.example.authorservice.core.dao.Author;
import com.example.bookservice.core.converter.BookConverter;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToAuthorViewWithBooks implements Converter<Author, AuthorViewWithBooks> {
    private final BookConverter bookConverter;

    public AuthorToAuthorViewWithBooks(@Lazy BookConverter bookConverter) {
        this.bookConverter = bookConverter;
    }

    @Override
    public AuthorViewWithBooks convert(Author source){
        return new AuthorViewWithBooks(
                source.getId(),
                source.getLastname(),
                source.getFirstname(),
                source.getMiddlename(),
                source.getNative(),
                source.getBooks().stream().map(bookConverter::toBookView).toList()
        );
    }
}
