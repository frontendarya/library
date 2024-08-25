package com.example.bookservice.core.converter;


import com.example.components.bookcontract.BookView;
import com.example.authorservice.core.dao.Author;
import com.example.bookservice.core.dao.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookView implements Converter<Book, BookView> {

    @Override
    public BookView convert(Book source) {
        return new BookView(
                source.getId(),
                source.getAuthors().stream()
                        .map(Author::getId).toList(),
                source.getTitle(),
                source.getCategory().getId()
        );
    }
}
