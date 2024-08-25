package com.example.historyservice.core.converter;

import com.example.components.historycontract.HistoryView;
import com.example.historyservice.core.dao.BookStatusConverter;
import com.example.historyservice.core.dao.History;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class HistoryToHistoryView implements Converter<History, HistoryView> {
    BookStatusConverter bookStatusConverter = new BookStatusConverter();

    @Override
    public HistoryView convert(History source) {
        HistoryView historyView = new HistoryView(
                source.getId(),
                source.getCustomer().getId(),
                source.getBook().getId(),
                bookStatusConverter.convertToDatabaseColumn(source.getStatus()),
                source.getCreatedAt(),
                source.getUpdatedAt()
        );
        return historyView;
    }
}
