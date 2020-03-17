package com.softserve.tracking.TrackingService.service;

import com.softserve.tracking.TrackingService.dto.ScooterDto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

public class AvailableScooters {

    private static Set<ScooterDto> availableScooters = new HashSet<>();

    public ScooterDto getScooter(UUID id) {
        return availableScooters.stream().filter(data -> Objects.equals(data.getId(), id)).findFirst().get();
    }

    public void addScooter(ScooterDto scooter) {
        availableScooters.add(scooter);
    }

    public void removeScooter(UUID id) {
        availableScooters.removeIf(data -> Objects.equals(data.getId(), id));
    }

    public Set<ScooterDto> getAvailableScooters() {
        return availableScooters;
    }
}
