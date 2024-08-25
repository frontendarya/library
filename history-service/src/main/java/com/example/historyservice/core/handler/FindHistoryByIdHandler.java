package com.example.historyservice.core.handler;

import com.example.components.historycontract.HistoryView;
import com.example.historyservice.core.HistoryService;
import com.example.historyservice.core.converter.HistoryConverter;
import com.example.historyservice.core.dao.History;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindHistoryByIdHandler {
    private final HistoryService service;
    private final HistoryConverter converter;

    public FindHistoryByIdHandler(HistoryService service,
                                  HistoryConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public HistoryView handle(Integer id) {
        History history = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toView(history);
    }
}
