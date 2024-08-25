package com.example.bookservice.core.handler;

import com.example.components.bookcontract.BookFindByTitleRequest;
import com.example.components.bookcontract.BookRequest;
import com.example.components.bookcontract.BookView;
import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookControllerHandler {
    private final DeleteBookByIdHandler deleteBookByIdHandler;
    private final FindBookByIdHandler findBookByIdHandler;
    private final FindByTitleHandler findByTittleHandler;
    private final SaveBookHandler saveBookHandler;
    private final GetBookDetailsHandler getBookDetailsHandler;

    public BookControllerHandler(DeleteBookByIdHandler deleteBookByIdHandler,
                                 FindBookByIdHandler findBookByIdHandler,
                                 FindByTitleHandler findByTittleHandler,
                                 SaveBookHandler saveBookHandler,
                                 GetBookDetailsHandler getBookDetailsHandler) {
        this.deleteBookByIdHandler = deleteBookByIdHandler;
        this.findBookByIdHandler = findBookByIdHandler;
        this.findByTittleHandler = findByTittleHandler;
        this.saveBookHandler = saveBookHandler;
        this.getBookDetailsHandler = getBookDetailsHandler;
    }

    public BookView save(BookRequest req) {
        return saveBookHandler.handle(req);
    }

    public BookView findById(Integer id) {
        return findBookByIdHandler.handle(id);
    }

    public List<BookView> findByTitle(BookFindByTitleRequest req) {
        return findByTittleHandler.handle(req);
    }

    public BookViewWithAuthorsAndCategory getDetailsById(Integer id) {
        return getBookDetailsHandler.handle(id);
    }
    public void deleteById(Integer bookId) {
        deleteBookByIdHandler.handle(bookId);
    }
}
