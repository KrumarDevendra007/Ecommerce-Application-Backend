package com.example.EcommerceBackend.Transformer;

import com.example.EcommerceBackend.DTO.RequestDTO.ItemRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.ItemResponseDto;
import com.example.EcommerceBackend.Entity.Item;

public class ItemTransformer {

    public static Item itemToItemRequestDto(ItemRequestDto itemRequestDto){
        return Item.builder()
                .requiredQuantity(itemRequestDto.getRequiredQuantity())
                .build();
    }

    public static ItemResponseDto itemToItemResponseDto(Item item){
        return ItemResponseDto.builder()
                .productName(item.getProduct().getName())
                .priceOfOneItem(item.getProduct().getPrice())
                .totalPrice(item.getRequiredQuantity() * item.getProduct().getPrice())
                .quantity(item.getRequiredQuantity())
                .build();
    }
}
