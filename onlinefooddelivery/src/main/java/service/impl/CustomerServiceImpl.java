package service.impl;

import org.springframework.stereotype.Service;
import repository.CustomerRepository;

@Service
public class CustomerServiceImpl {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
