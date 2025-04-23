package com.accenturebe.onlinefooddelivery.controller;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")  //  base path url
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customer) {
        CustomerDTO createdCustomer = customerService.createCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@PathVariable @Valid Long customerId, @RequestBody @Valid CustomerDTO customer) {
        CustomerDTO updatedCustomer = customerService.updateCustomer(customerId, customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable @Valid Long customerId) {
        CustomerDTO customer = customerService.getCustomerById(customerId);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("delete/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable @Valid Long customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.ok().build();
    }

}
