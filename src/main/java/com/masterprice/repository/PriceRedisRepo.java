package com.masterprice.repository;

import com.masterprice.entity.Price;

public interface PriceRedisRepo {

    void savePrice(Price price);

    Price getPriceById(Integer id);
}
