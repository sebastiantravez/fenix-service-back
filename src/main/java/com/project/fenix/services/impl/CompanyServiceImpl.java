package com.project.fenix.services.impl;

import com.project.fenix.dto.company.CompanyDto;
import com.project.fenix.entities.company.Company;
import com.project.fenix.entities.company.Country;
import com.project.fenix.enums.EnumStatus;
import com.project.fenix.exceptions.GenericException;
import com.project.fenix.repository.CompanyRepository;
import com.project.fenix.services.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CompanyDto> getAllCompanies() {
        return companyRepository.findAll().stream().map(this::modelCompanyDto).toList();
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        Optional<Company> company = companyRepository.findByRuc(companyDto.getRuc());
        if (company.isPresent()) {
            throw new GenericException("Empresa con ruc " + companyDto.getRuc() + " ya existe");
        }
        Company companySave = modelMapper.map(companyDto, Company.class);
        companySave.setCreatedAt(LocalDateTime.now());
        companySave.setUpdatedAt(LocalDateTime.now());
        companySave.setStatus(EnumStatus.ACT);
        return modelCompanyDto(companyRepository.save(companySave));
    }

    @Override
    public CompanyDto update(Long companyId, CompanyDto companyDto) {
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new GenericException("Error: Registro no existe, no se puede actualizar"));
        company.setName(companyDto.getName());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setDescription(companyDto.getDescription());
        company.setCountry(modelMapper.map(companyDto.getCountry(), Country.class));
        company.setTypeCenter(companyDto.getTypeCenter());
        company.setUpdatedAt(LocalDateTime.now());
        company.setUserCreated(companyDto.getUserCreated());
        company.setStatus(companyDto.getStatus());
        companyRepository.save(company);
        return modelCompanyDto(companyRepository.save(company));
    }

    public CompanyDto modelCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    public Company modelCompanyEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }
}
