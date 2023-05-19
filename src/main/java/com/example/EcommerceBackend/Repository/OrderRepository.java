package com.example.EcommerceBackend.Repository;

import com.example.EcommerceBackend.Entity.Ordered;
import jakarta.persistence.criteria.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Ordered, Integer> {
}
