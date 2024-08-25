package com.example.historyservice.core.dao;

import jakarta.annotation.Nullable;

import java.util.Objects;
import java.util.stream.Stream;

public enum BookStatusEnum {
    RECEIVED("received"),
    RETURNED("returned"),
    LOST("lost");

    private final String status;
    BookStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public static BookStatusEnum getBookStatusByString(@Nullable String status) {
        return Stream.of(BookStatusEnum.values())
                .filter(e -> Objects.equals(e.getStatus(), status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
