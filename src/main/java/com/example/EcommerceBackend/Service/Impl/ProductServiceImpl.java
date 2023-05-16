package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.ProductRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.ProductResponseDto;
import com.example.EcommerceBackend.Entity.Product;
import com.example.EcommerceBackend.Entity.Seller;
import com.example.EcommerceBackend.Enum.ProductCategory;
import com.example.EcommerceBackend.Exception.InvalidSellerException;
import com.example.EcommerceBackend.Repository.ProductRepository;
import com.example.EcommerceBackend.Repository.SellerRepository;
import com.example.EcommerceBackend.Service.ProductService;
import com.example.EcommerceBackend.Transformer.ProductTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;
    @Override
    public ProductResponseDto addProduct(ProductRequestDto productRequestDto) throws InvalidSellerException {

        Seller seller;
        try {
            seller = sellerRepository.findById(productRequestDto.getSellerId()).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Seller doesn't exist");
        }

        Product product = ProductTransformer.productRequestDtoToProduct(productRequestDto);
        product.setSeller(seller);

        seller.getProductList().add(product);
        sellerRepository.save(seller);

        return ProductTransformer.productResponseDtoToProduct(product);
    }

    @Override
    public List<ProductResponseDto> getAllProductByDto(ProductCategory category) {

        List<Product> productList = productRepository.findByProductCategory(category);

        List<ProductResponseDto> productResponseDto = new ArrayList<>();

        for(Product product : productList){
            productResponseDto.add(ProductTransformer.productResponseDtoToProduct(product));
        }

        return productResponseDto;

    }

    @Override
    public List<ProductResponseDto> getAllProductByPriceAndCategory(int price, ProductCategory category) {
           List<Product> productlist = productRepository.getAllProductsByPriceAndCategory(price, category);

           List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
           for(Product product : productlist){
                productResponseDtoList.add(ProductTransformer.productResponseDtoToProduct(product));
           }

           return productResponseDtoList;
    }
}
