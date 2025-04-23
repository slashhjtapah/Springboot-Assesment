package com.accenturebe.onlinefooddelivery.mapper;

import com.accenturebe.onlinefooddelivery.dto.CustomerDTO;
import com.accenturebe.onlinefooddelivery.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-23T16:16:50+0800",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerDTO.getId() );
        customer.name( customerDTO.getName() );
        customer.address( customerDTO.getAddress() );
        customer.phone( customerDTO.getPhone() );

        return customer.build();
    }

    @Override
    public CustomerDTO toCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        customerDTO.address( customer.getAddress() );
        customerDTO.phone( customer.getPhone() );

        return customerDTO.build();
    }
}
