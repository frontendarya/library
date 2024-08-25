package com.example.customerservice.core.web;

import com.example.components.customercontract.CustomerRequest;
import com.example.components.customercontract.CustomerView;
import com.example.OnCreate;
import com.example.OnUpdate;
import com.example.customerservice.core.handler.CustomerControllerHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@Validated
@Tag(name = "Посетители")
public class CustomerController {

    private final CustomerControllerHandler customerHandler;
    public CustomerController(CustomerControllerHandler customerHandler) {this.customerHandler = customerHandler;}

    @Operation(summary = "Создать")
    @Validated(OnCreate.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    @ResponseBody
    public CustomerView create(@Valid @RequestBody @NotNull CustomerRequest request){
        return customerHandler.save(request);
    }

    @Operation(summary = "Изменить")
    @Validated(OnUpdate.class)
    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/update")
    @ResponseBody
    public CustomerView updateById(@Valid @RequestBody CustomerRequest request){
        return customerHandler.save(request);
    }

    @Operation(summary = "Найти по ID")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{customerId}")
    @ResponseBody
    public CustomerView findAllById(@PathVariable @NotNull Integer customerId){
        return customerHandler.findById(customerId);
    }

    @Operation(summary = "Удалить")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete/{customerId}")
    public void deleteById(@PathVariable @NotNull Integer customerId){
        customerHandler.deleteById(customerId);
    }
}
