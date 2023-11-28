package com.item.router;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.dto.SearchRequestDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductRouterTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void init(){
    }


    @DisplayName("상품 디테일 조회")
    @Test
    public void getProductDetailTest() throws Exception {


    }

    @DisplayName("상품 검색 테스트")
    @Test
    public void getProductSearchTest() throws Exception {
        SearchRequestDto searchRequestDto = new SearchRequestDto("셔츠", 0, 10);
        String content = objectMapper.writeValueAsString(searchRequestDto);

        mockMvc.perform(post("/product/search").contentType(MediaType.APPLICATION_JSON).content(content))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }
}
