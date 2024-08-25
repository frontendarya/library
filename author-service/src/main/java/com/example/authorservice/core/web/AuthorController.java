package com.example.authorservice.core.web;

import com.example.components.authorcontract.AuthorFindByFioRequest;
import com.example.components.authorcontract.AuthorRequest;
import com.example.components.authorcontract.AuthorView;
import com.example.components.authorcontract.AuthorViewWithBooks;
import com.example.*;
import com.example.authorservice.core.handler.AuthorControllerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authors")
@Validated
@Tag(name = "Авторы")
public class AuthorController {

    private final AuthorControllerHandler authorControllerHandler;
    public AuthorController(AuthorControllerHandler authorControllerHandler) {this.authorControllerHandler = authorControllerHandler;}

    @Operation(summary = "Создать")
    @Validated(OnCreate.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public AuthorView create(@Valid @RequestBody @NotNull AuthorRequest request){
        return authorControllerHandler.save(request);
    }

    @Operation(summary = "Изменить")
    @Validated(OnUpdate.class)
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    @ResponseBody
    public AuthorView updateById(@Valid @RequestBody @NotNull AuthorRequest request){
        return authorControllerHandler.save(request);
    }

    @Operation(summary = "Найти автора по ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{authorId}")
    @ResponseBody
    public AuthorView findById(@PathVariable @NotNull Integer authorId){
        return authorControllerHandler.findById(authorId);
    }

    @Operation(summary = "Найти книги по ID автора")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/all/{authorId}")
    @ResponseBody
    public AuthorViewWithBooks findAllBooksByAuthorId(@PathVariable @NotNull Integer authorId){
        return authorControllerHandler.findAllBooksByAuthorId(authorId);
    }

    @Operation(summary = "Найти книги по ФИО автора")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/fio")
    @ResponseBody
    public AuthorViewWithBooks findAllBooksByAuthorFio(@Valid @RequestBody @NotNull AuthorFindByFioRequest request){
        return authorControllerHandler.findAllBooksByAuthorFio(request);
    }

    @Operation(summary = "Удалить")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{authorId}")
    public void deleteById(@PathVariable @NotNull Integer authorId){
        authorControllerHandler.deleteById(authorId);
    }
}