package com.inditex.pricesapi.core.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Price(
        long id,
        Brand brand,
        Product product,
        LocalDateTime startDate,
        LocalDateTime endDate,
        BigDecimal value,
        int priority
) {

}