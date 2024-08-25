package com.example.historyservice.core.dao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Converter(autoApply = true)
public class BookStatusConverter implements AttributeConverter<BookStatusEnum, String> {

    @Override
    public String convertToDatabaseColumn(BookStatusEnum bookStatus) {
        if (bookStatus == null) {
            return null;
        }
        return bookStatus.getStatus();
    }

    @Override
    public BookStatusEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(BookStatusEnum.values())
                .filter(c -> c.getStatus().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
