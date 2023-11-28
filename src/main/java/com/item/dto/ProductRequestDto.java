package com.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

    private String keyword;

    private Long brandId;

    private int page;

    private int size;
}
