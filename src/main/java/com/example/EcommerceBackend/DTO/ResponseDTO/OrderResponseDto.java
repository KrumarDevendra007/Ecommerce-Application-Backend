package com.example.EcommerceBackend.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class OrderResponseDto {

       String OrderNo;
       int totalValue;
       Date OrderData;
       String cardUsed;
       List<ItemResponseDto> items;
       String customerName;
}
