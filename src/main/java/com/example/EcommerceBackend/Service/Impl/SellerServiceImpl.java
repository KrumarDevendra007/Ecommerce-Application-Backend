package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.SellerRequestDto;
import com.example.EcommerceBackend.DTO.ResponceDTO.SellerResponseDto;
import com.example.EcommerceBackend.Entity.Seller;
import com.example.EcommerceBackend.Exception.EmailAlreadyPresentException;
import com.example.EcommerceBackend.Exception.InvalidSellerException;
import com.example.EcommerceBackend.Repository.SellerRepository;
import com.example.EcommerceBackend.Service.SellerService;
import com.example.EcommerceBackend.Transformer.SellerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    SellerRepository sellerRepository;

    @Override
    public SellerResponseDto addSeller(SellerRequestDto sellerRequestDto) throws EmailAlreadyPresentException {

            if(sellerRepository.findByEmailId(sellerRequestDto.getName()) != null){
                throw new EmailAlreadyPresentException("EmailId already register");
            }

            Seller seller = SellerTransformer.sellerRequestDtoToSeller(sellerRequestDto);
            Seller savedSeller = sellerRepository.save(seller);

            SellerResponseDto sellerResponseDto = SellerTransformer.sellerToSellerResponseDto(savedSeller);
            return sellerResponseDto;
    }

    @Override  // Work on this
    public SellerResponseDto getSellerByEmailId(String emailId) throws InvalidSellerException {
            Seller seller;
        try{
            seller = sellerRepository.findByEmailId(emailId);
        }
        catch (Exception e){
            throw new InvalidSellerException("Seller doesn't exist");
        }

        SellerResponseDto sellerResponseDto = SellerTransformer.sellerToSellerResponseDto(seller);
       return sellerResponseDto;
    }

    @Override
    public SellerResponseDto getSellerById(int id) throws InvalidSellerException {

        Seller seller;
        try {
            seller = sellerRepository.findById(id).get();
        }
        catch (Exception e){
            throw new InvalidSellerException("Seller doesn't exist");
        }

        SellerResponseDto sellerResponseDto = SellerTransformer.sellerToSellerResponseDto(seller);
        return sellerResponseDto;
    }

    @Override
    public List<SellerResponseDto> getAllSeller() {
        return null;
    }


}
