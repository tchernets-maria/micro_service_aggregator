package org.parent.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http {
    static public HttpResponse<String> request(String uri) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(new URI(uri)).build();
        HttpClient httpClient = HttpClient.newHttpClient();
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }
}
