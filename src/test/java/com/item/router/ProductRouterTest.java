package com.item.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.dto.SearchRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class ProductRouterTest {

    @Autowired
    private WebTestClient client;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("상품 디테일 조회")
    @Test
    public void getProductDetailTest() throws Exception {
        client.get().uri("/product/detail/product_3").exchange();
    }

    @DisplayName("상품 검색 테스트")
    @Test
    public void getProductSearchTest() throws Exception {
        SearchRequestDto searchRequestDto = new SearchRequestDto("나이키", 0, 10);
        String content = objectMapper.writeValueAsString(searchRequestDto);

    }
}
