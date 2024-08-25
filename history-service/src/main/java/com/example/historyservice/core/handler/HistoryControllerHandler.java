package com.example.historyservice.core.handler;

import com.example.components.historycontract.HistoryReportView;
import com.example.components.historycontract.HistoryView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryControllerHandler {
    private final CheckBookStatusByIdHandler checkBookStatusByIdHandler;
    private final DeleteHistoryByIdHandler deleteHistoryByIdHandler;
    private final FindHistoryByIdHandler findHistoryByIdHandler;
    private final GetReportByCustomerIdHandler getReportByCustomerIdHandler;
    private final GetReportByUserIdHandler getReportByUserIdHandler;
    private final SaveHistoryHandler saveHistoryHandler;
    private final UpdateHistoryHandler updateHistoryHandler;

    public HistoryControllerHandler(CheckBookStatusByIdHandler checkBookStatusByIdHandler,
                                    DeleteHistoryByIdHandler deleteHistoryByIdHandler,
                                    FindHistoryByIdHandler findHistoryByIdHandler,
                                    GetReportByCustomerIdHandler getReportByCustomerIdHandler,
                                    GetReportByUserIdHandler getReportByUserIdHandler,
                                    SaveHistoryHandler saveHistoryHandler,
                                    UpdateHistoryHandler updateHistoryHandler){
        this.checkBookStatusByIdHandler = checkBookStatusByIdHandler;
        this.deleteHistoryByIdHandler = deleteHistoryByIdHandler;
        this.findHistoryByIdHandler = findHistoryByIdHandler;
        this.getReportByCustomerIdHandler = getReportByCustomerIdHandler;
        this.getReportByUserIdHandler = getReportByUserIdHandler;
        this.saveHistoryHandler = saveHistoryHandler;
        this.updateHistoryHandler = updateHistoryHandler;
    }

    public HistoryView save(Integer customerId, Integer bookId) {
        return saveHistoryHandler.handle(customerId, bookId);
    }

    public HistoryView updateById(Integer customerId, Integer bookId) {
        return updateHistoryHandler.handle(customerId, bookId);
    }

    public HistoryView findById(Integer id) {
        return findHistoryByIdHandler.handle(id);
    }

    public String checkBookStatusById(Integer bookId) {
        return checkBookStatusByIdHandler.handle(bookId);
    }

    public List<HistoryReportView> getReportByCustomerId(Integer customerId) {
        return getReportByCustomerIdHandler.handle(customerId);
    }

    public List<HistoryReportView> getReportByUserId(Integer userId) {
        return getReportByUserIdHandler.handle(userId);
    }

    public void deleteById(Integer historyId) {
        deleteHistoryByIdHandler.handle(historyId);
    }
}

