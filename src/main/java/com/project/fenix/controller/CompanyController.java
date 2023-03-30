package com.project.fenix.controller;

import com.project.fenix.dto.company.CompanyDto;
import com.project.fenix.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/getCompanies")
    public List<CompanyDto> getCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping("/saveCompany")
    public CompanyDto saveCompany(@RequestBody CompanyDto companyDto) {
        return companyService.save(companyDto);
    }

    @PutMapping("/updateCompany/{companyId}")
    public CompanyDto updateCompany(@PathVariable("companyId") Long companyId, @RequestBody CompanyDto companyDto) {
        return companyService.update(companyId, companyDto);
    }
}
