package com.softserve.tracking.TrackingService.service;

import com.google.maps.model.LatLng;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OptimalRouteService {

    private ApiJsonParser parser = new ApiJsonParser();
    public static AvailableScooters availableScooters = new AvailableScooters();

    public JSONObject getPedestrianWay(LatLng userCoordinate, UUID scooterId) {
        if (availableScooters.getScooter(scooterId).getStatus()) {
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                    + userCoordinate + "&destination="
                    + availableScooters.getScooter(scooterId).getCoordinates() +
                    "&mode=walking&key=AIzaSyCdfHglvxpOUk20QZvCYXI7RI4HmHD_1zg";
            return parser.parse(url);
        } else {
            return null;
        }
    }

    public JSONObject getRoadWay(LatLng userCoordinate, UUID scooterId) {
        if (availableScooters.getScooter(scooterId).getStatus()) {
            String url = "https://maps.googleapis.com/maps/api/directions/json?origin="
                    + userCoordinate + "&destination="
                    + availableScooters.getScooter(scooterId).getCoordinates() +
                    "&key=AIzaSyCdfHglvxpOUk20QZvCYXI7RI4HmHD_1zg";
            return parser.parse(url);
        } else {
            return null;
        }
    }

}
