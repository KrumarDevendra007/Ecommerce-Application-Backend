package com.example.EcommerceBackend.DTO.RequestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerRequestDto {
    String name;
    String email;
    int age;
    String mobNo;
    String address;
}
