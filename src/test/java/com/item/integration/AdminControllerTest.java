package com.item.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.dto.*;
import com.item.util.TestUtilService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@AutoConfigureRestDocs
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TestUtilService testUtilService;

    @RegisterExtension
    final RestDocumentationExtension restDocumentation = new RestDocumentationExtension("build/generated-snippets");

    @BeforeEach
    void initial(RestDocumentationContextProvider restDocumentation){
        mockMvc = testUtilService.setRestDocumentation(restDocumentation);
    }

    @DisplayName("상품 저장 테스트")
    @Test
    public void productSaveTest() throws Exception {
        List<QuantityDto> quantityDtoList = new ArrayList<>();
        quantityDtoList.add(new QuantityDto(5L,3L,"S",100));
        quantityDtoList.add(new QuantityDto(6L,3L,"M",100));
        quantityDtoList.add(new QuantityDto(7L,3L,"L",100));
        quantityDtoList.add(new QuantityDto(8L,3L,"XL",100));

        List<ProductImageDto> productImageDtoList = new ArrayList<>();
        productImageDtoList.add(new ProductImageDto(3L, 7L, "TITLE", "bear_1686581896495", 0));
        productImageDtoList.add(new ProductImageDto(3L, 8L, "TITLE", "flowers_1686581896968", 1));
        productImageDtoList.add(new ProductImageDto(3L, 9L, "INFO", "milk_1686581897101", 0));

        List<SizeDto> sizeDtoList = new ArrayList<>();
        sizeDtoList.add(new SizeDto(25L, 5L, "S", 7L, "어깨","48"));
        sizeDtoList.add(new SizeDto(25L, 5L, "S", 8L, "소매","92"));
        sizeDtoList.add(new SizeDto(25L, 5L, "S", 5L, "기장","65"));
        sizeDtoList.add(new SizeDto(25L, 6L, "M", 7L, "어깨","52"));
        sizeDtoList.add(new SizeDto(25L, 6L, "M", 8L, "소매","96"));
        sizeDtoList.add(new SizeDto(25L, 6L, "M", 5L, "기장","70"));
        sizeDtoList.add(new SizeDto(25L, 7L, "L", 7L, "어깨","56"));
        sizeDtoList.add(new SizeDto(25L, 7L, "L", 8L, "소매","100"));
        sizeDtoList.add(new SizeDto(25L, 7L, "L", 5L, "기장","75"));
        sizeDtoList.add(new SizeDto(25L, 8L, "XL", 7L, "어깨","60"));
        sizeDtoList.add(new SizeDto(25L, 8L, "XL", 8L, "소매","110"));
        sizeDtoList.add(new SizeDto(25L, 8L, "XL", 5L, "기장","80"));

        ProductInfoDto productInfoDto = new ProductInfoDto(3L,
                                                "j1q84zl8",
                                                "나이키 퀀텀 슬립 퀸즈 나이트",
                                                170000,
                                                "이것은 나이키의 혁명 나이키는 최고 하지만 나에게 나이키 신발은 없다!",
                                                "2023-06-12 23:58:16",
                                                "bear_1686581896495",
                                                1L,
                                                "NIKE",
                                                "nike_logo.png1685627330635");

        ProductDetailDto dto = new ProductDetailDto(productInfoDto, quantityDtoList, sizeDtoList, productImageDtoList);

        String content = objectMapper.writeValueAsString(dto);

        mockMvc.perform(post("/admin/save").contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document("admin/saveProduct",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @DisplayName("상품 배치 테스트")
    @Test
    public void productSaveAllTest() throws Exception {
        String content = objectMapper.writeValueAsString(null);

        mockMvc.perform(post("/admin/saveAll").contentType(MediaType.APPLICATION_JSON).content(content))
                .andDo(document("admin/saveAllProduct",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
