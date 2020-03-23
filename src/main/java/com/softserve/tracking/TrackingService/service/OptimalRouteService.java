package com.softserve.tracking.TrackingService.service;

import com.google.maps.model.LatLng;
import com.softserve.tracking.TrackingService.repository.RedisRepositoryImpl;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OptimalRouteService {

    private ApiJsonParser parser = new ApiJsonParser();
    private RedisRepositoryImpl repository;

    public JSONObject getPedestrianWay(LatLng userCoordinate, UUID scooterId) {
        if (repository.findScooter(scooterId).getStatus()) {
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                    + userCoordinate + "&destination="
                    + repository.findScooter(scooterId).getCoordinates() +
                    "&mode=walking&key=AIzaSyCdfHglvxpOUk20QZvCYXI7RI4HmHD_1zg";
            return parser.parse(url);
        } else {
            return null;
        }
    }

    public JSONObject getRoadWay(LatLng userCoordinate, UUID scooterId) {
        if (repository.findScooter(scooterId).getStatus()) {
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                    + userCoordinate + "&destination="
                    + repository.findScooter(scooterId).getCoordinates() +
                    "&key=AIzaSyCdfHglvxpOUk20QZvCYXI7RI4HmHD_1zg";
            return parser.parse(url);
        } else {
            return null;
        }
    }

}
