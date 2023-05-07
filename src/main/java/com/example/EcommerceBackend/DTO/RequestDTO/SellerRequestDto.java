package com.example.EcommerceBackend.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerRequestDto {

    String name;
    String emailId;
    int age;
    String mobNo;

}
