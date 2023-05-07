package com.example.EcommerceBackend.Controller;

import com.example.EcommerceBackend.DTO.RequestDTO.ProductRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.ProductResponseDto;
import com.example.EcommerceBackend.Entity.Product;
import com.example.EcommerceBackend.Enum.ProductCategory;
import com.example.EcommerceBackend.Exception.InvalidSellerException;
import com.example.EcommerceBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public ProductResponseDto addProduct(@RequestBody ProductRequestDto productRequestDto) throws InvalidSellerException {
        return productService.addProduct(productRequestDto);
    }

    // get all products of a particular category
    @GetMapping("/get/{category}")
    public List<ProductResponseDto> getAllProductByCategory(@PathVariable("category")ProductCategory category){

           return productService.getAllProductByDto(category);
    }


}
