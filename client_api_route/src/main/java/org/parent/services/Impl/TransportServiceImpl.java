package org.parent.services.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.parent.models.types.Transport;
import org.parent.services.TransportService;
import org.parent.utils.Http;
import org.parent.utils.MyPair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class TransportServiceImpl implements TransportService {
    @Override
    public String getName(Long id, Transport transport) {
        try {
            return Http.request("http://localhost:8081/transport/name?id=" + id + "&transport=" + transport).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getCompanyInfo(Long id, Transport transport) {
        try {
            return Http.request("http://localhost:8081/transport/company?id=" + id + "&transport=" + transport).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MyPair<Long, Transport> findTransport(String name) {
        try {
            return new Gson().fromJson(Http.request("http://localhost:8081/transport/find?name="
                            + name.replace(' ', 'Ь')).body(),
                    new TypeToken<MyPair<Long, Transport>>() {}.getType());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
