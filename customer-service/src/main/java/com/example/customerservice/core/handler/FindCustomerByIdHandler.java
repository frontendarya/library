package com.example.customerservice.core.handler;

import com.example.components.customercontract.CustomerView;
import com.example.customerservice.core.CustomerService;
import com.example.customerservice.core.converter.CustomerConverter;
import com.example.customerservice.core.dao.Customer;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerByIdHandler {
    private final CustomerService service;
    private final CustomerConverter converter;

    public FindCustomerByIdHandler(CustomerService service,
                                   CustomerConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public CustomerView handle(Integer id) {
        Customer customer = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toView(customer);
    }
}
