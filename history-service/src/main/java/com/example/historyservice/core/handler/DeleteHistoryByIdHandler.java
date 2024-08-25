package com.example.historyservice.core.handler;

import com.example.historyservice.core.HistoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteHistoryByIdHandler {
    private final HistoryService service;

    public DeleteHistoryByIdHandler(HistoryService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer historyId) {
        service.findById(historyId).orElseThrow(() -> new ResourceNotFoundException("History row not found"));
        service.delete(historyId);
    }
}
