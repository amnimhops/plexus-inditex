package com.inditex.pricesapi.adapter.in.web.controller;

import com.inditex.pricesapi.in.web.dto.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceWebMapper {
    @Mapping(target = "start", source = "price.startDate")
    @Mapping(target = "end", source = "price.endDate")
    Price toResponse(com.inditex.pricesapi.core.domain.model.Price price);

    @Mapping(target = "startDate", source = "price.start")
    @Mapping(target = "endDate", source = "price.end")
    @Mapping(target = "priority", constant = "0")
    com.inditex.pricesapi.core.domain.model.Price toDomain(Price price);
}
