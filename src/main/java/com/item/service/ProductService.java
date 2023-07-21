package com.item.service;

import com.item.ProductRepository;
import com.item.document.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }

    public Product findProduct(String id){
        return productRepository.findById(id).orElseThrow(()-> new RuntimeException(id+" is not exists Product"));
    }
}
