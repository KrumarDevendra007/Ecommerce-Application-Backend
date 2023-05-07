package com.example.EcommerceBackend.DTO.ResponceDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SellerResponseDto {

    String name;
    int age;
}
