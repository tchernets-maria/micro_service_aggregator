package org.parent.services.Impl;

import org.parent.controllers.dto.InfoRoute;
import org.parent.controllers.dto.MainInfoRoute;
import org.parent.models.Company;
import org.parent.models.Route;
import org.parent.models.types.Station;
import org.parent.models.types.Transport;
import org.parent.repo.RouteRepository;
import org.parent.services.CompanyService;
import org.parent.services.RouteService;
import org.parent.services.StationService;
import org.parent.services.TransportService;
import org.parent.utils.MyPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RouteServiceImpl implements RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private StationService stationService;
    @Autowired
    private TransportService transportService;
    @Autowired
    private CompanyService companyService;

    @Override
    public Iterable<MainInfoRoute> getAllRoutes() {
        Iterable<Route> routes = routeRepository.findAll();
        List<MainInfoRoute> mainInfoRoutes = new ArrayList<>();
        routes.forEach(route ->
            mainInfoRoutes.add(new MainInfoRoute(route.getId(),
                    stationService.getName(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getName(route.getIdStationTo(), route.getStationTo()),
                    route.getTransport())));
        return mainInfoRoutes;
    }

    @Override
    public InfoRoute getInfoRoute(long id) {
        Optional<Route> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            Route route = optionalRoute.get();
            Company company = companyService.getCompany(route.getIdCompany());
            return new InfoRoute(route.getTransport(),
                    transportService.getName(route.getIdTransport(), route.getTransport()),
                    transportService.getCompanyInfo(route.getIdTransport(), route.getTransport()),
                    route.getStationFrom(),
                    stationService.getName(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getAddress(route.getIdStationFrom(), route.getStationFrom()),
                    stationService.getName(route.getIdStationTo(), route.getStationTo()),
                    stationService.getAddress(route.getIdStationTo(), route.getStationTo()),
                    company.getName(),
                    company.getEmail(),
                    company.getPhone());
        }
        return new InfoRoute();
    }

    @Override
    public void addRoute(Long idCompany, String fromName, String toName, String transportName) {
        MyPair<Long, Transport> transport = transportService.findTransport(transportName);
        if (transport == null) {
            return;
        }
        MyPair<Long, Station> stationFrom = stationService.findStation(fromName);
        if (stationFrom == null) {
            return;
        }
        MyPair<Long, Station> stationTo = stationService.findStation(toName);
        if (stationTo == null) {
            return;
        }
        routeRepository.save(new Route(transport.getFirst(), stationFrom.getFirst(), stationTo.getFirst(), idCompany,
                transport.getSecond(), stationFrom.getSecond(), stationTo.getSecond()));
    }
}
