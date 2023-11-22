package com.item.controller;

import com.item.dto.ProductDetailDto;
import com.item.service.AdminService;
import com.item.util.Converter;
import com.item.util.ResponseDto;
import com.item.util.ResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    private final Converter converter;

    @PostMapping(value = "/save")
    public ResponseDto save(@RequestBody ProductDetailDto productDetailDto){
        //adminService.save(converter.toProduct(productDetailDto));
        log.info("get success");
        return ResponseDto.builder().code(ResponseStatus.OK.getStatusCode()).message("등록 성공").build();
    }
}
