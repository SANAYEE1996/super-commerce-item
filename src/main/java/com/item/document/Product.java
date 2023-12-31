package com.item.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document("items")
@CompoundIndex(name = "name_info", def = "{'info':1,'name':1}")
public class Product {

    @MongoId
    private String id;

    private String name;

    private String code;

    private int price;

    private String info;

    private String thumbNail;

    @Indexed
    private Long brandId;

    private String brandName;

    private String brandLogoImage;

    private List<Quantity> quantityList;

    private List<Size> sizeList;

    private List<Image> imageList;
}
