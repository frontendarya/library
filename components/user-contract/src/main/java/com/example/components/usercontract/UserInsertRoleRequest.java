package com.example.components.usercontract;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Изменение роли пользователя (УЗ)")
public record UserInsertRoleRequest(
        @NotBlank String role
) {
}
