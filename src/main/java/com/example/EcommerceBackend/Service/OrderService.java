package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.OrderRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Entity.Card;
import com.example.EcommerceBackend.Entity.Customer;
import com.example.EcommerceBackend.Entity.Ordered;
import com.example.EcommerceBackend.Exception.InvalidCardException;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Exception.InvalidProductException;

public interface OrderService {

    public Ordered paceOrder(Customer customer, Card card) throws Exception;

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception;
}
