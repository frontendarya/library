package com.example.components.customercontract;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Посетители")
public record CustomerView(
        @Schema(description = "ID посетителя")
        Integer id,
        @Schema(description = "Фамилия")
        String lastname,
        @Schema(description = "Имя")
        String firstname,
        @Schema(description = "Отчество (если есть)")
        String middlename
) {
}
