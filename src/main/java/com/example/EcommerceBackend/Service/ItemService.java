package com.example.EcommerceBackend.Service;

import com.example.EcommerceBackend.DTO.RequestDTO.ItemRequestDto;
import com.example.EcommerceBackend.Entity.Item;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Exception.InvalidProductException;

public interface ItemService {

    public Item addItem(ItemRequestDto itemRequestDto) throws InvalidCustomerException, InvalidProductException;

}
