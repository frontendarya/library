package com.example.authorservice.core.handler;

import com.example.components.authorcontract.AuthorFindByFioRequest;
import com.example.components.authorcontract.AuthorRequest;
import com.example.components.authorcontract.AuthorView;
import com.example.components.authorcontract.AuthorViewWithBooks;
import org.springframework.stereotype.Component;

@Component
public class AuthorControllerHandler {
    private final DeleteAuthorByIdHandler deleteAuthorByIdHandler;
    private final FindAllBooksByAuthorFioHandler findAllBooksByAuthorFioHandler;
    private final FindAllBooksByAuthorIdHandler findAllBooksByAuthorIdHandler;
    private final FindAuthorByIdHandler findAuthorByIdHandler;
    private final SaveAuthorHandler saveAuthorHandler;

    public AuthorControllerHandler(DeleteAuthorByIdHandler deleteAuthorByIdHandler,
                                   FindAllBooksByAuthorFioHandler findAllBooksByAuthorFioHandler,
                                   FindAllBooksByAuthorIdHandler findAllBooksByAuthorIdHandler,
                                   FindAuthorByIdHandler findAuthorByIdHandler,
                                   SaveAuthorHandler saveAuthorHandler){
        this.deleteAuthorByIdHandler = deleteAuthorByIdHandler;
        this.findAllBooksByAuthorFioHandler = findAllBooksByAuthorFioHandler;
        this.findAllBooksByAuthorIdHandler = findAllBooksByAuthorIdHandler;
        this.findAuthorByIdHandler = findAuthorByIdHandler;
        this.saveAuthorHandler = saveAuthorHandler;
    }

    public AuthorView save(AuthorRequest request){return saveAuthorHandler.handle(request);}

    public AuthorView findById(Integer id) {
        return findAuthorByIdHandler.handle(id);
    }

    public AuthorViewWithBooks findAllBooksByAuthorId(Integer id) {
        return findAllBooksByAuthorIdHandler.handle(id);
    }

    public AuthorViewWithBooks findAllBooksByAuthorFio(AuthorFindByFioRequest req) {
        return findAllBooksByAuthorFioHandler.handle(req);
    }

    public void deleteById(Integer authorId) {
        deleteAuthorByIdHandler.handle(authorId);
    }

}
