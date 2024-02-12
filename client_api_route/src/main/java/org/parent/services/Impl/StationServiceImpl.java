package org.parent.services.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.parent.models.types.Station;
import org.parent.services.StationService;
import org.parent.utils.Http;
import org.parent.utils.MyPair;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class StationServiceImpl implements StationService {

    @Override
    public String getName(Long id, Station station) {
        try {
            return Http.request("http://localhost:8082/station/name?id=" + id + "&station=" + station).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getAddress(Long id, Station station) {
        try {
            return Http.request("http://localhost:8082/station/address?id=" + id + "&station=" + station).body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MyPair<Long, Station> findStation(String name) {
        try {
            return new Gson().fromJson(Http.request("http://localhost:8082/station/find?name="
                            + name.replace(' ', 'Ь')).body(),
                    new TypeToken<MyPair<Long, Station>>() {}.getType());
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
