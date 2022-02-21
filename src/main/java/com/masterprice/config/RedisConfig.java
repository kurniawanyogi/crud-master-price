package com.masterprice.config;

import com.masterprice.entity.Price;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Price> redisTemplate() {
        RedisTemplate<String, Price> priceRedisTemplate = new RedisTemplate<>();
        priceRedisTemplate.setConnectionFactory(redisConnectionFactory());
        priceRedisTemplate.afterPropertiesSet();
        priceRedisTemplate.setEnableTransactionSupport(true);

        return priceRedisTemplate;
    }

}
