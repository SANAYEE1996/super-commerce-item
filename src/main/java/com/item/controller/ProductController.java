package com.item.controller;

import com.item.service.ProductService;
import com.item.util.ResponseBody;
import com.item.util.ResponseDto;
import com.item.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "/detail")
    public ResponseDto getDetailProduct(@RequestParam("id") String productId){
        try{
            return ResponseDto.builder().code(ResponseStatus.OK.getStatusCode()).body(new ResponseBody<>(productService.findProduct(productId))).build();
        }catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseDto.builder().code(ResponseStatus.EXCEPTION.getStatusCode()).message(e.getMessage()).build();
        }
    }

    @GetMapping(value = "/brand")
    public ResponseDto getBrandProductList(@RequestParam("id") Long id){
        try {
            return ResponseDto.builder().code(ResponseStatus.OK.getStatusCode()).body(new ResponseBody<>(productService.findAllBrandProduct(id))).build();
        }catch (RuntimeException e){
            log.error(e.getMessage());
            return ResponseDto.builder().code(ResponseStatus.EXCEPTION.getStatusCode()).message(e.getMessage()).build();
        }
    }
}
