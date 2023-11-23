package com.item.handler;

import com.item.document.Product;
import com.item.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component("productHandler")
@RequiredArgsConstructor
public class ProductHandler {

    private final ProductService productService;

    public Mono<ServerResponse> getOneProduct(ServerRequest request){

        String productId = request.pathVariable("id");

        Product productDetailDto =  productService.findProduct(productId);

        return ServerResponse.ok().bodyValue(productDetailDto).switchIfEmpty(ServerResponse.notFound().build());
    }
}
