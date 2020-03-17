package com.softserve.tracking.TrackingService.controller;

import com.google.maps.model.LatLng;
import com.softserve.tracking.TrackingService.dto.ScooterDto;
import com.softserve.tracking.TrackingService.service.OptimalRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final OptimalRouteService routeCalculator;

    @GetMapping("/available")
    public Set<ScooterDto> getAvailableScooters() {
        return OptimalRouteService.availableScooters.getAvailableScooters();
    }

    @GetMapping("/pedestrian/route")
    public String getPedestrianWay(@RequestBody LatLng userCoordinates, @RequestBody UUID scooterId) {
        return routeCalculator.getPedestrianWay(userCoordinates, scooterId).toString();
    }

    @GetMapping("/road/way")
    public String getRoadWay(@RequestBody LatLng userCoordinates, @RequestBody UUID scooterId) {
        return routeCalculator.getRoadWay(userCoordinates, scooterId).toString();
    }

}
