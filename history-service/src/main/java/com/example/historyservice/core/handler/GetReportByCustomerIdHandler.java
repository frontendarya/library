package com.example.historyservice.core.handler;

import com.example.components.historycontract.HistoryReportView;
import com.example.bookservice.core.BookService;
import com.example.bookservice.core.converter.BookConverter;
import com.example.bookservice.core.dao.Book;
import com.example.customerservice.core.CustomerService;
import com.example.historyservice.core.HistoryService;
import com.example.historyservice.core.converter.HistoryConverter;
import com.example.historyservice.core.dao.BookStatusConverter;
import com.example.historyservice.core.dao.BookStatusEnum;
import com.example.historyservice.core.dao.History;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetReportByCustomerIdHandler {
    private final HistoryService service;
    private final HistoryConverter converter;
    private final CustomerService customerService;
    private final BookService bookService;
    private final BookConverter bookConverter;
    private final BookStatusConverter bookStatusConverter;

    public GetReportByCustomerIdHandler(HistoryService service,
                                        HistoryConverter converter,
                                        CustomerService customerService,
                                        BookService bookService,
                                        BookConverter bookConverter,
                                        BookStatusConverter bookStatusConverter) {
        this.service = service;
        this.converter = converter;
        this.customerService = customerService;
        this.bookService = bookService;
        this.bookConverter = bookConverter;
        this.bookStatusConverter = bookStatusConverter;
    }

    @Transactional
    public List<HistoryReportView> handle(Integer customerId) {
        List<HistoryReportView> historyReportViews = new ArrayList<>();

        for(BookStatusEnum status : BookStatusEnum.values()){
            customerService.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
            List<Book> booksId = service.getReportByCustomerId(customerId, bookStatusConverter.convertToDatabaseColumn(status).toLowerCase()).stream().map(bookService::getDetailsById).toList();
            if (booksId.isEmpty()) {
                historyReportViews.add(null);
            }else{
                historyReportViews.add(converter.toViewWithBook(new History(),
                        booksId.size(),
                        booksId.stream().map(bookConverter::toBookViewWithDetails).toList()));
            }
        }
        return historyReportViews;
    }
}
