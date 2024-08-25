package com.example.authorservice.core.converter;

import com.example.components.authorcontract.AuthorView;
import com.example.components.authorcontract.AuthorViewWithBooks;
import com.example.authorservice.core.dao.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorConverter {
    private final AuthorToAuthorView authorToAuthorView;
    private final AuthorToAuthorViewWithBooks authorToAuthorViewWithBooks;

    public AuthorConverter(AuthorToAuthorView authorToAuthorView,
                           AuthorToAuthorViewWithBooks authorToAuthorViewWithBooks) {
        this.authorToAuthorView = authorToAuthorView;
        this.authorToAuthorViewWithBooks = authorToAuthorViewWithBooks;
    }

    public AuthorView toAuthorView(Author author) {
        return authorToAuthorView.convert(author);
    }

    public AuthorViewWithBooks toAuthorViewWithBooks(Author author) {
        return authorToAuthorViewWithBooks.convert(author);
    }
}
