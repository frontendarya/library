package com.example.components.categorycontract;

import com.example.components.bookcontract.BookView;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Жанр книг")
public record CategoryViewWithBooks(
        @Schema(description = "ID жанра")
        Integer id,
        @Schema(description = "Название жанра")
        String name,
        @Schema(description = "Книги")
        List<BookView> books
) {
}
