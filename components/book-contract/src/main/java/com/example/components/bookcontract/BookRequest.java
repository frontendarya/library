package com.example.components.bookcontract;

import com.example.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Schema(description = "Создание/ Изменение сущности книги")
public record BookRequest(
        Integer id,
        @NotEmpty(groups = {OnCreate.class}) Set<Integer> authorsId,
        @NotBlank(groups = {OnCreate.class}) String title,
        @NotNull(groups = {OnCreate.class}) Integer categoryId
) {
}
