package com.example.EcommerceBackend.Transformer;

import com.example.EcommerceBackend.DTO.RequestDTO.SellerRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.SellerResponseDto;
import com.example.EcommerceBackend.Entity.Seller;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class SellerTransformer {

    public static Seller sellerRequestDtoToSeller(SellerRequestDto sellerRequestDto){

        return Seller.builder()
                .name(sellerRequestDto.getName())
                .emailId(sellerRequestDto.getEmailId())
                .age(sellerRequestDto.getAge())
                .mobNo(sellerRequestDto.getMobNo())
                .build();
    }

    public static SellerResponseDto sellerToSellerResponseDto(Seller seller){

        return SellerResponseDto.builder()
                .name(seller.getName())
                .age(seller.getAge())
                .build();
    }


}
