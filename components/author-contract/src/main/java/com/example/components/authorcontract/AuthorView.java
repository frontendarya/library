package com.example.components.authorcontract;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Автор")
public record AuthorView(
        @Schema(description = "ID автора")
        Integer id,
        @Schema(description = "Фамилия")
        String lastname,
        @Schema(description = "Имя")
        String firstname,
        @Schema(description = "Отчество (если есть)")
        String middlename,
        @Schema(description = "Отечественный/ Зарубежный")
        Boolean isNative
) {
}
