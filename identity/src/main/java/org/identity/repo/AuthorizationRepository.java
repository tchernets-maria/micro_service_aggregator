package org.identity.repo;

import org.identity.models.Authorization;
import org.springframework.data.repository.CrudRepository;

public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {
}
