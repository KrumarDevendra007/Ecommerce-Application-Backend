package com.example.EcommerceBackend.Repository;

import com.example.EcommerceBackend.Entity.Cart;
import com.example.EcommerceBackend.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
