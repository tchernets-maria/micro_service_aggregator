package org.parent.services;

import org.parent.models.types.Transport;
import org.parent.utils.MyPair;
import org.springframework.stereotype.Service;

@Service
public interface TransportService {

    String getName(Long id, Transport transport);

    String getCompanyInfo(Long id, Transport transport);

    MyPair<Long, Transport> findTransport(String name);
}
