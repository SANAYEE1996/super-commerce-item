package com.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class QuantityDto {

    private Long quantityId;

    private Long productId;

    private String quantityName;

    private int quantity;
}
