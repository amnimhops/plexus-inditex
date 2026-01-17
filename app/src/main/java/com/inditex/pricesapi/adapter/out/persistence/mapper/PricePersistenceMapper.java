package com.inditex.pricesapi.adapter.out.persistence.mapper;

import com.inditex.pricesapi.adapter.out.persistence.entity.BrandEntity;
import com.inditex.pricesapi.adapter.out.persistence.entity.PriceEntity;
import com.inditex.pricesapi.adapter.out.persistence.entity.ProductEntity;
import com.inditex.pricesapi.core.domain.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricePersistenceMapper {
    PriceEntity toEntity(Price price);
    @Mapping(target = "brandId", source = "entity.brand.id")
    @Mapping(target = "productId", source = "entity.product.id")
    Price toDomain(PriceEntity entity);
}
