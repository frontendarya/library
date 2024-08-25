package com.example.userservice.core.web;

import com.example.*;
import com.example.userservice.core.handler.UserControllerHandler;
import com.example.components.usercontract.UserInsertRoleRequest;
import com.example.components.usercontract.UserRequest;
import com.example.components.usercontract.UserView;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/users")
@Validated
@Tag(name = "Учётные записи")
public class UserController {

    private final UserControllerHandler userHandler;
    public UserController(UserControllerHandler userHandler) {this.userHandler = userHandler;}

    @Operation(summary = "Создать")
    @Validated(OnCreate.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public UserView create(@Valid @RequestBody @NotNull UserRequest request){
        return userHandler.save(request);
    }

    @Operation(summary = "Изменить")
    @Validated(OnUpdate.class)
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    @ResponseBody
    public UserView updateById(@Valid @RequestBody UserRequest request){
        return userHandler.save(request);
    }

    @Operation(summary = "Найти по ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    @ResponseBody
    public UserView findAllById(@PathVariable @NotNull Integer userId){
        return userHandler.findById(userId);
    }

    @Operation(summary = "Назначить роль")
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/insertRole/{userId}")
    @ResponseBody
    public UserView insertUserRole(@PathVariable @NotNull Integer userId,
                                   @Valid @RequestBody UserInsertRoleRequest request){
        return userHandler.insertUserRole(userId, request);
    }

    @Operation(summary = "Удалить")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{userId}")
    public void deleteById(@PathVariable @NotNull Integer userId){
        userHandler.deleteById(userId);
    }
}
