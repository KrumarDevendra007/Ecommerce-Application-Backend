package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.CustomerRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CustomerResponseDto;
import com.example.EcommerceBackend.Exception.MobileNoAlreadyPresentException;

public interface CustomerService {

    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException;
}
