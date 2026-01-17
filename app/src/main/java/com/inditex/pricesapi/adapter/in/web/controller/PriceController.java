package com.inditex.pricesapi.adapter.in.web.controller;

import com.inditex.pricesapi.in.web.api.ApiApi;
import com.inditex.pricesapi.in.web.dto.Price;
import com.inditex.pricesapi.adapter.in.web.exception.ResourceNotFoundException;
import com.inditex.pricesapi.core.domain.port.in.QueryPricesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Validated
@RestController
public class PriceController implements ApiApi {
    QueryPricesUseCase queryPricesUseCase;
    PriceWebMapper priceWebMapper;

    public PriceController(
            QueryPricesUseCase queryPricesUseCase,
            PriceWebMapper priceWebMapper) {
        this.queryPricesUseCase = queryPricesUseCase;
        this.priceWebMapper = priceWebMapper;
    }

    @Override
    public ResponseEntity<Price> getPrice(Long brandId, Long productId, LocalDateTime date) {
        return ResponseEntity.ok(
                priceWebMapper.toResponse(
                        queryPricesUseCase
                                .findPriceByDate(brandId, productId, date)
                                .orElseThrow(() -> new ResourceNotFoundException("price"))));
    }
}
