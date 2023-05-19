package com.example.EcommerceBackend.Entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cart")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    int cartTotal;
    int numberOfItem;
    @OneToOne
    @JoinColumn
    Customer customer;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();

}
