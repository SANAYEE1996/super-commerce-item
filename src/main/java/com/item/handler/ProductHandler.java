package com.item.handler;

import com.item.dto.SearchRequestDto;
import com.item.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component("productHandler")
@RequiredArgsConstructor
@Slf4j
public class ProductHandler {

    private final ProductService productService;

    public Mono<ServerResponse> getOneProduct(ServerRequest request){
        return productService.findProduct(request.pathVariable("id"))
                .flatMap(product -> ServerResponse.ok().bodyValue(product));
    }

    public Mono<ServerResponse> searchProduct(ServerRequest request){
        return request.bodyToMono(SearchRequestDto.class)
                .flatMap(req -> ServerResponse.ok().bodyValue(productService.searchProduct(req.getKeyword(), req.getPage(), req.getSize())));
    }
}
