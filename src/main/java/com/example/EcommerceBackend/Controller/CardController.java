package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.CardRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CardResponseDto;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.CacheRequest;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping("/add")
    public ResponseEntity addCard(@RequestBody CardRequestDto cardRequestDto){
        try{
            CardResponseDto cardResponseDto = cardService.addCard(cardRequestDto);
            return new ResponseEntity(cardResponseDto, HttpStatus.CREATED);
        } catch (InvalidCustomerException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
