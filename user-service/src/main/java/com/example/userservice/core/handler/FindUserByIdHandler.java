package com.example.userservice.core.handler;

import com.example.components.usercontract.UserView;
import com.example.libs.common.error.ResourceNotFoundException;
import com.example.userservice.core.UserService;
import com.example.userservice.core.converter.UserConverter;
import com.example.userservice.core.dao.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class FindUserByIdHandler {
    private final UserService service;
    private final UserConverter converter;

    public FindUserByIdHandler(UserService service,
                               UserConverter converter) {
        this.service = service;
        this.converter = converter;
    }

    @Transactional
    public UserView handle(Integer id) {
        User user = service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        return converter.toView(user);
    }
}
