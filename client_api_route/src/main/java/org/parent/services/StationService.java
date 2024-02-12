package org.parent.services;

import org.parent.models.types.Station;
import org.parent.utils.MyPair;
import org.springframework.stereotype.Service;

@Service
public interface StationService {

    String getName(Long id, Station station);

    String getAddress(Long id, Station station);

    MyPair<Long, Station> findStation(String name);
}
