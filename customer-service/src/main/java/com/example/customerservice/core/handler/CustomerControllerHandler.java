package com.example.customerservice.core.handler;

import com.example.components.customercontract.CustomerRequest;
import com.example.components.customercontract.CustomerView;
import org.springframework.stereotype.Component;

@Component
public class CustomerControllerHandler {
    private final DeleteCustomerByIdHandler deleteCustomerByIdHandler;
    private final FindCustomerByIdHandler findCustomerByIdHandler;
    private final SaveCustomerHandler saveCustomerHandler;

    public CustomerControllerHandler(DeleteCustomerByIdHandler deleteCustomerByIdHandler,
                                     FindCustomerByIdHandler findCustomerByIdHandler,
                                     SaveCustomerHandler saveCustomerHandler){
        this.deleteCustomerByIdHandler = deleteCustomerByIdHandler;
        this.findCustomerByIdHandler = findCustomerByIdHandler;
        this.saveCustomerHandler = saveCustomerHandler;
    }
    public CustomerView save(CustomerRequest req) {
        return saveCustomerHandler.handle(req);
    }

    public CustomerView findById(Integer id) {
        return findCustomerByIdHandler.handle(id);
    }

    public void deleteById(Integer customerId) {
        deleteCustomerByIdHandler.handle(customerId);
    }
}

