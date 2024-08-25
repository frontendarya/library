package com.example.userservice.core.converter;

import com.example.components.usercontract.UserViewWithCustomer;
import com.example.customerservice.core.converter.CustomerConverter;
import com.example.userservice.core.dao.User;
import com.example.userservice.core.dao.UserRoleConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserViewWithCustomer implements Converter<User, UserViewWithCustomer> {
    private final UserRoleConverter userRoleConverter;
    private final CustomerConverter customerConverter;

    public UserToUserViewWithCustomer(UserRoleConverter userRoleConverter,
                                      CustomerConverter customerConverter){
        this.userRoleConverter = userRoleConverter;
        this.customerConverter = customerConverter;
    }

    @Override
    public UserViewWithCustomer convert(User source) {
        return new UserViewWithCustomer(
                source.getId(),
                source.getUsername(),
                customerConverter.toView(source.getCustomer()),
                userRoleConverter.convertToDatabaseColumn(source.getRole())
        );
    }
}
