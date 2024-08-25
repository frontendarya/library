package com.example.customerservice.core.handler;

import com.example.components.customercontract.CustomerRequest;
import com.example.components.customercontract.CustomerView;
import com.example.customerservice.core.CustomerService;
import com.example.customerservice.core.converter.CustomerConverter;
import com.example.customerservice.core.dao.Customer;
import com.example.customerservice.core.mapper.CustomerMapper;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveCustomerHandler {
    private final CustomerService service;
    private final CustomerMapper mapper;
    private final CustomerConverter converter;

    public SaveCustomerHandler(CustomerService service,
                               CustomerMapper mapper,
                               CustomerConverter converter) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Transactional
    public CustomerView handle(CustomerRequest req) {
        var customer = req.id() == null ? new Customer() :
                service.findById(req.id()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        customer = mapper.applyRequest(customer, req);
        customer = service.save(customer);
        return converter.toView(customer);
    }
}
