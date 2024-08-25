package com.example.historyservice.core.converter;

import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.components.historycontract.HistoryReportView;
import com.example.historyservice.core.dao.BookStatusConverter;
import com.example.historyservice.core.dao.History;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryToHistoryReportView {
    private final BookStatusConverter bookStatusConverter;

    public HistoryToHistoryReportView(BookStatusConverter bookStatusConverter){
        this.bookStatusConverter = bookStatusConverter;
    }


    public HistoryReportView convert(History source,
                                     Integer counter,
                                     List<BookViewWithAuthorsAndCategory> books) {
        return new HistoryReportView(
                source.getId(),
                source.getCustomer().getId(),
                bookStatusConverter.convertToDatabaseColumn(source.getStatus()),
                counter,
                books
        );
    }
}
