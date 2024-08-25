package com.example.components.usercontract;

import com.example.components.customercontract.CustomerView;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Учётная запись пользователя (УЗ)")
public record UserViewWithCustomer(
        @Schema(description = "ID записи")
        Integer id,
        @Schema(description = "username")
        String username,
        @Schema(description = "ФИО пользователя")
        CustomerView customer,
        @Schema(description = "Роль")
        String role
) {
}
