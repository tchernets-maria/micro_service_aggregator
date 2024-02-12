package org.transport.services;

import org.transport.models.types.Transport;
import org.springframework.stereotype.Service;
import org.transport.utils.MyPair;

@Service
public interface TransportService {

    String getName(Long id, Transport transport);

    String getCompanyInfo(Long id, Transport transport);

    MyPair<Long, Transport> findTransport(String name);
}
