package com.inditex.pricesapi.app.persistence.mapper;

import com.inditex.pricesapi.app.persistence.entity.PriceEntity;
import com.inditex.pricesapi.core.domain.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricePersistenceMapper {
    PriceEntity toEntity(Price price);
    Price toDomain(PriceEntity price);
}
