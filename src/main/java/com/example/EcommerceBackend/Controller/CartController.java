package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.CheckOutCartRequestDto;
import com.example.EcommerceBackend.DTO.RequestDTO.ItemRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CartResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Entity.Item;
import com.example.EcommerceBackend.Service.CartService;
import com.example.EcommerceBackend.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    ItemService itemService;

    @PostMapping("/add")
    public ResponseEntity addToCart(@RequestBody ItemRequestDto itemRequestDto){

        try {
            Item saveItem = itemService.addItem(itemRequestDto);
            CartResponseDto cartResponseDto = cartService.saveCart(itemRequestDto.getCustomerId(), saveItem);
            return new ResponseEntity(cartResponseDto, HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/checkout")
    public OrderResponseDto checkOutCart(@RequestBody CheckOutCartRequestDto checkOutCartRequestDto) throws Exception {
        return cartService.checkOutCart(checkOutCartRequestDto);
    }
}
