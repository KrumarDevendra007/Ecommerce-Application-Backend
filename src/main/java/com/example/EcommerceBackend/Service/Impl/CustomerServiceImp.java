package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.CustomerRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CustomerResponseDto;
import com.example.EcommerceBackend.Entity.Cart;
import com.example.EcommerceBackend.Entity.Customer;
import com.example.EcommerceBackend.Exception.MobileNoAlreadyPresentException;
import com.example.EcommerceBackend.Repository.CustomerRepository;
import com.example.EcommerceBackend.Service.CustomerService;
import com.example.EcommerceBackend.Transformer.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponseDto addCustomer(CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException {

        if(customerRepository.findByMobNo(customerRequestDto.getMobNo()) != null){
            throw new MobileNoAlreadyPresentException("Sorry customer already exist!");
        }
        Customer customer = CustomerTransformer.customerRequestDtoToCustomer(customerRequestDto);
        Cart cart = Cart.builder()
                .cartTotal(0)
                .numberOfItem(0)
                .customer(customer)
                .build();
        customer.setCart(cart);

        Customer savedCustomer = customerRepository.save(customer);

        return CustomerTransformer.customerToCustomerResponseDto(savedCustomer);
    }
}
