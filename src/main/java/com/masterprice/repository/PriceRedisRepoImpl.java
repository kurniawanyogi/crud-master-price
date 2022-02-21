package com.masterprice.repository;

import com.masterprice.entity.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceRedisRepoImpl implements PriceRedisRepo {
    private final String REDIS_CACHE_VALUE = "PRICE";

    private final PriceRepository priceRepository;


    @Override
    @CachePut(value = REDIS_CACHE_VALUE, key = "#price.id")
    public void savePrice(Price price) {
        priceRepository.save(price);
    }

    @Override
    @CachePut(value = REDIS_CACHE_VALUE, key = "#id")
    public Price getPriceById(Integer id) {
        Optional<Price> price = priceRepository.findById(id);

        return price.orElse(null);
    }
}
