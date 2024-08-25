package com.example.components.bookcontract;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Поиск книги по названию")
public record BookFindByTitleRequest(
        @NotBlank String title
) {
}
