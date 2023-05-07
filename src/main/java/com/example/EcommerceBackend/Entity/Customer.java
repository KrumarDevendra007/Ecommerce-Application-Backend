package com.example.EcommerceBackend.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  int customerId;
  String name;
  String emailId;
  int age;
  String mobNo;
  String address;
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  List<Card> cardList = new ArrayList<>();
  @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
  Cart cart;
  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  List<Ordered> orderedList = new ArrayList<>();

}
