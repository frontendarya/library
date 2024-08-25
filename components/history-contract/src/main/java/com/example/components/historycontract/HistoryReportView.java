package com.example.components.historycontract;

import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Отчёт о количестве книг")
public record HistoryReportView(
        @Schema(description = "ID записи")
        Integer id,
        @Schema(description = "ID посетителя")
        Integer customerId,
        @Schema(description = "Статус книг")
        String status,
        @Schema(description = "Количество книг с этим статусом")
        Integer counter,
        @Schema(description = "Книги")
        List<BookViewWithAuthorsAndCategory> books
) {
}
