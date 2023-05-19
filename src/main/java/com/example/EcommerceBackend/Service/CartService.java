package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.CheckOutCartRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CartResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Entity.Cart;
import com.example.EcommerceBackend.Entity.Item;
import org.springframework.web.bind.annotation.RequestBody;

public interface CartService {

    public CartResponseDto saveCart(int customerId, Item item);

    public OrderResponseDto checkOutCart(CheckOutCartRequestDto checkOutCartRequestDto) throws Exception;
}
