package com.example.EcommerceBackend.Repository;

import com.example.EcommerceBackend.Entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
