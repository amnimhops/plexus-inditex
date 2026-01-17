package com.inditex.pricesapi.adapter.out.persistence.repository;

import com.inditex.pricesapi.adapter.out.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductEntity, Long> {
}
