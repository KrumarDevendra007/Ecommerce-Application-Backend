package com.example.EcommerceBackend.DTO.ResponceDTO;

import com.example.EcommerceBackend.Enum.ProductCategory;
import com.example.EcommerceBackend.Enum.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ProductResponseDto {

      String productName;
      String sellerName;
      int quantity;
      ProductStatus productStatus;

}
