package com.item.service;

import com.item.repository.ProductRepository;
import com.item.document.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProduct(String id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException(id+" is not exists Product"));
    }

    public void saveAll(List<Product> productList){
        productRepository.saveAll(productList);
    }

    public List<Product> findAllBrandProduct(Long id){
        return productRepository.findAllByBrandId(id);
    }

    public List<Product> searchProduct(String keyword){
        return productRepository.findAllByNameContainsOrInfoContains(keyword);
    }
}
