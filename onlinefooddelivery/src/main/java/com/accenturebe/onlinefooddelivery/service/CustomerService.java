package com.accenturebe.onlinefooddelivery.service;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.entity.Customer;
import com.accenturebe.onlinefooddelivery.exception.CustomerAlreadyExistsException;
import com.accenturebe.onlinefooddelivery.mapper.CustomerMapper;
import com.accenturebe.onlinefooddelivery.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();

    }

//    public CustomerDTO createCustomer(CustomerDTO request) {
//        Customer customer = customerMapper.toCustomer(request);
//        Customer savedCustomer = customerRepository.save(customer);
//        return customerMapper.toCustomerDTO(savedCustomer);
////        return customerMapper.toCustomerDTO((customerRepository.save(customer)));
//    }
//
//    public CustomerDTO getCustomerById(Long id) {
//        Customer customer = customerRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Customer not found"));
//        return customerMapper.toCustomerDTO(customer);
//    }
//
//    public void deleteCustomer(Long id) {
//        customerRepository.deleteById(id);
//    }

    public CustomerDTO createCustomer(CustomerDTO request){
        if (customerRepository.existsByPhone((request.getPhone()))){
            throw new CustomerAlreadyExistsException("Customer with this phone number already exists");
        }
        Customer customer = customerMapper.toCustomer(request);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDTO(savedCustomer);
    }

    public CustomerDTO getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customerMapper.toCustomerDTO(customer);
    }

    public CustomerDTO updateCustomer(Long id, CustomerDTO request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.setName(request.getName());
        customer.setAddress(request.getAddress());
        customer.setPhone(request.getPhone());
        Customer updatedCustomer = customerRepository.save(customer);
        return customerMapper.toCustomerDTO(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
