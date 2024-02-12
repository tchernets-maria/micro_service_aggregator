package org.transport.repo;

import org.transport.models.Train;
import org.springframework.data.repository.CrudRepository;

public interface TrainRepository extends CrudRepository<Train, Long> {
}
