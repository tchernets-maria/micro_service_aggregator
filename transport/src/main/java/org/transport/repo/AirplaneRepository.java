package org.transport.repo;

import org.transport.models.Airplane;
import org.springframework.data.repository.CrudRepository;

public interface AirplaneRepository extends CrudRepository<Airplane, Long> {
}
