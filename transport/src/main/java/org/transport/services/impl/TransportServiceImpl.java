package org.transport.services.impl;

import org.transport.models.*;
import org.transport.models.types.Transport;
import org.transport.repo.AirplaneRepository;
import org.transport.repo.BusRepository;
import org.transport.repo.TrainRepository;
import org.transport.services.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.transport.utils.MyPair;

@Component
public class TransportServiceImpl implements TransportService {
    @Autowired
    private AirplaneRepository airplaneRepository;
    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private BusRepository busRepository;

    @Override
    public String getName(Long id, Transport transport) {
        return switch (transport) {
            case AIRPLANE -> airplaneRepository.findById(id).orElse(new Airplane()).getName();
            case TRAIN -> trainRepository.findById(id).orElse(new Train()).getName();
            case BUS -> busRepository.findById(id).orElse(new Bus()).getName();
        };
    }

    @Override
    public String getCompanyInfo(Long id, Transport transport) {
        return switch (transport) {
            case AIRPLANE -> airplaneRepository.findById(id).orElse(new Airplane()).getCompany_info();
            case TRAIN -> trainRepository.findById(id).orElse(new Train()).getCompany_info();
            case BUS -> busRepository.findById(id).orElse(new Bus()).getCompany_info();
        };
    }

    @Override
    public MyPair<Long, Transport> findTransport(String name) {
        for (Airplane airplane: airplaneRepository.findAll()) {
            if (airplane.getName().equals(name)) {
                return new MyPair<>(airplane.getId(), Transport.AIRPLANE);
            }
        }
        for (Train train: trainRepository.findAll()) {
            if (train.getName().equals(name)) {
                return new MyPair<>(train.getId(), Transport.TRAIN);
            }
        }
        for (Bus bus: busRepository.findAll()) {
            if (bus.getName().equals(name)) {
                return new MyPair<>(bus.getId(), Transport.BUS);
            }
        }
        return null;
    }
}
