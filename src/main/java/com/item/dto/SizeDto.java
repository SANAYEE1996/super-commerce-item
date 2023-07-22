package com.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SizeDto {

    private Long sizeId;

    private Long quantityId;

    private String measureName;

    private Long bodyId;

    private String bodyName;

    private String sizeValue;
}
