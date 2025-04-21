package com.accenturebe.onlinefooddelivery.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Integer phone;

    // constructor
//    public Customer(Long id, String name, String address, Integer phone){
//        this.id = id;
//        this.name = name;
//        this.address = address;
//        this.phone = phone;
//    }
}
