package com.example.historyservice.core.handler;

import com.example.components.historycontract.HistoryView;
import com.example.historyservice.core.HistoryService;
import com.example.historyservice.core.converter.HistoryConverter;
import com.example.historyservice.core.dao.History;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class UpdateHistoryHandler {
    private final HistoryService service;
    private final HistoryConverter converter;

    public UpdateHistoryHandler(HistoryService service,
                                HistoryConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public HistoryView handle(Integer customerId, Integer bookId) {
        History history;
        try{
            history = service.update(customerId, bookId);
        }catch (RuntimeException e){
            throw new RuntimeException("Update failed");
        }
        return converter.toView(history);
    }
}
