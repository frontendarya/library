package com.example.userservice.core.mapper;

import com.example.components.usercontract.UserInsertRoleRequest;
import com.example.components.usercontract.UserRequest;
import com.example.customerservice.core.dao.Customer;
import com.example.userservice.core.dao.User;
import com.example.userservice.core.dao.UserRoleConverter;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final UserRoleConverter userRoleConverter;
    private final PasswordEncoder passwordEncoder;

    public UserMapper(UserRoleConverter userRoleConverter,
                      PasswordEncoder passwordEncoder) {
        this.userRoleConverter = userRoleConverter;
        this.passwordEncoder = passwordEncoder;

    }

    @NotNull
    public User applyRequest(User prototype, @NotNull UserRequest req, Customer customer) {
        prototype.setUsername(req.username());
        prototype.setPassword(passwordEncoder.encode(req.password()));
        prototype.setCustomer(customer);
        prototype.setRole(userRoleConverter.convertToEntityAttribute(req.role()));
        return prototype;
    }

    @NotNull
    public User applyInsertRoleRequest(User prototype, @NotNull Integer id, @NotNull UserInsertRoleRequest req) {
        prototype.setId(id);
        prototype.setRole(userRoleConverter.convertToEntityAttribute(req.role()));
        return prototype;
    }
}
