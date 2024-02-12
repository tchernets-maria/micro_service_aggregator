package org.parent.services;

import org.parent.models.Company;
import org.springframework.stereotype.Service;

@Service
public interface CompanyService {

    Company getCompany(Long id);

}
