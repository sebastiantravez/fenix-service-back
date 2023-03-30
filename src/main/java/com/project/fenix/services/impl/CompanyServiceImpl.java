package com.project.fenix.services.impl;

import com.project.fenix.dto.company.CompanyDto;
import com.project.fenix.dto.company.SubsidiaryDto;
import com.project.fenix.entities.company.Company;
import com.project.fenix.entities.company.Country;
import com.project.fenix.entities.company.Province;
import com.project.fenix.entities.company.Subsidiary;
import com.project.fenix.enums.EnumStatus;
import com.project.fenix.enums.EnumTypeCenter;
import com.project.fenix.exceptions.GenericException;
import com.project.fenix.repository.CompanyRepository;
import com.project.fenix.repository.SubsidiaryRepository;
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
    private SubsidiaryRepository subsidiaryRepository;

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
        Company companySave = modelCompanyEntity(companyDto);
        companySave.setCreatedAt(LocalDateTime.now());
        companySave.setUpdatedAt(LocalDateTime.now());
        companySave.setStatus(EnumStatus.ACT);
        companySave.setTypeCenter(EnumTypeCenter.MATRIZ);
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

    @Override
    public List<SubsidiaryDto> getAllSubsidiaries() {
        return subsidiaryRepository.findAll().stream().map(this::modelSubsidiaryDto).toList();
    }

    @Override
    public SubsidiaryDto saveSubsidiary(SubsidiaryDto subsidiaryDto) {
        Optional<Subsidiary> subsidiary = subsidiaryRepository
                .findByEmissionPointAndEstablishmentPoint(subsidiaryDto.getEmissionPoint(), subsidiaryDto.getEstablishmentPoint());
        if (subsidiary.isPresent()) {
            throw new GenericException("Error: Sucursal con punto de emision y establecimiento ya existe");
        }
        Subsidiary subsidiarySave = modelSubsidiaryEntity(subsidiaryDto);
        subsidiarySave.setCreatedAt(LocalDateTime.now());
        subsidiarySave.setUpdatedAt(LocalDateTime.now());
        subsidiarySave.setTypeCenter(EnumTypeCenter.SUCURSAL);
        subsidiarySave.setStatus(EnumStatus.ACT);
        subsidiarySave.setProvince(modelMapper.map(subsidiaryDto.getProvince(), Province.class));
        subsidiarySave.setCompany(modelMapper.map(subsidiaryDto.getCompany(), Company.class));
        subsidiaryRepository.save(subsidiarySave);
        return subsidiaryDto;
    }

    @Override
    public SubsidiaryDto updateSubsidiary(Long sucursalId, SubsidiaryDto subsidiaryDto) {
        Subsidiary subsidiary = subsidiaryRepository.findById(sucursalId)
                .orElseThrow(() -> new GenericException("Error: La sucursal no existe, no se puede actualizar"));

        subsidiary.setName(subsidiaryDto.getName());
        subsidiary.setAddress(subsidiaryDto.getAddress());
        subsidiary.setPhone(subsidiaryDto.getPhone());
        subsidiary.setDescription(subsidiaryDto.getDescription());
        subsidiary.setEmissionPoint(subsidiaryDto.getEmissionPoint());
        subsidiary.setEstablishmentPoint(subsidiaryDto.getEstablishmentPoint());
        subsidiary.setProvince(modelMapper.map(subsidiaryDto.getProvince(), Province.class));
        subsidiary.setCompany(modelMapper.map(subsidiaryDto.getCompany(), Company.class));
        subsidiary.setTypeCenter(subsidiaryDto.getTypeCenter());
        subsidiary.setUpdatedAt(LocalDateTime.now());
        subsidiary.setUserCreated(subsidiaryDto.getUserCreated());
        subsidiary.setStatus(subsidiaryDto.getStatus());
        subsidiaryRepository.save(subsidiary);
        return subsidiaryDto;
    }

    public CompanyDto modelCompanyDto(Company company) {
        return modelMapper.map(company, CompanyDto.class);
    }

    public Company modelCompanyEntity(CompanyDto companyDto) {
        return modelMapper.map(companyDto, Company.class);
    }

    public SubsidiaryDto modelSubsidiaryDto(Subsidiary subsidiary) {
        return modelMapper.map(subsidiary, SubsidiaryDto.class);
    }

    public Subsidiary modelSubsidiaryEntity(SubsidiaryDto subsidiaryDto) {
        return modelMapper.map(subsidiaryDto, Subsidiary.class);
    }
}
