package com.example.customerservice.core.converter;

import com.example.components.customercontract.CustomerView;
import com.example.customerservice.core.dao.Customer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CustomerToCustomerView implements Converter<Customer, CustomerView> {
    @Override
    public CustomerView convert(Customer source) {
        return new CustomerView(
                source.getId(),
                source.getLastname(),
                source.getFirstname(),
                source.getMiddlename()
        );
    }
}
