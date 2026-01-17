package com.inditex.pricesapi.core.domain.port.in;

import com.inditex.pricesapi.core.domain.model.Brand;
import com.inditex.pricesapi.core.domain.model.Price;
import com.inditex.pricesapi.core.domain.model.Product;

import java.time.LocalDateTime;
import java.util.Optional;

public interface QueryPricesUseCase {
    Optional<Price> findPriceByDate(long brandId, long productId, LocalDateTime date);
}
