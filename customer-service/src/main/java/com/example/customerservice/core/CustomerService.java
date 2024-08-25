package com.example.customerservice.core;

import com.example.customerservice.core.dao.Customer;
import com.example.customerservice.core.dao.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(Integer id, Customer customer) {
        return customerRepository.updateById(id,
                customer.getLastname(),
                customer.getFirstname(),
                customer.getMiddlename());
    }

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public void delete(Integer id) { customerRepository.deleteById(id); }
}
