package com.softserve.tracking.TrackingService.service;

import com.softserve.tracking.TrackingService.dto.ScooterDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener // provide the topics, group_id when producer will be ready
    public void consume(ScooterDto scooterDto) {
        if (scooterDto.getStatus()) {
            OptimalRouteService.availableScooters.addScooter(scooterDto);
        } else {
            OptimalRouteService.availableScooters.removeScooter(scooterDto.getId());
        }
    }
}
