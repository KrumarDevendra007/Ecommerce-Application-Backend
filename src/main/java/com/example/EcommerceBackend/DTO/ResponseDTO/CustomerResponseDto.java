package com.example.EcommerceBackend.DTO.ResponseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class CustomerResponseDto {
    String name;
    String message;
}
