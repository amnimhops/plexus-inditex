package com.inditex.pricesapi.core.domain.port.out;

import com.inditex.pricesapi.core.domain.model.Brand;
import com.inditex.pricesapi.core.domain.model.Price;
import com.inditex.pricesapi.core.domain.model.Product;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepository {
    List<Price> findPricesByTimeRange(Brand brand, Product product, LocalDateTime start, LocalDateTime end);
}
