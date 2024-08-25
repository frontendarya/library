package com.example.customerservice.core.mapper;

import com.example.components.customercontract.CustomerRequest;
import com.example.customerservice.core.dao.Customer;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    @NotNull
    public Customer applyRequest(Customer prototype, @NotNull CustomerRequest req) {
        prototype.setLastname(req.lastname());
        prototype.setFirstname(req.firstname());
        prototype.setMiddlename(req.middlename());
        return prototype;
    }
}
