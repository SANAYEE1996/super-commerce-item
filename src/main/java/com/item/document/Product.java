package com.item.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Document("items")
public class Product {

    @MongoId
    private String id;

    private String name;

    private String code;

    private int price;

    private String info;

    private List<Quantity> quantityList;

    private List<Size> sizeList;

    private List<Image> imageList;
}
