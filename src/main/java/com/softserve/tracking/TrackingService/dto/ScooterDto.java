package com.softserve.tracking.TrackingService.dto;

import com.google.maps.model.LatLng;
import lombok.Data;

import java.util.UUID;

@Data
public class ScooterDto {

    private UUID id;
    private Boolean status;
    private LatLng coordinates;

}
