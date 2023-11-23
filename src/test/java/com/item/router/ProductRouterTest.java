package com.item.router;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class ProductRouterTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("상품 디테일 가져오기")
    @Test
    public void productSaveTest() throws Exception {
        mockMvc.perform(get("/product/detail/product_3"))
                .andDo(MockMvcResultHandlers.print());
    }
}
