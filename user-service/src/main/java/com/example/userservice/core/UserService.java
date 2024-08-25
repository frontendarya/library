package com.example.userservice.core;

import com.example.userservice.core.dao.User;
import com.example.userservice.core.dao.UserRepository;
import com.example.userservice.core.dao.UserRoleConverter;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserRoleConverter userRoleConverter;

    public UserService(UserRepository userRepository,
                       UserRoleConverter userRoleConverter) {
        this.userRepository = userRepository;
        this.userRoleConverter = userRoleConverter;
    }

    public User save(User user) {
        return userRepository.save(
                user.getUsername(),
                user.getPassword(),
                user.getCustomer().getId(),
                userRoleConverter.convertToDatabaseColumn(user.getRole()));
    }

    public User update(Integer userId, User user) {
        return userRepository.updateById(userId,
                user.getUsername(),
                user.getPassword(),
                user.getCustomer().getId(),
                userRoleConverter.convertToDatabaseColumn(user.getRole()));
    }

    public Optional<User> findById(Integer userId) {
        return userRepository.findById(userId);
    }

    public User insertUserRole(Integer userId, User user) {
        return userRepository.insertUserRole(userId,
            userRoleConverter.convertToDatabaseColumn(user.getRole()));
    }

    public void delete(Integer userId) { userRepository.deleteById(userId); }

}
