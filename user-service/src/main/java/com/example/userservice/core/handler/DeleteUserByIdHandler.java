package com.example.userservice.core.handler;

import com.example.libs.common.error.ResourceNotFoundException;
import com.example.userservice.core.UserService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserByIdHandler {
    private final UserService service;

    public DeleteUserByIdHandler(UserService service) {
        this.service = service;
    }

    @Transactional
    public void handle(Integer userId) {
        service.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        service.delete(userId);
    }
}
