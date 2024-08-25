package com.example.components.categorycontract;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Жанр")
public record CategoryView(
        @Schema(description = "ID жанра")
        Integer id,
        @Schema(description = "Название жанра")
        String name
) {
}
