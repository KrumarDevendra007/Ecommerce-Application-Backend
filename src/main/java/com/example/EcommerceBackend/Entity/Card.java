package com.example.EcommerceBackend.Entity;

import com.example.EcommerceBackend.Enum.CardType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "card")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int cardId;
    @Column(unique = true, nullable = false)
    String cardNo;
    int cvv;
    Date expiryDate;
    @Enumerated(EnumType.STRING)
    CardType cardType;
    @ManyToOne
    @JoinColumn
    Customer customer;
}
