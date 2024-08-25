package com.example.userservice.core.dao;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRoleEnum, String> {
    @Override
    public String convertToDatabaseColumn(UserRoleEnum userRole) {
        if (userRole == null) {
            return null;
        }
        return userRole.getRole();
    }

    @Override
    public UserRoleEnum convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(UserRoleEnum.values())
                .filter(c -> c.getRole().equals(dbData))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
