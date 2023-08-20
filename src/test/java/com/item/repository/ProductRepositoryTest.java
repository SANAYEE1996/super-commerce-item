package com.item.repository;

import com.item.document.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

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
    
    @Test
    @DisplayName("brand id 로 상품 조회 테스트")
    void findProductByBrandTest(){
        Long brandId = 941L;

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        List<Product> productList = productRepository.findAllByBrandId(brandId);
        endNanoTime = System.nanoTime();
        log.info("result size : {}", productList.size());
        log.info("product get clear");
        log.info("time : {} sec", (double)(endNanoTime - startNanoTime)/1000000000);

    }

    @Test
    @DisplayName("상품 검색 테스트")
    void findProductBySearchKeywordTest(){
        String keyword = "셔츠";

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        List<Product> productList = productRepository.findAllByNameContainsOrInfoContains(keyword, keyword);
        endNanoTime = System.nanoTime();
        log.info("result size : {}", productList.size());
        log.info("product get clear");
        log.info("time : {} sec", (double)(endNanoTime - startNanoTime)/1000000000);
    }

    @Test
    @DisplayName("상품 페이징 테스트")
    void pagingTest(){
        int page = 0;
        int size = 10;

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        List<Product> productList = productRepository.findAll(PageRequest.of(page, size)).getContent();
        endNanoTime = System.nanoTime();
        log.info("result size : {}", productList.size());
        log.info("product get clear");
        log.info("time : {} sec", (double)(endNanoTime - startNanoTime)/1000000000);
        for(Product product : productList){
            System.out.println(product.getId() + " " +product.getName());
        }
    }
}
