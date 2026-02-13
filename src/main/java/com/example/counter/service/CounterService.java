package com.example.counter.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CounterService {
    private static final Logger log = LoggerFactory.getLogger(CounterService.class);
    private final StringRedisTemplate redisTemplate;
    private static final String COUNTER_KEY = "visit;count";

    public CounterService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public Long increment() {
        log.info("sada");
        return redisTemplate.opsForValue().increment(COUNTER_KEY);
    }

    public Long getCount() {
        String count = redisTemplate.opsForValue().get(COUNTER_KEY);
        return count == null ? 0L : Long.parseLong(count);
    }
}









