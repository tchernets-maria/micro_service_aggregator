package org.estation.repo;

import org.estation.models.Airport;
import org.springframework.data.repository.CrudRepository;

public interface AirportRepository extends CrudRepository<Airport, Long> {
}
