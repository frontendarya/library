package com.example.categoryservice.core.web;

import com.example.components.categorycontract.CategoryFindByNameRequest;
import com.example.components.categorycontract.CategoryRequest;
import com.example.components.categorycontract.CategoryView;
import com.example.components.categorycontract.CategoryViewWithBooks;
import com.example.*;
import com.example.categoryservice.core.handler.CategoryControllerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
@Tag(name = "Категории")
public class CategoryController {

    private final CategoryControllerHandler categoryHandler;
    public CategoryController(CategoryControllerHandler categoryHandler) {this.categoryHandler = categoryHandler;}

    @Operation(summary = "Создать")
    @Validated(OnCreate.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public CategoryView create(@Valid @RequestBody @NotNull CategoryRequest request){
        return categoryHandler.save(request);
    }

    @Operation(summary = "Изменить")
    @Validated(OnUpdate.class)
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    @ResponseBody
    public CategoryView updateById(@Valid @RequestBody CategoryRequest request){
        return categoryHandler.updateById(request);
    }

    @Operation(summary = "Найти по ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{categoryId}")
    @ResponseBody
    public CategoryView findAllById(@PathVariable @NotNull Integer categoryId){
        return categoryHandler.findById(categoryId);
    }

    @Operation(summary = "Найти книги по названию категории")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/name")
    @ResponseBody
    public CategoryViewWithBooks findAllByCategoryName(@Valid @RequestBody @NotNull CategoryFindByNameRequest request){
        return categoryHandler.findAllByCategoryName(request);
    }

    @Operation(summary = "Удалить")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{categoryId}")
    public void deleteById(@PathVariable @NotNull Integer categoryId){
        categoryHandler.deleteById(categoryId);
    }
}
