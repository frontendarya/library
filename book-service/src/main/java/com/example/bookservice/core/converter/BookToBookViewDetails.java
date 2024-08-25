package com.example.bookservice.core.converter;

import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.authorservice.core.converter.AuthorConverter;
import com.example.bookservice.core.dao.Book;
import com.example.categoryservice.core.converter.CategoryConverter;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookViewDetails implements Converter<Book, BookViewWithAuthorsAndCategory> {
    private final AuthorConverter authorConverter;
    private final CategoryConverter categoryConverter;

    public BookToBookViewDetails(@Lazy AuthorConverter authorConverter,
                                 @Lazy CategoryConverter categoryConverter) {
        this.authorConverter = authorConverter;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public BookViewWithAuthorsAndCategory convert(Book source){
        return new BookViewWithAuthorsAndCategory(
                source.getId(),
                source.getAuthors().stream()
                        .map(authorConverter::toAuthorView).toList(),
                source.getTitle(),
                categoryConverter.toView(source.getCategory())
        );
    }
}
