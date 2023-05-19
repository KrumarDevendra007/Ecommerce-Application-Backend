package com.example.EcommerceBackend.Service.Impl;

import com.example.EcommerceBackend.DTO.RequestDTO.OrderRequestDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.ItemResponseDto;
import com.example.EcommerceBackend.DTO.ResponseDTO.OrderResponseDto;
import com.example.EcommerceBackend.Entity.*;
import com.example.EcommerceBackend.Exception.InvalidCardException;
import com.example.EcommerceBackend.Exception.InvalidCustomerException;
import com.example.EcommerceBackend.Exception.InvalidProductException;
import com.example.EcommerceBackend.Repository.CardRepository;
import com.example.EcommerceBackend.Repository.CustomerRepository;
import com.example.EcommerceBackend.Repository.OrderRepository;
import com.example.EcommerceBackend.Repository.ProductRepository;
import com.example.EcommerceBackend.Service.OrderService;
import com.example.EcommerceBackend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    ProductService productService;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    CardRepository cardRepository;
    @Autowired
    private OrderRepository orderRepository;
    public Ordered paceOrder(Customer customer, Card card) throws Exception {
        Cart cart = customer.getCart();

        Ordered order = new Ordered();
        order.setOrderNo(String.valueOf(UUID.randomUUID()));

        String maskCard = generateMaskedCard(card.getCardNo());
        order.setCardUsed(maskCard);
        order.setCustomer(customer);

            List<Item> orderedItem = new ArrayList<>();
            for(Item item : cart.getItemList()){
                try{
                   productService.decreaseProductQuantity(item);
                } catch (Exception e) {
                    throw new Exception("Product out of stock");
                }
            }

            order.setItemList(orderedItem);
            for(Item item : orderedItem)
                item.setOrder(order);
            order.setTotalValue(cart.getCartTotal());
            return order;
    }

    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto) throws Exception {

        Customer customer;

        try{
            customer = customerRepository.findById(orderRequestDto.getCustomerId()).get();
        }
        catch (Exception e){
            throw new InvalidCustomerException("Customer Id is invalid!");
        }

        Product product;
        try{
            product = productRepository.findById(orderRequestDto.getProductId()).get();
        }
        catch (Exception e){
            throw new InvalidProductException("Product doesn't exist");
        }
        Card card = cardRepository.findByCardNo(orderRequestDto.getCardNo());
        if(card == null || card.getCvv() != orderRequestDto.getCvv() || card.getCustomer() != customer){
            throw new InvalidCardException("Your card is not valid!");
        }

        Item item = Item.builder()
                .requiredQuantity(orderRequestDto.getRequiredQuantity())
                .product(product)
                .build();

        try {
            productService.decreaseProductQuantity(item);
        }
        catch (Exception e){
            throw new Exception((e.getMessage()));
        }

        Ordered order = new Ordered();
        order.setOrderNo(String.valueOf(UUID.randomUUID()));
        String maskCardNo = generateMaskedCard(card.getCardNo());
        order.setCardUsed(maskCardNo);
        order.setCustomer(customer);
        order.setTotalValue(item.getRequiredQuantity()*product.getPrice());
        order.getItemList().add(item);

        customer.getOrderedList().add(order);
        item.setOrder(order);
        product.getItemList().add(item);

        Ordered saveOrder = orderRepository.save(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderData(saveOrder.getOrderDate());
        orderResponseDto.setCardUsed(saveOrder.getCardUsed());
        orderResponseDto.setCustomerName(customer.getName());
        orderResponseDto.setOrderNo(saveOrder.getOrderNo());
        orderResponseDto.setTotalValue(saveOrder.getTotalValue());

        List<ItemResponseDto> items = new ArrayList<>();
        for(Item itemEntity : saveOrder.getItemList()){
            ItemResponseDto itemResponseDto = new ItemResponseDto();
            itemResponseDto.setPriceOfOneItem(itemEntity.getProduct().getPrice());
            itemResponseDto.setTotalPrice(itemEntity.getRequiredQuantity() * itemEntity.getProduct().getPrice());
            itemResponseDto.setProductName(itemEntity.getName());
            itemResponseDto.setQuantity(itemEntity.getRequiredQuantity());

            items.add(itemResponseDto);
        }

        orderResponseDto.setItems(items);

        return orderResponseDto;
    }

    public String generateMaskedCard(String cardNo){
        String maskCardNo = "";
        for(int i=0; i<cardNo.length()-4; i++)
            maskCardNo += 'X';

        maskCardNo += cardNo.substring(cardNo.length()-4);
        return maskCardNo;
    }
}
