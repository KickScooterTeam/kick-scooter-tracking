package com.softserve.tracking.TrackingService.controller;

import com.google.maps.model.LatLng;
import com.softserve.tracking.TrackingService.dto.ScooterDto;
import com.softserve.tracking.TrackingService.repository.RedisRepositoryImpl;
import com.softserve.tracking.TrackingService.service.OptimalRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final OptimalRouteService routeCalculator;
    private final RedisRepositoryImpl repository;

    @GetMapping("/available")
    public Map<String, ScooterDto> getAvailableScooters() {
        return repository.findAll();
    }

    @GetMapping("/way/{id}")
    public String getNearestWay(@PathVariable UUID id, @RequestBody LatLng userCoords) {
        return routeCalculator.getRoadWay(userCoords, id).toString();
    }

}
