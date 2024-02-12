package org.identity.controllers;

import org.identity.services.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    private IdentityService identityService;

    @GetMapping("/identity")
    public String check(@RequestParam String login, @RequestParam String password) {
        Long idCompany = identityService.getIdCompany(login, password);
        if (idCompany == null) {
            return "";
        }
        return Long.toString(idCompany);
    }

}
