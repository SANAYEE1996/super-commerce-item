package com.item.handler;

import com.item.dto.ProductRequestDto;
import com.item.service.ProductService;
import com.item.util.RequestValidator;
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

    private final RequestValidator<ProductRequestDto> validator;

    public Mono<ServerResponse> getOneProduct(ServerRequest request){
        return productService.findProduct(request.pathVariable("id"))
                .flatMap(product -> ServerResponse.ok().bodyValue(product));
    }

    public Mono<ServerResponse> searchProduct(ServerRequest request){
        return request.bodyToMono(ProductRequestDto.class)
                .doOnNext(validator::validate)
                .flatMap(req -> productService.searchProduct(req.getKeyword(), req.getPage(), req.getSize()))
                .flatMap(products -> ServerResponse.ok().bodyValue(products));
    }

    public Mono<ServerResponse> findAllBrandProduct(ServerRequest request){
        return request.bodyToMono(ProductRequestDto.class)
                .doOnNext(validator::validate)
                .doOnNext(validator::brandValidate)
                .flatMap(req -> productService.findAllBrandProduct(req.getBrandId(), req.getPage(), req.getSize()))
                .flatMap(products -> ServerResponse.ok().bodyValue(products));
    }
}
