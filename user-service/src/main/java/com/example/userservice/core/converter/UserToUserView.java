package com.example.userservice.core.converter;

import com.example.components.usercontract.UserView;
import com.example.userservice.core.dao.User;
import com.example.userservice.core.dao.UserRoleConverter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToUserView implements Converter<User, UserView> {
    private final UserRoleConverter userRoleConverter;

    public UserToUserView(UserRoleConverter userRoleConverter) {
        this.userRoleConverter = userRoleConverter;
    }

    @Override
    public UserView convert(User source) {
        return new UserView(
                source.getId(),
                source.getUsername(),
                source.getCustomer().getId(),
                userRoleConverter.convertToDatabaseColumn(source.getRole())
        );
    }
}
