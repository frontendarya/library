package com.example.historyservice.core.converter;

import com.example.components.bookcontract.BookViewWithAuthorsAndCategory;
import com.example.components.historycontract.HistoryReportView;
import com.example.components.historycontract.HistoryView;
import com.example.historyservice.core.dao.History;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryConverter {

    private final HistoryToHistoryView historyToHistoryView;
    private final HistoryToHistoryReportView historyToViewWithBook;

    public HistoryConverter(HistoryToHistoryView historyToHistoryView,
                            HistoryToHistoryReportView historyToViewWithBook) {
        this.historyToHistoryView = historyToHistoryView;
        this.historyToViewWithBook = historyToViewWithBook;
    }

    public HistoryView toView (History history) {return historyToHistoryView.convert(history);}

    public HistoryReportView toViewWithBook (History history,
                                             Integer counter,
                                             List<BookViewWithAuthorsAndCategory> books) {
        return historyToViewWithBook.convert(history, counter, books);
    }
}
