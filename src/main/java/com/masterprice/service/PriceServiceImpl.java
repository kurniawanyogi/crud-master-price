package com.masterprice.service;

import com.masterprice.domain.request.PriceRequest;
import com.masterprice.entity.Price;
import com.masterprice.repository.PriceRedisRepo;
import com.masterprice.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepository priceRepository;
    private final PriceRedisRepo priceRedisRepo;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Price savePrice(PriceRequest request) {
        Price price = new Price();
        price.setOriginCode(request.getOriginCode());
        price.setDestinationCode(request.getDestinationCode());
        price.setPrice(request.getPrice());
        price.setProduct(request.getProduct());
        Price saved = priceRepository.save(price);
        priceRedisRepo.savePrice(saved);
        return price;
    }

    @Override
    public Price getOneByProductId(Integer id) {
        return priceRedisRepo.getPriceById(id);
    }
}
