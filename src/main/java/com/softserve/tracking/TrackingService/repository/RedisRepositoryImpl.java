package com.softserve.tracking.TrackingService.repository;

import com.softserve.tracking.TrackingService.dto.ScooterDto;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.UUID;

@Repository
public class RedisRepositoryImpl implements RedisRepository {

    private RedisTemplate<String, ScooterDto> redisTemplate;
    private HashOperations hashOperations;

    public RedisRepositoryImpl(RedisTemplate<String, ScooterDto> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<String, ScooterDto> findAll() {
        return hashOperations.entries("SCOOTER");
    }

    @Override
    public void add(ScooterDto scooter) {
        hashOperations.put("SCOOTER", scooter.getId(), scooter);
    }

    @Override
    public void delete(UUID id) {
        hashOperations.delete("SCOOTER", id);
    }

    @Override
    public void update(ScooterDto scooter) {
        add(scooter);
    }

    @Override
    public ScooterDto findScooter(UUID id) {
        return (ScooterDto) hashOperations.get("SCOOTER", id);
    }

}
