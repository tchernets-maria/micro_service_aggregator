package org.estation.services;

import org.estation.models.types.Station;
import org.estation.utils.MyPair;
import org.springframework.stereotype.Service;

@Service
public interface StationService {

    String getName(Long id, Station station);

    String getAddress(Long id, Station station);

    MyPair<Long, Station> findStation(String name);
}
