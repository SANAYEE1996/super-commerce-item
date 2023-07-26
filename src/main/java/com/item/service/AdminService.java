package com.item.service;

import com.item.repository.ProductRepository;
import com.item.document.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminService {

    private final ProductRepository productRepository;

    public void save(Product product){
        productRepository.save(product);
    }
}
