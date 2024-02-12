package org.parent.services.Impl;

import org.parent.services.IdentityService;
import org.parent.utils.Http;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;

@Component
public class IdentityServiceImpl implements IdentityService {
    @Override
    public Long getIdCompany(String login, String password) {
        try {
            String result = Http.request("http://localhost:8083/identity?login=" + login + "&password=" + password).body();
            if ("".equals(result)) {
                return null;
            }
            return Long.parseLong(result);
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
