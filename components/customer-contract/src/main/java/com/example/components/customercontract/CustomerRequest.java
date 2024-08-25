package com.example.components.customercontract;

import com.example.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Создание/ Изменение сущности посетителя")
public record CustomerRequest(
        Integer id,
        @NotBlank(groups = {OnCreate.class}) String lastname,
        @NotBlank(groups = {OnCreate.class}) String firstname,
        String middlename
) {
}
