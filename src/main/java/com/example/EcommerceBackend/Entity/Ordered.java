package com.example.EcommerceBackend.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ordered")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ordered {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String orderNo;
    int totalValue;
    Date orderDate;
    String cardUsed;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    List<Item> itemList = new ArrayList<>();
    @ManyToOne
    @JoinColumn
    Customer customer;
}
