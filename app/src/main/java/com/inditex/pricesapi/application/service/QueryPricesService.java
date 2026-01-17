package com.inditex.pricesapi.application.service;

import com.inditex.pricesapi.adapter.out.persistence.entity.PriceEntity;
import com.inditex.pricesapi.adapter.out.persistence.mapper.PricePersistenceMapper;
import com.inditex.pricesapi.core.domain.port.in.QueryPricesUseCase;
import com.inditex.pricesapi.core.domain.port.out.PriceRepository;
import com.inditex.pricesapi.core.domain.model.Brand;
import com.inditex.pricesapi.core.domain.model.Price;
import com.inditex.pricesapi.core.domain.model.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
public class QueryPricesService implements QueryPricesUseCase {
    private final PriceRepository priceRepository;

    public QueryPricesService(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }


    @Override
    public Optional<Price> findPriceByDate(long brandId, long productId, LocalDateTime date){
        return priceRepository
                .findPricesByDate(brandId,productId,date)
                .stream()
                .max(Comparator.comparingInt(Price::priority));
    }
}
