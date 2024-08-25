package com.example.components.usercontract;

import com.example.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Создание/ Изменение сущности пользователя (УЗ)")
public record UserRequest(
        Integer id,
        @NotBlank(groups = {OnCreate.class}) String username,
        @NotBlank(groups = {OnCreate.class}) String password,
        @NotNull(groups = {OnCreate.class}) Integer customerId,
        String role
) {
}
