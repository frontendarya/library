package com.example.historyservice.core;

import com.example.historyservice.core.dao.History;
import com.example.historyservice.core.dao.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public History save(Integer customerId, Integer bookId) {
        return historyRepository.saveHistory(customerId, bookId);
    }

    public History update(Integer customerId, Integer bookId) {
        return historyRepository.updateHistory(customerId, bookId);
    }

    public Optional<History> findById(Integer historyId) {
        return historyRepository.findById(historyId);
    }

    public String checkBookStatusById(Integer bookId) {
        return historyRepository.checkBookStatusById(bookId);
    }

    public List<Integer> getReportByCustomerId(Integer customerId, String status) {
        return historyRepository.getReportByCustomerId(customerId, status.toLowerCase());
    }

    public List<Integer> getReportByUserId(Integer userId, String status) {
        return historyRepository.getReportByUserId(userId, status.toUpperCase());
    }

    public void delete(Integer historyId) { historyRepository.deleteById(historyId); }
}
