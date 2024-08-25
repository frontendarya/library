package com.example.bookservice.core.web;

import com.example.components.bookcontract.BookFindByTitleRequest;
import com.example.components.bookcontract.BookRequest;
import com.example.components.bookcontract.BookView;
import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.*;
import com.example.bookservice.core.handler.BookControllerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/books")
@Validated
@Tag(name = "Книги")
public class BookController {
    private final BookControllerHandler bookHandler;
    public BookController(BookControllerHandler bookHandler){this.bookHandler = bookHandler;}

    @Operation(summary = "Создать")
    @Validated(OnCreate.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public BookView create(@Valid @RequestBody BookRequest request){
        return bookHandler.save(request);
    }

    @Operation(summary = "Изменить")
    @Validated(OnUpdate.class)
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    @ResponseBody
    public BookView updateById(@Valid @RequestBody BookRequest request){
        return bookHandler.save(request);
    }

    @Operation(summary = "Найти по ID")
    @GetMapping("/{bookId}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BookView findById(@PathVariable @NotNull Integer bookId){
        return bookHandler.findById(bookId);
    }

    @Operation(summary = "Найти по названию", tags = {"Книги"})
    @GetMapping("/title")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<BookView> findByTitle(@Valid @RequestBody BookFindByTitleRequest request){
        return bookHandler.findByTitle(request);
    }

    @Operation(summary = "Получить информацию о книге")
    @GetMapping("/{bookId}/details")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public BookViewWithAuthorsAndCategory getDetailsById(@PathVariable @NotNull Integer bookId){
        return bookHandler.getDetailsById(bookId);
    }

    @Operation(summary = "Удалить")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{bookId}")
    public void deleteById(@PathVariable @NotNull Integer bookId){
        bookHandler.deleteById(bookId);
    }
}
