package org.parent.services.Impl;

import org.parent.models.Company;
import org.parent.repo.CompanyRepository;
import org.parent.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company getCompany(Long id) {
        return companyRepository.findById(id).orElse(new Company());
    }

}
