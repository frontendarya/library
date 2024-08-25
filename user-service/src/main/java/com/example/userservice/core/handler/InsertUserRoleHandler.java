package com.example.userservice.core.handler;

import com.example.components.usercontract.UserInsertRoleRequest;
import com.example.components.usercontract.UserView;
import com.example.libs.common.error.ResourceNotFoundException;
import com.example.userservice.core.UserService;
import com.example.userservice.core.converter.UserConverter;
import com.example.userservice.core.dao.User;
import com.example.userservice.core.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class InsertUserRoleHandler {
    private final UserService service;
    private final UserMapper mapper;
    private final UserConverter converter;

    public InsertUserRoleHandler(UserService service,
                                 UserMapper mapper,
                                 UserConverter converter) {
        this.service = service;
        this.mapper = mapper;
        this.converter = converter;
    }

    @Transactional
    public UserView handle(Integer id, UserInsertRoleRequest req) {
        var user = id == null ? new User():
                service.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found"));
        user = mapper.applyInsertRoleRequest(user, id, req);
        user = service.insertUserRole(id, user);
        return converter.toView(user);
    }
}
