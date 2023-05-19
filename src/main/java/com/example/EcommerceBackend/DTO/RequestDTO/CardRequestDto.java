package com.example.EcommerceBackend.DTO.RequestDTO;

import com.example.EcommerceBackend.Enum.CardType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CardRequestDto {
    String mobNo;
    String cardNo;
    int cvv;
    Date expiryDate;
    CardType cardType;
}
