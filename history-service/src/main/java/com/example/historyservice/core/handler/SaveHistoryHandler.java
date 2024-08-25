package com.example.historyservice.core.handler;

import com.example.components.historycontract.HistoryView;
import com.example.historyservice.core.HistoryService;
import com.example.historyservice.core.converter.HistoryConverter;
import com.example.historyservice.core.dao.BookStatusConverter;
import com.example.historyservice.core.dao.BookStatusEnum;
import com.example.historyservice.core.dao.History;
import com.example.libs.common.error.BookUnavailableException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveHistoryHandler {
    private final HistoryService service;
    private final HistoryConverter converter;
    private final BookStatusConverter bookStatusConverter;

    public SaveHistoryHandler(HistoryService service,
                              HistoryConverter converter,
                              BookStatusConverter bookStatusConverter) {
        this.service = service;
        this.converter = converter;
        this.bookStatusConverter = bookStatusConverter;
    }

    @Transactional
    public HistoryView handle(Integer customerId, Integer bookId) {
        History history;
        BookStatusEnum fromDb = bookStatusConverter.convertToEntityAttribute(service.checkBookStatusById(bookId));

        if(fromDb.equals(BookStatusEnum.LOST) || fromDb.equals(BookStatusEnum.RECEIVED)){
            throw new BookUnavailableException("Book is not available");
        }

        try{
            history = service.save(customerId, bookId);
        }catch (RuntimeException e){
            throw new RuntimeException("Save failed");
        }
        return converter.toView(history);
    }
}
