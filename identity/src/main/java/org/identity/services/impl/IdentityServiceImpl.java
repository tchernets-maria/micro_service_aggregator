package org.identity.services.impl;

import org.identity.models.Authorization;
import org.identity.repo.AuthorizationRepository;
import org.identity.services.IdentityService;
import org.identity.utils.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdentityServiceImpl implements IdentityService {
    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Override
    public Long getIdCompany(String login, String password) {
        String hash = Hash.get(password);
        Long id = null;
        for (Authorization authorization : authorizationRepository.findAll()) {
            if (authorization.getLogin().equals(login) && authorization.getPassword().equals(hash)) {
                id = authorization.getId();
            }
        }
        return id;
    }
}
