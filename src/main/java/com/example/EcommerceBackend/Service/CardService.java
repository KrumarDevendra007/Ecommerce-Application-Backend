package com.example.EcommerceBackend.Service;


import com.example.EcommerceBackend.DTO.RequestDTO.CardRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CardResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CartResponseDto;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;

public interface CardService {

    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws InvalidCustomerException;
}
