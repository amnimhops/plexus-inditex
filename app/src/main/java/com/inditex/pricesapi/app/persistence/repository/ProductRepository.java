package com.inditex.pricesapi.app.persistence.repository;

import com.inditex.pricesapi.app.persistence.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
