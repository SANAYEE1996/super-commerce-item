package com.item.router;

import com.item.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration("productRouter")
public class ProductRouter {

    @Bean
    public RouterFunction<?> routeProduct(ProductHandler productHandler){
        return route()
                .GET("/product/detail/{id}", accept(MediaType.APPLICATION_JSON), productHandler::getOneProduct)
                .POST("/product/search", accept(MediaType.APPLICATION_JSON), productHandler::searchProduct)
                .POST("/product/brand", accept(MediaType.APPLICATION_JSON), productHandler::findAllBrandProduct)
                .build();
    }
}
