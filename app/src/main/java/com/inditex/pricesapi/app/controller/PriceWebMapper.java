package com.inditex.pricesapi.app.controller;


import com.example.app.model.Price;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceWebMapper {
    Price toResponse(com.inditex.pricesapi.core.domain.model.Price price);
    com.inditex.pricesapi.core.domain.model.Price toDomain(Price price);

}
