package org.estation.controllers;

import com.google.gson.Gson;
import org.estation.models.types.Station;
import org.estation.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private StationService stationService;

    @GetMapping("/station/name")
    public String getName(@RequestParam Long id, @RequestParam Station station) {
        return stationService.getName(id, station);
    }

    @GetMapping("/station/address")
    public String getAddress(@RequestParam Long id, @RequestParam Station station) {
        return stationService.getAddress(id, station);
    }

    @GetMapping("/station/find")
    public String findStation(@RequestParam String name) {
        return new Gson().toJson(stationService.findStation(name.replace('Ь', ' ')));
    }

}
