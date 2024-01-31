package com.sujeet.project.springboot.inf;

import java.util.Map;

public interface FlightRadarService {
    Map<String, Double> getFlightLocation(String flightName);
}
