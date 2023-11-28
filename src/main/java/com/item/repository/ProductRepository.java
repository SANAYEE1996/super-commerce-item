package com.item.repository;

import com.item.document.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findByNameContainingIgnoreCaseOrInfoContainingIgnoreCase(String name, String info, Pageable pageable);

    Flux<Product> findByBrandId(Long id, Pageable pageable);
}
