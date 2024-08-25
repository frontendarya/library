package com.example.bookservice.core.converter;


import com.example.components.bookcontract.BookView;
import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.bookservice.core.dao.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {
    private final BookToBookView bookToBookView;
    private final BookToBookViewDetails bookToBookViewDetails;

    public BookConverter(BookToBookView bookToBookView,
                         BookToBookViewDetails bookToBookViewDetails) {
        this.bookToBookView = bookToBookView;
        this.bookToBookViewDetails = bookToBookViewDetails;
    }

    public BookView toBookView(Book book) {return bookToBookView.convert(book);}

    public BookViewWithAuthorsAndCategory toBookViewWithDetails(Book book) {return bookToBookViewDetails.convert(book);}
}
