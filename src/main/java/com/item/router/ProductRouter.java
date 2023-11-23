package com.item.router;

import com.item.handler.ProductHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration("productRouter")
public class ProductRouter {

    @Bean
    public RouterFunction<?> routeProduct(ProductHandler productHandler){
        return route()
                .GET("/product/{id}", productHandler::getOneProduct)
                .build();
    }
}
