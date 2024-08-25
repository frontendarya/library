package com.example.components.usercontract;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Учётная запись посетителя (УЗ)")
public record UserView(
        @Schema(description = "ID записи")
        Integer id,
        @Schema(description = "username")
        String username,
        @Schema(description = "ID пользователя")
        Integer customerId,
        @Schema(description = "Роль")
        String role
) {
}
