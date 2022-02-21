package com.masterprice.service;

import com.masterprice.domain.request.PriceRequest;
import com.masterprice.entity.Price;

public interface PriceService {
    Price savePrice(PriceRequest request);

    Price getOneByProductId(Integer id);
}
