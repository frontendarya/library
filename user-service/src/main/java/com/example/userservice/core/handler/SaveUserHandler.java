package com.example.userservice.core.handler;

import com.example.components.usercontract.UserRequest;
import com.example.components.usercontract.UserView;
import com.example.customerservice.core.CustomerService;
import com.example.customerservice.core.dao.Customer;
import com.example.libs.common.error.ResourceNotFoundException;
import com.example.userservice.core.UserService;
import com.example.userservice.core.converter.UserConverter;
import com.example.userservice.core.dao.User;
import com.example.userservice.core.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class SaveUserHandler {
    private final UserService service;
    private final UserMapper mapper;
    private final UserConverter converter;
    private final CustomerService customerService;

    public SaveUserHandler(UserService service,
                           UserMapper mapper,
                           UserConverter converter,
                           CustomerService customerService) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
        this.customerService = customerService;
    }

    @Transactional
    public UserView handle(UserRequest req) {
        var user = req.id() == null ? new User():
                service.findById(req.id()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        var customer = req.id() == null ? new Customer():
                customerService.findById(req.customerId()).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        user = mapper.applyRequest(user, req, customer);
        user = service.save(user);
        return converter.toView(user);
    }
}
