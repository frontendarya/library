package com.example.components.bookcontract;

import com.example.components.categorycontract.CategoryView;
import com.example.components.authorcontract.AuthorView;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Книга, её авторы и категория")
public record BookViewWithAuthorsAndCategory(
        @Schema(description = "ID книги")
        Integer id,
        @Schema(description = "Авторы")
        List<AuthorView> authors,
        @Schema(description = "Название")
        String title,
        @Schema(description = "Жанр")
        CategoryView category
) {
}
