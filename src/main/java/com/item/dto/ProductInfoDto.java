package com.item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoDto {

    private Long id;

    private String productCode;

    private String productName;

    private int productPrice;

    private String productInfo;

    private String productRegisterDate;

    private String productThumbnail;

    private Long brandId;

    private String brandName;

    private String brandLogoImage;


}
