package com.example.EcommerceBackend.Transformer;

import com.example.EcommerceBackend.DTO.RequestDTO.ProductRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.ProductResponseDto;
import com.example.EcommerceBackend.Entity.Product;
import com.example.EcommerceBackend.Enum.ProductStatus;

public class ProductTransformer {

    public static Product productRequestDtoToProduct(ProductRequestDto productRequestDto){

        return Product.builder()
                .name(productRequestDto.getName())
                .price(productRequestDto.getPrice())
                .productCategory(productRequestDto.getProductCategory())
                .quantity(productRequestDto.getQuantity())
                .productStatus(ProductStatus.AVAILABLE)
                .build();
    }

    public static ProductResponseDto productResponseDtoToProduct(Product product){

                  return ProductResponseDto.builder()
                          .productName(product.getName())
                          .sellerName(product.getSeller().getName())
                          .quantity(product.getQuantity())
                          .productStatus(product.getProductStatus())
                          .build();
    }
}
