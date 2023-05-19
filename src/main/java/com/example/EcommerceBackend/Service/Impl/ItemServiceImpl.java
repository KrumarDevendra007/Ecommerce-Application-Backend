package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.ItemRequestDto;
import com.example.EcommerceBackend.Entity.Customer;
import com.example.EcommerceBackend.Entity.Item;
import com.example.EcommerceBackend.Entity.Product;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Exception.InvalidProductException;
import com.example.EcommerceBackend.Repository.CustomerRepository;
import com.example.EcommerceBackend.Repository.ItemRepository;
import com.example.EcommerceBackend.Repository.ProductRepository;
import com.example.EcommerceBackend.Service.ItemService;
import com.example.EcommerceBackend.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ProductRepository productRepository;

    @Override
    public Item addItem(ItemRequestDto itemRequestDto) throws InvalidCustomerException, InvalidProductException {
        Customer customer;
        try{
            customer = customerRepository.findById(itemRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new InvalidCustomerException("Customer Id is invalid!");
        }

        Product product;
        try{
            product = productRepository.findById(itemRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new InvalidProductException("Product dose not exist");
        }

        Item item = ItemTransformer.itemToItemRequestDto(itemRequestDto);
        item.setProduct(product);

        product.getItemList().add(item);
        return itemRepository.save(item);
    }
}
