package com.example.components.historycontract;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "История выдачи")
public record HistoryView(
        @Schema(description = "ID записи")
        Integer id,
        @Schema(description = "ID посетителя")
        Integer customerId,
        @Schema(description = "ID книги")
        Integer bookId,
        @Schema(description = "Статус книги")
        String status,
        @Schema(description = "Дата выдачи")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createdAt,
        @Schema(description = "Дата получения")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime updatedAt
) {
}