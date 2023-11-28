package com.item.repository;

import com.item.document.Product;
import com.item.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(ProductRepositoryTest.class);

    @Autowired
    private ProductService productService;


    @Test
    @DisplayName("product 단건 조회 테스트")
    void findProductTest(){
        String id = "product_3";

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        Mono<Product> productMono = productService.findProduct(id);
        endNanoTime = System.nanoTime();

        Product product = productMono.block();
        System.out.println(product.getName());
        System.out.println(product.getBrandName());
        System.out.println(product.getPrice());
        System.out.println("wasting time : "+(endNanoTime - startNanoTime));
    }
    
    @Test
    @DisplayName("brand id 로 상품 조회 테스트")
    void findProductByBrandTest(){
        int page = 9;
        int size = 10;
        Long brandId = 941L;

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();

        endNanoTime = System.nanoTime();
    }

    @Test
    @DisplayName("상품 검색 테스트")
    void findProductBySearchKeywordTest(){
        int page = 2;
        int size = 10;
        String keyword = "셔츠";

        long startNanoTime;
        long endNanoTime;
        log.info("go");
        startNanoTime = System.nanoTime();
        Mono<List<Product>> productMono = productService.searchProduct(keyword,page,size);
        endNanoTime = System.nanoTime();

        List<Product> productList = productMono.block();
        for(Product product : productList){
            System.out.println("product name : " +product.getName());
        }
        System.out.println("wasting time : "+(endNanoTime - startNanoTime));
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

        endNanoTime = System.nanoTime();
    }
}
