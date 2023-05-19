package com.example.EcommerceBackend.Transformer;

import com.example.EcommerceBackend.DTO.RequestDTO.CustomerRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CustomerResponseDto;
import com.example.EcommerceBackend.Entity.Customer;

public class CustomerTransformer {

    public static Customer customerRequestDtoToCustomer(CustomerRequestDto customerRequestDto){
           return Customer.builder()
                   .name(customerRequestDto.getName())
                   .emailId(customerRequestDto.getEmail())
                   .age(customerRequestDto.getAge())
                   .mobNo(customerRequestDto.getMobNo())
                   .address(customerRequestDto.getAddress())
                   .build();
    }

    public static CustomerResponseDto customerToCustomerResponseDto(Customer customer){

        return CustomerResponseDto.builder()
                .name(customer.getName())
                .message("Welcome " + customer.getName() + " to online shop!!!")
                .build();
    }
}
