package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.OrderRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeOrder")
    public OrderResponseDto placeOrder(@RequestBody OrderRequestDto orderRequestDto) throws Exception {
        return orderService.placeOrder(orderRequestDto);
    }
}
