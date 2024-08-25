package com.example.userservice.core.dao;

import jakarta.annotation.Nullable;

import java.util.Objects;
import java.util.stream.Stream;

public enum UserRoleEnum {
    ROLE_CUSTOMER("customer"),
    ROLE_ADMIN("admin");

    private final String role;
    UserRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public static UserRoleEnum getUserRoleByString(@Nullable String role) {
        return Stream.of(UserRoleEnum.values())
                .filter(e -> Objects.equals(e.getRole(), role))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
