package com.item.repository;

import com.item.document.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("product 단건 조회 테스트")
    void findProductTest(){
        String id = "product_3";

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        Product product = productRepository.findById(id).orElseThrow(()->new RuntimeException(""));
        endNanoTime = System.nanoTime();
        log.info("product get clear");
        log.info("time : {} sec", (double)(endNanoTime - startNanoTime)/1000000000);

        assertThat(product.getId()).isEqualTo(id);
        assertThat(product.getName()).isEqualTo("나이키 퀀텀 슬립 퀸즈 나이트");
    }
}