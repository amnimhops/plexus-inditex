package com.inditex.pricesapi.adapter.in.web.controller;


import com.example.app.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceWebMapper {
    @Mapping(target = "start", source = "price.startDate")
    @Mapping(target = "end", source = "price.endDate")
    Price toResponse(com.inditex.pricesapi.core.domain.model.Price price);
    com.inditex.pricesapi.core.domain.model.Price toDomain(Price price);
}
