package org.parent.services;

import org.parent.controllers.dto.InfoRoute;
import org.parent.controllers.dto.MainInfoRoute;
import org.springframework.stereotype.Service;

@Service
public interface RouteService {

    Iterable<MainInfoRoute> getAllRoutes();

    InfoRoute getInfoRoute(long id);

    void addRoute(Long idCompany, String fromName, String toName, String transportName);

}
