package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.CustomerRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CustomerResponseDto;
import com.example.EcommerceBackend.Exception.MobileNoAlreadyPresentException;
import com.example.EcommerceBackend.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody CustomerRequestDto customerRequestDto) throws MobileNoAlreadyPresentException {

       try{
           CustomerResponseDto customerResponseDto =  customerService.addCustomer(customerRequestDto);
           return new ResponseEntity<>(customerResponseDto, HttpStatus.CREATED);

       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }
}
