package com.softserve.tracking.TrackingService.repository;

import com.softserve.tracking.TrackingService.dto.ScooterDto;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface RedisRepository {

    Map<String, ScooterDto> findAll();
    void add(ScooterDto scooter);
    void delete(UUID id);
    void update(ScooterDto scooter);
    ScooterDto findScooter(UUID id);

}
