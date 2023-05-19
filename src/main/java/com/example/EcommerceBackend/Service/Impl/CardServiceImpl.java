package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.CardRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CardResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CartResponseDto;
import com.example.EcommerceBackend.Entity.Card;
import com.example.EcommerceBackend.Entity.Customer;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Repository.CustomerRepository;
import com.example.EcommerceBackend.Service.CardService;
import com.example.EcommerceBackend.Transformer.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws InvalidCustomerException {
        Customer customer = customerRepository.findByMobNo(cardRequestDto.getMobNo());
        if(customer == null){
            throw new InvalidCustomerException("Sorry customer doesn't exists");
        }

        Card card = CardTransformer.cardRequstDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCardList().add(card);
        customerRepository.save(customer);

        return CardTransformer.catrToCardResponseDto(card);
    }
}
