package com.example.components.authorcontract;

import com.example.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Создание/ изменение сущности автора")
public record AuthorRequest(
        Integer id,
        @NotBlank(groups = {OnCreate.class}) String lastname,
        @NotBlank(groups = {OnCreate.class}) String firstname,
        String middlename,
        @NotNull(groups = {OnCreate.class}) Boolean isNative
) {
}
