package com.example.components.categorycontract;

import com.example.OnCreate;
import com.example.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Создание/ Изменение сущести жанра")
public record CategoryRequest(
        Integer id,
        @NotBlank(groups = {OnCreate.class, OnUpdate.class}) String name) {
}
