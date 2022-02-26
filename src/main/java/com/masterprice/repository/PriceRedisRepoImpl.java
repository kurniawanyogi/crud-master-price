package com.masterprice.repository;

import com.masterprice.entity.Price;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceRedisRepoImpl implements PriceRedisRepo {
    private final String REDIS_CACHE_VALUE = "PRICE";

    private final PriceRepository priceRepository;

    @Resource(name = "redisTemplate")
    private HashOperations<String, Integer, Price> hashOperations;


    @Override
    public void savePrice(Price price) {
        hashOperations.putIfAbsent(REDIS_CACHE_VALUE, price.getId(), price);
    }

    @Override
    @Cacheable(value = REDIS_CACHE_VALUE, key = "#id")
    public Price getPriceById(Integer id) {
        Optional<Price> price = priceRepository.findById(id);

        return price.orElse(null);
    }
}
