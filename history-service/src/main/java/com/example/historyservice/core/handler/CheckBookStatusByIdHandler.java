package com.example.historyservice.core.handler;

import com.example.historyservice.core.HistoryService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CheckBookStatusByIdHandler {
    private final HistoryService service;

    public CheckBookStatusByIdHandler(HistoryService service) {
        this.service = service;
    }

    @Transactional
    public String handle(Integer id) {
        String status = service.checkBookStatusById(id);
        if (status==null) {
            throw new ResourceNotFoundException("Book status with id " + id + " not found");
        }else {
            return status;
        }
    }
}
