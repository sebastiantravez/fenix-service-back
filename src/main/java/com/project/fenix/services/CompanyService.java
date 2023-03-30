package com.project.fenix.services;

import com.project.fenix.dto.company.CompanyDto;
import com.project.fenix.dto.company.SubsidiaryDto;

import java.util.List;

public interface CompanyService {
    List<CompanyDto> getAllCompanies();

    CompanyDto save(CompanyDto companyDto);

    CompanyDto update(Long companyId, CompanyDto companyDto);

    List<SubsidiaryDto> getAllSubsidiaries();

    SubsidiaryDto saveSubsidiary(SubsidiaryDto subsidiaryDto);

    SubsidiaryDto updateSubsidiary(Long sucursalId, SubsidiaryDto subsidiaryDto);
}
