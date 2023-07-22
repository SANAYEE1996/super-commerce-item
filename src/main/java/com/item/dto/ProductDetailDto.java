package com.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailDto {

    private ProductInfoDto productInfoDto;

    private List<QuantityDto> quantityDtoList;

    private List<SizeDto> sizeDtoList;

    private List<ProductImageDto> productImageDtoList;
}
