package com.project.fenix.services;

import com.project.fenix.dto.company.CompanyDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();

    CompanyDto save(CompanyDto companyDto);

    CompanyDto update(Long companyId, CompanyDto companyDto);
}
