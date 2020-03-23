package com.softserve.tracking.TrackingService.service;

import com.softserve.tracking.TrackingService.dto.ScooterDto;
import com.softserve.tracking.TrackingService.repository.RedisRepositoryImpl;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private RedisRepositoryImpl repository;

    @KafkaListener // provide the topics, group_id when producer will be ready
    public void consume(ScooterDto scooterDto) {
        if (scooterDto.getStatus()) {
            repository.add(scooterDto);
        }
    }
}
