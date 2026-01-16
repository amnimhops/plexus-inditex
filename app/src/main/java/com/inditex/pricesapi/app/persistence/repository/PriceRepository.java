package com.inditex.pricesapi.app.persistence.repository;

import com.inditex.pricesapi.app.persistence.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity,Long> {
}
