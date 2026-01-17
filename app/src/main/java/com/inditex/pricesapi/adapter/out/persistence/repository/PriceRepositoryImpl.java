package com.inditex.pricesapi.adapter.out.persistence.repository;

import com.inditex.pricesapi.adapter.out.persistence.mapper.PricePersistenceMapper;
import com.inditex.pricesapi.core.domain.model.Brand;
import com.inditex.pricesapi.core.domain.model.Price;
import com.inditex.pricesapi.core.domain.model.Product;
import com.inditex.pricesapi.core.domain.port.out.PriceRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {
    JpaPriceRepository jpaPriceRepository;
    JpaBrandRepository jpaBrandRepository;
    JpaProductRepository jpaProductRepository;
    PricePersistenceMapper pricePersistenceMapper;

    public PriceRepositoryImpl(
            JpaPriceRepository jpaPriceRepository,
            JpaBrandRepository jpaBrandRepository,
            JpaProductRepository jpaProductRepository,
            PricePersistenceMapper pricePersistenceMapper){
        this.jpaPriceRepository = jpaPriceRepository;
        this.pricePersistenceMapper = pricePersistenceMapper;
    }

    @Override
    public List<Price> findPricesByDate(long brandId, long productId, LocalDateTime date) {
        var fu = jpaPriceRepository
                .findPricesByDate(brandId,productId,date)
                .stream();
        var bar = fu
                .map(pricePersistenceMapper::toDomain)
                .toList();

        return bar;
    }
}
