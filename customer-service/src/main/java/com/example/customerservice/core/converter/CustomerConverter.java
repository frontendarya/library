package com.example.customerservice.core.converter;

import com.example.components.customercontract.CustomerView;
import com.example.customerservice.core.dao.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    private final CustomerToCustomerView customerToCustomerView;

    public CustomerConverter(CustomerToCustomerView customerToCustomerView) {
        this.customerToCustomerView = customerToCustomerView;
    }

    public CustomerView toView (Customer customer) {return customerToCustomerView.convert(customer);}
}
