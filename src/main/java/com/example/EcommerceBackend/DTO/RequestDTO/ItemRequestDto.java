package com.example.EcommerceBackend.DTO.RequestDTO;

import jakarta.persistence.criteria.Order;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ItemRequestDto {

    int customerId;
    int productId;
    int requiredQuantity;

}
