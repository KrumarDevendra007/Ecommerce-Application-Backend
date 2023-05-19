package com.example.EcommerceBackend.Transformer;

import com.example.EcommerceBackend.DTO.RequestDTO.CardRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CardResponseDto;
import com.example.EcommerceBackend.Entity.Card;

public class CardTransformer {

    public static Card cardRequstDtoToCard(CardRequestDto cardRequestDto){
        return  Card.builder()
                .cardNo(cardRequestDto.getCardNo())
                .cardType(cardRequestDto.getCardType())
                .cvv(cardRequestDto.getCvv())
                .expiryDate(cardRequestDto.getExpiryDate())
                .build();
    }

    public static CardResponseDto catrToCardResponseDto(Card card){
        return CardResponseDto.builder()
                .customerName(card.getCustomer().getName())
                .cardNo(card.getCardNo())
                .build();
    }
}
