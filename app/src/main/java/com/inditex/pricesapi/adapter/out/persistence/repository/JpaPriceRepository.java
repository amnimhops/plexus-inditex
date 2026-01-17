package com.inditex.pricesapi.adapter.out.persistence.repository;

import com.inditex.pricesapi.adapter.out.persistence.entity.PriceEntity;
import com.inditex.pricesapi.core.domain.port.out.PriceRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface JpaPriceRepository extends JpaRepository<PriceEntity, Long> {
    @Query("""
                SELECT p 
                FROM PriceEntity p
                WHERE p.brand.id = :brandId
                  AND p.product.id = :productId
                  AND :date BETWEEN p.startDate AND p.endDate
            """)
    List<PriceEntity> findPricesByDate(
            @Param("brandId") Long brandId,
            @Param("productId") Long productId,
            @Param("date") LocalDateTime date
    );
}
