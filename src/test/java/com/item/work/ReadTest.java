package com.item.work;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.document.Product;
import com.item.dto.ProductDetailDto;
import com.item.service.ProductService;
import com.item.util.Converter;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class ReadTest {

    @Value("${testUtil.fileLocation}")
    private String fileLocation;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Converter converter;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("json 파일 읽기")
    void readTest() throws Exception{
        FileReader reader = new FileReader(fileLocation+"/test.json");
        JSONParser parser = new JSONParser();
        JSONArray jsonObject = (JSONArray) parser.parse(reader);

        List<ProductDetailDto> dtoList = Arrays.asList(objectMapper.readValue(jsonObject.toString(), ProductDetailDto[].class));

        List<Product> productList = new ArrayList<>();

        for (ProductDetailDto productDetailDto : dtoList){
            System.out.println(productDetailDto.getProductInfoDto().toString());
            productList.add(converter.toProduct(productDetailDto));
        }

        productService.saveAll(productList);
    }

}
