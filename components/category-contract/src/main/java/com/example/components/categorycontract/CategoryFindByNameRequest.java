package com.example.components.categorycontract;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Поиск книги по жанру")
public record CategoryFindByNameRequest(@NotBlank String name) {
}
