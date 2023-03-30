package com.project.fenix.controller;

import com.project.fenix.dto.company.CityDto;
import com.project.fenix.dto.company.CountryDto;
import com.project.fenix.dto.company.ProvinceDto;
import com.project.fenix.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/getCountries")
    public List<CountryDto> getCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/getProvinces")
    public List<ProvinceDto> getProvinces() {
        return countryService.getAllProvinces();
    }

    @GetMapping("/getCities")
    public List<CityDto> getCities() {
        return countryService.getAllCities();
    }
}
