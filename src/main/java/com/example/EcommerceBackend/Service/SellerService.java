package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.SellerRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.SellerResponseDto;
import com.example.EcommerceBackend.Entity.Seller;
import com.example.EcommerceBackend.Exception.EmailAlreadyPresentException;
import com.example.EcommerceBackend.Exception.InvalidSellerException;

import java.util.List;

public interface SellerService {

    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws EmailAlreadyPresentException;

    public SellerResponseDto getSellerByEmailId(String emailId) throws InvalidSellerException;

    public SellerResponseDto getSellerById(int id) throws InvalidSellerException;

    public List<SellerResponseDto> getAllSeller();
}
