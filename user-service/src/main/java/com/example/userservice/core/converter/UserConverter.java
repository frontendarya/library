package com.example.userservice.core.converter;

import com.example.components.usercontract.UserView;
import com.example.components.usercontract.UserViewWithCustomer;
import com.example.userservice.core.dao.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    private final UserToUserView userToUserView;
    private final UserToUserViewWithCustomer userToUserViewWithCustomer;

    public UserConverter(UserToUserView userToUserView,
                         UserToUserViewWithCustomer userToUserViewWithCustomer) {
        this.userToUserView = userToUserView;
        this.userToUserViewWithCustomer = userToUserViewWithCustomer;
    }

    public UserView toView (User user) {return userToUserView.convert(user);}

    public UserViewWithCustomer toViewWithCustomer (User user) {return userToUserViewWithCustomer.convert(user);}
}
