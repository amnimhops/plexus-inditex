package com.inditex.pricesapi.core.application.service;

import com.inditex.pricesapi.core.domain.port.in.QueryPricesUseCase;
import com.inditex.pricesapi.core.domain.port.out.PriceRepository;
import com.inditex.pricesapi.core.domain.model.Brand;
import com.inditex.pricesapi.core.domain.model.Price;
import com.inditex.pricesapi.core.domain.model.Product;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

public class QueryPricesService implements QueryPricesUseCase {
    private PriceRepository priceRepository;

    public QueryPricesService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public Optional<Price> findPrice(Brand brand, Product product, LocalDateTime start, LocalDateTime end) {
        return priceRepository
                .findPricesByTimeRange(brand,product,start,end)
                .stream()
                .max(Comparator.comparingInt(Price::priority));
    }
}
