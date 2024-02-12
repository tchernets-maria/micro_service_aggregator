package org.estation.services.impl;

import org.estation.models.*;
import org.estation.models.types.Station;
import org.estation.repo.AirportRepository;
import org.estation.repo.BusStationRepository;
import org.estation.repo.RailwayStationRepository;
import org.estation.services.StationService;
import org.estation.utils.MyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StationServiceImpl implements StationService {
    @Autowired
    private AirportRepository airportRepository;
    @Autowired
    private RailwayStationRepository railwayStationRepository;
    @Autowired
    private BusStationRepository busStationRepository;

    @Override
    public String getName(Long id, Station station) {
        return switch (station) {
            case AIRPORT -> airportRepository.findById(id).orElse(new Airport()).getName();
            case BUSSTATION -> busStationRepository.findById(id).orElse(new BusStation()).getName();
            case RAILWAYSTATION -> railwayStationRepository.findById(id).orElse(new RailwayStation()).getName();
        };
    }

    @Override
    public String getAddress(Long id, Station station) {
        return switch (station) {
            case AIRPORT -> airportRepository.findById(id).orElse(new Airport()).getAddress();
            case BUSSTATION -> busStationRepository.findById(id).orElse(new BusStation()).getAddress();
            case RAILWAYSTATION -> railwayStationRepository.findById(id).orElse(new RailwayStation()).getAddress();
        };
    }

    @Override
    public MyPair<Long, Station> findStation(String name) {
        for (Airport airport: airportRepository.findAll()) {
            if (airport.getName().equals(name)) {
                return new MyPair<>(airport.getId(), Station.AIRPORT);
            }
        }
        for (BusStation busStation: busStationRepository.findAll()) {
            if (busStation.getName().equals(name)) {
                return new MyPair<>(busStation.getId(), Station.BUSSTATION);
            }
        }
        for (RailwayStation railwayStation: railwayStationRepository.findAll()) {
            if (railwayStation.getName().equals(name)) {
                return new MyPair<>(railwayStation.getId(), Station.RAILWAYSTATION);
            }
        }
        return null;
    }
}
