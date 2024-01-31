package com.sujeet.project.springboot.service;

import com.sujeet.project.springboot.inf.FlightRadarService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Profile("prod")
@Service
public class FlightRadarServiceImpl implements FlightRadarService {

    @Override
    public Map<String, Double> getFlightLocation(String flightName) {
        System.out.println("Getting map location of flight from satellite");
        Map<String, Double> flightLocationMap = new HashMap<String, Double>();
        Double lat = 29.9;
        Double lon = 25.67;
        flightLocationMap.put("latitude", lat);
        flightLocationMap.put("longitude", lon);
        return flightLocationMap;
    }
}
