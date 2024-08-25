package com.example.components.bookcontract;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Книга")
public record BookView(
        @Schema(description = "ID книги")
        Integer id,
        @Schema(description = "Список ID авторов")
        List<Integer> authorId,
        @Schema(description = "Название")
        String title,
        @Schema(description = "ID жанра")
        Integer categoryId
) {
}
