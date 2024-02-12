package org.transport.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.transport.models.types.Transport;
import org.transport.services.TransportService;

@RestController
public class MainController {

    @Autowired
    private TransportService transportService;

    @GetMapping("/transport/name")
    public String getName(@RequestParam Long id, @RequestParam Transport transport) {
        return transportService.getName(id, transport);
    }

    @GetMapping("/transport/company")
    public String getCompany(@RequestParam Long id, @RequestParam Transport transport) {
        return transportService.getCompanyInfo(id, transport);
    }

    @GetMapping("/transport/find")
    public String findTransport(@RequestParam String name) {
        return new Gson().toJson(transportService.findTransport(name.replace('Ь', ' ')));
    }

}
