package com.item.service;

import com.item.repository.ProductRepository;
import com.item.document.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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

    public List<Product> findAllBrandProduct(Long id, int page, int size){
        return productRepository.findByBrandId(id, PageRequest.of(page, size)).getContent();
    }

    public List<Product> searchProduct(String keyword, int page, int size){
        return productRepository.findByNameContainingIgnoreCaseOrInfoContainingIgnoreCase(keyword, keyword, PageRequest.of(page, size)).getContent();
    }

    public List<Product> findAll(int page, int size){
        return productRepository.findAll(PageRequest.of(page, size)).getContent();
    }
}
