package com.example.EcommerceBackend.DTO.RequestDTO;

import com.example.EcommerceBackend.Enum.ProductCategory;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductRequestDto {

    int sellerId;
    String name;
    int price;
    int quantity;
    ProductCategory productCategory;
}
