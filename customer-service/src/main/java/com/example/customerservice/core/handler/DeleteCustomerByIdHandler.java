package com.example.customerservice.core.handler;

import com.example.customerservice.core.CustomerService;
import com.example.libs.common.error.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdHandler {
    private final CustomerService service;

    public DeleteCustomerByIdHandler(CustomerService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer customerId) {
        service.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        service.delete(customerId);
    }
}
