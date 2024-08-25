package com.example.components.authorcontract;

import com.example.components.bookcontract.BookView;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Автор и книги")
public record AuthorViewWithBooks(
        @Schema(description = "ID автора")
        Integer id,
        @Schema(description = "Фамилия")
        String lastname,
        @Schema(description = "Имя")
        String firstname,
        @Schema(description = "Отчество (если есть)")
        String middlename,
        @Schema(description = "Отечественный/ Зарубежный")
        Boolean isNative,
        @Schema(description = "Список принадлежащих книг")
        List<BookView> books
) {
}
