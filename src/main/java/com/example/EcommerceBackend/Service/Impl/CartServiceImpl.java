package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.CheckOutCartRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.CartResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.ItemResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Entity.*;
import com.example.EcommerceBackend.Exception.InvalidCardException;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Repository.CardRepository;
import com.example.EcommerceBackend.Repository.CartRepository;
import com.example.EcommerceBackend.Repository.CustomerRepository;
import com.example.EcommerceBackend.Repository.OrderRepository;
import com.example.EcommerceBackend.Service.CartService;
import com.example.EcommerceBackend.Service.OrderService;
import com.example.EcommerceBackend.Transformer.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Override
    public CartResponseDto saveCart(int customerId, Item item) {
        Customer customer = customerRepository.findById(customerId).get();

        Cart cart = customer.getCart();

        int newTotal = cart.getCartTotal() + item.getRequiredQuantity() * item.getProduct().getPrice();
        cart.setCartTotal(newTotal);
        cart.getItemList().add(item);
        cart.setNumberOfItem(cart.getItemList().size());
        item.setCart(cart);

        Cart savedCart = cartRepository.save(cart);

        CartResponseDto cartResponseDto = CartResponseDto.builder()
                                          .cartTotal(savedCart.getCartTotal())
                                          .customerName(customer.getName())
                                          .numberOfItem(savedCart.getNumberOfItem())
                                          .build();


        List<ItemResponseDto> itemResponseDtoList = new ArrayList<>();
       for(Item itemEntity : savedCart.getItemList()){
           ItemResponseDto itemResponseDto = ItemTransformer.itemToItemResponseDto(itemEntity);
           itemResponseDtoList.add(itemResponseDto);
       }

       cartResponseDto.setItems(itemResponseDtoList);

       return cartResponseDto;
    }

    public OrderResponseDto checkOutCart(CheckOutCartRequestDto checkOutCartRequestDto) throws Exception {

        Customer customer;
        try{
            customer = customerRepository.findById(checkOutCartRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new InvalidCustomerException("Customer is invalid");
        }

        Card card = cardRepository.findByCardNo(checkOutCartRequestDto.getCardNo());
        if(card == null || card.getCvv() != checkOutCartRequestDto.getCvv() || card.getCustomer() != customer){
            throw new InvalidCardException("Your card is not valid!");
        }

        Cart cart = customer.getCart();
        if(cart.getNumberOfItem() == 0){
            throw new Exception("Cart is empty!");
        }

        try{
            Ordered order = orderService.paceOrder(customer, card);
            customer.getOrderedList().add(order);
            resetCart(cart);
            Ordered saveOrder = orderRepository.save(order);

            OrderResponseDto orderResponseDto = new OrderResponseDto();
            orderResponseDto.setOrderData(saveOrder.getOrderDate());
            orderResponseDto.setCardUsed(saveOrder.getCardUsed());
            orderResponseDto.setCustomerName(customer.getName());
            orderResponseDto.setOrderNo(saveOrder.getOrderNo());
            orderResponseDto.setTotalValue(saveOrder.getTotalValue());

            List<ItemResponseDto> items = new ArrayList<>();
            for(Item itemEntity : saveOrder.getItemList()){
                ItemResponseDto itemResponseDto = ItemTransformer.itemToItemResponseDto(itemEntity);
                items.add(itemResponseDto);
            }

            orderResponseDto.setItems(items);
            return orderResponseDto;
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public void resetCart(Cart cart){

        cart.setCartTotal(0);
        for(Item item : cart.getItemList()){
            item.setCart(null);
        }

        cart.setNumberOfItem(0);
        cart.getItemList().clear();
    }
}
