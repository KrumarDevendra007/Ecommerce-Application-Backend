package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.ProductRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.ProductResponseDto;
import com.example.EcommerceBackend.Entity.Product;
import com.example.EcommerceBackend.Enum.ProductCategory;
import com.example.EcommerceBackend.Exception.InvalidSellerException;

import java.util.List;

public interface ProductService {

    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws InvalidSellerException;
    public List<ProductResponseDto> getAllProductByDto(ProductCategory category);
    public List<ProductResponseDto> getAllProductByPriceAndCategory(int price, ProductCategory category);
}
