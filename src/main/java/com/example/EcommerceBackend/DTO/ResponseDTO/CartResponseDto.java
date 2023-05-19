package com.example.EcommerceBackend.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CartResponseDto {

    int cartTotal;
    int numberOfItem;
    String customerName;
    List<ItemResponseDto> items;
}
