package com.example.components.authorcontract;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Поиск книги по ФИО автора")
public record AuthorFindByFioRequest(
        @NotBlank String lastname,
        @NotBlank String firstname,
        String middlename,
        Boolean isNative) {
}
