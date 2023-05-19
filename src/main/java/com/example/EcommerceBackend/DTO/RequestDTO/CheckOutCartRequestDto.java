package com.example.EcommerceBackend.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CheckOutCartRequestDto {

    int customerId;
    String cardNo;
    int cvv;
}
