package com.inditex.pricesapi.app.controller;

import com.example.app.api.ApiApi;
import com.example.app.model.Price;
import com.inditex.pricesapi.app.persistence.mapper.PricePersistenceMapper;
import com.inditex.pricesapi.app.persistence.repository.PriceRepository;
import com.inditex.pricesapi.app.persistence.repository.ProductRepository;
import com.inditex.pricesapi.core.domain.port.in.QueryPricesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@Validated
@RestController
public class PriceController implements ApiApi {
    @Autowired
    private PriceRepository repo;
    @Autowired
    private PricePersistenceMapper entityMapper;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PriceWebMapper webMapper;
    @Override
    public ResponseEntity<Price> getPrice(Long brandId, Long productId, OffsetDateTime start, OffsetDateTime end) {
        var test = repo.findAll();
        var bar = productRepository.findAll();
        //** Por aqui, el mapper no devuelve los attr brand,product porque en la entidad no estan, ahora tocan los joins
        var fu = entityMapper.toDomain(test.get(0));
        var item = webMapper.toResponse(fu);
        return ResponseEntity.ok(item);
    }
}
