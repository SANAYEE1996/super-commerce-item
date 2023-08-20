package com.item.repository;

import com.item.document.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

    Page<Product> findByBrandIdIgnoreCase(Long id, Pageable pageable);

    Page<Product> findByNameContainingIgnoreCaseOrInfoContainingIgnoreCase(String keyword, String keyword1, Pageable pageable);
}
